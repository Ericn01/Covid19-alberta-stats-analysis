package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	public static DataAnalyser analysis = new DataAnalyser(new FileLoader().getDataContainer()); // The only instance of file loader and data analyzer, hence the static keyword
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("StartPane.fxml"));
			Scene dataLookup = new Scene(root);
			
			primaryStage.setTitle("COVID-19 Data Analysis");
			primaryStage.setScene(dataLookup);
			primaryStage.getIcons().add(new Image("file:src/icon.png"));
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	

	

}
