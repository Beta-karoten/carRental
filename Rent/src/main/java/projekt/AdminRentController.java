package projekt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.sql.Date;

public class AdminRentController {
    @FXML
    TableView<Rent> renttable;
    @FXML
    TableColumn<Rent,Integer> rentid;
    @FXML
    TableColumn<Rent, Date> datefrom;
    @FXML
    TableColumn<Rent,Date> dateto;
    @FXML
    TableColumn<Rent,String> note;
    @FXML
    TableColumn<Rent,Integer> clientid;
    @FXML
    TableColumn<Rent,Integer> carid;
    @FXML
    TableColumn<Rent,Integer> sum;
    private ObservableList<Rent> rents = FXCollections.observableArrayList();
    @FXML
    private void initialize() throws IOException{
        renttable.getItems().clear();
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(15);
        bw.flush();
        rentid.setCellValueFactory(new PropertyValueFactory<>("rent_id"));
        datefrom.setCellValueFactory(new PropertyValueFactory<>("rent_date"));
        dateto.setCellValueFactory(new PropertyValueFactory<>("return_date"));
        note.setCellValueFactory(new PropertyValueFactory<>("note"));
        clientid.setCellValueFactory(new PropertyValueFactory<>("client_id"));
        carid.setCellValueFactory(new PropertyValueFactory<>("car_id"));
        sum.setCellValueFactory(new PropertyValueFactory<>("sum"));
        String odpt;
        while((odpt=br.readLine())!=null){
            JSONObject rent = new JSONObject(odpt);
            int id = rent.getInt("rent_id");
            String datefrom = rent.getString("rent_date");
            String dateto = rent.getString("return_date");
            String note = rent.getString("note");
            int client_id = rent.getInt("client_id");
            int car_id = rent.getInt("car_id");
            int sum = rent.getInt("sum");
            rents.add(new Rent(id,datefrom,dateto,note,client_id,car_id,sum));


        }
        renttable.setItems(rents);
        socket.close();
    }
    @FXML
    private void backToPanel() throws IOException{
        App.setRoot("primary");
    }
    @FXML
    private void delete() throws IOException {
        Rent rent = renttable.getSelectionModel().getSelectedItem();
        int id = rent.getRent_id();
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(16);
        bw.flush();
        bw.write(id);
        bw.flush();
        int odp = br.read();
        if(odp==1) initialize();
        br.read();
        bw.close();
        socket.close();
    }
}
