package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel2 {

	public static void main(String[] args) throws IOException 
	{
		
		FileInputStream file= new FileInputStream("C:\\Users\\adj_2\\OneDrive\\Documents\\login.xlsx");
		XSSFWorkbook book= new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("logindata");
		
		int rowCount = sheet.getLastRowNum();// Returns the rows count
		short cellCount = sheet.getRow(0).getLastCellNum();// Returns the cell count
		//System.out.println("RowCount is :: "+rowCount +"       "+"Cell count is :: "+cellCount);
		
		for(int i=0;i<rowCount;i++)
		{
			XSSFRow currentRow = sheet.getRow(i);
			for(int j=0; j<cellCount;j++) {
				
			    //XSSFCell cellvalue = currentRow.getCell(j);
			    //String value = cellvalue.getStringCellValue();
				
				String value = currentRow.getCell(j).toString();
				System.out.print("  "+value);
			}
			System.out.println();
		}
		
	}

}
