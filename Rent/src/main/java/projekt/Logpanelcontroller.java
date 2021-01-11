package projekt;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class Logpanelcontroller {
    @FXML
    TextField login;
    @FXML
    PasswordField password;
    @FXML
    private void logIn() throws IOException{
        String log = login.getText();
        String pass = password.getText();

        Socket socket = new Socket("localhost",8080);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(1);
        bw.flush();
        bw.write(log + "\n");
        bw.flush();
        bw.write(pass + "\n");
        bw.flush();
        int odp = br.read();
        if(odp==1) ActualClient.setActual_id(br.read());
        br.close();
        bw.close();
        socket.close();
        if(odp==1){
            App.setRoot("client");
        }else if(odp==2) {
            App.setRoot("primary");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Podano niepoprawne dane logowania!");
            alert.showAndWait();
        }
    }
    @FXML
    private void toRegistry() throws IOException{
        App.setRoot("secondary");
    }
}
