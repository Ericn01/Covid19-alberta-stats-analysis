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
		northZone.getData().add(new XYChart.Data<>("Cases", Main.analysis.getNorthZone()));
		northZone.getData().add(new XYChart.Data<>("Deaths", Main.analysis.getNorthZoneDeaths()));
		
		XYChart.Series<String, Number> southZone = new XYChart.Series<>();
		southZone.setName("South Zone");
		southZone.getData().add(new XYChart.Data<>("Cases", Main.analysis.getSouthZone()));
		southZone.getData().add(new XYChart.Data<>("Deaths", Main.analysis.getSouthZoneDeaths()));
		
		XYChart.Series<String, Number> edmontonZone = new XYChart.Series<>();
		edmontonZone.setName("Edmonton");
		edmontonZone.getData().add(new XYChart.Data<>("Cases", Main.analysis.getEdmontonZone()));
		edmontonZone.getData().add(new XYChart.Data<>("Deaths", Main.analysis.getEdmontonZoneDeaths()));
		
		XYChart.Series<String, Number> calgaryZone = new XYChart.Series<>();
		calgaryZone.setName("Calgary");
		calgaryZone.getData().add(new XYChart.Data<>("Cases", Main.analysis.getCalgaryZone()));
		calgaryZone.getData().add(new XYChart.Data<>("Deaths", Main.analysis.getCalgaryZoneDeaths()));
		
		XYChart.Series<String, Number> centralZone = new XYChart.Series<>();
		centralZone.setName("Central Zone");
		centralZone.getData().add(new XYChart.Data<>("Cases", Main.analysis.getCentralZone()));
		centralZone.getData().add(new XYChart.Data<>("Deaths", Main.analysis.getCentralZoneDeaths()));
		
		XYChart.Series<String, Number> unknown = new XYChart.Series<>();
		unknown.setName("Unknown");
		unknown.getData().add(new XYChart.Data<>("Cases", Main.analysis.getUnknown()));
		unknown.getData().add(new XYChart.Data<>("Deaths", Main.analysis.getUnknownZoneDeaths()));
		
		zoneChart.getData().addAll(northZone, southZone, edmontonZone, calgaryZone, centralZone, unknown);
		Group root = new Group(zoneChart);
		
		return root;
	}
	
	public Group makeAgeChart() {
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setCategories(FXCollections.observableArrayList(
				Arrays.asList("Cases", "Deaths")));
		xAxis.setLabel("");
		
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("");
		
		BarChart<String, Number> yearChart = new BarChart<>(xAxis, yAxis);
		yearChart.setTitle("Alberta COVID-19 cases and deaths by year");
		
		XYChart.Series<String, Number> series2020 = new XYChart.Series<>();
		series2020.setName("2020");
		series2020.getData().add(new XYChart.Data<>("Cases", Main.analysis.getCasesIn2020()));
		series2020.getData().add(new XYChart.Data<>("Deaths", Main.analysis.getDeathsIn2020()));
		
		XYChart.Series<String, Number> series2021 = new XYChart.Series<>();
		series2021.setName("2021");
		series2021.getData().add(new XYChart.Data<>("Cases", Main.analysis.getCasesIn2021()));
		series2021.getData().add(new XYChart.Data<>("Deaths", Main.analysis.getDeathsIn2021()));
		
		XYChart.Series<String, Number> series2022 = new XYChart.Series<>();
		series2022.setName("2022");
		series2022.getData().add(new XYChart.Data<>("Cases", Main.analysis.getCasesIn2022()));
		series2022.getData().add(new XYChart.Data<>("Deaths", Main.analysis.getDeathsIn2022()));
		
		yearChart.getData().addAll(series2020, series2021, series2022);
		Group root = new Group(yearChart);
		return root;
	}

}
