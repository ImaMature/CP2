package Controller;

import java.io.IOException;

import DAO.MemberDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MFindIdController {
	Alert alert = new Alert(AlertType.INFORMATION);

    @FXML
    private TextField Emailtxt;

    @FXML
    private Button FindIdbtn;

    @FXML
    private Button GoFindPwbtn;

    @FXML
    private ImageView ImageBack;

    @FXML
    private TextField Nametxt;

    @FXML
    private AnchorPane loginpane;

    @FXML
    void BackOMC(MouseEvent event) {
    	MainController.getMainController().LoadPage("LoginPage");

    }

    @FXML
    void FindIdAction(ActionEvent event) {
    	String result = MemberDAO.getMemberDAO().findid(Nametxt.getText(), Emailtxt.getText());
    	if(result != null) {
    		alert.setTitle("���̵�ã��");
    		alert.setHeaderText("ȸ������ ���̵�� " + result + "�Դϴ�. \n\nȮ���� �����ø� �α��� �������� �̵��մϴ�.");
    		alert.showAndWait();
    		MainController.getMainController().LoadPage("LoginPage");

    	}else { 
    		alert.setTitle("���̵�ã��");
    		alert.setHeaderText("��ġ�ϴ� ������ �����ϴ�.");
    		alert.showAndWait();}
    }

    @FXML
    void GoFindPwAction(ActionEvent event) {

    	MainController.getMainController().LoadPage("FindPwPage");
    }
 
}
