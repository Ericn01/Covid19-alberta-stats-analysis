package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewSwitch {
	
	public void switchToDataLookupScene(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("StartPane.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void switchToCasesGraphsScene(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("GraphPane.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void switchToDeathGraphsScene(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MortalityGraphsPane.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void switchToDataSummaryScene(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("SummaryPane.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
