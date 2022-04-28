package application;


import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

import javafx.scene.text.Text;

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
	
	
	// METHODS SECTION

	public void submit(ActionEvent e, CovidData[] container) {

			resultsList.getItems().clear();

			// Initializing local input variables
			String ageSelection = ageGroupSelection.getValue();
			String genderSelect = genderSelection.getValue();
			boolean[] selectedZones = getZoneSelections();
			LocalDate[] timeRange = {startTime.getValue().plusDays(0), endTime.getValue().plusDays(0)}; 
			
			// Time range must be at least 30 days
			
			// Do the lookup
			ArrayList<CovidData> matchingEntries = Main.analysis.lookupData(ageSelection, genderSelect, selectedZones, timeRange);
			resultsList.getItems().addAll(matchingEntries); // populations the list view

	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Populating data in the two combo boxes
		ageGroupSelection.getItems().addAll(ageGroupOptions);
		genderSelection.getItems().addAll(genderOptions);
	}

	
	private boolean[] getZoneSelections() {
		boolean[] zoneSelect = {calgaryCheckbox.isSelected(), edmontonCheckbox.isSelected(),
								northZoneCheckbox.isSelected(), southZoneCheckbox.isSelected(),
								centralZoneCheckbox.isSelected()};					
		return zoneSelect;
	}
	
}
