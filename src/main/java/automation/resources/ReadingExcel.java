package automation.resources;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//File--->workbook--->sheet--->row---->cells

public class ReadingExcel {
	
	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("sheet1"); // with index workbook.getSheetAt(0)
		
		int totalrows = sheet.getLastRowNum();
		int totalcells = sheet.getRow(1).getLastCellNum();
		
		System.out.println("No. of row: "+ totalrows); //6
		System.out.println("No. of cells: "+ totalcells);//3
		
		//to get the data of excel sheet 
		for(int r=0;r<=totalrows;r++) {
			XSSFRow currentRow = sheet.getRow(r);
			for(int c=0;c<totalcells;c++) {
//				XSSFCell cell = currentRow.getCell(c);
//				String value = cell.toString();
				String value = currentRow.getCell(c).toString();
				System.out.println(value);
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}
}
