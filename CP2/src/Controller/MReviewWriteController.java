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
	   
	    public static int c_num; // coin name���� ���� �ѹ��� ���� ���� �����ϱ� ���� ��������

	    @FXML
	    void BackOMC(MouseEvent event) {
	    	MMainController.getmmainController().MLoadPage("MReviewPage");
	    }

	    @FXML
	    void WriteAction(ActionEvent event) {
	    	
	    	String loginid = LoginController.getLoginController().getloginid(); // �α��ε� ���̵� �� ��������
	    	int loginNo = MemberDAO.getMemberDAO().getMemberNo(loginid); // �α��ε� ���̵� �����༭ �α��ε� ȸ���� ��ȣ ��������
	    	int coincol = BoardDAO.getboardDAO().CoinRecordCount(); //(*)count�� ������ �������� ������ ����. �������� ���� = ������ ���� count�ؼ� ���� �÷��� 1���� �����Ѵ�.
		    	for(int q = 1; q < coincol + 1; q++) { //�迭�� �ε����� 0���� ����, �׷��� db�÷��� 1���� ���� �׸��� q=1�̴ϱ� 1���ͽ����Ϸ��� q<=coincol�ϰų�, q<coincol+1
		          String coinname = CoinDAO.getDAO().getCoinName(q); //�������� ������ŭ for�� ���� ������ �̸��� ��.	
			    		//System.out.println(coinname.toString());
		          c_num = BoardDAO.getboardDAO().getc_no(coinname); //������ �̸����� ������ �ѹ����ͼ� ���������� ����
		          
			    }//for�� ��																				//c_num ���� �ѹ��� ����
	    	Board board = new Board(loginNo, ReviewTitletxt.getText(), ReviewContentstxt.getText(), 2, c_num);
	    	System.out.println("board ����" + board.toString());
	    	boolean result = BoardDAO.getboardDAO().boardwrite(board);
	    	if(result) {
	    		MMainController.infoAlert.setTitle("�˸�");
	    		MMainController.infoAlert.setHeaderText("�Խù� ��� ����");
	    		MMainController.infoAlert.showAndWait();
	    		MMainController.getmmainController().MLoadPage("MReviewPage");
	    		
	    	}else { 
	    		MMainController.infoAlert.setTitle("�˸�");
	    		MMainController.infoAlert.setHeaderText("�Խù� ��� ����");
	    		MMainController.infoAlert.showAndWait();
	    	}
	    	
	    }
}
