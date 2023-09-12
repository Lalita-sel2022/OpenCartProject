package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DataDrivenUsingTestNG {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\adj_2\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	
		FileInputStream file=new FileInputStream("C:\\Users\\adj_2\\OneDrive\\Documents\\login.xlsx");
		XSSFWorkbook book= new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("logindata");
		
		int rowCount = sheet.getLastRowNum();
		
		System.out.println("Row Count is :: "+rowCount);
		
		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			
			String userName = row.getCell(0).getStringCellValue();
			String pass = row.getCell(1).getStringCellValue();
			String status = row.getCell(2).getStringCellValue();
			
			driver.get("https://opensource-demo.orangehrmlive.com/");//password
			WebElement user = driver.findElement(By.xpath("//input[@name='username']"));
			user.sendKeys(userName);
			user.clear();
			WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
			password.sendKeys(pass);
			password.clear();
			driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
			
			String ExpTitle="OrangeHRM";
			String actualTitle = driver.getTitle();
			//System.out.println(actualTitle); //actualTitle.equals(ExpTitle)
			
			if(status.equals("Valid"))
			{
				if(actualTitle.equals(ExpTitle))
				{
					driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
					driver.findElement(By.linkText("Logout")).click();
					System.out.println("Test passed");
				}
				else {
					System.out.println("Test failed");
				}
				
			}
			else if(status.equals("Invalid"))
			{
				if(actualTitle.equals(ExpTitle))
				{
					System.out.println("Test failed");
				}
				else {
					System.out.println("Test passed");
				}
			}

		}
		
		Thread.sleep(2000);
		driver.close();

	}

}
