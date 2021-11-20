package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MHomeController {

	@FXML
    private Button GetMoneybtn;

    @FXML
    private Button Tradebtn;

    @FXML
    void TradeAction(ActionEvent event) {
    	MMainController.getmmainController().MLoadPage("TradePage");
    }

    @FXML
    void TradeAction2(ActionEvent event) {
    	MMainController.getmmainController().MLoadPage("TradePage");
    }
}
