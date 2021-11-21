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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class TradeController implements Initializable {
   private static ArrayList<Integer> savePrice = new ArrayList<>();
   private static ArrayList<Integer> saveEachPrice = new ArrayList<>();
   ArrayList<String> coinName = new ArrayList<>();
   CoinListRefreshController cc = new CoinListRefreshController();
   static String getStringCoinName;
   int saveBefore = 0;
   int saveAfter;
   String coinname;
   int coincol;
   Thread refreshChart;
   Thread refreshRandom;
   Thread ListRefresh;

   // 스트링을 차트 값으로 넘겨야함
   // 디폴트값은 비트코인
   // 넘긴 스트링값만 차트에 찍음
   // 리스트에 저장? - 코인개수만큼 리스트생성? - 각 코인을 리스트에 저장?

   @Override
   public void initialize(URL arg0, ResourceBundle arg1) {
      refreshChart = new Thread(new Runnable() {

         @Override
         public void run() {
            Runnable updateChart = new Runnable() {

               @Override
               public void run() {
                  LoadPage("ChartPage");
                  if (getStringCoinName != null) {
//                     ChartController.eachChart();
                  }
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
               System.out.println("getString :" + getStringCoinName);
               try {
                  int i = 0;
                  for (int h = 0; h < i + 1; h++) {
                     ChangeCoinName();
                     selectCoinName();
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
                  Thread.sleep(1000);
               } catch (Exception e) {
                  System.out.println(e.getMessage());
               }
               Platform.runLater(Refresh);
            }
         }
      });
      refreshRandom.start();
      refreshChart.start();
      ListRefresh.start();
   }

   public static TradeController tradeController;

   public static TradeController getTradeController() {
      return tradeController;
   }

   public TradeController() {
      tradeController = this;
   }

   public static ArrayList<Integer> getSavePrice() {
      return saveEachPrice;
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
         System.out.println("coinName : " + coinName.get(q));
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

   public void selectCoinName() {
      if (getStringCoinName != null) {
         for (int q = 1; q < coincol + 1; q++) {
            if (getStringCoinName.trim().equals(CoinDAO.getDAO().getCoinName(q))) {
               saveEachPrice.add(CoinDAO.getDAO().outPrice(getStringCoinName.trim()));
            } else {
               System.out.println("아니다");
            }
         }
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            System.out.println(e.getMessage());
         }
      }
   }
}