package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class DemoTest extends Base{
	//public WebDriver driver;
	
	@BeforeTest
	public void initialize()
	{
		driver=initializeDriver();
	}
	@Test
	public void launch()
	{
		driver.get("https://www.goibibo.com/");
		System.out.println(driver.getTitle());
	}
 
}
