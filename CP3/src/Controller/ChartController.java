package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;

public class ChartController implements Initializable  {
   
    @FXML
    private javafx.scene.chart.LineChart LineChart;
   
    private static ArrayList<Integer> savePrice = TradeController.getSavePrice();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
       System.out.println("РќШЏСп");
       System.out.println( savePrice.toString());
       chart();
    }
   
   
   public void chart( ) {
      
         XYChart.Series series = new XYChart.Series<>();
         int i = 0; 
         for(int num :  savePrice) {
               XYChart.Data data = new XYChart.Data<>(i + "", num);
               i++;
               series.getData().add(data);
         }
         LineChart.getData().add(series);
       }
}