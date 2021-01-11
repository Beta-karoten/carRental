package projekt;

import java.io.*;
import java.net.Socket;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SecondaryController {
    @FXML
    TextField login;
    @FXML
    PasswordField password;
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
    private void registry() throws IOException {
        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(2);
        bw.flush();
        bw.write(login.getText()+"\n");
        bw.flush();
        bw.write(password.getText()+"\n");
        bw.flush();
        bw.write(fname.getText()+"\n");
        bw.flush();
        bw.write(lname.getText()+"\n");
        bw.flush();
        bw.write(pesel.getText()+"\n");
        bw.flush();
        bw.write(phone.getText()+"\n");
        bw.flush();
        bw.write(drive.getText()+"\n");
        bw.flush();
        int odp = br.read();
        br.close();
        bw.close();
        socket.close();
        if(odp==1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Utworzono konto");
            alert.showAndWait();
            App.setRoot("logpanel");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Podany login jest zajęty!");
            alert.showAndWait();
        }
    }
    @FXML
    private void backToLog() throws IOException{
        App.setRoot("logpanel");
    }
}