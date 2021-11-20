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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ClientAController implements Initializable{
		Board b = ClientServiceController.qnaboard;
//		ArrayList<Reply> a = new ArrayList<>();
		ObservableList<Reply> a = ReplyDAO.getreplyDAO().MQnAReplyList(0, 0)
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			
			AContentstxt.setEditable(false);
			ATitletxt.setEditable(false);
			ATitletxt.setText(b.getB_title());
			AContentstxt.setText(null);
			
		}

		@FXML
	    private TextArea AContentstxt;

	    @FXML
	    private TextField ATitletxt;

	    @FXML
	    private ImageView Backimg;

	    @FXML
	    void BackOMC(MouseEvent event) {
	    	MMainController.getmmainController().MLoadPage("ClientServicePage");
	    }
	    
	    //아이디 admin인걸 가져와야됨, 어드민이 작성한 거 가져와야됨.
	    
	    //리플DB에서 가져와야한다.
}
