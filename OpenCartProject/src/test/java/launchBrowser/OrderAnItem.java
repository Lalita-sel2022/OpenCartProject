package launchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderAnItem {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/");
		WebElement ele = driver.findElement(By.linkText("Tablets"));
		ele.click();
		WebElement element = driver.findElement(By.xpath("//div[@class='button-group']/button[1]"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		//jse.executeScript("arguments[0].click()", ele);
		//Thread.sleep(2000);
		//driver.close();
	

	}

}
