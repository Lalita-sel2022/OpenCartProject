package launchBrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
//		options.addArguments("--window-size=1200, 719");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.navigate().to("https://demo.opencart.com/");
		driver.get("https://demo.opencart.com/");
		driver.findElement(By.xpath("(//span[@class='d-none d-md-inline'])[3]")).click();
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("input-firstname")).sendKeys("Ramesh");
		driver.findElement(By.id("input-lastname")).sendKeys("Sharma");
		driver.findElement(By.id("input-lastname")).sendKeys("Sharma");
		driver.findElement(By.id("input-email")).sendKeys("Ramesh121Sharma@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Ramesh@121");
		//driver.findElement(By.id("input-newsletter-yes")).click();
//		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.elementToBeClickable(By.name("agree")));
		WebElement ele = driver.findElement(By.name("agree"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
		Thread.sleep(2000);
		//driver.findElement(By.linkText("Continue")).click();
		//driver.close();

	}

}
