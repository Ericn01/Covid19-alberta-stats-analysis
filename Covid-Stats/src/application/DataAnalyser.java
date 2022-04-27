package application;

import java.text.DecimalFormat;

public class DataAnalyser {

	private CovidData[] container;
	
	private int totalMortalities = 0;
	private int maleMortalities = 0;
	private int maleCases = 0;
	private int femaleMortalities = 0;
	private int femaleCases = 0;
	
	// Zone cases
	private int calgaryZone = 0;
	private int edmontonZone = 0;
	private int northZone = 0;
	private int centralZone = 0;
	private int southZone = 0;
	
	// Zone deaths
	private int calgaryZoneDeaths = 0;
	private int edmontonZoneDeaths = 0;
	private int northZoneDeaths = 0;
	private int centralZoneDeaths = 0;
	private int southZoneDeaths = 0;
	private int unknown, unknownZoneDeaths = 0;
	
	// Year case counter
	private int casesIn2019 = 0;
	private int casesIn2020 = 0;
	private int casesIn2021 = 0;
	private int casesIn2022 = 0;
	
	// Year death counter :(
	private int deathsIn2019 = 0;
	private int deathsIn2020 = 0;
	private int deathsIn2021 = 0;
	private int deathsIn2022 = 0;
	
	// Age case counter
	private int underOne = 0;
	private int oneToFour = 0;
	private int fiveToNine = 0;
	private int tenToNineteen = 0;
	private int twentyToTwentynine = 0;
	private int thirtyToThirtynine = 0;
	private int fourtyToFourtynine = 0;
	private int fiftyToFiftynine = 0;
	private int sixtyToSixtynine = 0;
	private int seventyToSeventynine = 0;
	private int overEighty = 0;
	private int unknownAge = 0;
	
	// Age death counter
	private int underOneDeaths = 0;
	private int oneToFourDeaths = 0;
	private int fiveToNineDeaths = 0;
	private int tenToNineteenDeaths = 0;	
	private int twentyToTwentynineDeaths = 0;
	private int thirtyToThirtynineDeaths = 0;
	private int fourtyToFourtynineDeaths = 0;
	private int fiftyToFiftynineDeaths = 0;
	private int sixtyToSixtynineDeaths = 0;
	private int seventyToSeventynineDeaths = 0;
	private int overEightyDeaths = 0;	
	private int unknownAgeDeaths = 0;
	// Month case counters
	private int casesInJan, deathsInJan = 0; 
	private int casesInFeb, deathsInFeb = 0;
	private int casesInMar, deathsInMar = 0;
	private int casesInApr, deathsInApr = 0;
	private int casesInMay, deathsInMay = 0;
	private int casesInJun, deathsInJun = 0;
	private int casesInJul, deathsInJul = 0;
	private int casesInAug, deathsInAug = 0;
	private int casesInSep, deathsInSep = 0;
	private int casesInOct, deathsInOct = 0;
	private int casesInNov, deathsInNov = 0;
	private int casesInDec, deathsInDec = 0;
	
	// Misc
	private double ageTally = 0.0;
	
