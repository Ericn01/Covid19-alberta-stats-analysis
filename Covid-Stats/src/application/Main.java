package application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			start();
			
			FileLoader loadFile = new FileLoader();
			DataAnalyser analysis = new DataAnalyser(loadFile.getDataContainer());
			analysis.dataReport();
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,800,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("COVID-19 Data Analysis");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void start() {
	}
	public static void main(String[] args) {
		launch(args);
	}
	

	

}
