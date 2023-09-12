package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	public static  XSSFRow row =null;
	public static XSSFCell cell=null;

	public static void main(String[] args) throws IOException 
	{
	
		FileInputStream file= new FileInputStream("C:\\Users\\adj_2\\OneDrive\\Documents\\login.xlsx");
		XSSFWorkbook book= new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("logindata"); //Providing sheets name 
		//XSSFSheet sheet = book.getSheetAt(0); // Providing sheets index
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(0);
		String value = cell.getStringCellValue();
		System.out.println("Cell value is...."+value);
		book.close();
		file.close();
		
//		int rowCount = sheet.getLastRowNum();// Returns the rows count
//		short cellCount = sheet.getRow(0).getLastCellNum();// Returns the cell count
//		//System.out.println("RowCount is :: "+rowCount +"                                    "+"Cell count is :: "+cellCount);
//		
//		for(int i=0;i<=rowCount;i++)
//		{
//			for(int j=1;j<=cellCount;j++)
//			{
//				
//			}
//		}

	}

}