	/**
	 * Constructor for the Data Analyser class. 
	 * It takes in the loaded file in the form of an array as a parameter, and then calculates data based on that 
	 * @param container the covid data container / array
	 */
	public DataAnalyser(CovidData[] container) {
		this.container=container;
		calculateAggregateData(); // Calculates data
		dataReport(); // prints data to console
	}
	/**
	 * Prints the main findings from the data. 
	 */
	public void dataReport() {
		int totalCases = FileLoader.NUMBER_OF_ENTRIES;
		
		printHeader();
		ratioPrint("Total ", totalCases, totalMortalities);
		System.out.println("\nBY YEAR\n");
		ratioPrint("2019 ", casesIn2019, deathsIn2019);	
		ratioPrint("2020 ", casesIn2020, deathsIn2020);
		ratioPrint("2021 ", casesIn2021, deathsIn2021);
		ratioPrint("2022 ", casesIn2022, deathsIn2022);
		
		System.out.println("\nBY MONTH\n");
		ratioPrint("January ", casesInJan, deathsInJan);
		ratioPrint("February ", casesInFeb, deathsInFeb);
		ratioPrint("March ", casesInMar, deathsInMar);
		ratioPrint("April ", casesInApr, deathsInApr);
		ratioPrint("May ", casesInMay, deathsInMay);
		ratioPrint("June ", casesInJun, deathsInJun);
		ratioPrint("July ", casesInJul, deathsInJul);
		ratioPrint("August ", casesInAug, deathsInAug);
		ratioPrint("September ", casesInSep, deathsInSep);
		ratioPrint("October ", casesInOct, deathsInOct);
		ratioPrint("November ", casesInNov, deathsInNov);
		ratioPrint("December ", casesInDec, deathsInDec);
		
		System.out.println("\nBY AGE GROUP\n");
		ratioPrint("< 1 years old ", underOne, underOneDeaths);
		ratioPrint("1 - 4 years old ", oneToFour, oneToFourDeaths);
		ratioPrint("5 - 9 years old", fiveToNine, fiveToNineDeaths);
		ratioPrint("10 - 19 years old", tenToNineteen, tenToNineteenDeaths);
		ratioPrint("20 - 29 years old", twentyToTwentynine, twentyToTwentynineDeaths);
		ratioPrint("30 - 39 years old ", thirtyToThirtynine, thirtyToThirtynineDeaths);
		ratioPrint("40 - 49 years old ", fourtyToFourtynine, fourtyToFourtynineDeaths);
		ratioPrint("50 - 59 years old ", fiftyToFiftynine, fiftyToFiftynineDeaths);
		ratioPrint("60 - 69 years old ", sixtyToSixtynine, sixtyToSixtynineDeaths);
		ratioPrint("70 - 79 years old ", seventyToSeventynine, seventyToSeventynineDeaths);
		ratioPrint("80+ years old ", overEighty, overEightyDeaths);
		ratioPrint("Unknown age ", unknownAge, unknownAgeDeaths);
		
		System.out.println("\nBY ZONE\n");
		ratioPrint("North Zone ", northZone, northZoneDeaths);
		ratioPrint("Central Zone ", centralZone, centralZoneDeaths);
		ratioPrint("South Zone ", southZone, southZoneDeaths);
		ratioPrint("Edmonton Zone ", edmontonZone, edmontonZoneDeaths);
		ratioPrint("Calgary Zone ", calgaryZone, calgaryZoneDeaths);
		ratioPrint("Unknown area ", unknown, unknownZoneDeaths);
		
		
		System.out.println("\nBY GENDER\n");;
		ratioPrint("Male", maleCases, maleMortalities);
		ratioPrint("Female", femaleCases, femaleMortalities);
		System.out.println("\nThe average age of death from COVID-19 in Alberta is " + (int)(ageTally / totalMortalities) + " years old");
		DecimalFormat df = new DecimalFormat("###.###");
		System.out.println("The mortality rate of COVID-19 in Alberta is " + df.format(((double) totalMortalities / totalCases) * 100) + "%");
	}
	
	/**
	 * Prints and formats the given data nicely.
	 * @param msg The message that gives context to the value
	 * @param cases number of cases or mortalities given on the context
	 * @param type the type of data we're dealing with. 1 = cases, 2 = mortalities
	 */
	private void ratioPrint(String msg, int cases, int mortalities) {
		int totalCases = FileLoader.NUMBER_OF_ENTRIES;
		System.out.printf("%-4s%-22s%,-10d%-1s%-1.3f%-9s%,-10d%-1s%-1.3f%-1s%n", "", msg, cases, "(",  ((double) cases / totalCases) * 100, "%)", 
						mortalities, "(", ((double) mortalities / totalMortalities) * 100, "%)");
	}
	
