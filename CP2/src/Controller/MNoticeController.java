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
import javafx.scene.control.TableView;

public class MNoticeController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
//		NoticeTableView.refresh();
//		ObservableList<Board> MNboards = BoardDAO.getboardDAO().MBoardList(3, )
//		
}

    @FXML
    private TableView<Board> NoticeTableView;
    

}
