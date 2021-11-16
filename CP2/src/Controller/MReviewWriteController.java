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

	    }

	    @FXML
	    void WriteAction(ActionEvent event) {
	    	String loginid = LoginController.getLoginController().getloginid();
	    	Member userid = MemberDAO.getMemberDAO().getmemberinfo(loginid);
	    	Board board = new Board(userid.getM_no(), ReviewTitletxt.getText(), ReviewContentstxt.getText(), 0, 0);
		    	if(board != null) {
		    		
		    		
		    	}else { 
		    		MMainController.infoAlert.setTitle("버그 발생!");
		    		MMainController.infoAlert.setHeaderText("잘못된 입력입니다!");
		    		MMainController.infoAlert.showAndWait();
		    	}
	    	
	    }
}
