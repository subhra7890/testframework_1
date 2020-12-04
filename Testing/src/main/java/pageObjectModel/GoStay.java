package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import resources.Base;

public class GoStay extends Base{
	//private WebDriver driver;
	By radioOptions=By.xpath("//input[@name='CountryType']");
	By inputSource=By.xpath("//input[contains(@id,'downshift')]");
	By trendingCity=By.xpath("//ul[contains(@class,'TrendingDestinations')]");
	By suggestions=By.xpath("(//ul[contains(@class,'TopDestinationsUIstyles')])[1]");
	By citiesName=By.xpath("(//ul[contains(@class,'TopDestinationsUIstyles')])[2]");
	By buttonCity=By.xpath("//button[contains(@class,'TopDestinationsUIstyles')]");
	By bottomElement=By.xpath("(//div[@class='padT10'])[2]");
	By chekIn=By.xpath("//div[@data-testid='openCheckinCalendar']");
	By month=By.xpath("//p[contains(@class,'MonthNamePara')]");
	By sliderArrow=By.xpath("(//div[contains(@class,'SliderArrow')])[2]");
	By checkInDates=By.xpath("//ul[contains(@class,'dcalendarstyles__DateWrapDiv')]");
	By checkOut=By.xpath("//div[@data-testid='openCheckoutCalendar']");
	By guest=By.xpath("(//input[contains(@class,'SearchBlockUIstyles')])[3]");
	By rooms=By.xpath("(//span[contains(@class,'PaxWidgetstyles')])[4]");
	By roomsValue=By.xpath("(//h4[contains(@class,'dwebCommonstyles__SmallSectionHeader')])[5]");
	By adultDecrement=By.xpath("(//span[contains(@class,'PaxWidgetstyles')])[7]");
	By adultValue=By.xpath("(//h4[contains(@class,'dwebCommonstyles__SmallSectionHeader')])[6]");
	By romDecrement=By.xpath("(//span[contains(@class,'PaxWidgetstyles')])[3]");
	By done=By.xpath("//button[text()='Done']");
	By hotelSearch=By.xpath("//button[text()='Search Hotels']");
	By searchWindow=By.xpath("//div[contains(@class,'SearchBlockUIstyles__AutoSuggestInnerWrap')]");
	
	
//	public GoStay(WebDriver driver) {
//		this.driver = driver;
//	}

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
	
	public WebElement checkIn()
	{
		return driver.findElement(chekIn);
	}
	
	public WebElement month()
	{
		return driver.findElement(month);
	}
	
	public WebElement arrowClick()
	{
		return driver.findElement(sliderArrow);
	}
	
	public WebElement checkInDates()
	{
		return driver.findElement(checkInDates);
	}
	
	public WebElement checkOut()
	{
		return driver.findElement(checkOut);
	}
	
	public WebElement guestCount()
	{
		return driver.findElement(guest);
	}
	
	public WebElement roomsClick()
	{
		return driver.findElement(rooms);
	}
	
	public WebElement roomText()
	{
		return driver.findElement(roomsValue);
	}
	
	public WebElement adultDecrementClick()
	{
		return driver.findElement(adultDecrement);
	}
	
	public WebElement adultText()
	{
		return driver.findElement(adultValue);
	}
	
	public WebElement roomDecrement()
	{
		return driver.findElement(romDecrement);
	}
	
	public WebElement done()
	{
		return driver.findElement(done);
	}
	
	public HotelSearch hotelSearchClick()
	{
		try {
			driver.findElement(hotelSearch).click();
			return new HotelSearch();
		} 
		catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			WebElement ele=driver.findElement(hotelSearch);
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", ele);
			return new HotelSearch();
		}
	}
	
	public WebElement hotelPage()
	{
		return driver.findElement(searchWindow);
	}

}
