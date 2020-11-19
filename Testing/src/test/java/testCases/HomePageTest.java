package testCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import org.testng.asserts.SoftAssert;

import pageObjectModel.BookingDetail;
import pageObjectModel.FlightSearch;
import pageObjectModel.HomePage;
import resources.Base;
import resources.Reuse;

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
		Reuse re=new Reuse();
		re.exceptionHandling();
		for(int i=1;i<links.size();i++)
		{
			if(links.get(i).getText().isEmpty()==false)
			{
			String click=Keys.chord(Keys.CONTROL,Keys.ENTER);
			links.get(i).sendKeys(click);
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
	
	@Test(dependsOnMethods = {"oneRoundTripWithoutDepDate"})
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
		Reuse re=new Reuse();
		//Select s=new Select(hp.classSelection());
		Select s=re.select(hp.classSelection());
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
	public void departureTime_Stops_Airlines()
	{
		int actual=4;
		FlightSearch fp=new FlightSearch();
		Reuse re=new Reuse();
		//List<WebElement> elements=fp.departureTime().findElements(By.tagName("label"));
		Assert.assertEquals(actual, re.sizeOfList(fp.departureTime(), "label"));
		ArrayList<String> actualList=new ArrayList<>(Arrays.asList("4am - 11am","11am - 4pm","4pm - 9pm","9pm - 4am"));
		ArrayList<String> expectedList=re.addElements(fp.departureTime(),"label");
		Assert.assertEquals(actualList, expectedList);
		//List<WebElement> stopsNumber=fp.stops().findElements(By.tagName("label"));
		ArrayList<String> actualStops=new ArrayList<>(Arrays.asList("0 Stop","1 Stops","2 Stops","3 Stops"));
		ArrayList<String> expectedStops=re.addElements(fp.stops(),"label");
		Assert.assertEquals(actual,re.sizeOfList(fp.stops(),"label"));
		Assert.assertEquals(actualStops, expectedStops);
		Assert.assertTrue(fp.onwardPrice().isDisplayed());
		Assert.assertTrue(fp.onwardDuration().isDisplayed());
		//List<WebElement> airLinesNames=fp.airLines().findElements(By.tagName("label"));
		//ArrayList<String> expectedAirLine=re.addElements(fp.airLines(),"label");
		int actualCount=6;
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actualCount, re.sizeOfList(fp.airLines(),"label"));
	}
	
	@Test(dependsOnMethods = {"departureTime_Stops_Airlines"})
	public void ValidateFilterResult()
	{
		String actualAirLine="Air India";
		String actualSource="Kolkata";
		String actualDestination="Delhi";
		String actualTime="4am - 11am";
		int actual=4;
		ArrayList<String> actualList=new ArrayList<>(Arrays.asList("FLIGHT INFORMATION","FARE DETAILS","BAGGAGE RULES","CANCELLATION RULES"));
		FlightSearch fp=new FlightSearch();
		Reuse re=new Reuse();
		re.applyFilter(fp.departureTime(),"label","4am - 11am");
		re.applyFilter(fp.stops(),"label","1 Stops");
		re.applyFilter(fp.airLines(),"label","Air India");
		List<WebElement> filterResult=fp.filterResult();
		for(int i=0;i<filterResult.size();i++)
		{
			String expectedAirLine=fp.airLineName(i+1).getText();
			Assert.assertEquals(actualAirLine, expectedAirLine);
			String expectedSource=fp.Station((2*i)+1).getText();
			Assert.assertTrue(expectedSource.contains(actualSource));
			String expectedDestination=fp.Station((2*i)+2).getText();
			Assert.assertTrue(expectedDestination.contains(actualDestination));
			String[] time=fp.resultDepartureTime((2*i)+1).getText().split(":");
			String expectedTime=time[0];
			Assert.assertTrue(re.compariosn(actualTime, expectedTime));
			fp.flightDetails(i+1).click();
			ArrayList<String> expectedList=re.addElements(fp.flightDetailsBar(),"span");
			Assert.assertEquals(actual, re.sizeOfList(fp.flightDetailsBar(),"span"));
			Assert.assertEquals(actualList, expectedList);
			Assert.assertTrue(fp.flightInformation().isDisplayed());
			fp.fareDetails(i+1).click();
			Assert.assertTrue(fp.fareDetailsWindow().isDisplayed());
			fp.baggage(i+1).click();
			Assert.assertTrue(fp.baggageWindow().isDisplayed());
			fp.cancellation(i+1).click();
			Assert.assertTrue(fp.cancelWindow().isDisplayed());
			Assert.assertEquals("Goibibo Fee",fp.companyName().getText());
			Assert.assertEquals("300",fp.cancellationFee().getText());
		}	
	}
	
	@Test(dependsOnMethods = {"ValidateFilterResult"})
	public void resetSortingPrice()
	{
		FlightSearch fp=new FlightSearch();
		fp.reset().click();
		Reuse re=new Reuse();
		Assert.assertFalse(re.statusOfLabel(fp.departureTime(), "label","4am - 11am"));
		Assert.assertFalse(re.statusOfLabel(fp.stops(),"label","1 Stops"));
		Assert.assertFalse(fp.flightOptions("Air India").isSelected());
		fp.priceClick().click();
		List<WebElement> filterResult=fp.filterResult();
		ArrayList<Integer> priceList=new ArrayList<>();
		for(int i=0;i<filterResult.size();i++)
		{
			String price=fp.price(i+1).getText().replaceAll(",","");
			int iPrice=Integer.parseInt(price);
			priceList.add(iPrice);
		}
		ArrayList<Integer> copiedList=new ArrayList<>();
		for (Integer integer : priceList) {
			copiedList.add(integer);
		}
		Collections.sort(copiedList);
		Collections.reverse(copiedList);
		Assert.assertEquals(priceList, copiedList);		
	}
	
	@Test(dependsOnMethods = {"resetSortingPrice"})
	public void flightBooking()
	{
		FlightSearch fp=new FlightSearch();
		fp.priceClick().click();
		Reuse re=new Reuse();
		BookingDetail bd;
		String offerMsg="Congrats! Promo Discount has been applied. Now use your Axis Bank card only on the payment page to avail 10X Reward Points.";
		String promoMsg="Offer not valid on this PromoCode";
		String errorMsg="ERROR:\n"
				+ "Please select one of the options in Travel Protection";
		if(fp.bookText().getAttribute("value").equalsIgnoreCase("VIEW FARES"))
		{
			bd=fp.bookUnderFare();
		}
		else
		{
			bd=fp.book();
		}
		Assert.assertTrue(bd.fareDetails().isDisplayed());
		ArrayList<String> actualList=new ArrayList<String>(Arrays.asList("GOBOB","GOHDFC","GOTRAVEL","FLYDOM","GOAXIS10X"));
		ArrayList<String> expectedList=new ArrayList<>();
		for (WebElement element : bd.offersList()) {
			expectedList.add(element.findElement(By.tagName("input")).getAttribute("value"));
		}
		System.out.println("expected list size is :"+expectedList.size());
		SoftAssert soft=new SoftAssert();
		//Assert.assertEquals(actualList, expectedList);
		soft.assertEquals(actualList, expectedList);
		bd.selectOffer("GOAXIS10X").click();
		Assert.assertTrue(bd.alertText().isDisplayed(),"offer value is selected");
		Assert.assertTrue(bd.alertText().getText().contains(offerMsg),"offer msg is validated");
		bd.alertClick().click();
		bd.promo().sendKeys("123456");
		bd.promoApply().click();
		Assert.assertTrue(bd.alertText().isDisplayed(),"clicked successfuly on promo apply");
		Assert.assertTrue(bd.alertText().getText().contains(promoMsg), "promo msg is validated");
		bd.alertClick().click();
		re.scrollDown(bd.proceed());
		bd.proceed().click();
		Assert.assertTrue(bd.errorMsg().getText().equalsIgnoreCase(errorMsg));	
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
