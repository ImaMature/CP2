package Controller;

import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MMainController implements Initializable{
	public static Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
	public static Alert infoAlert = new Alert(AlertType.INFORMATION);
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		UserIdLabel.setText(LoginController.getLoginController().getloginid());
		
	}
	public static MMainController mmainController;
	
	public static MMainController getmmainController() {
		return mmainController;
	}
	
	public MMainController() {
		mmainController = this;
	}
	
    @FXML
    private Label BoardLabel;

    @FXML
    private Button GetMoneybtn;

    @FXML
    private ImageView ManImage;

    @FXML
    private BorderPane MMainBoarderPane;

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
    private Label UserIdLabel;

    @FXML
    void BoardOMC(MouseEvent event) {
    	MMainController.getmmainController().MLoadPage("MReviewCoinbtnpage");
    }


	@FXML
    void ManimageOMC(MouseEvent event) {
    	
    	confirmAlert.setTitle("�α׾ƿ� Ȯ��");
    	confirmAlert.setHeaderText("Ȯ�ι�ư�� �����ø� �α׾ƿ��ϰ� �˴ϴ�.\n\n�α׾ƿ� �Ͻðڽ��ϱ�?");
    	
    	Optional<ButtonType> optional = confirmAlert.showAndWait();
    	if(optional.get() == ButtonType.OK) {
    		ManImage.getScene().getWindow().hide();
    		
    		Stage stage = new Stage();
    		try {
				Parent parent = FXMLLoader.load(getClass().getResource("/View/MainPage.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.setTitle("Gazua!");
				stage.show();
			} catch (Exception e) {
				System.out.println("�α׾ƿ� ����" + e.getMessage());
			}
    	}
    }
	
	
	
    //ȸ������
    @FXML
    void MemberInfoOMC(MouseEvent event) {
    	MMainController.getmmainController().MLoadPage("MyinfoPage");
    }

    //�����Խ���
    @FXML
    void NoticeOMC(MouseEvent event) {
    	try{MMainController.getmmainController().MLoadPage("ANoticeListPage");}
    	catch(Exception e) {System.out.println("�����������̵�����" + e.getMessage());}
    }
    //QNA
    @FXML
    void QnAOMC(MouseEvent event) {
    	MMainController.getmmainController().MLoadPage("ClientServicePage");
    }

    
    @FXML
    void TradeAction(ActionEvent event) {
    	MMainController.getmmainController().MLoadPage("MyinfoPage");
    }
    
    //�ŷ� ��ư
    @FXML 
    void TradeAction2(ActionEvent event) {
    	MMainController.getmmainController().MLoadPage("TradePage");
    }

    @FXML
    void TradeOMC(MouseEvent event) {
    	MMainController.getmmainController().MLoadPage("TradePage");
    }

    @FXML
    void home(MouseEvent event) {
    	MMainController.getmmainController().MLoadPage("MHomePage");
    }
    			//after member login page move method 
    public void MLoadPage(String page) {
    	try {
			Parent parent = FXMLLoader.load(getClass().getResource("/View/"+page+".fxml"));
			MMainBoarderPane.setCenter(parent);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
}