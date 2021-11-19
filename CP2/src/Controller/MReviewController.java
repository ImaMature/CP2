package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DAO.BoardDAO;
import DAO.MemberDAO;
import Domain.Board;
import Domain.Member;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MReviewController implements Initializable {

	
	@Override // 처음에 테이블이 보여야 하기 때문에 Initializable 사용
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		CoinReviewTable.refresh();
		
		ObservableList<Board> Mboards = BoardDAO.getboardDAO().MBoardList(2, MReviewCoinbtnController.C_num); //게시판 타입 2번일때 인수 전달
//		ArrayList<String> mName = new ArrayList<>();
		System.out.println("coinreviewtable"+Mboards.toString() );
		TableColumn tc = CoinReviewTable.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_title"));
	
		tc = CoinReviewTable.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("writer"));
		
		tc = CoinReviewTable.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_date"));
		
				
		CoinReviewTable.setItems(Mboards);
		
		CoinReviewTable.setOnMouseClicked(e -> {
			if(e.getButton().equals(MouseButton.PRIMARY)) {
				Mboard = CoinReviewTable.getSelectionModel().getSelectedItem();
				//MMainController.getmmainController().MLoadPage(null);
				MReviewCoinbtnController.getRC().RLoadPage("MReviewDetail");
				
			}
		});
	}
	public static Board Mboard;
	
    @FXML
    private TableView<Board> CoinReviewTable;

   
    @FXML
    private Button Registerbtn;

    @FXML
    private ImageView BackImg;
    

    @FXML
    void BackOMC(MouseEvent event) {
    	MMainController.getmmainController().MLoadPage("MHomePage");
    }

    @FXML
    void RegisterAction(ActionEvent event) {
    	MReviewCoinbtnController.getRC().RLoadPage("MReviewWritePage");
	    	
	    	
    }


    
}
