package Controller;

import java.net.URL;
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
		String loginid = LoginController.getLoginController().getloginid();
		
		Member member = MemberDAO.getMemberDAO().getmemberinfo(loginid);
		
		MemberIDLabel.setText(member.getM_id());
		MemberNameLabel.setText(member.getM_name());
		MemberEmailLabel.setText(member.getM_email());
		MemberFundsLabel.setText(member.getM_money()+"��");
		MemberCoinAmountLabel.setText(member.getM_holdingcoin()+"��");
		
		 ObservableList<Coin> coins = CoinDAO.getDAO().coinManagelist();
		    ObservableList<PieChart.Data> pie = FXCollections.observableArrayList();

//		    for(Coin coin : coins) {
//		    	pie.add(new PieChart.Data((), )); �����ߵǴ°���
//		    }
		
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
