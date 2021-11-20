package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CoinInsertController implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { }
	
	@FXML
    private TableView<?> ACoinInserttable;

    @FXML
    private Button CoinCancelbtn;

    @FXML
    private Button CoinUpdatebtn;

    @FXML
    void ACoinInsert(ActionEvent event) {

    }

    @FXML
    void CoinCancelAction(ActionEvent event) {
    	AMainController.getamainController().ALoadPage("CoinManagePage");
    }

    @FXML
    void CoinUpdateAction(ActionEvent event) {

    }
}