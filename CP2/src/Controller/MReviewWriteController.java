package Controller;

import DAO.BoardDAO;
import DAO.MemberDAO;
import Domain.Board;
import Domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MReviewWriteController {

	 @FXML
	    private ImageView BackImg;

	    @FXML
	    private TextArea ReviewContentstxt;

	    @FXML
	    private TextField ReviewTitletxt;

	    @FXML
	    private Button Writebtn;

	    @FXML
	    void BackOMC(MouseEvent event) {
	    	MMainController.getmmainController().MLoadPage("MReviewPage");
	    }

	    @FXML
	    void WriteAction(ActionEvent event) {
	    	
	    	String loginid = LoginController.getLoginController().getloginid();
	    	int loginNo = MemberDAO.getMemberDAO().getMemberNo(loginid);
	    	//Member loginInfo = MemberDAO.getMemberDAO().getmemberinfo(loginNo);
	    	
	    	//코인 넘버를 빼오는 메소드 필요 그래서 0으로 해놨음
	    																		// 1자리에 c_no를 넣어야함
	    	Board board = new Board(loginNo, ReviewTitletxt.getText(), ReviewContentstxt.getText(), 2, 1);
	    	System.out.println(board.toString());
	    	boolean result = BoardDAO.getboardDAO().boardwrite(board);
		    	if(result) {
		    			MMainController.infoAlert.setTitle("알림");
		    			MMainController.infoAlert.setHeaderText("게시물 등록 성공");
		    			MMainController.infoAlert.showAndWait();
		    			MMainController.getmmainController().MLoadPage("MReviewPage");
		    		
		    	}else { 
		    		MMainController.infoAlert.setTitle("알림");
		    		MMainController.infoAlert.setHeaderText("게시물 등록 실패");
		    		MMainController.infoAlert.showAndWait();
		    	}
	    	
	    }
}
