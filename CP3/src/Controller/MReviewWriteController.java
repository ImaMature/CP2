package Controller;

import DAO.BoardDAO;
import DAO.CoinDAO;
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
	   
	    public static int c_num2; // coin name으로 코인 넘버를 빼온 것을 저장하기 위한 전역변수

	    @FXML
	    void BackOMC(MouseEvent event) {
	    	//MMainController.getmmainController().MLoadPage("MReviewPage");
	    	MReviewCoinbtnController.getRC().RLoadPage("MReviewPage");
	    }

	    @FXML
	    void WriteAction(ActionEvent event) {
	    	
	    	String loginid = LoginController.getLoginController().getloginid(); // 로그인된 아이디 값 가져오기
//	    	System.out.println("loginid 값 : "+loginid );
//	    	int loginNo = MemberDAO.getMemberDAO().getMemberNo(loginid); // 로그인된 아이디값 전해줘서 로그인된 회원의 번호 가져오기
	  		Member member = MemberDAO.getMemberDAO().getmemberinfo(loginid);													//c_num 코인 넘버가 있음
//	  		System.out.println("member값 : " + member.toString());
//	  		System.out.println("member.getM_no값 : " + member.getM_no());
	    	Board board = new Board(member.getM_no(), ReviewTitletxt.getText(), ReviewContentstxt.getText(), 2, MReviewCoinbtnController.C_num);
	    		//System.out.println("board객체 값 : " + board.toString());
	    	boolean result = BoardDAO.getboardDAO().boardwrite(board);
	    	if(result) {
	    		MMainController.infoAlert.setTitle("알림");
	    		MMainController.infoAlert.setHeaderText("게시물 등록 성공");
	    		MMainController.infoAlert.showAndWait();
	    		MReviewCoinbtnController.getRC().RLoadPage("MReviewPage");
	    		
	    	}else { 
	    		MMainController.infoAlert.setTitle("알림");
	    		MMainController.infoAlert.setHeaderText("게시물 등록 실패");
	    		MMainController.infoAlert.showAndWait();
	    	}
	    	
	    }
}
