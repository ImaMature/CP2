package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {
    @FXML
    private Button Loginbtn;

    @FXML
    private Button Tradebtn;

    @FXML
    void LoginAction(ActionEvent event) {
    	MainController.getMainController().LoadPage("LoginPage");
    }

    @FXML
    void TradeAction(ActionEvent event) {
    	MainController.getMainController().LoadPage("TradePage");
    }

}
