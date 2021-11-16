package Controller;

import DAO.BoardDAO;
import DAO.MemberDAO;
import Domain.Board;
import Domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class MReviewController {

	
    @FXML
    private TableView<?> Coinreview;

    @FXML
    private Button PostDeletebtn;

    @FXML
    private Button PostUpdatebtn;

    @FXML
    private Button Registerbtn;

    @FXML
    void DeleteAction(ActionEvent event) {

    }

    @FXML
    void RegisterAction(ActionEvent event) {
    	
	    	MainController.getMainController().LoadPage("MReviewPage");
	    	
    }

    @FXML
    void UpdateAction(ActionEvent event) {

    }

}
