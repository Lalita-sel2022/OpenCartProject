package DataDrivenTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebAndHtmlTable {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\adj_2\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

	
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement user = driver.findElement(By.xpath("//input[@name='username']"));
		user.sendKeys("Admin");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("admin123");
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")).click();
		
		int rowCount=driver.findElements(By.xpath("//div[@class='oxd-table']/div[2]/div")).size();
		System.out.println(rowCount);
		
		int enableCount = 0;
		for(int i=1;i<=rowCount;i++)
		{
			String status = driver.findElement(By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'])[5]")).getText();
			if(status.equalsIgnoreCase("Enabled"))
			{
				enableCount=enableCount+1;
			}
		}
		
		System.out.println("Total cunt of Enabled is ::"+enableCount);
		//driver.close();
			


	}

}
