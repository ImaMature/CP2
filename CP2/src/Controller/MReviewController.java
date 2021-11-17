package Controller;

import java.net.URL;
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

	
	@Override // ó���� ���̺��� ������ �ϱ� ������ Initializable ���
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Board> Mboards = BoardDAO.getboardDAO().MBoardList(2); //�Խ��� Ÿ�� 2���϶� �μ� ����
		CoinReviewTable.setItems(Mboards);
		System.out.println( Mboards.toString() );
		TableColumn tc = CoinReviewTable.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_title"));
		
		tc = CoinReviewTable.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("writer"));
		
		tc = CoinReviewTable.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_date"));
			

		
		
		
		CoinReviewTable.setOnMouseClicked(e -> {
			if(e.getButton().equals(MouseButton.PRIMARY)) {
				Mboard = CoinReviewTable.getSelectionModel().getSelectedItem();
				MMainController.getmmainController().MLoadPage("MReviewDetail");
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
    	
	    	MMainController.getmmainController().MLoadPage("MReviewWritePage");
	    	
    }


    
}
