package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.BoardDAO;
import DAO.CoinDAO;
import Domain.Board;
import Domain.Coin;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class CoinInsertController  {

   @FXML
    private ImageView BackImg;

    @FXML
    private TextField CoinNametxt;

    @FXML
    private Button CoinRegisterbtn;

    @FXML
    private TextField coinpricetxt;

    @FXML
    private TextField maxcointxt;

    @FXML
    void BackOMC(MouseEvent event) {
    	AMainController.getamainController().ALoadPage("CoinManagePage");
    }

    @FXML
    void CRegisterAction(ActionEvent event) {
    	int coinprice = Integer.parseInt(coinpricetxt.getText());
    	int maxcoin = Integer.parseInt(maxcointxt.getText());
    	String coinname = CoinNametxt.getText();
    	System.out.println("maxcoin : " + maxcoin);
    	System.out.println("coinprice : " + coinprice);
    	Boolean rs = CoinDAO.getDAO().coinReg(coinname, coinprice, maxcoin);
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(rs) {
    		alert.setTitle("알림");;
    		alert.setHeaderText("코인 등록에 성공하였습니다.");
    		alert.showAndWait();
    		AMainController.getamainController().ALoadPage("CoinManagePage");
    	}else {
    		alert.setTitle("알림");;
    		alert.setHeaderText("코인 등록에 실패하였습니다.");
    		alert.showAndWait();
    	}
    }
}