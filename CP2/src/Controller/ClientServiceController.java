package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.BoardDAO;
import Domain.Board;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ClientServiceController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Board> MAboards = BoardDAO.getboardDAO().QBoardList(2);
		
	}
	@FXML
    private TableView<Board> MQNAView;

    @FXML
    private Button Questionbtn;

    @FXML
    private ImageView Backimg;
    @FXML
    void BackOMC(MouseEvent event) {
    	MMainController.getmmainController().MLoadPage("MHomePage");
    }
    @FXML
    void QuestionAction(ActionEvent event) {

    	MMainController.getmmainController().MLoadPage("ClientSQPage");
    }
}
