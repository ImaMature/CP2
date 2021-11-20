package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class AHomeController {

	@FXML
    private Button ALogoutbtn;

    @FXML
    private AnchorPane AMainBoarderPane;

    @FXML
    private Button AMainpagebtn;

    @FXML
    void ALogoutAction(ActionEvent event) {
    	AMainController.getamainController().ALoadPage("MainPage");
    }

    @FXML
    void AMainpageAction(ActionEvent event) {
    	AMainController.getamainController().ALoadPage("CoinManagePage");
    }
}