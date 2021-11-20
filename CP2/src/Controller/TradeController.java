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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class TradeController implements Initializable {
   private static ArrayList<Integer> savePrice = new ArrayList<>();
   ArrayList<String> coinName = new ArrayList<>();
   int saveBefore = 0;
   int saveAfter;
   String coinname;
   int coincol;
   Thread refreshChart;
   Thread refreshRandom;
   Thread ListRefresh;

   @Override
   public void initialize(URL arg0, ResourceBundle arg1) {
      refreshChart = new Thread(new Runnable() {

         @Override
         public void run() {
            Runnable updateChart = new Runnable() {

               @Override
               public void run() {
                  LoadPage("ChartPage");
                  System.out.println(coinName);
               }
            };

            while (true) {
               try {
                  Thread.sleep(1000);
               } catch (InterruptedException e) {
                  System.out.println(e.getMessage());
               }
               Platform.runLater(updateChart);
            }
         }
      });

      refreshRandom = new Thread(new Runnable() {

         @Override
         public void run() {
            while (true) {
               try {
                  int i = 0;
                  for (int h = 0; h < i + 1; h++) {
                     ChangeCoinName();
                  }
                  while (true) {
                     if (saveAfter == 0) {
                        saveAfter = saveBefore;
                     } else {
                        if (saveAfter < (saveBefore + 500000) && saveAfter > (saveBefore - 500000)) {
                           Thread.sleep(500);
                           for (int e = 1; e < coincol + 1; e++) {
                              CoinDAO.getDAO().updateCoin(e, savePrice.get(i));
                              i++;
                           }
                        }
                     }
                  }
               } catch (Exception e) {
                  System.out.println(e.getMessage());
               }
            }

         }

      });
      ListRefresh = new Thread(new Runnable() {

         @Override
         public void run() {
            Runnable Refresh = new Runnable() {

               @Override
               public void run() {
                  LoadCenterPage("CoinListRefreshPage");
               }
            };
            while (true) {
               try {
                  Thread.sleep(500);
               } catch (Exception e) {
                  System.out.println(e.getMessage());
               }
               Platform.runLater(Refresh);
            }
         }
      });
      refreshRandom.start();
      ListRefresh.start();
      refreshChart.start();
   }

   public static TradeController tradeController;

   public static TradeController getTradeController() {
      return tradeController;
   }

   public TradeController() {
      tradeController = this;
   }

   public static ArrayList<Integer> getSavePrice() {
      return savePrice;
   }

   @FXML
   private AnchorPane CoinListPane;

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

   public void LoadCenterPage(String page) {
      try {
         Parent parent = FXMLLoader.load(getClass().getResource("/View/" + page + ".fxml"));
         TradeBoarderPane.setCenter(parent);
      } catch (IOException e) {
         System.out.println(e.getMessage());
      }
   }

   public void ChangeCoinName() {
      coincol = CoinDAO.getDAO().coinCol();
      Random ran = new Random();
      for (int q = 1; q < coincol + 1; q++) {
         coinName.add(CoinDAO.getDAO().getCoinName(q));
         System.out.println("coinName :" + coinName.get(q));
         saveAfter = CoinDAO.getDAO().outPrice(coinName.get(q));
         System.out.println("saveAfter : " + saveAfter);
         while (true) {
            saveBefore = ran.nextInt(100000000);
            if (saveBefore < (saveAfter + 500000) && saveBefore > (saveAfter - 500000)) {

               System.out.println("saveBefore : " + saveBefore);
               savePrice.add(saveBefore);
               saveAfter = saveBefore;
               break;
            }
         }
      }
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         System.out.println(e.getMessage());
      }
   }
}