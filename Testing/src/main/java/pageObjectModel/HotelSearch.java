package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.Base;

public class HotelSearch extends Base{
	//private WebDriver driver;
	By searchResult=By.xpath("//div[contains(@class,'HotelCardstyles__OuterWrapper')]");
	By outerResult=By.xpath("//div[contains(@class,'SRPstyles__BodyWrapperContentStyle')]");
	By hotelResults=By.xpath("//div[contains(@class,'HotelCardstyles__WrapperSectionMetaDiv')]");
	By price=By.xpath("(//div[contains(@class,'CheckBoxList__CheckboxListWrapperDiv')])[1] //div[contains(@class,'CheckBoxList__TextCenteredDiv')]/span");
	By customerRating=By.xpath("(//div[contains(@class,'CheckBoxList__CheckboxListWrapperDiv')])[2] //div[contains(@class,'CheckBoxList__TextCenteredDiv')]/span");
	By ratings=By.xpath("(//div[contains(@class,'CheckBoxList__CheckboxListWrapperDiv')])[3] //div[contains(@class,'CheckBoxList__TextCenteredDiv')]/span");
	By hotelShow=By.xpath("(//div[contains(@class,'CheckBoxList__ShowAllText')])[2]");
	By hotelType=By.xpath("(//div[contains(@class,'CheckBoxList__CheckboxListWrapperDiv')])[4] //div[contains(@class,'CheckBoxList__TextCenteredDiv')]/span");
	By amenitiesShow=By.xpath("(//div[contains(@class,'CheckBoxList__ShowAllText')])[3]");
	By amenitiesList=By.xpath("(//div[contains(@class,'CheckBoxList__CheckboxListWrapperDiv')])[5] //div[contains(@class,'CheckBoxList__TextCenteredDiv')]/span");
	By filters=By.xpath("//div[contains(@class,'Filtersstyles__AppliedFilters')]");
	By reset=By.xpath("//span[text()='CLEAR']");
		
//	public HotelSearch(WebDriver driver) {
//		this.driver = driver;
//	}


	public List<WebElement> searchResult()
	{
		List<WebElement> element=driver.findElements(searchResult);
		return element;
	}
	
	public WebElement visibilty()
	{
		return driver.findElement(outerResult);
	}
	
	public List<WebElement> hotelResults()
	{
		List<WebElement> element=driver.findElements(hotelResults);
		return element;
	}
	
	public List<WebElement> price()
	{
		List<WebElement> element=driver.findElements(price);
		return element;
	}
	
	public List<WebElement> customerRating()
	{
		List<WebElement> element=driver.findElements(customerRating);
		return element;
	}
	
	public List<WebElement> rating()
	{
		List<WebElement> element=driver.findElements(ratings);
		return element;
	}
	
	public WebElement hotelShow()
	{
		return driver.findElement(hotelShow);
	}
	
	public List<WebElement> hotelType()
	{
		List<WebElement> element=driver.findElements(hotelType);
		return element;
	}
	
	public WebElement amenitiesShow()
	{
		return driver.findElement(amenitiesShow);
	}
	
	public List<WebElement> amenitiesList()
	{
		List<WebElement> element=driver.findElements(amenitiesList);
		return element;
	}
	
	public WebElement filter()
	{
		return driver.findElement(filters);
	}
	
	public WebElement clearFilter()
	{
		return driver.findElement(reset);
	}
	
	


}
