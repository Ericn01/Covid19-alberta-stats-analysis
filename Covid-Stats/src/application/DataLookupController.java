package application;


import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DataLookupController implements Initializable {
	
	@FXML
	private ComboBox<String> ageGroupSelection;
	private String[] ageGroupOptions = {"Under 1 year", "1-4 years", "5-9 years", "10-19 years", "20-29 years", "30-39 years", "40-49 years", "50-59 years", 
			                            "60-69 years", "70-79 years", "80+ years", "Unknown", "All"};
	@FXML
	private ComboBox<String> genderSelection;
	
	private String[] genderOptions = {"Male", "Female", "All"};

	@FXML
	private CheckBox calgaryCheckbox;
	@FXML
	private CheckBox edmontonCheckbox;
	@FXML
	private CheckBox northZoneCheckbox;
	@FXML
	private CheckBox southZoneCheckbox;
	@FXML
	private CheckBox centralZoneCheckbox;
	@FXML 
	private CheckBox unknownCheckbox;
	@FXML 
	private DatePicker startTime;
	@FXML 
	private DatePicker endTime;
	@FXML
	private Button submitBtn;
	@FXML
	private Button clearBtn;
	@FXML
	private ListView<CovidData> resultsList;
	@FXML 
	private Text caseNum;
	@FXML
	private Text deathNum;
	@FXML
	private PieChart distributionChart;
	
	// METHODS SECTION

	public void submit(ActionEvent e) {
			resultsList.getItems().clear();

			// Initializing local input variables
			String ageSelection = ageGroupSelection.getValue();
			String genderSelect = genderSelection.getValue();
			boolean[] selectedZones = getZoneSelections();
			LocalDate[] timeRange = {startTime.getValue().plusDays(0), endTime.getValue().plusDays(0)}; 
			
			// Time range must be at least 30 days
		
			// Do the lookup
			ArrayList<CovidData> matchingEntries = Main.analysis.lookupData(ageSelection, genderSelect, selectedZones, timeRange);
			DecimalFormat df = new DecimalFormat("###.###");
			
			// Holds the number of cases and deaths in relation to the given parameters
			int paramCases = matchingEntries.size();
			int paramDeaths = getDeathNumFromSelection(matchingEntries);
			ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
					new PieChart.Data("Number of cases", paramCases), new PieChart.Data("Number of deaths", paramDeaths));
			distributionChart.setData(pieChartData);
			caseNum.setText(Integer.toString(paramCases) + " (" + df.format(((double)paramCases / FileLoader.NUMBER_OF_ENTRIES) * 100) + "% of cases)");
			deathNum.setText(Integer.toString(paramDeaths) + " (" + df.format(((double) paramDeaths / (Main.analysis.getTotalMortalities()) * 100)) + "% of deaths)");
			resultsList.getItems().addAll(matchingEntries); // populations the list view
			
	}
	public void printMatchingEntries(ArrayList<CovidData> entries) {
		int counter =0;
		for (CovidData i: entries) {
			if (counter > 100) {
			System.out.println(i);
			}
			else {break;}
			counter++;
		}
	}
	public void clear(ActionEvent e) {
		ageGroupSelection.setValue("All"); // setting the default value to all
		genderSelection.setValue("All");
		// Setting every checkbox to be selected by default
		calgaryCheckbox.setSelected(true);
		edmontonCheckbox.setSelected(true);		
		northZoneCheckbox.setSelected(true);		
		southZoneCheckbox.setSelected(true);
		centralZoneCheckbox.setSelected(true);
		unknownCheckbox.setSelected(false);
		caseNum.setText("");
		deathNum.setText("");
		startTime.setValue(LocalDate.of(2020, 03, 01));
		endTime.setValue(LocalDate.now());
	}
	/**
	 * Calculates the number of deaths from the user's selection
	 * @param data
	 * @return
	 */
	private int getDeathNumFromSelection(ArrayList<CovidData> data) {
		int deathNum = 0;
		for (CovidData i: data) {
			String result = i.getResultedInDeath().replaceAll("\"", "");
			if (!result.toLowerCase().equals("na")) {
				deathNum++;
			}
		}
		return deathNum;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Populating data in the two combo boxes
		ageGroupSelection.getItems().addAll(ageGroupOptions);
		ageGroupSelection.setValue("All"); // setting the default value to all
		genderSelection.getItems().addAll(genderOptions);
		genderSelection.setValue("All");
		// Setting every checkbox to be selected by default
		calgaryCheckbox.setSelected(true);
		edmontonCheckbox.setSelected(true);		
		northZoneCheckbox.setSelected(true);		
		southZoneCheckbox.setSelected(true);
		centralZoneCheckbox.setSelected(true);
		unknownCheckbox.setSelected(false);
		startTime.setValue(LocalDate.of(2020, 03, 01));
		endTime.setValue(LocalDate.now()); // sets it to the current day
		
	}
	/**
	 * Boolean representation of the state of the checkboxes
	 * @return
	 */
	private boolean[] getZoneSelections() {
		boolean[] zoneSelect = {calgaryCheckbox.isSelected(), edmontonCheckbox.isSelected(),
								northZoneCheckbox.isSelected(), southZoneCheckbox.isSelected(),
								centralZoneCheckbox.isSelected(), unknownCheckbox.isSelected()};			
		System.out.println(zoneSelect);
		return zoneSelect;
	}
	
	public void switchToDataSummaryScene(ActionEvent event) {
		try {
			System.out.println("I've been clicked!");
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
