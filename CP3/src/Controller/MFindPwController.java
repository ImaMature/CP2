package Controller;

import DAO.MemberDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MFindPwController {

	Alert alert = new Alert(AlertType.INFORMATION);
    @FXML
    private TextField Emailtxt;

    @FXML
    private Button FindPwbtn;

    @FXML
    private Button GoFindIdbtn;

    @FXML
    private TextField Idtxt;

    @FXML
    private ImageView ImageBack;

    @FXML
    private AnchorPane loginpane;

    @FXML
    void BackOMC(MouseEvent event) {
    	MainController.getMainController().LoadPage("LoginPage");
    }

    @FXML
    void FindPwAction(ActionEvent event) {
    	try{
    		String result = MemberDAO.getMemberDAO().findpw(Idtxt.getText(), Emailtxt.getText());
    		if(result != null) {
    			alert.setTitle("비밀번호 찾기 성공");
    			alert.setHeaderText("회원님의 비밀번호는 " +result+"입니다. \n\n확인을 누르시면 로그인 페이지로 이동합니다.");
    			alert.showAndWait();
    			MainController.getMainController().LoadPage("LoginPage");
    		}else {
    			alert.setTitle("비밀번호 찾기 실패");
    			alert.setHeaderText("일치하는 정보가 없습니다.");
    			alert.showAndWait();
    		}
    	}catch (Exception e) {
    		System.out.println("비밀번호찾기 FXML오류" +e.getMessage());
    	}
    }

    @FXML
    void GoFindIdAction(ActionEvent event) {
    	MainController.getMainController().LoadPage("FindIdPage");
    }
}
