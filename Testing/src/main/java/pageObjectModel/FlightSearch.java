package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.Base;

public class FlightSearch extends Base{
	
	By afterSearch=By.xpath("//div[@class='fl width100 flexCol']");
	By sourceCity=By.xpath("(//span[@class='db textOverflow'])[1]/child::span[2]");
	By destinationCity=By.xpath("(//span[@class='db textOverflow'])[2]/child::span[2]");
	By departureTime=By.xpath("(//div[contains(@class,'flexWrap')])[1]");
	By stops=By.xpath("(//div[contains(@class,'flexWrap')])[2]");
	
	
	public WebElement afterSearch()
	{
		return driver.findElement(afterSearch);
	}
	
	public WebElement sourceCity()
	{
		return driver.findElement(sourceCity);
	}
	
	public WebElement destinationCity()
	{
		return driver.findElement(destinationCity);
	}
	
	public WebElement departureTime()
	{
		return driver.findElement(departureTime);
	}
	
	public WebElement stops()
	{
		return driver.findElement(stops);
	}

}
