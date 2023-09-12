package amazonDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class closeAndQuit {

	public static void main(String[] args) 
	{
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.get("http://www.popuptest.com/popuptest2.html");
	  driver.navigate().to("https://www.amazon.in");
	  //driver.close();

	}

}
