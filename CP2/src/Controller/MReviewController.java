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
    private TableView<Board> Coinreview;

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
    	
	    	MMainController.getmmainController().MLoadPage("MReviewWritePage");
	    	
    }

    @FXML
    void UpdateAction(ActionEvent event) {

    }

}
