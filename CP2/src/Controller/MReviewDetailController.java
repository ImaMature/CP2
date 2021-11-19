package Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import DAO.BoardDAO;
import DAO.MemberDAO;
import Domain.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MReviewDetailController implements Initializable{

	Board board = MReviewController.Mboard;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//제목 보여주기
		ReviewTitletxt.setText(board.getB_title());
		
		//내용 보여주기
		ReviewContentstxt.setText(board.getB_contents());
		System.out.println("내용 : "+ board.getB_contents());
		
		//현재사용자 = user = getloginid해온값 이 
		String user = LoginController.getLoginController().getloginid();
		String writer = board.getWriter();
		System.out.println("writer : " + writer);
		
		//현재 사용자(user)와 빼온 이름이 같다면 수정, 삭제 버튼 보여줌. 완료
		if(!user.equals(writer)) {
			PostDeletebtn.setVisible(false);
			PostUpdatebtn.setVisible(false);
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
	    	MMainController.confirmAlert.setTitle("게시물 삭제 알림");
	    	MMainController.confirmAlert.setHeaderText("정말 게시물을 삭제하시겠습니까?");
	    	
	    	Optional<ButtonType> optional = MMainController.confirmAlert.showAndWait();
	    	if(optional.get()==ButtonType.OK) {
	    		boolean result = BoardDAO.getboardDAO().ReviewDelete(board.getB_no());
	    		if(result) {
	    			MMainController.confirmAlert.setTitle("알림");
	    			MMainController.confirmAlert.setHeaderText("해당 게시물이 삭제되었습니다.");
	    			MMainController.confirmAlert.showAndWait();
	    			
	    			MReviewCoinbtnController.getRC().RLoadPage("MReviewPage");
	    		}
	    	}
	    }

	    @FXML
	    void UpdateAction(ActionEvent event) {
	    	
	    	
	    }

}
