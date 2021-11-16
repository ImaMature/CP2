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
    			alert.setTitle("��й�ȣ ã�� ����");
    			alert.setHeaderText("ȸ������ ��й�ȣ�� " +result+"�Դϴ�. \n\nȮ���� �����ø� �α��� �������� �̵��մϴ�.");
    			alert.showAndWait();
    			MainController.getMainController().LoadPage("LoginPage");
    		}else {
    			alert.setTitle("��й�ȣ ã�� ����");
    			alert.setHeaderText("��ġ�ϴ� ������ �����ϴ�.");
    			alert.showAndWait();
    		}
    	}catch (Exception e) {
    		System.out.println("��й�ȣã�� FXML����" +e.getMessage());
    	}
    }

    @FXML
    void GoFindIdAction(ActionEvent event) {
    	MainController.getMainController().LoadPage("FindIdPage");
    }
}
