package Controller;

import DAO.MemberDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
   
	
	Alert alert = new Alert(AlertType.INFORMATION); 
	
	public static LoginController loginController;
	
	public static LoginController getLoginController() {
		return loginController;
	}
	
	public LoginController() {
		loginController = this;
	}
	
    @FXML
    private Label FindLabel;

    @FXML
    private TextField IDtxt;

    @FXML
    private AnchorPane LoginPane;

    @FXML
    private Button Loginbtn;

    @FXML
    private PasswordField PWtxt;

    @FXML
    private Button SignUpbtn;
    
    @FXML
    private ImageView ImageCancel;

    
    @FXML
    void FindIdPwOMC(MouseEvent event) {
    	MainController.getMainController().LoadPage("FindIdPage");
    }

    @FXML
    //로그인 회원 -> MemberMainpage / 어드민 -> AdminMainPage
    void LoginAction(ActionEvent event) {
    	
    	
    	if(IDtxt.getText().equals("admin") && PWtxt.getText().equals("1234")) {
    		System.out.println("");
    		Loginbtn.getScene().getWindow().hide();
    		Stage stage = new Stage();
    		try {
				Parent parent = FXMLLoader.load(getClass().getResource("/View/AMainPage.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.setTitle("Gazua!");
				stage.show();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
    	}
    	else {
	    	boolean result = MemberDAO.getMemberDAO().LoginAction(IDtxt.getText(), PWtxt.getText());
	    	if(result) {
	    		alert.setTitle("알림");
	    		alert.setHeaderText("로그인 성공");
	    		alert.showAndWait();
	    		
	    		Loginbtn.getScene().getWindow().hide();
	    		Stage stage = new Stage();
	    		try {
					Parent parent = FXMLLoader.load(getClass().getResource("/View/MMainPage.fxml"));
					Scene scene = new Scene(parent);
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Gazua!");
					stage.show();
				} catch (Exception e) {
					
					System.out.println("로그인 오류"+e.getMessage());
				}
	    	}else {alert.setTitle("알림");
    		alert.setHeaderText("로그인 실패");
    		alert.showAndWait();
	    	}
    	}
    }

    @FXML
    void SignUpAction(ActionEvent event) {
    	MainController.getMainController().LoadPage("SignUpPage");
    }
    @FXML
    void Cancel(MouseEvent event) {
    	MainController.getMainController().LoadPage("HomePage");
    }

   public String getloginid() {
	   return IDtxt.getText();
   }

}
