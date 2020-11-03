package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.Base;

public class FlightSearch extends Base{
	
	By afterSearch=By.xpath("//div[@class='fl width100 flexCol']");
	By sourceCity=By.xpath("(//span[@class='db textOverflow'])[1]/child::span[2]");
	By destinationCity=By.xpath("(//span[@class='db textOverflow'])[2]/child::span[2]");
	
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

}
