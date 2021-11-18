package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.MemberDAO;
import Domain.Board;
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

		
		
		String writer = LoginController.getLoginController().getloginid();
		int m_no = MemberDAO.getMemberDAO().getMemberNo(writer);
		String writer2 = MemberDAO.getMemberDAO().getMid(m_no);
		
		//현재 이용자의 아이디 = writer 
		if(!writer.equals(writer2)) {
			PostDeletebtn.setVisible(false);
			PostUpdatebtn.setVisible(false);
		}else {
			PostDeletebtn.setVisible(true);
			PostDeletebtn.setVisible(true);
		}
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
	    	MReviewCoinbtnController.getRC().RLoadPage("MReviewPage");
	    }

	    @FXML
	    void DeleteAction(ActionEvent event) {
	    	
	    }

	    @FXML
	    void UpdateAction(ActionEvent event) {

	    }

}
