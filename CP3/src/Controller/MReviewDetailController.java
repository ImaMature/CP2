package Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import DAO.BoardDAO;
import DAO.MemberDAO;
import Domain.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MReviewDetailController implements Initializable{

	Board board = MReviewController.Mboard;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//���� �����ֱ�
		ReviewTitletxt.setText(board.getB_title());
		
		//���� �����ֱ�
		ReviewContentstxt.setText(board.getB_contents());
		//System.out.println("���� : "+ board.getB_contents());
		//�ۼ��Ҽ� ���� �س��� �ؿ��� ������ �� ��
		
		//�������� = user = getloginid�ؿ°� �� 
		String user = LoginController.getLoginController().getloginid();
		String writer = board.getWriter();
		//System.out.println("writer : " + writer);
		
		//���� �����(user)�� ���� �̸��� ���� �ʴٸ� ����, ���� ��ư ������. �Ϸ�
		if(!user.equals(writer)) {
			PostDeletebtn.setVisible(false);
			PostUpdatebtn.setVisible(false);
			
		}
		ReviewTitletxt.setEditable(false);
		ReviewContentstxt.setEditable(false);
		
	}
	
	  @FXML
	    private ImageView BackImg;

	    @FXML
	    private Button PostDeletebtn;

	    @FXML
	    private Button PostUpdatebtn;

	    @FXML
	    private TextArea ReviewContentstxt;

	    @FXML
	    private TextField ReviewTitletxt;

	    @FXML
	    void BackOMC(MouseEvent event) {
	    	MReviewCoinbtnController.getRC().RLoadPage("MReviewPage");
	    }

	    @FXML
	    void DeleteAction(ActionEvent event) {
	    	MMainController.confirmAlert.setTitle("�Խù� ���� �˸�");
	    	MMainController.confirmAlert.setHeaderText("���� �Խù��� �����Ͻðڽ��ϱ�?");
	    	
	    	Optional<ButtonType> optional = MMainController.confirmAlert.showAndWait();
	    	if(optional.get()==ButtonType.OK) {
	    		boolean result = BoardDAO.getboardDAO().ReviewDelete(board.getB_no());
	    		System.out.println(result);
	    		if(result) {
	    			MMainController.confirmAlert.setTitle("�˸�");
	    			MMainController.confirmAlert.setHeaderText("�ش� �Խù��� �����Ǿ����ϴ�.");
	    			MMainController.confirmAlert.showAndWait();
	    			
	    			MReviewCoinbtnController.getRC().RLoadPage("MReviewPage");
	    		}
	    	}
	    }
	    boolean aa = true;
	    @FXML
	    void UpdateAction(ActionEvent event) {
//		    	System.out.println("Ÿ��Ʋ : " +board.getB_title() + " ������ : " + board.getB_contents() + " �ѹ� : " + board.getB_no() );
	    		if(aa) {
	    			MMainController.infoAlert.setTitle("�˸�");
	    			MMainController.infoAlert.setHeaderText("���� ���� �� ��ư Ŭ���� �����Ϸ�.");
	    			MMainController.infoAlert.showAndWait();
	    			ReviewTitletxt.setEditable(true);
	    			ReviewContentstxt.setEditable(true);
	    			aa = false;
	    			
	    		}else {
	    			
	    			boolean re =  BoardDAO.getboardDAO().ReviewUpdate( ReviewTitletxt.getText()  , ReviewContentstxt.getText() , board.getB_no());
	    			System.out.println( "re : " + re );
	    			if(re) {
	    			MMainController.infoAlert.setTitle("�˸�");
	    			MMainController.infoAlert.setHeaderText("�Խù��� �����Ǿ����ϴ�.");
	    			MMainController.infoAlert.showAndWait();
	    			MReviewCoinbtnController.getRC().RLoadPage("MReviewPage");
	    			
	    			}
	    			aa=true;
	    			ReviewTitletxt.setEditable(false);
	    			ReviewContentstxt.setEditable(false);
	    		
	    		}
	    	
	    	
	    }

}
