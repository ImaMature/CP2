package Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import DAO.CoinDAO;
import Domain.Coin;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class CoinManageController implements Initializable {
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		
		coinlist();
		CoinDeletebtn.setVisible(false);
		
	}
		
		public static Coin coincoin;
	    @FXML
	    private ImageView Backimg;

	    @FXML
	    private Button CoinDeletebtn;

	    @FXML
	    private Button CoinRegisterbtn;

	    @FXML
	    private TableView<Coin> Coinlist;

	    @FXML
	    void BackOMC(MouseEvent event) {
	    	AMainController.amainController.ALoadPage("AHomePage");
	    }
	    
	    public void coinlist() {
	    	ObservableList<Coin> coins = CoinDAO.getDAO().coinManagelist();
			System.out.println("coins list : " + coins);
			Coinlist.setItems(coins);
			TableColumn tc = Coinlist.getColumns().get(0);
			tc.setCellValueFactory(new PropertyValueFactory<>("c_no"));
			
			tc = Coinlist.getColumns().get(1);
			tc.setCellValueFactory(new PropertyValueFactory<>("c_name"));
			
			tc = Coinlist.getColumns().get(2);
			tc.setCellValueFactory(new PropertyValueFactory<>("c_price"));
			
			tc = Coinlist.getColumns().get(3);
			tc.setCellValueFactory(new PropertyValueFactory<>("c_maxcoin"));
			
			Coinlist.setOnMouseClicked(e -> { //e -> {정의}
				// 2. 클릭 이벤트가 마우스 클릭과 같으면 
				if(e.getButton().equals(MouseButton.PRIMARY)) {
					coincoin = Coinlist.getSelectionModel().getSelectedItem(); 
					CoinDeletebtn.setVisible(true);
				}
			});
	    }

	    @FXML
	    void CoinDeleteAction(ActionEvent event) {
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setHeaderText("제품을 삭제 하시겠습니까?");
	    	Optional<ButtonType> optional = alert.showAndWait();
	    	if(optional.get() == ButtonType.OK) {
	    		CoinDAO.getDAO().coindelete(coincoin.getC_no());
	    			Alert alert2 = new Alert(AlertType.INFORMATION);
	    			alert.setHeaderText("삭제 되었습니다.");
	    			AMainController.amainController.ALoadPage("CoinManagePage");
	    		
	    	}

	    }

	   
	    @FXML
	    void CoinRegAction(ActionEvent event) {
	    	AMainController.getamainController().ALoadPage("CoinInsertPage");
	    }
}
	
