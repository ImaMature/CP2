package Controller;

import DAO.BoardDAO;
import DAO.MemberDAO;
import Domain.Board;
import Domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ANoticewriteController {
	
	@FXML
    private Button ACancelbtn;

    @FXML
    private TextArea AContentsTxt;

    @FXML
    private TextField Atitletxt;

    @FXML
    private Button Awritebtn;

    @FXML
    void AcancelAction(ActionEvent event) {
    	AMainController.getamainController().ALoadPage("ANoticeListPage");
    }

    @FXML
    void AwriteAction(ActionEvent event) {
    	String loginid = LoginController.getLoginController().getloginid(); //  로그인 사람 아이디 
    	Member member = MemberDAO.getMemberDAO().getmemberinfo(loginid); // 로그인한 사람의 회원정보[ 회원번호 포함 ] 
    	 Board board = new Board(member.getM_no(), Atitletxt.getText(), AContentsTxt.getText(), 1, 0);
    	boolean result =  BoardDAO.getboardDAO().boardwrite(board);
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(result) {
    		alert.setHeaderText("게시물 등록 성공");
    		alert.showAndWait();
    		AMainController.getamainController().ALoadPage("ANoticeListPage");
    	} else {
    		alert.setHeaderText("[알림] 게시물 등록 실패");
    		alert.showAndWait();
    	}
    }
	
}