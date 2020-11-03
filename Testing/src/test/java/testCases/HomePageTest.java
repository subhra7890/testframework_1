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
		hp.flightSearch();
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(hp.flightSearch().afterSearch()));
		Assert.assertTrue(hp.flightSearch().afterSearch().isDisplayed());
		Assert.assertEquals(true,hp.flightSearch().sourceCity().getText().contains("Kolkata"));
		Assert.assertEquals(true,hp.flightSearch().destinationCity().getText().contains("Delhi"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
