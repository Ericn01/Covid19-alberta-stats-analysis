package application;

import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Chart {
	// To create a JavaFX chart, you need to first define the axis of the chart
	// Instantiate the respective class
	// Prepare and pass data to the chart
	FileLoader loadFile = new FileLoader();
	DataAnalyser analysis = new DataAnalyser(loadFile.getDataContainer());
	
	public Group makeZoneChart() {
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setCategories(FXCollections.observableArrayList(
				Arrays.asList("Cases", "Deaths")));
		xAxis.setLabel("");
		
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("");
		
		BarChart<String, Number> zoneChart = new BarChart<>(xAxis, yAxis);
		zoneChart.setTitle("Alberta COVID-19 cases and deaths by zone");
		
		XYChart.Series<String, Number> northZone = new XYChart.Series<>();
		northZone.setName("North Zone");
		northZone.getData().add(new XYChart.Data<>("Cases", analysis.getNorthZone()));
		northZone.getData().add(new XYChart.Data<>("Deaths", analysis.getNorthZoneDeaths()));
		
		XYChart.Series<String, Number> southZone = new XYChart.Series<>();
		southZone.setName("South Zone");
		southZone.getData().add(new XYChart.Data<>("Cases", analysis.getSouthZone()));
		southZone.getData().add(new XYChart.Data<>("Deaths", analysis.getSouthZoneDeaths()));
		
		XYChart.Series<String, Number> edmontonZone = new XYChart.Series<>();
		edmontonZone.setName("Edmonton");
		edmontonZone.getData().add(new XYChart.Data<>("Cases", analysis.getEdmontonZone()));
		edmontonZone.getData().add(new XYChart.Data<>("Deaths", analysis.getEdmontonZoneDeaths()));
		
		XYChart.Series<String, Number> calgaryZone = new XYChart.Series<>();
		calgaryZone.setName("Calgary");
		calgaryZone.getData().add(new XYChart.Data<>("Cases", analysis.getCalgaryZone()));
		calgaryZone.getData().add(new XYChart.Data<>("Deaths", analysis.getCalgaryZoneDeaths()));
		
		XYChart.Series<String, Number> centralZone = new XYChart.Series<>();
		centralZone.setName("Central Zone");
		centralZone.getData().add(new XYChart.Data<>("Cases", analysis.getCentralZone()));
		centralZone.getData().add(new XYChart.Data<>("Deaths", analysis.getCentralZoneDeaths()));
		
		XYChart.Series<String, Number> unknown = new XYChart.Series<>();
		unknown.setName("Unknown");
		unknown.getData().add(new XYChart.Data<>("Cases", analysis.getUnknown()));
		unknown.getData().add(new XYChart.Data<>("Deaths", analysis.getUnknownZoneDeaths()));
		
		zoneChart.getData().addAll(northZone, southZone, edmontonZone, calgaryZone, centralZone, unknown);
		Group root = new Group(zoneChart);
		
		return root;
	}

}
