package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.CoinDAO;
import Domain.Coin;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class CoinListRefreshController implements Initializable {

   public CoinListRefreshController() {
      
   }
   
   @Override
   public void initialize(URL arg0, ResourceBundle arg1) {
      refreshCoin();
   }

   @FXML
   private AnchorPane CoinListRefreshPane;

   String ClickCoinName;

   static VBox Namevb;   
   
   public void refreshCoin() {
      int col = CoinDAO.getDAO().coinCol();
      for (int j = 1; j < col + 1; j++) {
         Coin coin = CoinDAO.getDAO().getCoinStatus(j);
         Namevb = new VBox();
         VBox Pricevb = new VBox();
         VBox Leftvb = new VBox();
         Label CoinName = new Label();
         Label CoinPrice = new Label();
         Label CoinLeft = new Label();

         int k = 5;

         CoinName.setText(coin.getC_name());
         CoinName.setLayoutX(30);
         CoinName.setLayoutY(k + j * 40);
         CoinName.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
//            CoinName.setTextFill(Color.web("#ffffff"));
         CoinPrice.setText(Integer.toString(coin.getC_price()));
         CoinPrice.setLayoutX(100);
         CoinPrice.setLayoutY(k + j * 40);
//            CoinPrice.setTextFill(Color.web("#ffffff"));
         CoinPrice.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
         CoinLeft.setText(Integer.toString(coin.getC_maxcoin()));
         CoinLeft.setLayoutX(180);
         CoinLeft.setLayoutY(k + j * 40);
//            CoinLeft.setTextFill(Color.web("#ffffff"));
         CoinLeft.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

         Namevb.getChildren().add(CoinName);
         Namevb.setLayoutX(30);
         Namevb.setLayoutY(k + j * 40);
         
         seeclick();
         
         Pricevb.getChildren().add(CoinPrice);
         Pricevb.setLayoutX(100);
         Pricevb.setLayoutY(k + j * 40);

         Leftvb.getChildren().add(CoinLeft);
         Leftvb.setLayoutX(180);
         Leftvb.setLayoutY(k + j * 40);

         CoinListRefreshPane.getChildren().add(Namevb);
         CoinListRefreshPane.getChildren().add(Pricevb);
         CoinListRefreshPane.getChildren().add(Leftvb);
      }
      
      
   }
   public void seeclick() {
      Namevb.setOnMouseClicked(e -> {
         String allString = e.toString().split(" ")[6];
         String textString = allString.toString().split("=")[1];
         String niceString = textString.split(",")[0];
         String spaceString = niceString.split("\"")[1];
         ClickCoinName = spaceString.split(" ")[0];
         
         TradeController.getSavePrice().clear();
         
         try {
            
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\JHD\\git\\CP2\\CP2\\src\\text/Click.txt");
            
            fileOutputStream.write(ClickCoinName.trim().getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            
         } catch (Exception e2) {
            e2.printStackTrace();
         }
         
         FileInputStream fileInputStream;
         
         try {
            
            fileInputStream = new FileInputStream("C:\\Users\\JHD\\git\\CP2\\CP2\\src\\text/Click.txt");
            
            byte[] bytes = new byte[10];
            fileInputStream.read(bytes);
            TradeController.getStringCoinName = new String(bytes);
//            System.out.println("StringCoinName : " + TradeController.getStringCoinName);
            
         } catch (Exception e1) {}
      });
   }
}