package projekt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.JSONObject;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientCarController {
    @FXML
    TableView<NewRent> cartable;
    @FXML
    TableColumn<NewRent,String> mark;
    @FXML
    TableColumn<NewRent,String> model;
    @FXML
    TableColumn<NewRent,String> body;
    @FXML
    TableColumn<NewRent,Integer> year;
    @FXML
    TableColumn<NewRent,Integer> engine;
    @FXML
    TableColumn<NewRent,Integer> mil;
    @FXML
    TableColumn<NewRent,String> city;
    @FXML
    TableColumn<NewRent,Integer> day;
    @FXML
    DatePicker datefrom;
    @FXML
    DatePicker dateto;
    @FXML
    TextField enginesize;
    @FXML
    TextField yearfil;
    @FXML
    TextField milefil;
    private ObservableList<NewRent> rents = FXCollections.observableArrayList();
    private List<NewRent> rents1 = new ArrayList<>();
    @FXML
    private void initialize() throws IOException{
        cartable.getItems().clear();
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(19);
        bw.flush();
        mark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        body.setCellValueFactory(new PropertyValueFactory<>("body"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        engine.setCellValueFactory(new PropertyValueFactory<>("engine"));
        mil.setCellValueFactory(new PropertyValueFactory<>("mil"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        day.setCellValueFactory(new PropertyValueFactory<>("day"));
        String odpt;

        while((odpt=br.readLine())!=null){
            JSONObject rent = new JSONObject(odpt);
            int id = rent.getInt("id");
            String mark = rent.getString("mark");
            String model = rent.getString("model");
            String body = rent.getString("body");
            int year = rent.getInt("year");
            int engine = rent.getInt("engine");
            int mil = rent.getInt("mil");
            String city = rent.getString("city");
            int day = rent.getInt("day");
            rents.add(new NewRent(id,mark,model,body,year,engine,mil,city,day));
            rents1.add(new NewRent(id,mark,model,body,year,engine,mil,city,day));
        }
        cartable.setItems(rents);
        socket.close();
    }
    @FXML
    private void filtered() throws IOException{
        rents1 = rents1.stream()
                .filter(newRent -> newRent.getEngine()>=Integer.parseInt(enginesize.getText()))
                .filter(newRent -> newRent.getYear()>=Integer.parseInt(yearfil.getText()))
                .filter(newRent -> newRent.getMil()<=Integer.parseInt(milefil.getText()))
                .collect(Collectors.toList());
        rents1.sort(Comparator.comparing(NewRent::getId));
        rents1.forEach(System.out::println);
        cartable.getItems().clear();
        rents.clear();
        for(NewRent rent: rents1){
            rents.add(new NewRent(rent.getId(),rent.getMark(),rent.getModel(),rent.getBody(),rent.getYear(),rent.getEngine(),rent.getMil(),rent.getCity(),rent.getDay()));
        }
        cartable.setItems(rents);
    }
    @FXML
    private void backToPanel() throws IOException{
        App.setRoot("client");
    }
    @FXML
    private void rent() throws IOException {
        NewRent rent = cartable.getSelectionModel().getSelectedItem();
        int id = rent.getId();
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(20);
        bw.flush();
        bw.write(String.valueOf(datefrom.getValue()));
        bw.newLine();
        bw.flush();
        bw.write(String.valueOf(dateto.getValue()));
        bw.newLine();
        bw.flush();
        bw.write(id);
        bw.flush();
        bw.write(ActualClient.getActual_id());
        bw.flush();
        int odp= br.read();
        if(odp==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Wypożyczono auto(wypozyczenie znajduje się w Moje wypożyczenia)");
            alert.showAndWait();
            App.setRoot("client");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Dane auto w podanym terminie jest już wypożyczone, proszę wybrać inne auto badź termin");
            alert.showAndWait();
        }
    }
}
