package application;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.DataAnalyser;
import model.FileLoader;
import view.ConsolePrint;
import view.Viewer;



public class Main extends Application {
	public static DataAnalyser analysis = new DataAnalyser(new FileLoader().getDataContainer()); // The only instance of file loader and data analyzer, hence the static keyword
	@Override
	public void start(Stage primaryStage) {
		ConsolePrint.printDataReport(); // prints data to console
		Viewer appView = new Viewer(primaryStage);
		appView.loadView();
		// Configuration
		primaryStage.getIcons().add(new Image("file:src/icon.png"));
		primaryStage.setResizable(false);
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	

	

}
