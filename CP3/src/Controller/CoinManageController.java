package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class CoinManageController implements Initializable {
	public static Alert confAlert = new Alert(AlertType.CONFIRMATION);
	public static Alert infoAlert = new Alert(AlertType.INFORMATION);
	
@Override
public void initialize(URL arg0, ResourceBundle arg1) { }

	 @FXML
	    private Button CoinDeletebtn;

	    @FXML
	    private Button CoinRegisterbtn;

	    @FXML
	    void CoinDeleteAction(ActionEvent event) {
	    	AMainController.getamainController().ALoadPage("CoinDeletePage");
	    }

	    @FXML
	    void CoinRegAction(ActionEvent event) {
	    	AMainController.getamainController().ALoadPage("CoinInsertPage");
	    }
}
