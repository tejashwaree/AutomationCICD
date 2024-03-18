package automation.resources;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//File--->workbook--->shett--->row---->cells


public class WritingExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
//		XSSFCell cell = sheet.createRow(0).createCell(1); //create single row and single cell for the row
//		cell.setCellValue("welcome");
		
		//creating rows , cells and updating data without loop
		/*XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Welcome"); // single stetment to add data
		row1.createCell(1).setCellValue("1234");
		row1.createCell(2).setCellValue("test");
		
		XSSFRow row2 = sheet.createRow(1);
		
		row2.createCell(0).setCellValue("Auto");
		row2.createCell(1).setCellValue("32646");
		row2.createCell(2).setCellValue("api");
		*/
		
		//creating rows, cells and update data with loop
		Scanner sc = new Scanner(System.in);
		
		for(int r = 0; r<3; r++)
		{
			XSSFRow currentrow = sheet.createRow(r);
			for(int c=0;c<2;c++) 
			{
				System.out.println("Enter value : ");
				String value = sc.next();
				currentrow.createCell(c).setCellValue(value);
			}
		}
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("Writing is done");
	}

}
