package automation.resources;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.opencsv.CSVWriter;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField.Write;

public class WriteintoCSV  {
	
	public static void main(String[] args) throws IOException{
	//initiating CSVWriter class
	CSVWriter writer = new CSVWriter(new FileWriter("Files\\result.csv"));
	
	//write data into file
	String set1[] = {"Name","Class","Marks"};
	String set2[] = {"Aman","10th","98"};
	String set3[] = {"Maahi","12th","67"};
	String set4[] = {"Avi","12th","87"};
	
//	writer.writeNext(set1);
//	writer.writeNext(set2);
//	writer.writeNext(set3);
//	writer.writeNext(set4);
	
	//create list as arraylist
	List list = new ArrayList();
	
	list.add(set1);
	list.add(set2);
	list.add(set3);
	list.add(set4);
	
	
	
	
	writer.writeAll(list);
	//flush date into created csv file
	writer.flush();
	
	System.out.println("data added");
	}
}