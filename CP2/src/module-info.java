module CoinProject1 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens Controller to javafx.graphics, javafx.fxml;
	opens DAO to javafx.graphics, javafx.fxml;
	opens View to javafx.graphics, javafx.fxml;
}
