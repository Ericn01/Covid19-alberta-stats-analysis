package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import view.ViewSwitch;

public class CasesChartController implements Initializable{
	// To create a JavaFX chart, you need to first define the axis of the chart
	// Instantiate the respective class
	// Prepare and pass data to the chart
	ViewSwitch switchControl = new ViewSwitch();
	@FXML
	private LineChart<String, Number> casesByAgeLineChart;
	@FXML
	private BarChart<String, Number> casesByZoneBarChart;
	@FXML
	private LineChart<String, Number> casesByMonthLineChart;


	
	public void populateCasesByZoneBarChart() {
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		
		xAxis.setLabel("Alberta Zone");
		yAxis.setLabel("Number of cases");
		
		XYChart.Series<String, Number> northZone = new XYChart.Series<>();
		northZone.setName("North Zone");
		northZone.getData().add(new XYChart.Data<>("Cases", Main.analysis.getNorthZone()));
		
		XYChart.Series<String, Number> southZone = new XYChart.Series<>();
		southZone.setName("South Zone");
		southZone.getData().add(new XYChart.Data<>("Cases", Main.analysis.getSouthZone()));
		
		XYChart.Series<String, Number> edmontonZone = new XYChart.Series<>();
		edmontonZone.setName("Edmonton");
		edmontonZone.getData().add(new XYChart.Data<>("Cases", Main.analysis.getEdmontonZone()));
		
		XYChart.Series<String, Number> calgaryZone = new XYChart.Series<>();
		calgaryZone.setName("Calgary");
		calgaryZone.getData().add(new XYChart.Data<>("Cases", Main.analysis.getCalgaryZone()));
		
		XYChart.Series<String, Number> centralZone = new XYChart.Series<>();
		centralZone.setName("Central Zone");
		centralZone.getData().add(new XYChart.Data<>("Cases", Main.analysis.getCentralZone()));

//		XYChart.Series<String, Number> unknown = new XYChart.Series<>();
//		unknown.setName("Unknown");
//		unknown.getData().add(new XYChart.Data<>("Cases", Main.analysis.getUnknown())); Data is so negligible it really shouldn't be included.

		casesByZoneBarChart.getData().addAll(calgaryZone, edmontonZone, northZone, centralZone, southZone);
	}
	
	public void populateCasesByAgeLineChart() {
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		
		xAxis.setLabel("Age Category");
		yAxis.setLabel("Number of cases");
		
		
		XYChart.Series<String, Number> cases = new XYChart.Series<>();
		cases.getData().add(new XYChart.Data<>("< 1", Main.analysis.getUnderOne()));
		cases.getData().add(new XYChart.Data<>("1 - 4", Main.analysis.getOneToFour()));
		cases.getData().add(new XYChart.Data<>("5 - 9", Main.analysis.getFiveToNine()));
		cases.getData().add(new XYChart.Data<>("10 - 19", Main.analysis.getTenToNineteen()));
		cases.getData().add(new XYChart.Data<>("20 - 29", Main.analysis.getTwentyToTwentynine()));
		cases.getData().add(new XYChart.Data<>("30 - 39", Main.analysis.getThirtyToThirtynine()));
		cases.getData().add(new XYChart.Data<>("40 - 49", Main.analysis.getFourtyToFourtynine()));
		cases.getData().add(new XYChart.Data<>("50 - 59", Main.analysis.getFiftyToFiftynine()));
		cases.getData().add(new XYChart.Data<>("60 - 69", Main.analysis.getSixtyToSixtynine()));
		cases.getData().add(new XYChart.Data<>("70 - 79", Main.analysis.getSeventyToSeventynine()));
		cases.getData().add(new XYChart.Data<>("80+", Main.analysis.getOverEighty()));
		
		casesByAgeLineChart.getData().addAll(cases);
	}
	private void populateCasesByMonthLineChart() {
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		
		xAxis.setLabel("Month");
		yAxis.setLabel("Number of cases");
		
		XYChart.Series<String, Number> cases = new XYChart.Series<>();
		cases.getData().add(new XYChart.Data<>("Jan", Main.analysis.getCasesInJan()));
		cases.getData().add(new XYChart.Data<>("Feb", Main.analysis.getCasesInFeb()));
		cases.getData().add(new XYChart.Data<>("Mar", Main.analysis.getCasesInMar()));
		cases.getData().add(new XYChart.Data<>("Apr", Main.analysis.getCasesInApr()));
		cases.getData().add(new XYChart.Data<>("May", Main.analysis.getCasesInMay()));
		cases.getData().add(new XYChart.Data<>("Jun", Main.analysis.getCasesInJun()));
		cases.getData().add(new XYChart.Data<>("Jul", Main.analysis.getCasesInJul()));
		cases.getData().add(new XYChart.Data<>("Aug", Main.analysis.getCasesInAug()));
		cases.getData().add(new XYChart.Data<>("Sep", Main.analysis.getCasesInSep()));
		cases.getData().add(new XYChart.Data<>("Oct", Main.analysis.getCasesInOct()));
		cases.getData().add(new XYChart.Data<>("Nov", Main.analysis.getCasesInNov()));
		cases.getData().add(new XYChart.Data<>("Dec", Main.analysis.getCasesInDec()));
		
		casesByMonthLineChart.getData().addAll(cases);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		populateCasesByAgeLineChart();
		populateCasesByZoneBarChart();
		populateCasesByMonthLineChart();
	}
	
	public void switchToDataSummaryScene(ActionEvent event) {
		switchControl.switchToDataSummaryScene(event);
	}
	public void switchToDeathGraphScene(ActionEvent event) {
		switchControl.switchToDeathGraphsScene(event);
	}
	
	public void switchToDataLookupScene(ActionEvent event) {
		switchControl.switchToDataLookupScene(event);
	}


}
