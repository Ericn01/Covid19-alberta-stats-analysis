package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class FileLoader {
	private final static String FILE_PATH = "src/data.csv";
	public final static int NUMBER_OF_ENTRIES = 558483; // will be changed to retrieve number of entries directly from the file.
	private CovidData[] dataContainer = new CovidData[NUMBER_OF_ENTRIES];
	
	public FileLoader() {
		loadFile();
	}
	/**
	 * Loads the CSV file into Java and the information is parsed into an array
	 */
	public void loadFile() {
		try {
			BufferedReader input = new BufferedReader(new FileReader(FILE_PATH));
			String delimiter = "[,]+";
			String currentLine;
			int counter = 0;
			double timerStart = System.nanoTime();
			while ((currentLine = input.readLine()) != null) {
				if (counter != 0) { // skips the first line of the CSV file 
					
					String[] d = currentLine.split(delimiter); // array containing all the string values in an entry in the CSV file
					CovidData dataObject = new CovidData(convertID(d[0]), LocalDate.parse(d[1]), removeQuotations(d[2]), removeQuotations(d[3]),
						                                 removeQuotations(d[4]), removeQuotations(d[5]), removeQuotations(d[6]));
					dataContainer[counter - 1] = dataObject;
				}
				counter++;
			}
			double timerEnd = System.nanoTime();
			printLoadInfo(timerStart, timerEnd); // print the file load data. Runs in an average of 4 seconds on my computer.
		
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("The specified file could not be found - please check the file path.");
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("An IO Exception has occured.");
		}
	}
	
//	public static int getFileEntries() {
//		File f = new File(FILE_PATH);
//		Scanner readFile;
//		int entryCounter = 0;
//		try {
//			readFile = new Scanner(f);
//			while(readFile.hasNextLine()) {
//				entryCounter++;
//				readFile.close();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return entryCounter;
//	}
	
	public CovidData[] getDataContainer() {
		return dataContainer;
	}
	
	private int convertID(String ID) {
		return Integer.parseInt((ID.replaceAll("\"", "")));
	}
	
	private String removeQuotations(String input) {
		return input.replaceAll("\"", "");
	}
	
	private void printLoadInfo(double start, double end) {
		double loadTime = (end - start) / 1_000_000_000;
		System.out.println("File was loaded in " + loadTime + " seconds" + " (" + loadTimePerformance(loadTime) + ")");
		System.out.println("Loaded " + NUMBER_OF_ENTRIES + " entries at a speed of " + (int)(NUMBER_OF_ENTRIES / loadTime) + " entries/second");
	}
	
	private String loadTimePerformance(double loadTime) {
		String performance = "";
		if (loadTime < 2.25) {
			performance = "Very fast";
		}
		else if (loadTime >= 2.25  && loadTime < 4.0) {
			performance = "Fast";
		}
		else if (loadTime >= 4.0 && loadTime < 6.0) {
			performance = "Medium";
		}
		else if (loadTime >= 6.0 && loadTime < 10.0) {
			performance = "Slow";
		}
		else {
			performance = "Very slow - you may want to close some apps";
		}
		return performance;
	}

}
