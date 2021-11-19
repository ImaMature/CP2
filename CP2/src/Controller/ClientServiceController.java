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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ClientServiceController implements Initializable{

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Board> MAboards = BoardDAO.getboardDAO().QBoardList();
		System.out.println("MAboads 내용 : " + MAboards);
			for(int i =0; i<MAboards.size(); i++) {
				boolean rs = LoginController.getLoginController().getloginid().equals("admin");
				if(!rs) {
				System.out.println("admin 아닌가요? : " + rs);
					MQNAView.setItems(MAboards);
					
					TableColumn tc = MQNAView.getColumns().get(0);
					tc.setCellValueFactory(new PropertyValueFactory<>("b_no"));
					
					tc = MQNAView.getColumns().get(1);
					tc.setCellValueFactory(new PropertyValueFactory<>("b_title"));
					
					tc = MQNAView.getColumns().get(2);
					tc.setCellValueFactory(new PropertyValueFactory<>("b_contents"));
					
					tc = MQNAView.getColumns().get(3);
					tc.setCellValueFactory(new PropertyValueFactory<>("b_date"));
					
					
					MQNAView.setOnMouseClicked(e -> {
						if(e.getButton().equals(MouseButton.PRIMARY)) {
						qnaboard=MQNAView.getSelectionModel().getSelectedItem();
						String m_id = LoginController.getLoginController().getloginid();
//						if()
						MMainController.getmmainController().MLoadPage("ClientAPage");
					}	
				});
			}
		}
	}
	
	public static Board qnaboard;
	
	@FXML
    private TableView<Board> MQNAView;

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
