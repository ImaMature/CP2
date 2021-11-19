package Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import DAO.BoardDAO;
import DAO.MemberDAO;
import DAO.ReplyDAO;
import Domain.Board;
import Domain.Member;
import Domain.Reply;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

public class AQnAController implements Initializable {
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ObservableList<Board> boards = BoardDAO.getboardDAO().AQnAList(  );
		
		// ���̺� ǥ�� �ϱ� ���ؼ�
		for(int i = 0; i < boards.size(); i++) {
			if(LoginController.getMainController().getloginid().equals("admin")) {
				
				QnATableView.setItems(boards);
				
				TableColumn tc = QnATableView.getColumns().get(0);
				tc.setCellValueFactory(new PropertyValueFactory<>("m_no"));
				
				tc=QnATableView.getColumns().get(1);
				tc.setCellValueFactory(new PropertyValueFactory<>("b_title"));
				
				tc=QnATableView.getColumns().get(2);
				tc.setCellValueFactory(new PropertyValueFactory<>("b_contents"));
				
				tc=QnATableView.getColumns().get(3);
				tc.setCellValueFactory(new PropertyValueFactory<>("b_date"));
				
				QnATableView.setOnMouseClicked(e -> {
					if(e.getButton().equals(MouseButton.PRIMARY)) {
						board = QnATableView.getSelectionModel().getSelectedItem();
						// AMainController.getamainController().ALoadPage("AQnAViewPage");
						// ȸ���� "ID�� ��ȣ��(String)�� ������" ��ȣ�ȿ� ���� ȸ���� DB�� ��ȣ�� ��ȯ�Ǵ� �޼ҵ�
//						int memberno = MemberDAO.getMemberDAO().getMemberNo();
//						System.out.println(memberno);
						
					}
				});
			}
		}
	}
	
	public static AQnAController aqnaController;
	public static AQnAController getaqnaController() {
		return aqnaController;
	}
	
	public AQnAController() {aqnaController=this;}
	
	public static Board board;
	
	@FXML
    private TextArea AQnAreply;

    @FXML
    private Button AUpdatebtn;
    
    @FXML
    private TableView<Board> QnATableView;

    @FXML
    void AUpdateAction(ActionEvent event) {
    	String loginid = LoginController.getMainController().getloginid();
    	Member member = MemberDAO.getMemberDAO().getmemberinfo(loginid);
    	Reply Reply = new Reply( AQnAreply.getText() , board.getB_no() );
    	boolean result = ReplyDAO.getreplyDAO().Areply( Reply );
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(result) {
    		alert.setHeaderText("�亯 ��� �Ϸ�");
    		alert.showAndWait();
    		AMainController.getamainController().ALoadPage("AQnAPage");
    	} else {
    		alert.setHeaderText("�亯 ��� ����");
    		alert.showAndWait();
    	}
    	
    }
}