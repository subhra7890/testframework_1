package testCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModel.FlightSearch;
import pageObjectModel.HomePage;
import resources.Base;

public class HomePageTest extends Base{
	@BeforeTest
	public void initialize() {
		driver = initializeDriver();
		driver.get("https://www.goibibo.com/");
	}

	@Test
	public void numberOfLinksInRightSection() {
		HomePage hp=new HomePage();
		List<WebElement> links=hp.rightHeaderSection().findElements(By.tagName("a"));
		//int link_count=links.size();
		int count=0;
		int actual=7;
		for (WebElement webElement : links) {
			if(webElement.getText().isEmpty()==false)
			{
				count++;
				//System.out.println(webElement.getText());
			}
		}
		Assert.assertEquals(actual,count);
	}
	
	@Test
	public void numberOfLinksInLeftSection()
	{
		HomePage hp=new HomePage();
		List<WebElement> links=hp.leftHeaderSection().findElements(By.tagName("a"));
		int count=0;
		int aactual=4;
		for (WebElement webElement : links) {
			if(webElement.getText().isEmpty()==false)
			{
				count++;
			}
		}
		Assert.assertEquals(aactual, count);
	}
	
	@Test
	public void titleOfLinksRightSection()
	{
		HomePage hp=new HomePage();
		List<WebElement> links=hp.rightHeaderSection().findElements(By.tagName("a"));
		try {
			WebDriverWait wait=new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(hp.container()));
			if(hp.container().isDisplayed())
			{
				//System.out.println("element is visible");
			hp.containerClose().click();
			}
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e.getMessage());
		}
		for(int i=1;i<links.size();i++)
		{
			if(links.get(i).getText().isEmpty()==false)
			{
			String click=Keys.chord(Keys.CONTROL,Keys.ENTER);
			links.get(i).sendKeys(click);
//			  links.get(i).click();
//			  System.out.println(driver.getTitle());
//			  driver.navigate().back();
//			  driver.navigate().refresh(); 
//			  rightElement=driver.findElement(By.xpath( "//div[contains(@class,'marginT5')]"));
//			  links=rightElement.findElements(By.tagName("a"));	
			}
		}
		ArrayList<Boolean> actualValues=new ArrayList<>(Arrays.asList(true,true,true,true,true,true,true,true));
		ArrayList<Boolean> values=new ArrayList<>();
		String parentId=driver.getWindowHandle();
		Set<String> string=driver.getWindowHandles();
		Iterator<String> ids=string.iterator();
		while(ids.hasNext())
		{
			driver.switchTo().window(ids.next());
			//System.out.println(ids.next());
			//System.out.println(driver.getTitle());
			String title=driver.getTitle();
			if(!title.equalsIgnoreCase("Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off"))
			{
				driver.close();	
			}
			if(title.contains("Cab")|| title.contains("IRCTC") || title.contains("Gostays") || title.contains("Hotel") || title.contains("Goibibo") ||title.isEmpty())
			{
				values.add(true);
			}
			else
			{
				values.add(false);
			}
		}
		driver.switchTo().window(parentId);
		Assert.assertEquals(actualValues, values);
//		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//		ArrayList<Boolean> values=new ArrayList<>();
//		for(int i=1;i<tabs.size();i++)
//		{
//			driver.switchTo().window(tabs.get(i));
//			System.out.println(driver.getTitle());
//			String title=driver.getTitle();
//			if(title.contains("Cab")|| title.contains("IRCTC") || title.contains("Gostays") || title.contains("Hotel"))
//			{
//				values.add(true);
//			}
//		}
	}
	
	@Test
	public void oneRoundTripWithoutDepDate() throws InterruptedException
	{
		String actualMsg="Please enter a valid departure date";
		HomePage hp=new HomePage();
		hp.source().sendKeys("KOL");
		hp.sourceText();
		hp.destination().sendKeys("DEL");
		hp.destinationText();
		hp.flightSearch();
		String msg=hp.errorMsg().getText();
		Assert.assertTrue(msg.contains(actualMsg));
		
		
	}
	
	@Test
	public void validateOfOneRoundTrip() throws InterruptedException
	{
		HomePage hp=new HomePage();
		hp.source().clear();
		Thread.sleep(5000);
		hp.source().sendKeys("KOL");
		hp.sourceText();
		hp.destination().clear();
		Thread.sleep(5000);
		hp.destination().sendKeys("DEL");
		hp.destinationText();
		hp.departureDate().click();
		hp.departureDateSelection();
		hp.traveller().click();
		Select s=new Select(hp.classSelection());
		String expectedDefault="Economy";
		String actualDefault=s.getFirstSelectedOption().getText();
		Assert.assertEquals(expectedDefault, actualDefault);
		hp.adult().click();
		hp.adultClose().click();
		FlightSearch fp=hp.flightSearch();
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(fp.afterSearch()));
		Assert.assertTrue(fp.afterSearch().isDisplayed());
		Assert.assertEquals(true,fp.sourceCity().getText().contains("Kolkata"));
		Assert.assertEquals(true,fp.destinationCity().getText().contains("Delhi"));
	}
	
	@Test(dependsOnMethods = {"validateOfOneRoundTrip"})
	public void departureTime_Stops()
	{
		int actual=4;
		FlightSearch fp=new FlightSearch();
		List<WebElement> elements=fp.departureTime().findElements(By.tagName("label"));
		Assert.assertEquals(actual, elements.size());
		ArrayList<String> actualList=new ArrayList<>(Arrays.asList("4am - 11am","11am - 4pm","4pm - 9pm","9pm - 4am"));
		ArrayList<String> expectedList=new ArrayList<>();
		for (WebElement element : elements) {
//			System.out.println(element.getAttribute("value"));
//			System.out.println(element.getText());
			expectedList.add(element.getText());
		}
		for (String string : expectedList) {
			System.out.println(string);
		}
		Assert.assertEquals(actualList, expectedList);
		List<WebElement> stopsNumber=fp.stops().findElements(By.tagName("label"));
		ArrayList<String> actualStops=new ArrayList<>(Arrays.asList("0 Stop","1 Stops","2 Stops","3 Stops"));
		ArrayList<String> expectedStops=new ArrayList<>();
		Assert.assertEquals(actual,stopsNumber.size());
		for (WebElement webElement : stopsNumber) {
			expectedStops.add(webElement.getText());
		}
		Assert.assertEquals(actualStops, expectedStops);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
