package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.Base;

public class GoStay extends Base{
	By radioOptions=By.xpath("//input[@name='CountryType']");
	By inputSource=By.xpath("//input[@id='downshift-1-input']");
	By trendingCity=By.xpath("//ul[contains(@class,'TrendingDestinations')]");
	By suggestions=By.xpath("(//ul[contains(@class,'TopDestinationsUIstyles')])[1]");
	By citiesName=By.xpath("(//ul[contains(@class,'TopDestinationsUIstyles')])[2]");
	By buttonCity=By.xpath("//button[contains(@class,'TopDestinationsUIstyles')]");
	By bottomElement=By.xpath("(//div[@class='padT10'])[2]");
	
	public WebElement radioOptions()
	{
		return driver.findElement(radioOptions);
	}
	
	public WebElement source()
	{
		return driver.findElement(inputSource);
	}
	
	public WebElement trendingCity()
	{
		return driver.findElement(trendingCity);
	}
	
	public WebElement suggestions()
	{
		return driver.findElement(suggestions);
	}
	
	public WebElement citiesName()
	{
		return driver.findElement(citiesName);
	}
	
	public WebElement buttonClick()
	{
		return driver.findElement(buttonCity);
	}
	
	public WebElement bottomElement()
	{
		return driver.findElement(bottomElement);
	}

}
