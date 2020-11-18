package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.Base;

public class FlightSearch extends Base{
	
	By afterSearch=By.xpath("//div[@class='fl width100 flexCol']");
	By sourceCity=By.xpath("(//span[@class='db textOverflow'])[1]/child::span[2]");
	By destinationCity=By.xpath("(//span[@class='db textOverflow'])[2]/child::span[2]");
	By departureTime=By.xpath("(//div[contains(@class,'flexWrap')])[1]");
	By stops=By.xpath("(//div[contains(@class,'flexWrap')])[2]");
	By onwardPrice=By.xpath("(//div[@id='sliderFO'])[1]");
	By onwardDuration=By.xpath("(//div[@id='sliderFO'])[2]");
	By airLines=By.xpath("//div[@id='Air India']/parent::div");
	By filterResult=By.xpath("//div[@class='fl width100 dF padLR20 padT10']");
	By flightDetailsBar=By.xpath("//div[@class='quicks paleGreyBg blueGrey alignItemsCenter justifyBetween dF fb txtTransUpper fltHpyDtlMenu ico13']");
	By flightInformation=By.xpath("//div[@class='fltHpyDtlsCont justifyBetween dF padT20']");
	By fareDetailsWindow=By.xpath("//div[contains(@class,'fltDetailsBody fl width')]");
	By baggageWindow=By.xpath("//div[@id='fltBaggage']");
	By cancelWindow=By.xpath("//div[@id='fltFareRules']");
	By companyName=By.xpath("//div[text()='Cancellation Charges']/following::div[1]/span");
	By cancellationFee=By.xpath("//span[text()='Goibibo Fee']/following::span[1]");
	By reset=By.xpath("//span[text()='Reset All']");
	By priceClick=By.xpath("//li[@id='PRICE']");
	private String airLineName="(//div[@class='dF width100 alignItemsCenter'])";
	private String station="(//span[@class='db textOverflow'])";
	private String price="(//span[@data-cy='finalPrice'])";
	private String flightDetails="(//a[@class='dF alignItemsCenter curPointFlt fr'])";
	private String fareDetails="(//span[text()='Fare Details'])";
	private String baggage="(//span[text()='Baggage Rules'])";
	private String cancellation="(//span[text()='Cancellation Rules'])";
	
	
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
	
	public WebElement onwardPrice()
	{
		return driver.findElement(onwardPrice);
	}
	
	public WebElement onwardDuration()
	{
		return driver.findElement(onwardDuration);
	}
	
	public WebElement airLines()
	{
		return driver.findElement(airLines);
	}
	
	public List<WebElement> filterResult()
	{
		List<WebElement> elements=driver.findElements(filterResult);
		return elements;
		
	}
	
	public WebElement airLineName(int num)
	{ 
		//int i=num;
		String element=airLineName+"["+num+"]"+"/span";
		return driver.findElement(By.xpath(element));
		
	}
	
	public WebElement Station(int num)
	{
		String element=station+"["+num+"]"+"/child::span[2]";
		return driver.findElement(By.xpath(element));
	}
	
//	public WebElement destinationStation()
//	{
//		return driver.findElement(destinationStation);
//	}
	
	public WebElement resultDepartureTime(int num)
	{
		String element=station+"["+num+"]"+"/following::span[1]";
		return driver.findElement(By.xpath(element));
	}
	
	public WebElement price(int num)
	{
		String element=price+"["+num+"]";
		return driver.findElement(By.xpath(element));
	}
	
	public WebElement flightDetails(int num)
	{
		String element=flightDetails+"["+num+"]";
		return driver.findElement(By.xpath(element));
	}
	
	public WebElement flightDetailsBar()
	{
		return driver.findElement(flightDetailsBar);
	}
	
	public WebElement flightInformation()
	{
		return driver.findElement(flightInformation);
	}
	
	public WebElement fareDetails(int num)
	{
		String element=fareDetails+"["+num+"]";
		return driver.findElement(By.xpath(element));
	}
	
	public WebElement fareDetailsWindow()
	{
		return driver.findElement(fareDetailsWindow);
	}
	
	public WebElement baggage(int num)
	{
		String element=baggage+"["+num+"]";
		return driver.findElement(By.xpath(element));
	}
	
	public WebElement baggageWindow()
	{
		return driver.findElement(baggageWindow);
	}
	
	public WebElement cancellation(int num)
	{
		String element=cancellation+"["+num+"]";
		return driver.findElement(By.xpath(element));
	}
	
	public WebElement cancelWindow()
	{
		return driver.findElement(cancelWindow);
	}
	
	public WebElement companyName()
	{
		return driver.findElement(companyName);
	}
	
	public WebElement cancellationFee()
	{
		return driver.findElement(cancellationFee);
	}
	
	public WebElement reset()
	{
		return driver.findElement(reset);
	}
	
	public WebElement flightOptions(String flight)
	{
		String element="//div[@id='"+flight+"']";
		return driver.findElement(By.xpath(element));
	}
	
	public WebElement priceClick()
	{
		return driver.findElement(priceClick);
	}

}
