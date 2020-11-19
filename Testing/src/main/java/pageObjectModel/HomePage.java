package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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
	By container=By.xpath("//div[contains(@id,'notification-container')]");
	By containerClose=By.xpath("//a[contains(@id,'notification-close')]");
	By source=By.id("gosuggest_inputSrc");
	By destination=By.id("gosuggest_inputDest");
	By search=By.id("gi_search_btn");
	By oneTripErrorMsg=By.xpath("(//span[contains(@class,'failure')])[2]");
	By departureDate=By.xpath("//i[contains(@class,'calendar')]");
	By departureMonth=By.xpath("//div[@class='DayPicker-Caption']");
	By departureNext=By.xpath("//span[@role='button']");
	By departureCalendarDays=By.xpath("//div[@class='DayPicker-Day']");
	By traveller=By.xpath("//i[contains(@class,'adult')]");
	By classSelection=By.id("gi_class");
	By adult=By.id("adultPaxPlus");
	By adultClose=By.id("adultPaxBox");
	
	public WebElement rightHeaderSection()
	{
		return driver.findElement(rightHeader);
		
	}
	
	public WebElement leftHeaderSection()
	{
		return driver.findElement(leftHeader);
	}
	
	public WebElement container()
	{
		return driver.findElement(container);
	}
	
	public WebElement containerClose()
	{
		return driver.findElement(containerClose);
	}
	
	public WebElement source()
	{
		return driver.findElement(source);
	}
	
	public WebElement destination()
	{
		return driver.findElement(destination);
	}
	
	public FlightSearch flightSearch()
	{
		driver.findElement(search).click();
		try {
			FlightSearch fp=new FlightSearch();
			return fp;
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			FlightSearch fp1=new FlightSearch();
			return fp1;
		}
		
	}
	
	public WebElement errorMsg()
	{
		return driver.findElement(oneTripErrorMsg);
	}
	
	public WebElement departureDate()
	{
		return driver.findElement(departureDate);
	}
	
	public WebElement departureMonth()
	{
		return driver.findElement(departureMonth);
	}
	
	public WebElement departureNext()
	{
		return driver.findElement(departureNext);
	}
	
	public WebElement departureCalendarDays()
	{
		return driver.findElement(departureCalendarDays);
	}
	
	public WebElement traveller()
	{
		return driver.findElement(traveller);
	}
	
	public WebElement adult()
	{
		return driver.findElement(adult);
	}
	
	public WebElement adultClose()
	{
		return driver.findElement(adultClose);
	}
	
	public WebElement classSelection()
	{
		return driver.findElement(classSelection);
	}
	
	public void sourceText() throws InterruptedException
	{
		Thread.sleep(8000);
		source().sendKeys(Keys.DOWN);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String script="return document.getElementById(\"gosuggest_inputSrc\").value;";
		String text=(String)js.executeScript(script);
		//System.out.println(text);
		while (!text.contains("Kolkata")) {
			source().sendKeys(Keys.DOWN);
			Thread.sleep(5000);
			text=(String)js.executeScript(script);
		}
		source().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}
	
	public void destinationText() throws InterruptedException
	{
		Thread.sleep(8000);
		destination().sendKeys(Keys.DOWN);
		JavascriptExecutor js_destination=(JavascriptExecutor)driver;
		String script_des="return document.getElementById(\"gosuggest_inputDest\").value;";
		String text_des=(String)js_destination.executeScript(script_des);
		//System.out.println(text_des);
		while (!text_des.contains("Delhi")) {
			destination().sendKeys(Keys.DOWN);
			Thread.sleep(5000);
			text_des=(String)js_destination.executeScript(script_des);
		}
		destination().sendKeys(Keys.ENTER);
		Thread.sleep(5000);		
		
	}
	
	public void departureDateSelection() throws InterruptedException
	{
		departureDate().click();
		String text=departureMonth().getText();
		while (!text.contains("November")) {
			departureNext().click();
			text=departureMonth().getText();		
		}
		List<WebElement> daysList=driver.findElements(departureCalendarDays);
		for(int i=0;i<daysList.size();i++)
		{
			String[] value=daysList.get(i).getAttribute("aria-label").split(" ");
			if(value[2].equalsIgnoreCase("22"))
			{
				daysList.get(i).click();
				break;
			}
		}
		
	}
	
	

}
