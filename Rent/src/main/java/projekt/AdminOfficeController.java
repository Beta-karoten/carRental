package projekt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;

public class AdminOfficeController {
    @FXML
    TableView<Office> officetable;
    @FXML
    TableColumn<Office,Integer> id;
    @FXML
    TableColumn<Office,String> address;
    @FXML
    TableColumn<Office,String> phone;
    @FXML
    TableColumn<Office,String> city;
    private ObservableList<Office> offices = FXCollections.observableArrayList();
    @FXML
    TextField addressadd;
    @FXML
    TextField phoneadd;
    @FXML
    TextField cityadd;
    @FXML
    private void initialize() throws IOException{
        officetable.getItems().clear();
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(6);
        bw.flush();
        id.setCellValueFactory(new PropertyValueFactory<>("office_id"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        String odpt;
        while((odpt=br.readLine())!=null){
            JSONObject office = new JSONObject(odpt);
            int id = office.getInt("office_id");
            String address = office.getString("address");
            String phone = office.getString("phone");
            String city = office.getString("city");
            offices.add(new Office(id,address,phone,city));
        }
        officetable.setItems(offices);
        socket.close();
    }
    @FXML
    private void add() throws IOException{
        if(addressadd.getLength()!=0 && phoneadd.getLength()!=0 && cityadd.getLength()!=0){
            Socket socket = new Socket("localhost",8080);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw.write(7);
            bw.flush();
            Office newoffice = new Office(0,addressadd.getText(),phoneadd.getText(),cityadd.getText());
            JSONObject officeadd = new JSONObject(newoffice);
            bw.write(officeadd.toString());
            bw.newLine();
            bw.flush();
            int odp = br.read();
            if(odp==1) {
                initialize();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Coś poszło nie tak, spróbuj jeszcze raz");
                alert.showAndWait();
            }

            bw.close();
            br.close();
            socket.close();

        }
    }
    @FXML
    private void backToPanel() throws IOException{
        App.setRoot("primary");
    }
    @FXML
    private void delete() throws IOException {
        Office office = officetable.getSelectionModel().getSelectedItem();
        int id = office.getOffice_id();
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(8);
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
