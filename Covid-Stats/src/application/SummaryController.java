package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SummaryController implements Initializable {
	
@FXML
private Label totalCases;
@FXML
private Label totalDeaths;

@FXML 
private Label cases2020;
@FXML
private Label cases2021;
@FXML
private Label cases2022;

@FXML 
private Label deaths2020;
@FXML
private Label deaths2021;
@FXML
private Label deaths2022;

@FXML 
private Label casesMale;
@FXML
private Label casesFemale;
@FXML 
private Label deathsMale;
@FXML
private Label deathsFemale;

@FXML
private Label casesSubOne;
@FXML
private Label casesOneToFour;
@FXML
private Label casesFiveToNine;
@FXML
private Label casesTenToNineteen;
@FXML
private Label casesTwentyToTwentynine;
@FXML
private Label casesThirtyToThirtynine;
@FXML
private Label casesFourtyToFourtynine;
@FXML
private Label casesFiftyToFiftynine;
@FXML
private Label casesSixtyToSixtynine;
@FXML
private Label casesSeventyToSeventynine;
@FXML
private Label casesOverEighty;

@FXML
private Label deathsSubOne;
@FXML
private Label deathsOneToFour;
@FXML
private Label deathsFiveToNine;
@FXML
private Label deathsTenToNineteen;
@FXML
private Label deathsTwentyToTwentynine;
@FXML
private Label deathsThirtyToThirtynine;
@FXML
private Label deathsFourtyToFourtynine;
@FXML
private Label deathsFiftyToFiftynine;
@FXML
private Label deathsSixtyToSixtynine;
@FXML
private Label deathsSeventyToSeventynine;
@FXML
private Label deathsOverEighty;

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	cases2020.setText(Integer.toString(Main.analysis.getCasesIn2020()));
	cases2021.setText(Integer.toString(Main.analysis.getCasesIn2021()));
	cases2022.setText(Integer.toString(Main.analysis.getCasesIn2022()));
	
	deaths2020.setText(Integer.toString(Main.analysis.getDeathsIn2020()));
	deaths2021.setText(Integer.toString(Main.analysis.getDeathsIn2021()));
	deaths2022.setText(Integer.toString(Main.analysis.getDeathsIn2022()));
	
	casesMale.setText(Integer.toString(Main.analysis.getMaleCases()));
	casesFemale.setText(Integer.toString(Main.analysis.getFemaleCases()));
	
	deathsMale.setText(Integer.toString(Main.analysis.getMaleMortalities()));
	deathsFemale.setText(Integer.toString(Main.analysis.getFemaleMortalities()));

	casesSubOne.setText(Integer.toString(Main.analysis.getUnderOne()));
	casesOneToFour.setText(Integer.toString(Main.analysis.getOneToFour()));
	casesFiveToNine.setText(Integer.toString(Main.analysis.getFiveToNine()));
	casesTenToNineteen.setText(Integer.toString(Main.analysis.getTenToNineteen()));
	casesTwentyToTwentynine.setText(Integer.toString(Main.analysis.getTwentyToTwentynine()));
	casesThirtyToThirtynine.setText(Integer.toString(Main.analysis.getThirtyToThirtynine()));
	casesFourtyToFourtynine.setText(Integer.toString(Main.analysis.getFourtyToFourtynine()));
	casesFiftyToFiftynine.setText(Integer.toString(Main.analysis.getFiftyToFiftynine()));
	casesSixtyToSixtynine.setText(Integer.toString(Main.analysis.getSixtyToSixtynine()));
	casesSeventyToSeventynine.setText(Integer.toString(Main.analysis.getFiftyToFiftynine()));
	casesOverEighty.setText(Integer.toString(Main.analysis.getOverEighty()));
	
	deathsSubOne.setText(Integer.toString(Main.analysis.getUnderOneDeaths()));
	deathsOneToFour.setText(Integer.toString(Main.analysis.getOneToFourDeaths()));
	deathsFiveToNine.setText(Integer.toString(Main.analysis.getFiveToNineDeaths()));
	deathsTenToNineteen.setText(Integer.toString(Main.analysis.getTenToNineteenDeaths()));
	deathsTwentyToTwentynine.setText(Integer.toString(Main.analysis.getTwentyToTwentynineDeaths()));
	deathsThirtyToThirtynine.setText(Integer.toString(Main.analysis.getThirtyToThirtynineDeaths()));
	deathsFourtyToFourtynine.setText(Integer.toString(Main.analysis.getFourtyToFourtynineDeaths()));
	deathsFiftyToFiftynine.setText(Integer.toString(Main.analysis.getFiftyToFiftynineDeaths()));
	deathsSixtyToSixtynine.setText(Integer.toString(Main.analysis.getSixtyToSixtynineDeaths()));
	deathsSeventyToSeventynine.setText(Integer.toString(Main.analysis.getFiftyToFiftynineDeaths()));
	deathsOverEighty.setText(Integer.toString(Main.analysis.getOverEightyDeaths()));
	
	totalCases.setText(Integer.toString(FileLoader.NUMBER_OF_ENTRIES));
	totalCases.setText(Integer.toString(Main.analysis.getTotalMortalities()));
}

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



}
