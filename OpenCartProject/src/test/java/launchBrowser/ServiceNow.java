package launchBrowser;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\adj_2\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		//driver.get("https://www.servicenow.com/my-account/sign-up.html");
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));

		JavascriptExecutor js= (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		
		Actions ac= new Actions(driver);
		ac.clickAndHold(ele).moveByOffset(150, 200).perform();
		
		
		
		//https://testautomationpractice.blogspot.com/
		
//		driver.findElement(By.id("businessPhone")).sendKeys("6475677576");
//		driver.findElement(By.id("businessPhone")).sendKeys("6475677576");
//		driver.findElement(By.id("businessPhone")).sendKeys("6475677576");

	}

}
