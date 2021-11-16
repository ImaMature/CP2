package Controller;

import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AMainController {

	public static AMainController AMainC;
	
	
	
    public static AMainController getAMainC() {
		return AMainC;
	}

	public AMainController() {
		AMainC = this;
	}
	@FXML
    private Label ABoardLabel;

    @FXML
    private Label ANoticeLabel;

    @FXML
    private Label AQnALabel;

    @FXML
    private Label ATradeLabel;

    @FXML
    private Label AdminLogout;

    @FXML
    private Label Alblhome;

    @FXML
    private Button Loginbtn;

    @FXML
    private BorderPane MainBoarderPane;

    @FXML
    private Button Tradebtn;

    @FXML
    void AdminBoardOMC(MouseEvent event) {

    }

    @FXML
    void AdminHomeOMC(MouseEvent event) {
    	AMainController.getAMainC().ALoadPage("AHomePage");
    }

    @FXML
    void AdminLogoutOMC(MouseEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("로그아웃 확인");
    	alert.setHeaderText("로그아웃 하시겠습니까?");
     	Optional<ButtonType> optional = alert.showAndWait();
     	if(optional.get() == ButtonType.OK) {
     		AdminLogout.getScene().getWindow().hide();
     		Stage stage = new Stage();
     		try {
				Parent parent = FXMLLoader.load(getClass().getResource("/View/MainPage.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     	}
    }

    @FXML
    void AdminNoticeOMC(MouseEvent event) {

    }

    @FXML
    void AdminQnAOMC(MouseEvent event) {

    }

    @FXML
    void AdminTradeOMC(MouseEvent event) {

    }

    public void ALoadPage(String page) {
    	try {
			Parent parent = FXMLLoader.load(getClass().getResource("/View/"+page+".fxml"));
			MainBoarderPane.setCenter(parent);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
