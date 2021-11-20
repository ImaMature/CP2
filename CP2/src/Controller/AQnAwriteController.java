package Controller;

import DAO.BoardDAO;
import DAO.MemberDAO;
import Domain.Board;
import Domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AQnAwriteController {
	
	@FXML
    private Button AQnACancelbtn;

    @FXML
    private TextArea AQnAContentsTxt;

    @FXML
    private TextField AQnAtitletxt;

    @FXML
    private Button AQnAwrite;

    @FXML
    void AQnAcancelAction(ActionEvent event) {
    	AMainController.getamainController().ALoadPage("AQnAPage");
    }

    @FXML
    void AQnAwriteAction(ActionEvent event) {
    	
    	}
    }
	
