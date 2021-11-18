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
	   
	    public static int c_num2; // coin name���� ���� �ѹ��� ���� ���� �����ϱ� ���� ��������

	    @FXML
	    void BackOMC(MouseEvent event) {
	    	//MMainController.getmmainController().MLoadPage("MReviewPage");
	    	MReviewCoinbtnController.getRC().RLoadPage("MReviewPage");
	    }

	    @FXML
	    void WriteAction(ActionEvent event) {
	    	
	    	String loginid = LoginController.getLoginController().getloginid(); // �α��ε� ���̵� �� ��������
//	    	System.out.println("loginid �� : "+loginid );
//	    	int loginNo = MemberDAO.getMemberDAO().getMemberNo(loginid); // �α��ε� ���̵� �����༭ �α��ε� ȸ���� ��ȣ ��������
	  		Member member = MemberDAO.getMemberDAO().getmemberinfo(loginid);													//c_num ���� �ѹ��� ����
//	  		System.out.println("member�� : " + member.toString());
//	  		System.out.println("member.getM_no�� : " + member.getM_no());
	    	Board board = new Board(member.getM_no(), ReviewTitletxt.getText(), ReviewContentstxt.getText(), 2, MReviewCoinbtnController.C_num);
	    		//System.out.println("board��ü �� : " + board.toString());
	    	boolean result = BoardDAO.getboardDAO().boardwrite(board);
	    	if(result) {
	    		MMainController.infoAlert.setTitle("�˸�");
	    		MMainController.infoAlert.setHeaderText("�Խù� ��� ����");
	    		MMainController.infoAlert.showAndWait();
	    		MReviewCoinbtnController.getRC().RLoadPage("MReviewPage");
	    		
	    	}else { 
	    		MMainController.infoAlert.setTitle("�˸�");
	    		MMainController.infoAlert.setHeaderText("�Խù� ��� ����");
	    		MMainController.infoAlert.showAndWait();
	    	}
	    	
	    }
}
