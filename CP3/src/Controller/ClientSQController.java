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
    						//DB board테이블에서 c_no가 여기서는 필요없으므로 db에서 not null인거 빼주기 그럼 0으로해도 들어감
    	Board board = new Board(m_no, QTitletxt.getText(),QContentstxt.getText(),3);
    	boolean rs = BoardDAO.getboardDAO().Mqnaboardwrite(board);
    	if(rs) {
    		MMainController.infoAlert.setTitle("알림");
    		MMainController.infoAlert.setHeaderText("게시물 등록 성공");
    		MMainController.infoAlert.showAndWait();
    		MMainController.getmmainController().MLoadPage("ClientServicePage");
    	}else {
    		MMainController.infoAlert.setTitle("알림");
    		MMainController.infoAlert.setHeaderText("게시물 등록 실패");
    		MMainController.infoAlert.showAndWait();
    	}
    }
}
