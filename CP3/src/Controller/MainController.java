package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable{
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ManImage.setVisible(false);
		userid.setVisible(false);
		
	}
	
	public static MainController mainController;
	
	public static MainController getMainController() {
		return mainController;
	}
	
	public MainController() {
		mainController = this;
	}
	
	@FXML
    private Label BoardLabel;

    @FXML
    private Button Loginbtn;

    @FXML
    private BorderPane MainBoarderPane;

    @FXML
    private ImageView ManImage;

    @FXML
    private Label NoticeLabel;

    @FXML
    private Label QnALabel;

    @FXML
    private Label TradeLabel;

    @FXML
    private Button Tradebtn;

    @FXML
    private Label lblhome;

    @FXML
    private Label userid;

    @FXML
    void BoardOMC(MouseEvent event) {

    	Alert alert = new Alert(AlertType.WARNING);
    	alert.setTitle("로그인 필요.");
    	alert.setHeaderText("로그인해주시기 바랍니다.");
    	alert.showAndWait();
    }

    @FXML
    void LoginAction(ActionEvent event) {
    	LoadPage("LoginPage");
    }

    @FXML
    void ManimageOMC(MouseEvent event) {
    	
    	
    }

    @FXML
    void NoticeOMC(MouseEvent event) {
    	Alert alert = new Alert(AlertType.WARNING);
    	alert.setTitle("로그인 필요.");
    	alert.setHeaderText("로그인해주시기 바랍니다.");
    	alert.showAndWait();
    	
    }

    @FXML
    void QnAOMC(MouseEvent event) {

    	Alert alert = new Alert(AlertType.WARNING);
    	alert.setTitle("로그인 필요.");
    	alert.setHeaderText("로그인해주시기 바랍니다.");
    	alert.showAndWait();
    }

    @FXML
    void TradeAction(ActionEvent event) {
    	LoadPage("TradePage");
    }

    @FXML
    void TradeOMC(MouseEvent event) {

    	Alert alert = new Alert(AlertType.WARNING);
    	alert.setTitle("로그인 필요.");
    	alert.setHeaderText("로그인해주시기 바랍니다.");
    	alert.showAndWait();
    }

    @FXML
    void home(MouseEvent event) {
    	LoadPage("HomePage");
    }
    
    public void LoadPage(String page) {
    	try {
    	Parent parent = FXMLLoader.load(getClass().getResource("/View/" + page + ".fxml"));
			MainBoarderPane.setCenter(parent);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
    }
}