	private void printHeader() {
		System.out.println("Here's a short overview of Alberta's covid data");
		System.out.printf("%n%-26s%-10s%-17s%-10s%1s%n", "", "CASES", "Percent Ratio", "DEATHS", "Percent Ratio"); // header
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
	/**
	 * A single pass of the Array that calculates all the information we want
	 */
	private void calculateAggregateData() {
		for (int i = 0; i < container.length; i++) {
			CovidData individualData = container[i];
			/* 1: Mortality Data
			*     a) Total 
			*     b) Average age of death
			*     c) Percent male/female death
			*/
			totalMortalities += mortalityInterpreter(individualData.getResultedInDeath());
			genderDistributionCounter(individualData);
			casesPerDate(individualData);
			ageTally(individualData);
			ageGroupCasesAndDeaths(individualData);
			zoneCasesAndDeaths(individualData);
		}
	}
	
	private void genderDistributionCounter (CovidData d) {
		String gender = d.getGender();
		if (gender.equals("Male")) {
			maleCases++;
		}
		else if (gender.equals("Female")) {
			femaleCases++;
		}
		if (gender.equals("Male") && mortalityInterpreter(d.getResultedInDeath()) == 1) {
			maleMortalities++;
		}
		else if (gender.equals("Female") && mortalityInterpreter(d.getResultedInDeath()) == 1) {
			femaleMortalities++;
		}
	}
	
	private void ageTally(CovidData d) {
		if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
			this.ageTally += interpretAgeGroup(d.getAgeGroup());
		}
	}
	
