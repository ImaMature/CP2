package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.CoinDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MReviewCoinbtnController implements Initializable {
	

    @FXML
    private ScrollPane CoinbtnPane;
    
    @FXML
    private VBox vbox;
    
    @FXML
    private BorderPane RCPane;
    
    
    int ch ;
    
    //public static int intC_num;
    
    public static MReviewCoinbtnController RC;
    
    public static MReviewCoinbtnController getRC() {
    	return RC;
    }
    
    public MReviewCoinbtnController(){
    	RC = this;
    }
    
    public static int C_num;
    
    
    public void RefreshPane(){
    	int c_no = CoinDAO.getDAO().coinCol();
    	
    	
    	
    	Button[] buttons = new Button[c_no+1];
    	
    	for(int i =1; i<=c_no; i++) {
    		ch = i;
    		String c_name = CoinDAO.getDAO().getCoinName( i );
    		
    		buttons[i] = new Button();
    		
    		buttons[i].setId( i+"" );
    		buttons[i].setLayoutX( 20 );
    		buttons[i].setLayoutY( 30 + ( i*30) );
    		buttons[i].setText(c_name);
    		
    		//매개변수.이벤트( 인수 -> { 실행문 });
    			// 익명메소드 : 람다식 
    		
    		buttons[i].setOnAction( e  -> {
    			
    			//System.out.println( c_name + "페이지 열기 " + e.getSource().toString().split(",")[0].split("=")[1] );
    			String c_num = (e.getSource().toString().split(",")[0].split("=")[1]);
    			C_num = Integer.parseInt(c_num);
    			
    			MReviewCoinbtnController.getRC().RLoadPage("MReviewPage");
    		}  );
    		
    		vbox.getChildren().add( buttons[i] );
    	}
    	
    	
    }
    
    
    public void RLoadPage(String page) {
    	try {
    		Parent parent = FXMLLoader.load(getClass().getResource("/View/"+page+".fxml"));
    		RCPane.setCenter(parent);
    	} catch (Exception e) {
    		System.out.println("RLoadPage() 문제" + e.getMessage());;
    	}
    	
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	// 코인 갯수 만큼 버튼 생성 
    	RefreshPane();
    	
    }
    
    

    
}
