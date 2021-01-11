package projekt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;

public class AdminClientController {
    @FXML
    TableView<Client> clienttable;
    @FXML
    TableColumn<Client,String> Fname;
    @FXML
    TableColumn<Client,String> Lname;
    @FXML
    TableColumn<Client,String> PESEL;
    @FXML
    TableColumn<Client,String> Phone;
    @FXML
    TableColumn<Client,String> DriveLic;
    @FXML
    TableColumn<Client,String> login;
    private ObservableList<Client> clients = FXCollections.observableArrayList();
    @FXML
    TextField Fnameadd;
    @FXML
    TextField Lnameadd;
    @FXML
    TextField peseladd;
    @FXML
    TextField phoneadd;
    @FXML
    TextField drivelicadd;
    @FXML
    TextField loginadd;
    @FXML
    PasswordField passwordadd;
    @FXML
    private void initialize() throws IOException{
        clienttable.getItems().clear();
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(12);
        bw.flush();
        Fname.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        Lname.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        PESEL.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        Phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        DriveLic.setCellValueFactory(new PropertyValueFactory<>("driving_license_num"));
        login.setCellValueFactory(new PropertyValueFactory<>("login"));
        String odpt;
        while((odpt=br.readLine())!=null){
            JSONObject client = new JSONObject(odpt);
            int id = client.getInt("client_id");
            String fname = client.getString("first_name");
            String lname = client.getString("last_name");
            String pesel = client.getString("pesel");
            String phone = client.getString("phone");
            String drive = client.getString("driving_license_num");
            String login = client.getString("login");
            String pass = client.getString("password");
            clients.add(new Client(id,fname,lname,pesel,phone,drive,login,pass));
        }
        clienttable.setItems(clients);
        socket.close();
    }
    @FXML
    private void add() throws IOException{
        if(loginadd.getLength()!=0 && passwordadd.getLength()!=0 && peseladd.getLength()!=0){
            Socket socket = new Socket("localhost",8080);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw.write(13);
            bw.flush();
            Client newclient = new Client(0,Fnameadd.getText(),Lnameadd.getText(),peseladd.getText(),phoneadd.getText(),drivelicadd.getText(),loginadd.getText(),passwordadd.getText());
            JSONObject clientadd = new JSONObject(newclient);
            bw.write(clientadd.toString());
            bw.newLine();
            bw.flush();
            int odp = br.read();
            if(odp!=1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Coś poszło nie tak, spróbuj jeszcze raz");
                alert.showAndWait();
            }
            bw.close();
            br.close();
            socket.close();
            initialize();
        }
    }
    @FXML
    private void backToPanel() throws IOException{
        App.setRoot("primary");
    }
    @FXML
    private void delete() throws IOException {
        Client client = clienttable.getSelectionModel().getSelectedItem();
        int id = client.getClient_id();
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(14);
        bw.flush();
        bw.write(id);
        bw.flush();
        int odp = br.read();
        if(odp==1) initialize();
        br.close();
        bw.close();
        socket.close();
    }
}
