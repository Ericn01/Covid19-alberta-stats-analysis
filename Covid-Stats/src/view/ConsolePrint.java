package view;

import java.text.DecimalFormat;

import application.Main;
import model.FileLoader;

public class ConsolePrint {
	
	/**
	 * Prints the main findings from the data.
	 * This is the original data report function which I intend to keep
	 * Presents the main findings in a formatted, tabular form to the console
	 */
	public static void printDataReport() {
		int totalCases = FileLoader.NUMBER_OF_ENTRIES;
		
		printHeader();
		ratioPrint("Total ", totalCases, Main.analysis.getTotalMortalities());
		System.out.println("\nBY YEAR\n");
		ratioPrint("2019 ", Main.analysis.getCasesIn2019(), Main.analysis.getDeathsIn2019());	
		ratioPrint("2020 ", Main.analysis.getCasesIn2020(), Main.analysis.getDeathsIn2020());	
		ratioPrint("2021 ", Main.analysis.getCasesIn2021(), Main.analysis.getDeathsIn2021());	
		ratioPrint("2022 ", Main.analysis.getCasesIn2022(), Main.analysis.getDeathsIn2022());	
		
		System.out.println("\nBY MONTH\n");
		ratioPrint("January ", Main.analysis.getCasesInJan(), Main.analysis.getDeathsInJan());
		ratioPrint("February ", Main.analysis.getCasesInFeb(), Main.analysis.getDeathsInFeb());
		ratioPrint("March ", Main.analysis.getCasesInMar(), Main.analysis.getDeathsInMar());
		ratioPrint("April ", Main.analysis.getCasesInApr(), Main.analysis.getDeathsInApr());
		ratioPrint("May ", Main.analysis.getCasesInMay(), Main.analysis.getDeathsInMay());
		ratioPrint("June ", Main.analysis.getCasesInJun(), Main.analysis.getDeathsInJun());
		ratioPrint("July ", Main.analysis.getCasesInJul(), Main.analysis.getDeathsInJul());
		ratioPrint("August ", Main.analysis.getCasesInAug(), Main.analysis.getDeathsInAug());
		ratioPrint("September ", Main.analysis.getCasesInSep(), Main.analysis.getDeathsInSep());
		ratioPrint("October ",  Main.analysis.getCasesInOct(), Main.analysis.getDeathsInOct());
		ratioPrint("November ", Main.analysis.getCasesInNov(), Main.analysis.getDeathsInNov());
		ratioPrint("December ", Main.analysis.getCasesInDec(), Main.analysis.getDeathsInDec());

		System.out.println("\nBY AGE GROUP\n");
		ratioPrint("< 1 year old ", Main.analysis.getUnderOne(), Main.analysis.getUnderOneDeaths());
		ratioPrint("1 - 4 years old ", Main.analysis.getOneToFour(), Main.analysis.getOneToFourDeaths());
		ratioPrint("5 - 9 years old ", Main.analysis.getFiveToNine(), Main.analysis.getFiveToNineDeaths());
		ratioPrint("10 - 19 years old ", Main.analysis.getTenToNineteen(), Main.analysis.getTenToNineteenDeaths());
		ratioPrint("20 - 29 years old ", Main.analysis.getTwentyToTwentynine(), Main.analysis.getTwentyToTwentynineDeaths());
		ratioPrint("30 - 39 years old ", Main.analysis.getThirtyToThirtynine(), Main.analysis.getThirtyToThirtynineDeaths());
		ratioPrint("40 - 49 years old ", Main.analysis.getFourtyToFourtynine(), Main.analysis.getFourtyToFourtynineDeaths());
		ratioPrint("50 - 59 years old ", Main.analysis.getFiftyToFiftynine(), Main.analysis.getFiftyToFiftynineDeaths());
		ratioPrint("60 - 69 years old ", Main.analysis.getSixtyToSixtynine(), Main.analysis.getSixtyToSixtynineDeaths());
		ratioPrint("70 - 79 years old ", Main.analysis.getSeventyToSeventynine(), Main.analysis.getSeventyToSeventynineDeaths());
		ratioPrint("80+ years old ", Main.analysis.getOverEighty(), Main.analysis.getOverEightyDeaths());
		ratioPrint("Unkown age ", Main.analysis.getUnknownAge(), Main.analysis.getUnknownAgeDeaths());

		
		System.out.println("\nBY ZONE\n");
		ratioPrint("North Zone ", Main.analysis.getNorthZone(), Main.analysis.getNorthZoneDeaths());
		ratioPrint("South Zone ", Main.analysis.getSouthZone(), Main.analysis.getSouthZoneDeaths());
		ratioPrint("Central Zone ", Main.analysis.getCentralZone(), Main.analysis.getCentralZoneDeaths());
		ratioPrint("Edmonton Zone ", Main.analysis.getEdmontonZone(), Main.analysis.getEdmontonZoneDeaths());
		ratioPrint("Calgary Zone ", Main.analysis.getCalgaryZone(), Main.analysis.getCalgaryZoneDeaths());
		ratioPrint("Unknown Area ", Main.analysis.getUnknown(), Main.analysis.getUnknownZoneDeaths());
		
		
		System.out.println("\nBY GENDER\n");;
		ratioPrint("Male ", Main.analysis.getMaleCases(),Main.analysis.getMaleMortalities());
		ratioPrint("Female ", Main.analysis.getFemaleCases(), Main.analysis.getFemaleMortalities());
		System.out.println("\nThe average age of death from COVID-19 in Alberta is " + (int)(Main.analysis.ageTally / Main.analysis.getTotalMortalities()) + " years old");
		DecimalFormat df = new DecimalFormat("###.###");
		System.out.println("The mortality rate of COVID-19 in Alberta is " + df.format(((double) Main.analysis.getTotalMortalities() / totalCases) * 100) + "%");
	}
	
	/**
	 * Prints and formats the given data nicely.
	 * @param msg The message that gives context to the value
	 * @param cases number of cases or mortalities given on the context
	 * @param type the type of data we're dealing with. 1 = cases, 2 = mortalities
	 */
	private static void ratioPrint(String msg, int cases, int mortalities) {
		int totalCases = FileLoader.NUMBER_OF_ENTRIES;
		System.out.printf("%-4s%-22s%,-10d%-1s%-1.3f%-9s%,-10d%-1s%-1.3f%-1s%n", "", msg, cases, "(",  ((double) cases / totalCases) * 100, "%)", 
						mortalities, "(", ((double) mortalities / Main.analysis.getTotalMortalities()) * 100, "%)");
	}
	/**
	 * The header for the data report
	 */
	private static void printHeader() {
		System.out.println("Here's a short overview of Alberta's covid data");
		System.out.printf("%n%-26s%-10s%-17s%-10s%1s%n", "", "CASES", "Percent Ratio", "DEATHS", "Percent Ratio"); // header
		for (int i = 0; i < 90; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}
