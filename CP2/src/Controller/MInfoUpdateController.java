package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.MemberDAO;
import Domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MInfoUpdateController implements Initializable{
	
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			String loginid = LoginController.getLoginController().getloginid();
			int loginNo = MemberDAO.getMemberDAO().getMemberNo(loginid);
			Member member = MemberDAO.getMemberDAO().getmemberinfo(loginNo);
			MemberIDLabel.setText(member.getM_id());
		
		}
		
		public  Alert alert = new Alert(AlertType.INFORMATION);
		
	 	@FXML
	    private ImageView BackImg;

	    @FXML
	    private TextField Emailtxt;

	    @FXML
	    private TextField Nametxt;

	    @FXML
	    private Label MemberIDLabel;

	    @FXML
	    private Button MemberUpdatebtn;

	    @FXML
	    private PasswordField PwConfirmfield;

	    @FXML
	    private PasswordField Pwfield;

	    @FXML
	    private Button SignOutbtn;

	    @FXML
	    void BackOMC(MouseEvent event) {
	    	MMainController.getmmainController().MLoadPage("MyInfoPage");
	    }

	    @FXML //�̸� 2���� �̻󿡼� ����
	    void MemberUpdateAcion(ActionEvent event) {
	    	if(Nametxt.getText().length()<2) {
	    		alert.setTitle("�˸�");
	    		alert.setHeaderText("�̸��� 2���� �̻� �����մϴ�.");
	    		alert.showAndWait();
	    		return;
	    	}
	    	if(Pwfield.getText().length() < 4 || Pwfield.getText().length() > 13) {
	    		alert.setTitle("�˸�");
	    		alert.setHeaderText("��й�ȣ�� 4 ~ 12���ڸ� �����մϴ�.");
	    		alert.showAndWait();
	    		return;
	    	}
	    	
	    	if(!Pwfield.getText().equals(PwConfirmfield.getText())) {
	    		alert.setTitle("�˸�");
	    		alert.setHeaderText("��й�ȣ�� �������� �ʽ��ϴ�.");
	    		alert.showAndWait();
	    		return;
	    	}
	    	
	    	if(Emailtxt.getText().length() < 5 || !Emailtxt.getText().contains("@")) {
	    		alert.setTitle("�˸�");
	    		alert.setHeaderText("�̸��� ������ �ƴմϴ�.");
	    		alert.showAndWait();
	    		return;
    		}

	    	boolean result = MemberDAO.getMemberDAO().MInfoUpdate(Nametxt.getText(), Emailtxt.getText(), Pwfield.getText(), MemberIDLabel.getText());
	    	if(result) {
	    		alert.setTitle("�˸�");
	    		alert.setHeaderText("ȸ�������� �����Ǿ����ϴ�.");
	    		alert.showAndWait();
	    		MMainController.getmmainController().MLoadPage("MyInfoPage");
	    	}else {
	    		alert.setTitle("�˸�");
	    		alert.setHeaderText("ȸ������ ���� ���� �߻�!\n�����ڿ��� �����ϼ���");
	    		alert.showAndWait();
	    	}
	    }

	    @FXML
	    void SignOutAction(ActionEvent event) {

	    }
}
