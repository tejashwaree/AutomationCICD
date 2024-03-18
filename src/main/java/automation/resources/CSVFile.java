package automation.resources;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVWriter;

public class CSVFile {

	private static final String CSV_FILE_PATH = "D:/result1.csv";

	public static void main(String[] args) {
		addDataToCSV(CSV_FILE_PATH);
	}

	public static void addDataToCSV(String output) {
		// first create file object for file placed at location
		// specified by filepath
		File file = new File(output);
		Scanner sc = new Scanner(System.in);
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter with ';' as separator
			CSVWriter writer = new CSVWriter(outputfile, ';', CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

			// create a List which contains Data
			List<String[]> data = new ArrayList<String[]>();

			System.out.println("Enter no of rows");
			int noOfRow = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Data");
			for (int i = 0; i < noOfRow; i++) {
				String row = sc.nextLine();
				String[] rowdata = row.split(" ");
				data.add(rowdata);
			}

			writer.writeAll(data);

			// closing writer connection
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
