package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.BoardDAO;
import Domain.Board;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

public class ANoticeListController implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ObservableList<Board> boards = BoardDAO.getboardDAO().ABoardList();
		TableColumn tc = NoticeTableView.getColumns().get(0); // ���̺� ���� ù��° �ʵ�
		tc.setCellValueFactory(new PropertyValueFactory<>("b_no"));
		tc=NoticeTableView.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_title"));
		tc=NoticeTableView.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_date"));
		
		NoticeTableView.setItems(boards); // ���̺� �信 ����Ʈ �ֱ�
		
		NoticeTableView.setOnMouseClicked(e -> {		// ���̺��� �� Ŭ�������� 
			if(e.getButton().equals(MouseButton.PRIMARY)) {
				board = NoticeTableView.getSelectionModel().getSelectedItem();
				AMainController.getamainController().ALoadPage("ANoticeViewPage");
			
			
			}
		});
	}
	public static ANoticeListController anoticeController;
	public static ANoticeListController getanoticeController() {
		return anoticeController;
	}
	
	public ANoticeListController() {anoticeController=this;}

	public static Board board; // new�� �ָ� �ȵ�
	
	@FXML
    private Button Deletebtn;

    @FXML
    private TableView<Board> NoticeTableView;
    
    
    @FXML
    private Button Registerbtn;

    @FXML
    private Button Updatebtn;

    @FXML
    void DeleteAction(ActionEvent event) {

    }

    @FXML
    void RegisterAction(ActionEvent event) {
    	AMainController.getamainController().ALoadPage("ANoticewritePage");
    }

    @FXML
    void UpdateAction(ActionEvent event) {
    	
    }
}