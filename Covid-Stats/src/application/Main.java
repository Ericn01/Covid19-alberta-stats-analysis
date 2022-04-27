package application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			start();
			Chart charts = new Chart();
			
//			FileLoader loadFile = new FileLoader();
//			DataAnalyser analysis = new DataAnalyser(loadFile.getDataContainer());
//			analysis.dataReport();
	
			Scene scene = new Scene(charts.makeZoneChart(),500,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("COVID-19 Data Analysis");
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("file:src/icon.png"));
			primaryStage.setResizable(false);
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
