package application;
import java.time.LocalDate;
/**
 * This class represents what a COVID data object will look like. All the attributes from the CSV file are here.
 * @author Eric Nielsen
 *
 */
public class CovidData {
	private int id;
	private LocalDate dateReported;
	private String albertaZone;
	private String gender;
	private String ageGroup;
	private String resultedInDeath;
	private String caseType;
	
	public CovidData(int id, LocalDate dateReported, String albertaZone, String gender, String ageGroup,
			String resultedInDeath, String caseType) {
		this.id = id;
		this.dateReported = dateReported;
		this.albertaZone = albertaZone;
		this.gender = gender;
		this.ageGroup = ageGroup;
		this.resultedInDeath = resultedInDeath;
		this.caseType = caseType;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDateReported() {
		return dateReported;
	}
	public void setDateReported(LocalDate dateReported) {
		this.dateReported = dateReported;
	}
	public String getAlbertaZone() {
		return albertaZone;
	}
	public void setAlbertaZone(String albertaZone) {
		this.albertaZone = albertaZone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
	public String getResultedInDeath() {
		return resultedInDeath;
	}
	public void setResultedInDeath(String resultedInDeath) {
		resultedInDeath = resultedInDeath.replaceAll("\"", "");
		this.resultedInDeath = resultedInDeath;
	}
	public String isCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	
	public String toString() {
		return "ID: " + id + ", " + dateReported + ", " + albertaZone + ", " + gender + ", " + ageGroup;
	}
	
}
