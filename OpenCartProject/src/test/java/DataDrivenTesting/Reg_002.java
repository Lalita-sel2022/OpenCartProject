package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reg_002 {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.findElement(By.id("")).sendKeys(String.valueOf(201));
		
		//Reading data from excel
		
		FileInputStream file= new FileInputStream("C:\\Users\\adj_2\\OneDrive\\Documents\\Registration.xlsx");
		XSSFWorkbook book= new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("reg");
		
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		
		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow row = sheet.getRow(i);
		
				//XSSFCell First_Name = row.getCell(0);
				//String fnameCell = First_Name.getStringCellValue();
			    
			
			     //int princ = (int)row.getCell(1).getNumericCellValue();
			
			
			
			     String firstName = row.getCell(0).getStringCellValue();
				XSSFCell Last_Name = row.getCell(1);
				String lnameCell = Last_Name.getStringCellValue();
			
				String Email = row.getCell(2).getStringCellValue();
				String Pass = row.getCell(3).getStringCellValue();
				}
			}
		

	}


