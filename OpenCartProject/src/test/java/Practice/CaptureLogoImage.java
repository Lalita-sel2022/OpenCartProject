package Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class CaptureLogoImage {

	public static void main(String[] args) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\adj_2\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		//driver.get("https://www.servicenow.com/my-account/sign-up.html");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement logoImageEle = driver.findElement(By.xpath("//img[@src='/web/images/ohrm_branding.png?v=1689053487449']"));
		
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver,logoImageEle);
		
		System.out.println("Image :: "+logoImageScreenshot.getImage());
		ImageIO.write(logoImageScreenshot.getImage(), "png", new File("C:\\Users\\adj_2\\OneDrive\\Pictures\\Saved Pictures\\orange.png"));
		
		File f= new File("C:\\Users\\adj_2\\OneDrive\\Pictures\\Saved Pictures\\orange.png");
		
		if(f.exists())
		{
			System.out.println("Image file catured");
		}
		else
		{
			System.out.println("Image file not catured");
		}
		
		

	}

}
