package resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
public static WebDriver driver;
	
	public WebDriver initializeDriver()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	

}
