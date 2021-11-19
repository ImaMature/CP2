package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Domain.Board;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ClientAPage implements Initializable{
		Board b = ClientServiceController.qnaboard;
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			AContentstxt.setEditable(false);
			ATitletxt.setEditable(false);
			
		}

		@FXML
	    private TextArea AContentstxt;

	    @FXML
	    private TextField ATitletxt;

	    @FXML
	    private ImageView Backimg;

	    @FXML
	    void BackOMC(MouseEvent event) {
	    	MMainController.getmmainController().MLoadPage("ClientSQController");
	    }
	    
	    //아이디 admin인걸 가져와야됨, 어드민이 작성한 거 가져와야됨.
	    
	    //
}
