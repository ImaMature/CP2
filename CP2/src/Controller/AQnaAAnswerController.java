package Controller;

import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class AQnaAAnswerController implements Initializable {
	Board board = AQnAController.board;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		replylist();
		
	   
			
	}
	public static Reply reply;
	
	@FXML
    private Button Answerbtn;

    @FXML
    private TextArea Answertxt;

    @FXML
    private TableView<Reply> ReplyView;
    
    @FXML
    private ImageView BackImg;

    @FXML
    void AnswerAction(ActionEvent event) {
    	Reply reply = new Reply(Answertxt.getText(), board.getB_no());
    	System.out.println(reply.toString());
    	boolean rs = ReplyDAO.getreplyDAO().Areply(reply);
    	System.out.println("AnserAction() rs : " + rs);
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	if(rs) {
    		alert.setTitle("알림");
    		alert.setHeaderText("답변을 등록하시겠습니까?");
    		alert.showAndWait();
    		Answertxt.setText("");
    		replylist();
    	}else {
    		alert.setTitle("알림");
    		alert.setHeaderText("답변 등록 실패");
    		alert.showAndWait();
    	}
    }
   
    
    @FXML
    void BackOMC(MouseEvent event) {
    	AMainController.getamainController().ALoadPage("AQnAPage");
    }
    
    public void replylist() {
    	 ObservableList<Reply> reply_list = ReplyDAO.getreplyDAO().AQnAReplyList(board.getB_no());
 	    System.out.println(reply_list.toString());
 			TableColumn tc = ReplyView.getColumns().get(0); 
 			tc.setCellValueFactory(new PropertyValueFactory<>("r_no")); 
 			
 			tc = ReplyView.getColumns().get(1); 
 			tc.setCellValueFactory(new PropertyValueFactory<>("r_contents"));
 				
 			tc = ReplyView.getColumns().get(2); 
 			tc.setCellValueFactory(new PropertyValueFactory<>("r_date"));
 	
 			ReplyView.setItems(reply_list);


	}
}