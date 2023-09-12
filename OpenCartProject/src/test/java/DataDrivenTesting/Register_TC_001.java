package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register_TC_001 {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		
		//Reading data from excel
		
		FileInputStream file= new FileInputStream("C:\\Users\\adj_2\\OneDrive\\Documents\\Registration.xlsx");
		XSSFWorkbook book= new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("reg");
		
		int rowCount = sheet.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow current_row = sheet.getRow(i);
			
			String First_Name = current_row.getCell(0).getStringCellValue();
			String Last_Name = current_row.getCell(1).getStringCellValue();
			String Email = current_row.getCell(2).getStringCellValue();
			String Pass = current_row.getCell(3).getStringCellValue();
			
			driver.findElement(By.xpath("(//span[@class='d-none d-md-inline'])[3]")).click();
			driver.findElement(By.linkText("Register")).click();
			
			driver.findElement(By.id("input-firstname")).sendKeys(First_Name);
			driver.findElement(By.id("input-lastname")).sendKeys(Last_Name);
			driver.findElement(By.id("input-email")).sendKeys(Email);
			driver.findElement(By.id("input-password")).sendKeys(Pass);
			
			WebElement ele = driver.findElement(By.name("agree"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", ele);
			
		}
		driver.quit();
		

	}

}
