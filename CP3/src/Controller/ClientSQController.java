package Controller;

import DAO.BoardDAO;
import DAO.MemberDAO;
import Domain.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ClientSQController {

	
	@FXML
    private ImageView Backimg;

    @FXML
    private TextArea QContentstxt;

    @FXML
    private TextField QTitletxt;

    @FXML
    private Button Sendbtn;

    @FXML
    void BackOMC(MouseEvent event) {
    	MMainController.getmmainController().MLoadPage("ClientServicePage");
    }
    @FXML
    void SendAction(ActionEvent event) {
    	String mid = LoginController.getLoginController().getloginid();
    	int m_no = MemberDAO.getMemberDAO().getMemberNo(mid);
    						//DB board���̺��� c_no�� ���⼭�� �ʿ�����Ƿ� db���� not null�ΰ� ���ֱ� �׷� 0�����ص� ��
    	Board board = new Board(m_no, QTitletxt.getText(),QContentstxt.getText(),3);
    	boolean rs = BoardDAO.getboardDAO().Mqnaboardwrite(board);
    	if(rs) {
    		MMainController.infoAlert.setTitle("�˸�");
    		MMainController.infoAlert.setHeaderText("�Խù� ��� ����");
    		MMainController.infoAlert.showAndWait();
    		MMainController.getmmainController().MLoadPage("ClientServicePage");
    	}else {
    		MMainController.infoAlert.setTitle("�˸�");
    		MMainController.infoAlert.setHeaderText("�Խù� ��� ����");
    		MMainController.infoAlert.showAndWait();
    	}
    }
}
