package Controller;

import Domain.Reply;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ClientServiceController {

	@FXML
    private TableView<Reply> MQNAView;

    @FXML
    private Button Questionbtn;

    @FXML
    private ImageView Backimg;
    @FXML
    void BackOMC(MouseEvent event) {
    	MMainController.getmmainController().MLoadPage("MHomePage");
    }
    @FXML
    void QuestionAction(ActionEvent event) {

    	MMainController.getmmainController().MLoadPage("ClientSQPage");
    }
}
