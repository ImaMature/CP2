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

	    @FXML //이름 2글자 이상에서 오류
	    void MemberUpdateAcion(ActionEvent event) {
	    	if(Nametxt.getText().length()<2) {
	    		alert.setTitle("알림");
	    		alert.setHeaderText("이름은 2글자 이상만 가능합니다.");
	    		alert.showAndWait();
	    		return;
	    	}
	    	if(Pwfield.getText().length() < 4 || Pwfield.getText().length() > 13) {
	    		alert.setTitle("알림");
	    		alert.setHeaderText("비밀번호는 4 ~ 12글자만 가능합니다.");
	    		alert.showAndWait();
	    		return;
	    	}
	    	
	    	if(!Pwfield.getText().equals(PwConfirmfield.getText())) {
	    		alert.setTitle("알림");
	    		alert.setHeaderText("비밀번호가 동일하지 않습니다.");
	    		alert.showAndWait();
	    		return;
	    	}
	    	
	    	if(Emailtxt.getText().length() < 5 || !Emailtxt.getText().contains("@")) {
	    		alert.setTitle("알림");
	    		alert.setHeaderText("이메일 형식이 아닙니다.");
	    		alert.showAndWait();
	    		return;
    		}

	    	boolean result = MemberDAO.getMemberDAO().MInfoUpdate(Nametxt.getText(), Emailtxt.getText(), Pwfield.getText(), MemberIDLabel.getText());
	    	if(result) {
	    		alert.setTitle("알림");
	    		alert.setHeaderText("회원정보가 수정되었습니다.");
	    		alert.showAndWait();
	    		MMainController.getmmainController().MLoadPage("MyInfoPage");
	    	}else {
	    		alert.setTitle("알림");
	    		alert.setHeaderText("회원정보 수정 오류 발생!\n관리자에게 문의하세요");
	    		alert.showAndWait();
	    	}
	    }

	    @FXML
	    void SignOutAction(ActionEvent event) {

	    }
}