	private void zoneCasesAndDeaths(CovidData d) {
		String zone = d.getAlbertaZone().replaceAll("\"", "");
		switch(zone) {
		case "Calgary Zone":
			calgaryZone++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				calgaryZoneDeaths++;
			}
			break;
		case "Edmonton Zone":
			edmontonZone++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				edmontonZoneDeaths++;
			}
			break;
		case "Central Zone":
			centralZone++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				centralZoneDeaths++;
			}
			break;
		case "South Zone":
			southZone++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				southZoneDeaths++;
			}
			break;
		case "North Zone":
			northZone++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				northZoneDeaths++;
			}
			break;
		case "Unknown":
			unknown++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				unknownZoneDeaths++;
			}
			break;
		case "":
			break;
		default:
			System.out.println("This should not appear" + zone);
		}
	}
	
	private void ageGroupCasesAndDeaths(CovidData d) {;
		String ageGroup = d.getAgeGroup().replaceAll("\"", "");
		switch(ageGroup) {
		case "10-19 years":
			tenToNineteen++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				tenToNineteenDeaths++;
			}
			break;
		case "40-49 years":
			fourtyToFourtynine++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				fourtyToFourtynineDeaths++;
			}
			break;
		case "50-59 years":
			fiftyToFiftynine++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				fiftyToFiftynineDeaths++;
			}
			break;
		case "60-69 years":
			sixtyToSixtynine++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				sixtyToSixtynineDeaths++;
			}
			break;
		case "30-39 years":
			thirtyToThirtynine++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				thirtyToThirtynineDeaths++;
			}
			break;
		case "20-29 years":
			twentyToTwentynine++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				twentyToTwentynineDeaths++;
			}
			break;
		case "70-79 years":
			seventyToSeventynine++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				seventyToSeventynineDeaths++;
			}
			break;
		case "1-4 years":
			oneToFour++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				oneToFourDeaths++;
			}
			break;
		case "5-9 years":
			fiveToNine++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				fiveToNineDeaths++;
			}
			break;
		case "Under 1 year":
			underOne++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) { // expected to be zero
				underOneDeaths++;
			}
			break;
		case "80+ years":
			overEighty++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				overEightyDeaths++;
			}
			break;
		case "Unknown":
			unknownAge++;
			if (mortalityInterpreter(d.getResultedInDeath()) == 1) {
				unknownAgeDeaths++;
			}
			break;
		default:
			System.out.println("Problem with age" + ageGroup);
		}
	}
	/**
	 * Used to calculate the average age of death 
	 * @param ageGroup
	 * @return
	 */
	private double interpretAgeGroup(String ageGroup) {
		double medianAge = 0;
		ageGroup = ageGroup.replaceAll("\"", "");
		switch(ageGroup) {
		case "10-19 years":
			medianAge = 15.0;
			break;
		case "40-49 years":
			medianAge = 45.0;
			break;
		case "50-59 years":
			medianAge = 55.0;
			break;
		case "60-69 years":
			medianAge = 45.0;
			break;
		case "30-39 years":
			medianAge = 35.0;
			break;
		case "20-29 years":
			medianAge = 25.0;
			break;
		case "70-79 years":
			medianAge = 78.0;
			break;
		case "1-4 years":
			medianAge = 2.50;
			break;
		case "5-9 years":
			medianAge = 7.50;
			break;
		case "Under 1 year":
			medianAge = 0.5;
			break;
		case "80+ years":
			medianAge = 92.0;
			break;
		default:
			System.out.println("");
		}
		return medianAge;
	}
	/**
	 * By now you'll probably see how repetitive this code is
	 * wasn't planned very well... lol
	 * @param d
	 */
	private void casesPerDate(CovidData d) {
		int year = d.getDateReported().getYear();
		int month = d.getDateReported().getMonthValue();
		int died = mortalityInterpreter(d.getResultedInDeath());
		switch(year) {
		case 2019:
			casesIn2019++; // should be 0
			if (died == 1) {
				deathsIn2019++;
			}
			break;
		case 2020:
			casesIn2020++;
			if (died == 1) {
				deathsIn2020++;
			}
			break;
		case 2021:
			casesIn2021++;
			if (died == 1) {
				deathsIn2021++;
			}
			break;
		case 2022:
			casesIn2022++;
			if (died == 1) {
				deathsIn2022++;
			}
			break;
		default:
			System.out.println("");
		}
		switch(month) {
		case 1:
			casesInJan++;
			if (died == 1) {
				deathsInJan++;
			}
			break;
		case 2:
			casesInFeb++;
			if (died == 1) {
				deathsInFeb++;
			}
			break;
		case 3:
			casesInMar++;
			if (died == 1) {
				deathsInMar++;
			}
			break;
		case 4:
			casesInApr++;
			if (died == 1) {
				deathsInApr++;
			}
			break;
		case 5:
			casesInMay++;
			if (died == 1) {
				deathsInMay++;
			}
			break;
		case 6:
			casesInJun++;
			if (died == 1) {
				deathsInJun++;
			}
			break;
		case 7:
			casesInJul++;
			if (died == 1) {
				deathsInJul++;
			}
			break;
		case 8:
			casesInAug++;
			if (died == 1) {
				deathsInAug++;
			}
			break;
		case 9:
			casesInSep++;
			if (died == 1) {
				deathsInSep++;
			}
			break;
		case 10:
			casesInOct++;
			if (died == 1) {
				deathsInOct++;
			}
			break;
		case 11:
			casesInNov++;
			if (died == 1) {
				deathsInNov++;
			}
			break;
		case 12:
			casesInDec++;
			if (died == 1) {
				deathsInDec++;
			}
			break;
		default:
			System.out.println("This should never print out");
		}
	}
	
	private int mortalityInterpreter(String input) {
		int died = 0; // 0 means the individual survived, 1 means that they did not
		if (input.equals("Died")) {
			died = 1;
		}
		return died;
	}
	
	// Getters to retrieve the data in other classes - impo
	public CovidData[] getContainer() {
		return container;
	}
	public int getTotalMortalities() {
		return totalMortalities;
	}
	public int getMaleMortalities() {
		return maleMortalities;
	}
	public int getMaleCases() {
		return maleCases;
	}
	public int getFemaleMortalities() {
		return femaleMortalities;
	}
	public int getFemaleCases() {
		return femaleCases;
	}
	public int getCalgaryZone() {
		return calgaryZone;
	}
	public int getEdmontonZone() {
		return edmontonZone;
	}
	public int getNorthZone() {
		return northZone;
	}
	public int getCentralZone() {
		return centralZone;
	}
	public int getSouthZone() {
		return southZone;
	}
	public int getCalgaryZoneDeaths() {
		return calgaryZoneDeaths;
	}
	public int getEdmontonZoneDeaths() {
		return edmontonZoneDeaths;
	}
	public int getNorthZoneDeaths() {
		return northZoneDeaths;
	}
	public int getCentralZoneDeaths() {
		return centralZoneDeaths;
	}
	public int getSouthZoneDeaths() {
		return southZoneDeaths;
	}
	public int getUnknown() {
		return unknown;
	}
	public int getUnknownZoneDeaths() {
		return unknownZoneDeaths;
	}
	public int getCasesIn2019() {
		return casesIn2019;
	}
	public int getCasesIn2020() {
		return casesIn2020;
	}
	public int getCasesIn2021() {
		return casesIn2021;
	}
	public int getCasesIn2022() {
		return casesIn2022;
	}
	public int getDeathsIn2019() {
		return deathsIn2019;
	}
	public int getDeathsIn2020() {
		return deathsIn2020;
	}
	public int getDeathsIn2021() {
		return deathsIn2021;
	}
	public int getDeathsIn2022() {
		return deathsIn2022;
	}
	public int getUnderOne() {
		return underOne;
	}
	public int getOneToFour() {
		return oneToFour;
	}
	public int getFiveToNine() {
		return fiveToNine;
	}
	public int getTenToNineteen() {
		return tenToNineteen;
	}
	public int getTwentyToTwentynine() {
		return twentyToTwentynine;
	}
	public int getThirtyToThirtynine() {
		return thirtyToThirtynine;
	}
	public int getFourtyToFourtynine() {
		return fourtyToFourtynine;
	}
	public int getFiftyToFiftynine() {
		return fiftyToFiftynine;
	}
	public int getSixtyToSixtynine() {
		return sixtyToSixtynine;
	}
	public int getSeventyToSeventynine() {
		return seventyToSeventynine;
	}
	public int getOverEighty() {
		return overEighty;
	}
	public int getUnknownAge() {
		return unknownAge;
	}
	public int getUnderOneDeaths() {
		return underOneDeaths;
	}
	public int getOneToFourDeaths() {
		return oneToFourDeaths;
	}
	public int getFiveToNineDeaths() {
		return fiveToNineDeaths;
	}
	public int getTenToNineteenDeaths() {
		return tenToNineteenDeaths;
	}
	public int getTwentyToTwentynineDeaths() {
		return twentyToTwentynineDeaths;
	}
	public int getThirtyToThirtynineDeaths() {
		return thirtyToThirtynineDeaths;
	}
	public int getFourtyToFourtynineDeaths() {
		return fourtyToFourtynineDeaths;
	}
	public int getFiftyToFiftynineDeaths() {
		return fiftyToFiftynineDeaths;
	}
	public int getSixtyToSixtynineDeaths() {
		return sixtyToSixtynineDeaths;
	}
	public int getSeventyToSeventynineDeaths() {
		return seventyToSeventynineDeaths;
	}
	public int getOverEightyDeaths() {
		return overEightyDeaths;
	}
	public int getUnknownAgeDeaths() {
		return unknownAgeDeaths;
	}
	public int getCasesInJan() {
		return casesInJan;
	}
	public int getDeathsInJan() {
		return deathsInJan;
	}
	public int getCasesInFeb() {
		return casesInFeb;
	}
	public int getDeathsInFeb() {
		return deathsInFeb;
	}
	public int getCasesInMar() {
		return casesInMar;
	}
	public int getDeathsInMar() {
		return deathsInMar;
	}
	public int getCasesInApr() {
		return casesInApr;
	}
	public int getDeathsInApr() {
		return deathsInApr;
	}
	public int getCasesInMay() {
		return casesInMay;
	}
	public int getDeathsInMay() {
		return deathsInMay;
	}
	public int getCasesInJun() {
		return casesInJun;
	}
	public int getDeathsInJun() {
		return deathsInJun;
	}
	public int getCasesInJul() {
		return casesInJul;
	}
	public int getDeathsInJul() {
		return deathsInJul;
	}
	public int getCasesInAug() {
		return casesInAug;
	}
	public int getDeathsInAug() {
		return deathsInAug;
	}
	public int getCasesInSep() {
		return casesInSep;
	}
	public int getDeathsInSep() {
		return deathsInSep;
	}
	public int getCasesInOct() {
		return casesInOct;
	}
	public int getDeathsInOct() {
		return deathsInOct;
	}
	public int getCasesInNov() {
		return casesInNov;
	}
	public int getDeathsInNov() {
		return deathsInNov;
	}
	public int getCasesInDec() {
		return casesInDec;
	}
	public int getDeathsInDec() {
		return deathsInDec;
	}
	
	
}
