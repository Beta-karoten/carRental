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

public class AdminPriceController {
    @FXML
    TableView<Car_price> pricetable;
    @FXML
    TableColumn<Car_price,Integer> id;
    @FXML
    TableColumn<Car_price,Integer> day;
    @FXML
    TableColumn<Car_price,Integer> engine;
    private ObservableList<Car_price> prices = FXCollections.observableArrayList();
    @FXML
    TextField dayadd;
    @FXML
    TextField engineadd;
    @FXML
    private void initialize() throws IOException{
        pricetable.getItems().clear();
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(9);
        bw.flush();
        id.setCellValueFactory(new PropertyValueFactory<>("price_id"));
        day.setCellValueFactory(new PropertyValueFactory<>("per_day"));
        engine.setCellValueFactory(new PropertyValueFactory<>("for_engine_size"));
        String odpt;
        while((odpt=br.readLine())!=null){
            JSONObject price = new JSONObject(odpt);
            int id = price.getInt("price_id");
            int day = price.getInt("per_day");
            int engine = price.getInt("for_engine_size");
            prices.add(new Car_price(id,day,engine));
        }
        pricetable.setItems(prices);
        socket.close();
    }
    @FXML
    private void add() throws IOException{
        if(dayadd.getLength()!=0 && engineadd.getLength()!=0){
            Socket socket = new Socket("localhost",8080);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw.write(10);
            bw.flush();
            Car_price price = new Car_price(0,Integer.parseInt(dayadd.getText()),Integer.parseInt(engineadd.getText()));
            JSONObject priceadd = new JSONObject(price);
            bw.write(priceadd.toString());
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
        Car_price price = pricetable.getSelectionModel().getSelectedItem();
        int id = price.getPrice_id();
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(11);
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
