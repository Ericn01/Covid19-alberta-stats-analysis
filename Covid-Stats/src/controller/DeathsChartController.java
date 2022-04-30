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

public class DeathsChartController implements Initializable {
	ViewSwitch switchControl = new ViewSwitch();
	@FXML
	private LineChart<String, Number> deathsByAgeLineChart;
	@FXML
	private BarChart<String, Number> deathsByZoneBarChart;
	@FXML
	private LineChart<String, Number> deathsByMonthLineChart;

	public void populateDeathsByAgeLineChart() {
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		
		xAxis.setLabel("Age Category");
		yAxis.setLabel("Number of cases");
		
		
		XYChart.Series<String, Number> cases = new XYChart.Series<>();
		cases.getData().add(new XYChart.Data<>("< 1", Main.analysis.getUnderOneDeaths()));
		cases.getData().add(new XYChart.Data<>("1 - 4", Main.analysis.getOneToFourDeaths()));
		cases.getData().add(new XYChart.Data<>("5 - 9", Main.analysis.getFiveToNineDeaths()));
		cases.getData().add(new XYChart.Data<>("10 - 19", Main.analysis.getTenToNineteenDeaths()));
		cases.getData().add(new XYChart.Data<>("20 - 29", Main.analysis.getTwentyToTwentynineDeaths()));
		cases.getData().add(new XYChart.Data<>("30 - 39", Main.analysis.getThirtyToThirtynineDeaths()));
		cases.getData().add(new XYChart.Data<>("40 - 49", Main.analysis.getFourtyToFourtynineDeaths()));
		cases.getData().add(new XYChart.Data<>("50 - 59", Main.analysis.getFiftyToFiftynineDeaths()));
		cases.getData().add(new XYChart.Data<>("60 - 69", Main.analysis.getSixtyToSixtynineDeaths()));
		cases.getData().add(new XYChart.Data<>("70 - 79", Main.analysis.getSeventyToSeventynineDeaths()));
		cases.getData().add(new XYChart.Data<>("80+", Main.analysis.getOverEightyDeaths()));
		
		deathsByAgeLineChart.getData().addAll(cases);
	}
	
	public void populateDeathsByZoneBarChart() {
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		
		xAxis.setLabel("Alberta Zone");
		yAxis.setLabel("Number of cases");

		XYChart.Series<String, Number> northZone = new XYChart.Series<>();
		northZone.setName("North Zone");
		northZone.getData().add(new XYChart.Data<>("Cases", Main.analysis.getNorthZoneDeaths()));
		
		XYChart.Series<String, Number> southZone = new XYChart.Series<>();
		southZone.setName("South Zone");
		southZone.getData().add(new XYChart.Data<>("Cases", Main.analysis.getSouthZoneDeaths()));
		
		XYChart.Series<String, Number> edmontonZone = new XYChart.Series<>();
		edmontonZone.setName("Edmonton");
		edmontonZone.getData().add(new XYChart.Data<>("Cases", Main.analysis.getEdmontonZoneDeaths()));
		
		XYChart.Series<String, Number> calgaryZone = new XYChart.Series<>();
		calgaryZone.setName("Calgary");
		calgaryZone.getData().add(new XYChart.Data<>("Cases", Main.analysis.getCalgaryZoneDeaths()));
		
		XYChart.Series<String, Number> centralZone = new XYChart.Series<>();
		centralZone.setName("Central Zone");
		centralZone.getData().add(new XYChart.Data<>("Cases", Main.analysis.getCentralZoneDeaths()));

//		XYChart.Series<String, Number> unknown = new XYChart.Series<>();
//		unknown.setName("Unknown");
//		unknown.getData().add(new XYChart.Data<>("Cases", Main.analysis.getUnknownDeaths())); data is so negligible it shouldn't be included

		deathsByZoneBarChart.getData().addAll(calgaryZone, edmontonZone, northZone, centralZone,southZone);
	}
	
	private void populateDeathsByMonthLineChart() {
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		
		xAxis.setLabel("Month");
		yAxis.setLabel("Number of cases");
		
		XYChart.Series<String, Number> cases = new XYChart.Series<>();
		cases.getData().add(new XYChart.Data<>("Jan", Main.analysis.getDeathsInJan()));
		cases.getData().add(new XYChart.Data<>("Feb", Main.analysis.getDeathsInFeb()));
		cases.getData().add(new XYChart.Data<>("Mar", Main.analysis.getDeathsInMar()));
		cases.getData().add(new XYChart.Data<>("Apr", Main.analysis.getDeathsInApr()));
		cases.getData().add(new XYChart.Data<>("May", Main.analysis.getDeathsInMay()));
		cases.getData().add(new XYChart.Data<>("Jun", Main.analysis.getDeathsInJun()));
		cases.getData().add(new XYChart.Data<>("Jul", Main.analysis.getDeathsInJul()));
		cases.getData().add(new XYChart.Data<>("Aug", Main.analysis.getDeathsInAug()));
		cases.getData().add(new XYChart.Data<>("Sep", Main.analysis.getDeathsInSep()));
		cases.getData().add(new XYChart.Data<>("Oct", Main.analysis.getDeathsInOct()));
		cases.getData().add(new XYChart.Data<>("Nov", Main.analysis.getDeathsInNov()));
		cases.getData().add(new XYChart.Data<>("Dec", Main.analysis.getDeathsInDec()));
		
		deathsByMonthLineChart.getData().addAll(cases);
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		populateDeathsByAgeLineChart();
		populateDeathsByZoneBarChart();
		populateDeathsByMonthLineChart();
	}
	
	public void switchToDataSummaryScene(ActionEvent event) {
		switchControl.switchToDataSummaryScene(event);
	}
	public void switchToGraphsScene(ActionEvent event) {
		switchControl.switchToCasesGraphsScene(event);;
	}
	
	public void switchToDataLookupScene(ActionEvent event) {
		switchControl.switchToDataLookupScene(event);
	}

	
}
