package projekt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;

public class ClientRentController {
    @FXML
    TableView<Clientrent> clientrenttab;
    @FXML
    TableColumn<Clientrent,String> mark;
    @FXML
    TableColumn<Clientrent,String> model;
    @FXML
    TableColumn<Clientrent,String> datefrom;
    @FXML
    TableColumn<Clientrent,String> dateto;
    @FXML
    TableColumn<Clientrent,Integer> sum;
    private ObservableList<Clientrent> rents = FXCollections.observableArrayList();
    @FXML
    private void initialize() throws IOException{
        clientrenttab.getItems().clear();
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(17);
        bw.flush();
        int id = ActualClient.getActual_id();
        bw.write(id);
        bw.flush();
        mark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        datefrom.setCellValueFactory(new PropertyValueFactory<>("datefrom"));
        dateto.setCellValueFactory(new PropertyValueFactory<>("dateto"));
        sum.setCellValueFactory(new PropertyValueFactory<>("sum"));
        String odpt;
        while((odpt=br.readLine())!=null){
            JSONObject clientrent = new JSONObject(odpt);
            String mark = clientrent.getString("mark");
            String model = clientrent.getString("model");
            String datefrom = clientrent.getString("datefrom");
            String dateto = clientrent.getString("dateto");
            int sum = clientrent.getInt("sum");
            rents.add(new Clientrent(mark,model,datefrom,dateto,sum));
        }
        clientrenttab.setItems(rents);
        socket.close();
    }
    @FXML
    private void backToPanel() throws IOException {
        App.setRoot("client");
    }
}
