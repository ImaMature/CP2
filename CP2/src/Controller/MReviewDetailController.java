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
//		//�������� = user
//		String user = LoginController.getLoginController().getloginid();
//		System.out.println("user : " + user);
//		//user �� �־ m_no������
//		int m_no = MemberDAO.getMemberDAO().getMemberNo(user);
//		System.out.println("m_no : " + m_no);
//		//���� m_no�� ����̸� ã��
//		String writer = MemberDAO.getMemberDAO().getMid(m_no);
//		System.out.println("writer: " + writer);
//		
//		//���� �����(user)�� ���� �̸��� ���ٸ� ����, ���� ��ư ������.
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
