package projekt;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {
    @FXML
    private void switchToCar() throws IOException{
        App.setRoot("adminCarController");
    }
    @FXML
    private void switchToRent() throws IOException{
        App.setRoot("adminRentController");
    }
    @FXML
    private void switchToClient() throws IOException{
        App.setRoot("adminClientController");
    }
    @FXML
    private void switchToOffice() throws IOException{
        App.setRoot("adminOfficeController");
    }
    @FXML
    private void switchToPrice() throws IOException{
        App.setRoot("adminPriceController");
    }
    @FXML
    private void logout() throws IOException {
        App.setRoot("logpanel");
    }
}
