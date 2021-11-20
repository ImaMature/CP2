package Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import DAO.BoardDAO;
import DAO.MemberDAO;
import Domain.Board;
import Domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AQnAViewController implements Initializable {
	
	Board AQnAboard = AQnAController.board;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		AQnAiplbl.setText(AQnAboard.getM_no()+"");
		AQnAtitletxt.setText("Re : " + AQnAboard.getB_title());
		AQnAcontentstxt.setText(AQnAboard.getB_contents());
		AQnAdatelbl.setText(AQnAboard.getB_date());
	}
	
	@FXML
    private Button AQnACancelbtn;

    @FXML
    private Button AQnAbackbtn;

    @FXML
    private TextArea AQnAcontentstxt;

    @FXML
    private Label AQnAdatelbl;

    @FXML
    private Label AQnAiplbl;

    @FXML
    private TextField AQnAtitletxt;

    @FXML
    private Button AQnAupdatebtn;

    @FXML
    void AQnACancelAction(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("해당 게시물을 삭제 하시겠습니까?");
    	alert.setTitle("알림");
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get()==ButtonType.OK) {
    		boolean result=BoardDAO.getboardDAO().delete(AQnAboard.getB_no());
    		if(result) {AMainController.getamainController().ALoadPage("AQnAController");
    }
    	}
    }
    @FXML
    void AQnAbackbtn(ActionEvent event) {
    	AMainController.getamainController().ALoadPage("AQnAPage");
    }
    
    boolean qnqcheck=true;
    @FXML
    void AQnAupdateAction(ActionEvent event) {
      	Alert alert = new Alert(AlertType.INFORMATION);
        	if(qnqcheck) {
        		alert.setHeaderText("내용 수정 후 다시 버튼 클릭시 수정 완료 됩니다.");
        		AQnAupdatebtn.setText("수정");
        		alert.showAndWait();
        		
        		AQnAtitletxt.setEditable(true);
        		AQnAcontentstxt.setEditable(true);	
        		qnqcheck=false;
        	} else {
        	BoardDAO.getboardDAO().update(AQnAboard.getB_no(), AQnAtitletxt.getText(), AQnAcontentstxt.getText());
        	alert.setHeaderText("게시물이 수정 되었습니다");
        	alert.showAndWait();
        	qnqcheck=true;
        	AQnAtitletxt.setEditable(false);
        	AQnAcontentstxt.setEditable(false);
        }  
}
}