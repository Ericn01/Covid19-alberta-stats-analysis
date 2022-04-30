package controller;


import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import model.FileLoader;
import view.ViewSwitch;


public class SummaryController implements Initializable {
	
ViewSwitch switchControl = new ViewSwitch();
@FXML 
private StackedBarChart<String, Number> casesDeathChart;
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

private void populateBarChart() {
	XYChart.Series<String, Number> cases = new XYChart.Series<>();
	XYChart.Series<String, Number> deaths = new XYChart.Series<>();	
	
	cases.setName("Cases");
	cases.getData().add(new XYChart.Data<>("Total", FileLoader.NUMBER_OF_ENTRIES));
	cases.getData().add(new XYChart.Data<>("2020", Main.analysis.getCasesIn2020()));
	cases.getData().add(new XYChart.Data<>("2021", Main.analysis.getCasesIn2021()));
	cases.getData().add(new XYChart.Data<>("2022", Main.analysis.getCasesIn2022()));
	
	deaths.setName("Deaths");
	deaths.getData().add(new XYChart.Data<>("Total", Main.analysis.getTotalMortalities()));
	deaths.getData().add(new XYChart.Data<>("2020", Main.analysis.getDeathsIn2020()));
	deaths.getData().add(new XYChart.Data<>("2021", Main.analysis.getDeathsIn2021()));
	deaths.getData().add(new XYChart.Data<>("2022", Main.analysis.getDeathsIn2022()));
	
	casesDeathChart.getData().addAll(cases, deaths);
}

private void populateYearData() {
	
	totalCases.setText(Integer.toString(FileLoader.NUMBER_OF_ENTRIES));
	totalDeaths.setText(Integer.toString(Main.analysis.getTotalMortalities()));
	
	cases2020.setText(Integer.toString(Main.analysis.getCasesIn2020()));
	cases2021.setText(Integer.toString(Main.analysis.getCasesIn2021()));
	cases2022.setText(Integer.toString(Main.analysis.getCasesIn2022()));
	
	deaths2020.setText(Integer.toString(Main.analysis.getDeathsIn2020()));
	deaths2021.setText(Integer.toString(Main.analysis.getDeathsIn2021()));
	deaths2022.setText(Integer.toString(Main.analysis.getDeathsIn2022()));
}

private void populateAgeGroupData() {
	
	casesSubOne.setText(Integer.toString(Main.analysis.getUnderOne()));
	casesOneToFour.setText(Integer.toString(Main.analysis.getOneToFour()));
	casesFiveToNine.setText(Integer.toString(Main.analysis.getFiveToNine()));
	casesTenToNineteen.setText(Integer.toString(Main.analysis.getTenToNineteen()));
	casesTwentyToTwentynine.setText(Integer.toString(Main.analysis.getTwentyToTwentynine()));
	casesThirtyToThirtynine.setText(Integer.toString(Main.analysis.getThirtyToThirtynine()));
	casesFourtyToFourtynine.setText(Integer.toString(Main.analysis.getFourtyToFourtynine()));
	casesFiftyToFiftynine.setText(Integer.toString(Main.analysis.getFiftyToFiftynine()));
	casesSixtyToSixtynine.setText(Integer.toString(Main.analysis.getSixtyToSixtynine()));
	casesSeventyToSeventynine.setText(Integer.toString(Main.analysis.getSeventyToSeventynine()));
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
	deathsSeventyToSeventynine.setText(Integer.toString(Main.analysis.getSeventyToSeventynineDeaths()));
	deathsOverEighty.setText(Integer.toString(Main.analysis.getOverEightyDeaths()));
}

private void populateGenderData() {
	
	casesMale.setText(Integer.toString(Main.analysis.getMaleCases()));
	casesFemale.setText(Integer.toString(Main.analysis.getFemaleCases()));
	
	deathsMale.setText(Integer.toString(Main.analysis.getMaleMortalities()));
	deathsFemale.setText(Integer.toString(Main.analysis.getFemaleMortalities()));
}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	populateBarChart();
	populateYearData();
	populateAgeGroupData();
	populateGenderData();
}

public void switchToDataLookupScene(ActionEvent event) {
	switchControl.switchToDataLookupScene(event);
}
public void switchToGraphsScene(ActionEvent event) {
	switchControl.switchToCasesGraphsScene(event);
}
}
