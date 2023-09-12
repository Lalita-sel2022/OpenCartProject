package DataDrivenTesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import xLUtiles.ExcelUtiles;

public class Register001 
{
	@Test(dataProvider="loginData")
	public void login(String userName, String pass, String exp)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("amazon.in");
		
		driver.findElement(By.id("")).sendKeys(userName);
		driver.findElement(By.id("")).sendKeys("pass");
		driver.findElement(By.id("")).click();
		
		
		
		if(exp.equals("valid"))
		{
			System.out.println("Valid Test Case");
		}else {
			System.out.println("Invalid Test Case");
		}
	}
	
	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException
	{
		String path="dbfsvn";
		ExcelUtiles util=new ExcelUtiles(path);
		int rows=util.getRowCount("login");
		int cells = util.getCellCount("login", 1);
		
		String loginData[][]= new String[rows][cells];
		
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<=cells;j++)
			{
				 loginData[i-1][j]=util.getData("login", i, j);
			}
		}
		return loginData;
		
		
		
	}

}
