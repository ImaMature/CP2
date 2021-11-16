package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import DAO.CoinDAO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class TradeController implements Initializable {
   private static ArrayList<Integer> savePrice = new ArrayList<>();
   int saveBefore = 0;
   int saveAfter = CoinDAO.getDAO().outPrice("비트코인");
   
   @Override
   public void initialize(URL arg0, ResourceBundle arg1) {
      Thread refreshChart = new Thread(new Runnable() {
         
         @Override
         public void run() {
            Runnable updateChart = new Runnable() {
               
               @Override
               public void run() {
                  LoadPage("chart");
               }
            };
            
            while(true) {
               try {
                  Thread.sleep(1000);
               } catch (InterruptedException e) {
                  System.out.println(e.getMessage());
               }
               Platform.runLater(updateChart);
            }
         }
      });
      refreshChart.start();
      Thread refreshRandom = new Thread(new Runnable() {
         
         @Override
         public void run() {
            while(true) {
               try {
                  Thread.sleep(1000);
                  Random ran = new Random();
                  int i = 0;
                  while(true) {
                     saveBefore = ran.nextInt(100000000);
                     if(saveAfter == 0) {
                        saveAfter = saveBefore;
                     } else {
                        if(saveAfter < (saveBefore + 10000) && saveAfter > (saveBefore - 10000)) {
                           saveAfter = saveBefore;
                           Thread.sleep(1000);
                           savePrice.add(saveAfter);
//                           CoinDAO.getDAO().updateCoin(1, savePrice.get(i));
                           i++;
                        }
                     }
                  }
               } catch (InterruptedException e) {
                  System.out.println(e.getMessage());
               }
            }
         }
      });
      refreshRandom.start();
   }
   
   public static TradeController tradeController;
   
   public static TradeController getTradeController() {
      return tradeController;
   }
   
   public TradeController() {
      tradeController = this;
   }
   
   public static ArrayList<Integer> getSavePrice(){
      return savePrice;
   }
   
    @FXML
    private BorderPane TradeBoarderPane;
   
   public void LoadPage(String page) {
      try {
         Parent parent = FXMLLoader.load(getClass().getResource("/View/" + page + ".fxml"));
         TradeBoarderPane.setLeft(parent);
      } catch (IOException e) {
         System.out.println(e.getMessage());
      }
   }
}