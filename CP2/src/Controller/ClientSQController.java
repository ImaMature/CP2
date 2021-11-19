package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ClientSQController {

	
	@FXML
    private ImageView Backimg;

    @FXML
    private TextArea QContentstxt;

    @FXML
    private TextField QTitletxt;

    @FXML
    private Button Sendbtn;

    @FXML
    void BackOMC(MouseEvent event) {
    	MMainController.getmmainController().MLoadPage("ClientServicePage");
    }
    @FXML
    void SendAction(ActionEvent event) {

    }
}
