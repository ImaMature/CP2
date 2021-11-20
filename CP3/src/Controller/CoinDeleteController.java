package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
public class CoinDeleteController implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
		
		@FXML
		private TableView<?> ACoinDeletettable;

		@FXML
		private Button CoinDeletebtn2;

		@FXML
		private Button CoinDeletebtn3;

		@FXML
		void ACoinDelete(ActionEvent event) {

		}

		@FXML
		void CoinDeletebtn2(ActionEvent event) {

	}
		@FXML
		void CoinDeletebtn3Action(ActionEvent event) { 
			AMainController.getamainController().ALoadPage("CoinManagePage");
		}
}
