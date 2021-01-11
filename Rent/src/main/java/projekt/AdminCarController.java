package projekt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.util.converter.IntegerStringConverter;
import org.json.JSONObject;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class AdminCarController {
    @FXML
    TableView<Car> cartable;
    @FXML
    TableColumn<Car,String> mark;
    @FXML
    TableColumn<Car,String> model;
    @FXML
    TableColumn<Car,String> VIN;
    @FXML
    TableColumn<Car,String> body;
    @FXML
    TableColumn<Car,Integer> year;
    @FXML
    TableColumn<Car,Integer> engine;
    @FXML
    TableColumn<Car,String> fuel;
    @FXML
    TableColumn<Car,String> lic;
    @FXML
    TableColumn<Car,Integer> mil;
    private ObservableList<Car> cars = FXCollections.observableArrayList();
    @FXML
    TextField markadd;
    @FXML
    TextField modeladd;
    @FXML
    TextField vinadd;
    @FXML
    TextField bodyadd;
    @FXML
    TextField yearadd;
    @FXML
    TextField engineadd;
    @FXML
    TextField fueladd;
    @FXML
    TextField licadd;
    @FXML
    TextField miladd;
    @FXML
    TextField officeadd;
    @FXML
    TextField priceadd;
    @FXML
    private void initialize() throws IOException {
        cartable.getItems().clear();
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(3);
        bw.flush();
        mark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        VIN.setCellValueFactory(new PropertyValueFactory<>("VIN"));
        body.setCellValueFactory(new PropertyValueFactory<>("body_type"));
        year.setCellValueFactory(new PropertyValueFactory<>("model_year"));
        engine.setCellValueFactory(new PropertyValueFactory<>("engine_size"));
        fuel.setCellValueFactory(new PropertyValueFactory<>("fuel_type"));
        lic.setCellValueFactory(new PropertyValueFactory<>("license_plate"));
        mil.setCellValueFactory(new PropertyValueFactory<>("mileage"));
        mark.setCellFactory(TextFieldTableCell.forTableColumn());
        model.setCellFactory(TextFieldTableCell.forTableColumn());
        VIN.setCellFactory(TextFieldTableCell.forTableColumn());
        body.setCellFactory(TextFieldTableCell.forTableColumn());
        year.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        engine.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        fuel.setCellFactory(TextFieldTableCell.forTableColumn());
        lic.setCellFactory(TextFieldTableCell.forTableColumn());
        mil.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        String odpt;
        while((odpt=br.readLine())!=null){
            JSONObject car = new JSONObject(odpt);
            int id = car.getInt("car_id");
            String lic = car.getString("license_plate");
            String mark = car.getString("mark");
            String model = car.getString("model");
            String vin = car.getString("VIN");
            String body = car.getString("body_type");
            int year = car.getInt("model_year");
            int engine = car.getInt("engine_size");
            String fuel = car.getString("fuel_type");
            int mil = car.getInt("mileage");
            int price = car.getInt("price_id");
            int office = car.getInt("office_id");
            cars.add(new Car(id,lic,mark,model,vin,body,year,engine,fuel,mil,price,office));
            }
        cartable.setItems(cars);
        socket.close();
    }
    @FXML
    private void add() throws IOException{
            if(priceadd.getLength()!=0 && officeadd.getLength()!=0 && markadd.getLength()!=0 && modeladd.getLength()!=0 &&vinadd.getLength()!=0){
                Socket socket = new Socket("localhost",8080);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bw.write(4);
                bw.flush();
                Car newcar = new Car(0,licadd.getText(),markadd.getText(),modeladd.getText(),vinadd.getText(),bodyadd.getText(),Integer.parseInt(yearadd.getText()),Integer.parseInt(engineadd.getText()),fueladd.getText(),Integer.parseInt(miladd.getText()),Integer.parseInt(priceadd.getText()),Integer.parseInt(officeadd.getText()));
                JSONObject caradd = new JSONObject(newcar);
                bw.write(caradd.toString());
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
    private void delete() throws IOException{
        Car car = cartable.getSelectionModel().getSelectedItem();
        int id = car.getCar_id();
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(5);
        bw.flush();
        bw.write(id);
        bw.flush();
        int odp = br.read();
        if(odp==1) initialize();
        bw.close();
        socket.close();
    }
    @FXML
    private void backToPanel() throws IOException{
        App.setRoot("primary");
    }

}
