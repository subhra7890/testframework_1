package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class HomePage extends Base{
	//public WebDriver driver;

	/*
	 * public HomePage(WebDriver driver) { this.driver = driver; }
	 */
	
	By rightHeader=By.xpath("//div[contains(@class,'marginT5')]");
	By leftHeader=By.xpath("//div[contains(@class,'txtRight')]");
	
	public WebElement rightHeaderSection()
	{
		return driver.findElement(rightHeader);
		
	}
	
	public WebElement leftHeaderSection()
	{
		return driver.findElement(leftHeader);
	}
	
	

}
