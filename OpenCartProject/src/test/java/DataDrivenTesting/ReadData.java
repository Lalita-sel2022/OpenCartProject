package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream file= new FileInputStream("C:\\Users\\adj_2\\OneDrive\\Documents\\Registration.xlsx");
		XSSFWorkbook book= new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("reg");
		
		
	     int rowCount = sheet.getLastRowNum();
	     int cellCount = sheet.getRow(0).getLastCellNum();
	     
	     for(int i=0;i<rowCount;i++)
	     {
	    	 XSSFRow row = sheet.getRow(i);
	    	 for(int j=0;j<cellCount;j++)
	    	 {
	    		 String val = row.getCell(j).toString();
	    		 System.out.print("  "+ val);
	    	 }
	    	 System.out.println();
	     }
		

	}

}
