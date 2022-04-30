package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Viewer {
	private Stage primaryStage;
	public Viewer(Stage primaryStage){
		this.primaryStage = primaryStage;
	}
	
	public void loadView() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("StartPane.fxml"));
			Scene dataLookup = new Scene(root, 700, 500);
			dataLookup.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("COVID-19 Data Analysis");
			primaryStage.setScene(dataLookup);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
