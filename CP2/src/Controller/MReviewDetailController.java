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

public class MReviewDetailController {

//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//
//		
//		//현재사용자 = user
//		String user = LoginController.getLoginController().getloginid();
//		System.out.println("user : " + user);
//		//user 값 넣어서 m_no빼오기
//		int m_no = MemberDAO.getMemberDAO().getMemberNo(user);
//		System.out.println("m_no : " + m_no);
//		//빼온 m_no로 멤버이름 찾기
//		String writer = MemberDAO.getMemberDAO().getMid(m_no);
//		System.out.println("writer: " + writer);
//		
//		//현재 사용자(user)와 빼온 이름이 같다면 수정, 삭제 버튼 보여줌.
//		if(user.equals(writer)) {
//			PostDeletebtn.setVisible(true);
//			PostUpdatebtn.setVisible(true);
//		}else {
//			PostDeletebtn.setVisible(false);
//			PostDeletebtn.setVisible(false);
//		}
//	}
	
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
