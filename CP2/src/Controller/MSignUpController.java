package Controller;

import DAO.MemberDAO;
import Domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MSignUpController {
	
		@FXML
		private ImageView ImageCancel;
		

	    @FXML
	    private TextField Emailtxt;

	    @FXML
	    private TextField IDtxt;

	    @FXML
	    private TextField Nametxt;

	    @FXML
	    private PasswordField PWConfirmtxt;

	    @FXML
	    private PasswordField PWtxt;

	    @FXML
	    private Button SignUpbtn;

	    @FXML
	    private AnchorPane cp;

	    public Alert alert = new Alert(AlertType.WARNING);
	    @FXML
	    void  CancelOMC (MouseEvent event) {

	    	MainController.getMainController().LoadPage("HomePage");
	    }

	    @FXML
	    void RealSignupAction(ActionEvent event) {
	    	
	    	if(IDtxt.getText().length()<4 || IDtxt.getText().length()> 13) {
	    		alert.setTitle("�˸�");
	    		alert.setHeaderText("���̵�� 4 ~ 12 ���ڸ� �����մϴ�.");
	    		alert.showAndWait();
	    		return;
	    	}
	    	
	    	if(PWtxt.getText().length() < 4 || PWtxt.getText().length() > 13) {
	    		alert.setTitle("�˸�");
	    		alert.setHeaderText("��й�ȣ�� 4 ~ 12���ڸ� �����մϴ�.");
	    		alert.showAndWait();
	    		return;
	    	}
	    	
	    	if(!PWtxt.getText().equals(PWConfirmtxt.getText())) {
	    		alert.setTitle("�˸�");
	    		alert.setHeaderText("��й�ȣ�� �������� �ʽ��ϴ�.");
	    		alert.showAndWait();
	    		return;
	    	}
	    	if(Nametxt.getText().length()<2) {
	    		alert.setTitle("�˸�");
	    		alert.setHeaderText("�̸��� 2���� �̻� �����մϴ�.");
	    		alert.showAndWait();
	    		return;
	    	}
	    	if(Emailtxt.getText().length() < 5 || !Emailtxt.getText().contains("@")) {
	    		alert.setTitle("�˸�");
	    		alert.setHeaderText("�̸��� ������ �ƴմϴ�.");
	    		alert.showAndWait();
	    		return;
    		}
	    	
	    	boolean idcheck = MemberDAO.getMemberDAO().idcheck(IDtxt.getText());
	    		if(idcheck) {
	    			alert.setTitle("�˸�");
		    		alert.setHeaderText("�ߺ��� ���̵��Դϴ�.");
		    		alert.showAndWait();
		    		return;
	    		}
	    	
	    	
	    		
	    	Member member = new Member(IDtxt.getText(), PWtxt.getText(), Nametxt.getText(), Emailtxt.getText());
	    	
	    	boolean idcheckResult = MemberDAO.getMemberDAO().RealSignupAction(member);
	    	if(idcheckResult) {
	    		alert.setTitle("�˸�");
	    		alert.setHeaderText("�������ּż� �����մϴ�.");
	    		alert.showAndWait();
	    		SignUpbtn.getScene().getWindow().hide();
	    		Stage stage = new Stage();
	    		try {
					Parent parent = FXMLLoader.load(getClass().getResource("/View/LoginPage.fxml"));
					Scene scene = new Scene(parent);
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Gazua!");
					stage.show();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
	    	}else {
	    		alert.setTitle("�˸�");
	    		alert.setHeaderText("ȸ������ ����");
	    		alert.showAndWait();
	    	}
	    }


    
}
