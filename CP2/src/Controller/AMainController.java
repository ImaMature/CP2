package Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AMainController implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { }
	
	public static AMainController amainController;
	
	public static AMainController getamainController() {
		return amainController;
	}
	public AMainController() {
		amainController=this;
	}

  
    
    @FXML
    private AnchorPane AMainBoarderPane;

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
    void AdminHomeOMC(MouseEvent event) {
    	AMainController.getamainController().ALoadPage("AHomePage");
    }

    @FXML
    void AdminLogoutOMC(MouseEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("로그아웃 확인");
    	alert.setHeaderText("확인버튼을 누르시면 로그아웃 하게 됩니다. \n\n 로그아웃 하시겠습니까?");
    	
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get()==ButtonType.OK) {
    		AdminLogout.getScene().getWindow().hide();
    		Stage stage = new Stage();
    		try {
				Parent parent = FXMLLoader.load(getClass().getResource("/View/MainPage.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.setTitle("Gazua!");
				stage.show();
			} catch (Exception e) {
				System.out.println("로그아웃 오류" + e.getMessage());
			}
    	}
    }

    @FXML
    void AdminNoticeOMC(MouseEvent event) {
    	AMainController.getamainController().ALoadPage("ANoticeListPage");
    }

    @FXML
    void AdminQnAOMC(MouseEvent event) {
    	AMainController.getamainController().ALoadPage("AQnAPage");
    }

    @FXML
    void AdminTradeOMC(MouseEvent event) {
    	AMainController.getamainController().ALoadPage("CoinManagePage");
    }

   public void ALoadPage(String page) {
	   try {
		Parent parent = FXMLLoader.load(getClass().getResource("/View/"+page+".fxml"));
		MainBoarderPane.setCenter(parent);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
   }
}