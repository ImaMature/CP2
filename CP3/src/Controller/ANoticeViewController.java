package Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import DAO.BoardDAO;
import Domain.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ANoticeViewController implements Initializable {
	
	Board Aboard = ANoticeListController.board;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		AVtitlelbl.setText(Aboard.getB_title()); // 제목
		AVdatelbl.setText(Aboard.getB_date()); // 등록일
		ANVtitletxt.setText(Aboard.getB_title());
		ANVContents.setText(Aboard.getB_contents());
	}
		
	@FXML
    private TextArea ANVContents;

    @FXML
    private TextField ANVtitletxt;

    @FXML
    private Button AVbackbtn1;

    @FXML
    private Label AVdatelbl;

    @FXML
    private Label AVtitlelbl;

    @FXML
    private Button AVupdatebtn;

    @FXML
    private Button AviewCancelbtn;

    @FXML
    void AVbackAction(ActionEvent event) {
    	AMainController.getamainController().ALoadPage("ANoticeListPage");
    }

    boolean aupcheck = true;
    @FXML
    void AVupdateAction(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(aupcheck) {
    		alert.setHeaderText("내용 수정 후 다시 버튼 클릭시 수정 완료 됩니다.");
    		AVupdatebtn.setText("수정");
    		alert.showAndWait();
    		
    		ANVtitletxt.setEditable(true);
    		ANVContents.setEditable(true);	
    		aupcheck=false;
    	} else {
    	BoardDAO.getboardDAO().update(Aboard.getB_no(), ANVtitletxt.getText(), ANVContents.getText());
    	alert.setHeaderText("게시물이 수정 되었습니다");
    	alert.showAndWait();
    	aupcheck=true;
    	ANVtitletxt.setEditable(false);
    	ANVContents.setEditable(false);
    }
   }
    @FXML
    void AviewCancelAction(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("해당 게시물을 삭제 하시겠습니까?");
    	alert.setTitle("알림");
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get()==ButtonType.OK) {
    		boolean result = BoardDAO.getboardDAO().delete(Aboard.getB_no());
    		if(result) {AMainController.getamainController().ALoadPage("ANoticeListPage");
    		}
    	}
    }
}