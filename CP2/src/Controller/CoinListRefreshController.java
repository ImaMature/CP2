package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.CoinDAO;
import Domain.Coin;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class CoinListRefreshController implements Initializable {
   @Override
   public void initialize(URL arg0, ResourceBundle arg1) {
      refreshCoin();
   }

   @FXML
   private AnchorPane CoinListRefreshPane;

   public void refreshCoin() {
      int col = CoinDAO.getDAO().coinCol();
      for (int i = 1; i < col + 1; i++) {
         Coin coin = CoinDAO.getDAO().getCoinStatus(i);
         for (int j = 1; j < col + 1; j++) {
            AnchorPane anchorPane = new AnchorPane();
            Label CoinName = new Label();
            Label CoinPrice = new Label();
            Label CoinLeft = new Label();

            int k = 5;

            CoinName.setText(coin.getC_name());
            CoinName.setLayoutX(30);
            CoinName.setLayoutY(k + j * 40);
            CoinName.setTextFill(Color.web("#ffffff"));
            CoinPrice.setText(Integer.toString(coin.getC_price()));
            CoinPrice.setLayoutX(100);
            CoinPrice.setLayoutY(k + j * 40);
            CoinLeft.setText(Integer.toString(coin.getC_maxcoin()));
            CoinLeft.setLayoutX(180);
            CoinLeft.setLayoutY(k + j * 40);

            anchorPane.getChildren().add(CoinName);
            anchorPane.getChildren().add(CoinPrice);
            anchorPane.getChildren().add(CoinLeft);

            CoinListRefreshPane.getChildren().add(anchorPane);
         }
      }
   }
}