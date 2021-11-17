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
	    	
	    	String loginid = LoginController.getLoginController().getloginid(); // 로그인된 아이디 값 가져오기
	    	int loginNo = MemberDAO.getMemberDAO().getMemberNo(loginid); // 로그인된 아이디값 전해줘서 로그인된 회원의 번호 가져오기
	    	int coincol = BoardDAO.getboardDAO().CoinRecordCount(); //(*)count로 코인의 데이터의 개수를 빼옴. 데이터의 개수 = 코인의 개수 count해서 나온 컬럼은 1부터 시작한다.
		    	for(int q = 1; q < coincol + 1; q++) { //배열의 인덱스는 0부터 시작, 그러나 db컬럼은 1부터 시작 그리고 q=1이니까 1부터시작하려면 q<=coincol하거나, q<coincol+1
		          String coinname = CoinDAO.getDAO().getCoinName(q); //데이터의 개수만큼 for문 돌려 코인의 이름을 얻어냄.	
			    		//System.out.println(coinname.toString());
		          c_num = BoardDAO.getboardDAO().getc_no(coinname); //코인의 이름으로 코인의 넘버빼와서 전역변수에 저장
		          
			    }//for문 끝																				//c_num 코인 넘버가 있음
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
