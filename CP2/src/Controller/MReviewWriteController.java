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
	   
	    public static int c_num; // coin name으로 코인 넘버를 빼온 것을 저장하기 위한 전역변수

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
	    	int coincol = BoardDAO.getboardDAO().CoinRecordCount(); //count해서 나온 컬럼은 1부터시작한다.
	    	for(int q = 1; q < coincol + 1; q++) { //배열의 인덱스는 0부터 시작, 그러나 db컬럼은 1부터 시작 그리고 q=1이니까 1부터시작하려면 q<=coincol하거나, q<coincol+1
	          String coinname = CoinDAO.getDAO().getCoinName(q);	
		    		//System.out.println(coinname.toString());
	          c_num = BoardDAO.getboardDAO().getc_no(coinname);
	          // 1자리에 c_no를 넣어야함
		    }//for문 끝
	    	Board board = new Board(loginNo, ReviewTitletxt.getText(), ReviewContentstxt.getText(), 2, c_num);
	    	System.out.println("board 문제" + board.toString());
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
