package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTable {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\adj_2\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		//driver.get("https://www.servicenow.com/my-account/sign-up.html");
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement ele = driver.findElement(By.xpath("//table[@name='BookTable']"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		
		List<WebElement> row = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr"));
		int rowCount =row.size();
		System.out.println("Total row is :: "+rowCount);
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr[1]/th"));
		int colCount = cols.size();
		System.out.println("Total cols is :: "+colCount);
		String val = null;
//		for(int i=0;i<row.size();i++)
//		{
//			for(int j=0;j<=i;j++)
//			{
//				
//				//val = row.get(i).getText();
//				driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[i]/th[j]")).getText();
//			}
//			//System.out.println();
//			//System.out.println(val);
//		}

		for(int i=2;i<=rowCount;i++)
		{
			for(int j=1;j<=colCount;j++)
			{
				val=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(val);
			}
			
			System.out.println();
		}
		
	}

}
