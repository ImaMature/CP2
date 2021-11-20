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
		MemberFundsLabel.setText(member.getM_money()+"원");
		MemberCoinAmountLabel.setText(member.getM_holdingcoin()+"개");
		
		 ObservableList<Coin> coins = CoinDAO.getDAO().coinManagelist();
		    ObservableList<PieChart.Data> pie = FXCollections.observableArrayList();

//		    for(Coin coin : coins) {
//		    	pie.add(new PieChart.Data((), )); 뭐들어가야되는거지
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

	    //회원탈퇴 메소드
	    @FXML 
	    void SignOutAction(ActionEvent event) {
	    	MMainController.confirmAlert.setTitle("회원탈퇴 여부 확인");
	    	MMainController.confirmAlert.setHeaderText("회원탈퇴를 진행하시겠습니까?");
	    	
	    	Optional<ButtonType> optional = MMainController.confirmAlert.showAndWait();
	    	if(optional.get() == ButtonType.OK) {
	    		boolean result = MemberDAO.getMemberDAO().deletemember(MemberIDLabel.getText());
	    		
	    		if(result) {
	    			MMainController.infoAlert.setTitle("알림");
	    			MMainController.infoAlert.setHeaderText("회원 탈퇴 되었습니다.\n이용해주셔서 감사합니다.");
	    			MMainController.infoAlert.showAndWait();
	    			//SignOutbtn = 회원탈퇴버튼
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
						System.out.println("SignOutAction(회원탈퇴)메소드 err");
						System.out.println(e.getMessage());
					} 
	    		}
	    	}
	    	
	    }
	    
	    
	   
}
