package projekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Clientcontroller {
    @FXML
    private void logOut() throws IOException{
        App.setRoot("logpanel");
    }
    @FXML
    private void switchToNewRent() throws IOException {
        App.setRoot("clientCarController");
    }
    @FXML
    private void switchToMyRent() throws IOException {
        App.setRoot("clientRentController");
    }
    @FXML
    private void switchToAccount() throws IOException {
        App.setRoot("clientAccountController");
    }
}
