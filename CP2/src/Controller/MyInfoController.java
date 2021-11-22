package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import DAO.CoinDAO;
import DAO.MemberDAO;
import Domain.Coin;
import Domain.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MyInfoController implements Initializable{
	
		
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			//�ܺο� ����� �����͸� �о���� fileinputstream
			ArrayList<Member> mem = new ArrayList<>();
//			try {
//				FileInputStream fileInputStream = new FileInputStream("C:/Users/JHD/git/CP2/CP2/src/text/usercoinlist.txt");
//				
//				byte [] bytes = new byte [1024];
//				
//				fileInputStream.read(bytes);
//				
//				String inputString = new String(bytes);
//				
//				
//
//				mem.add(inputString);
//				
//			} catch (Exception e) {
//				System.out.println("fileinput ���� : " + e.getMessage());
//			}
//			
			String loginid = LoginController.getLoginController().getloginid();
			
			Member member = MemberDAO.getMemberDAO().getmemberinfo(loginid);
			
			MemberIDLabel.setText(member.getM_id());
			MemberNameLabel.setText(member.getM_name());
			MemberEmailLabel.setText(member.getM_email());
			MemberFundsLabel.setText(member.getM_money()+"��");
			MemberCoinAmountLabel.setText(member.getM_holdingcoin()+"��");
//			
//			try {
//				FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/JHD/git/CP2/CP2/src/text/usercoinlist.txt", true);
//				
//				Member mem3 = new Member(member.getM_inputcoinname());
//				
//				String outStr = mem3.getM_inputcoinname()+"\n";
//				
//				fileOutputStream.write(outStr.getBytes());
//			} catch (Exception e) {
//				System.out.println("fileoutput ���� : "+e.getMessage());
//			}
//			
			ObservableList<Coin> coins = CoinDAO.getDAO().coinManagelist();
		    ObservableList<PieChart.Data> pie = FXCollections.observableArrayList();

		    for(Coin coin : coins) {
		    	pie.add(new PieChart.Data(coin.getC_name(), 1)); 
		    }
	
		    CoinPieChart.setData(pie);
		}
	
	  	
		@FXML
	    private ImageView BackImg;

	    @FXML
	    private PieChart CoinPieChart;

	    @FXML
	    private Label MemberCoinAmountLabel;

	    @FXML
	    private Label MemberEmailLabel;

	    @FXML
	    private Label MemberFundsLabel;

	    @FXML
	    private Label MemberIDLabel;

	    @FXML
	    private Label MemberNameLabel;

	    @FXML
	    private Button MemberUpdatebtn;

	    @FXML
	    private Button SignOutbtn;

	    @FXML
	    void BackOMC(MouseEvent event) {
	    	MMainController.getmmainController().MLoadPage("MHomePage");
	    }

	  

	    @FXML
	    void MemberUpdateAcion(ActionEvent event) {
	    	MMainController.getmmainController().MLoadPage("MInfoUpdatePage");
	    }

	    //ȸ��Ż�� �޼ҵ�
	    @FXML 
	    void SignOutAction(ActionEvent event) {
	    	MMainController.confirmAlert.setTitle("ȸ��Ż�� ���� Ȯ��");
	    	MMainController.confirmAlert.setHeaderText("ȸ��Ż�� �����Ͻðڽ��ϱ�?");
	    	
	    	Optional<ButtonType> optional = MMainController.confirmAlert.showAndWait();
	    	if(optional.get() == ButtonType.OK) {
	    		boolean result = MemberDAO.getMemberDAO().deletemember(MemberIDLabel.getText());
	    		
	    		if(result) {
	    			MMainController.infoAlert.setTitle("�˸�");
	    			MMainController.infoAlert.setHeaderText("ȸ�� Ż�� �Ǿ����ϴ�.\n�̿����ּż� �����մϴ�.");
	    			MMainController.infoAlert.showAndWait();
	    			//SignOutbtn = ȸ��Ż���ư
	    			SignOutbtn.getScene().getWindow().hide();
	    			
	    			Stage stage = new Stage();
	    			try {
						Parent parent = FXMLLoader.load(getClass().getResource("/View/MainPage.fxml"));
						Scene scene = new Scene(parent);
						stage.setScene(scene);
						stage.setResizable(false);
						stage.setTitle("Gazua!");
						stage.show();
					} catch (Exception e) {
						System.out.println("SignOutAction(ȸ��Ż��)�޼ҵ� err");
						System.out.println(e.getMessage());
					} 
	    		}
	    	}
	    	
	    }
	    
	    
	   
}
