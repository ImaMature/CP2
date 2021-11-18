package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/View/MainPage.fxml"));
			Scene scene = new Scene(parent);
			// ��Ʈ �ε� 

//			Font.loadFont( getClass().getResourceAsStream("esamanru Medium.ttf"), 20);
//
//			// �ܺ� ��Ÿ�Ͻ�Ʈ ���� 
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.setResizable(false);
				stage.setTitle("Gazua!");
				stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
