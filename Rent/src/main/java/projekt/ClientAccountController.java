package projekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class ClientAccountController {
    @FXML
    TextField fname;
    @FXML
    TextField lname;
    @FXML
    TextField pesel;
    @FXML
    TextField phone;
    @FXML
    TextField drive;
    @FXML
    PasswordField pass;

    @FXML
    private void backToPanel() throws IOException{
        App.setRoot("client");
    }
    @FXML
    private void fnamechange() throws IOException{
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(18);
        bw.flush();
        bw.write(ActualClient.getActual_id());
        bw.flush();
        bw.write(1);
        bw.flush();
        bw.write(fname.getText());
        bw.newLine();
        bw.flush();
        int odp=br.read();
        if(odp==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Zmieniono imię");
            alert.showAndWait();
            App.setRoot("client");
        }
        bw.close();
        br.close();
        socket.close();
    }
    @FXML
    private void lnamechange() throws IOException{
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(18);
        bw.flush();
        bw.write(ActualClient.getActual_id());
        bw.flush();
        bw.write(2);
        bw.flush();
        bw.write(lname.getText());
        bw.newLine();
        bw.flush();
        int odp = br.read();
        if(odp==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Zmieniono nazwisko");
            alert.showAndWait();
            App.setRoot("client");
        }
        br.close();
        bw.close();
        socket.close();
    }
    @FXML
    private void peselchange() throws IOException{
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(18);
        bw.flush();
        bw.write(ActualClient.getActual_id());
        bw.flush();
        bw.write(3);
        bw.flush();
        bw.write(pesel.getText());
        bw.newLine();
        bw.flush();
        int odp = br.read();
        if(odp==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Zmieniono pesel");
            alert.showAndWait();
            App.setRoot("client");
        }
        br.close();
        bw.close();
        socket.close();
    }
    @FXML
    private void phonechange() throws IOException{
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(18);
        bw.flush();
        bw.write(ActualClient.getActual_id());
        bw.flush();
        bw.write(4);
        bw.flush();
        bw.write(phone.getText());
        bw.newLine();
        bw.flush();
        int odp = br.read();
        if(odp==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Zmieniono numer telefonu");
            alert.showAndWait();
            App.setRoot("client");
        }
        br.close();
        bw.close();
        socket.close();
    }
    @FXML
    private void drivechange() throws IOException{
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(18);
        bw.flush();
        bw.write(ActualClient.getActual_id());
        bw.flush();
        bw.write(5);
        bw.flush();
        bw.write(drive.getText());
        bw.newLine();
        bw.flush();
        int odp = br.read();
        if(odp==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Zmieniono numer prawa jazdy");
            alert.showAndWait();
            App.setRoot("client");
        }
        br.close();
        socket.close();
    }
    @FXML
    private void passchange() throws IOException{
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(18);
        bw.flush();
        bw.write(ActualClient.getActual_id());
        bw.flush();
        bw.write(6);
        bw.flush();
        bw.write(pass.getText());
        bw.newLine();
        bw.flush();
        int odp = br.read();
        if(odp==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Zmieniono hasło");
            alert.showAndWait();
            App.setRoot("client");
        }
        bw.close();
        br.close();
        socket.close();
    }
}
