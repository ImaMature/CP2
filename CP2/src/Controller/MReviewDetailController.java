package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.MemberDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MReviewDetailController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		String idcheck = MemberDAO.getMemberDAO().getMid();
		if(!M)
	}
	
	  @FXML
	    private ImageView BackImg;

	    @FXML
	    private Button PostDeletebtn;

	    @FXML
	    private Button PostUpdatebtn;

	    @FXML
	    private TextArea ReviewContentstxt;

	    @FXML
	    private TextField ReviewTitletxt;

	    @FXML
	    void BackOMC(MouseEvent event) {
	    	MMainController.getmmainController().MLoadPage("MReviewWritePage");
	    }

	    @FXML
	    void DeleteAction(ActionEvent event) {

	    }

	    @FXML
	    void UpdateAction(ActionEvent event) {

	    }

}
