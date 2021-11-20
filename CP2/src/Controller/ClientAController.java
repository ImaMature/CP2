package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DAO.ReplyDAO;
import Domain.Board;
import Domain.Reply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ClientAController implements Initializable{
		Board board = ClientServiceController.qnaboard;
//		ArrayList<Reply> a = new ArrayList<>();
	
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			 ObservableList<Reply> Mreply_list = ReplyDAO.getreplyDAO().AQnAReplyList(board.getB_no());
			    System.out.println(Mreply_list.toString());
					TableColumn tc = AnswerView.getColumns().get(0); 
					tc.setCellValueFactory(new PropertyValueFactory<>("r_no")); 
					
					tc = AnswerView.getColumns().get(1); 
					tc.setCellValueFactory(new PropertyValueFactory<>("r_contents"));
						
					tc = AnswerView.getColumns().get(2); 
					tc.setCellValueFactory(new PropertyValueFactory<>("r_date"));
			
					AnswerView.setItems(Mreply_list);
			
			
		}

		
	    @FXML
	    private TableView<Reply> AnswerView;
	
	    @FXML
	    private ImageView Backimg;

	    @FXML
	    void BackOMC(MouseEvent event) {
	    	MMainController.getmmainController().MLoadPage("ClientServicePage");
	    }
	    
	 
	 
	   
	    //아이디 admin인걸 가져와야됨, 어드민이 작성한 거 가져와야됨.
	    
	    //리플DB에서 가져와야한다.
}
