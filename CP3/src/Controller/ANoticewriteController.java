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
    	String loginid = LoginController.getLoginController().getloginid(); //  �α��� ��� ���̵� 
    	Member member = MemberDAO.getMemberDAO().getmemberinfo(loginid); // �α����� ����� ȸ������[ ȸ����ȣ ���� ] 
    	 Board board = new Board(member.getM_no(), Atitletxt.getText(), AContentsTxt.getText(), 1, 0);
    	boolean result =  BoardDAO.getboardDAO().boardwrite(board);
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(result) {
    		alert.setHeaderText("�Խù� ��� ����");
    		alert.showAndWait();
    		AMainController.getamainController().ALoadPage("ANoticeListPage");
    	} else {
    		alert.setHeaderText("[�˸�] �Խù� ��� ����");
    		alert.showAndWait();
    	}
    }
	
}