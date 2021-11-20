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
		
	
			if(LoginController.getLoginController().getloginid().equals("admin")) {
				System.out.println("AQnAController 로그인 아이디 : " +LoginController.getLoginController().getloginid());
				
				TableColumn tc = QnATableView.getColumns().get(0);
				tc.setCellValueFactory(new PropertyValueFactory<>("m_no"));
				
				tc=QnATableView.getColumns().get(1);
				tc.setCellValueFactory(new PropertyValueFactory<>("b_title"));
				
				tc=QnATableView.getColumns().get(2);
				tc.setCellValueFactory(new PropertyValueFactory<>("writer"));
				
				tc=QnATableView.getColumns().get(3);
				tc.setCellValueFactory(new PropertyValueFactory<>("b_date"));
				
				QnATableView.setItems(boards);

				QnATableView.setOnMouseClicked(e -> {
					if(e.getButton().equals(MouseButton.PRIMARY)) {
						board = QnATableView.getSelectionModel().getSelectedItem();
						 AMainController.getamainController().ALoadPage("AQnAAnswerPage");
						// 회원의 "ID를 괄호안(String)에 넣으면" 괄호안에 넣은 회원의 DB내 번호가 반환되는 메소드
//						int memberno = MemberDAO.getMemberDAO().getMemberNo();
//						System.out.println(memberno);
						
					}
				});
			}
	}
	
	public static AQnAController aqnaController;
	public static AQnAController getaqnaController() {
		return aqnaController;
	}
	
	public AQnAController() {aqnaController=this;}
	
	public static Board board;
	
	
    
    @FXML
    private TableView<Board> QnATableView;

    
}