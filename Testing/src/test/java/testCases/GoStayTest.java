package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.GoStay;
import pageObjectModel.HomePage;
import pageObjectModel.HotelSearch;
import resources.Base;
import resources.ExcelUtilities;
import resources.Reuse;

public class GoStayTest extends Base{
	//private WebDriver driver;
	@BeforeTest
	public void initialize() {
		driver = initializeDriver();
		driver.get("https://www.goibibo.com/");
	}
	
	@Test(priority = 0)
	public void trendingDestinationCount() throws InterruptedException {
		int actual=6;
		HomePage hp=new HomePage();
		GoStay go=hp.goStay();
		Reuse re=new Reuse();
		go.radioOptions().click();
		System.out.println(go.radioOptions().isSelected());
		Thread.sleep(2000);
		Assert.assertTrue(go.radioOptions().isSelected());
		go.source().click();
		Thread.sleep(2000);
		int expected=re.sizeOfList(go.trendingCity(),"li");
		Assert.assertEquals(actual,expected);
	}
	
	@Test(enabled = false)
	public void selectTrendingCity()
	{
		Reuse re=new Reuse();
		GoStay go=new GoStay();
		re.selectElementsList(go.trendingCity(),"li","Goa");
		HotelSearch he=new HotelSearch();
		int expected=he.searchResult().size();
		Assert.assertTrue(expected>1);
		driver.navigate().back();
	}
	
	@Test(priority = 1,dataProvider ="sourceDestinationDate")
	public void maxmValidationRule(String source,String checkInMonth,String checkInDate,String checkOutMonth,String checkOutDate) throws InterruptedException
	{
		String alertMsg="Max allowed upto 8";
		GoStay go=new GoStay();
		Reuse re=new Reuse();
		//re.hotelCitySelection("Puri");
		while(!go.source().getAttribute("value").isEmpty())
		{
			go.source().sendKeys(Keys.BACK_SPACE);
		}
		go.source().sendKeys(source);
		Thread.sleep(5000);
		go.source().sendKeys(Keys.DOWN);
		Thread.sleep(5000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		String script="return document.getElementById(\"downshift-1-input\").value;";
//		System.out.println(script);
//		String text=(String)js.executeScript(script);
//		System.out.println("city name is :"+text);
//		while (!text.equals("Puri")) {
//			go.source().sendKeys(Keys.DOWN);
//			Thread.sleep(5000);
//			text=(String)js.executeScript(script);
//		}
		go.source().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		System.out.println(go.source().getText());
		//re.departureMonthSelection(go.checkIn(),go.month(),go.arrowClick(),"December");
		go.checkIn().click();
		String text=go.month().getText();
		System.out.println(text);
		while(!text.contains(checkInMonth))
		{
			go.arrowClick().click();
			text=go.month().getText();
		}
		re.hotelDateSelection(go.checkInDates().findElements(By.tagName("li")), checkInDate);
		//re.departureMonthSelection(go.checkOut(),go.month(),go.arrowClick(),"December");
		String text1=go.month().getText();
		System.out.println(text1);
		while(!text1.contains(checkOutMonth))
		{
			go.arrowClick().click();
			text1=go.month().getText();
		}
		re.hotelDateSelection(go.checkInDates().findElements(By.tagName("li")),checkOutDate);
		go.guestCount().click();
		go.roomsClick().click();
		while(!go.roomText().getText().equalsIgnoreCase("8"))
		{
			go.roomsClick().click();
		}
		go.roomsClick().click();
		Alert al=driver.switchTo().alert();
		String expected=al.getText();
		System.out.println(expected);
		Assert.assertEquals(alertMsg, expected);
		al.accept();
		go.adultDecrementClick().click();
		while(!go.adultText().getText().equalsIgnoreCase("2"))
		{
			go.adultDecrementClick().click();
		}
		go.roomDecrement().click();
		go.done();
		Thread.sleep(2000);
		//go.source().clear();
	}
	
	@Test(priority = 2)
	public void hotelSearchPage()
	{
		GoStay go=new GoStay();
		HotelSearch hs=go.hotelSearchClick();
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(hs.visibilty()));
		List<WebElement> hotelResult=hs.hotelResults();
		Assert.assertTrue(hotelResult.size()>1);
		List<WebElement> price=hs.price();
		Assert.assertEquals(5,price.size());
		List<WebElement> customerRating=hs.customerRating();
		Assert.assertEquals(3,customerRating.size());
		List<WebElement> ratings=hs.rating();
		Assert.assertEquals(3,ratings.size());
		ArrayList<String> hotels=new ArrayList<String>(Arrays.asList("Hotel","Guest House","Homestay"));
		ArrayList<String> expectedHotels=new ArrayList<>();
		List<WebElement> beforeHotels=hs.hotelType();
		Assert.assertEquals(3,beforeHotels.size());
		for (WebElement webElement : beforeHotels) {
			expectedHotels.add(webElement.getText());		
		}
		Assert.assertEquals(hotels, expectedHotels);
		hs.hotelShow().click();
		List<WebElement> afterHotels=hs.hotelType();
		Assert.assertEquals(11,afterHotels.size());
		ArrayList<String> amenities=new ArrayList<String>(Arrays.asList("Air Conditioning","Airport Transfer (on Demand)","Banquet hall"));
		ArrayList<String> expectedAmenities=new ArrayList<>();
		List<WebElement> beforeAmenities=hs.amenitiesList();
		Assert.assertEquals(3,beforeAmenities.size());
		for (WebElement webElement : beforeAmenities) {
			expectedAmenities.add(webElement.getText());
		}
		Assert.assertEquals(amenities, expectedAmenities);
		hs.amenitiesShow().click();
		List<WebElement> afterAmenities=hs.amenitiesList();
		Assert.assertEquals(38, afterAmenities.size());		
	}
	
	@Test(priority = 3,dataProvider = "hotelAmenitiesFilter")
	public void validationOfFilter(String hotel,String amenitiesType) throws InterruptedException
	{
		HotelSearch hs=new HotelSearch();
		Reuse re=new Reuse();
		List<WebElement> price=hs.price();
		//int priceCount=0,hotelCount=0,amenitiesCount=0;
		JavascriptExecutor js=(JavascriptExecutor) driver;
		for (WebElement webElement : price) {
			String text=webElement.getText();
			if(text.contains("2001"))
			{
				try {
				webElement.click();
				} catch (ElementClickInterceptedException e) {
					// TODO: handle exception
					js.executeScript("arguments[0].click()", webElement);
				}
//				Assert.assertTrue(webElement.isSelected());			
			}				
		}
		List<WebElement> hotels=hs.hotelType();
		for (WebElement webElement : hotels) {
			String text=webElement.getText();
			if(text.equalsIgnoreCase(hotel))
			{
				try {
					webElement.click();
					break;
				} catch (ElementClickInterceptedException e) {
					// TODO: handle exception
					js.executeScript("arguments[0].click()", webElement);
					break;
				}				
			}		
		}
		List<WebElement> amenities=hs.amenitiesList();
		for (WebElement webElement : amenities) {
			String text=webElement.getText();
			if(text.equalsIgnoreCase(amenitiesType))
			{
				try {
					webElement.click();
					break;
				} catch (ElementClickInterceptedException e) {
					js.executeScript("arguments[0].click()", webElement);
					break;
				}				
				//Assert.assertTrue(webElement.isSelected());			
			}	
		}
		int size=re.sizeOfList(hs.filter(),"div");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(3, size);
		System.out.println("filer result is :"+size);
		try {
			hs.clearFilter().click();
		} catch (ElementClickInterceptedException  e) {
			js.executeScript("arguments[0].click()", hs.clearFilter());
		}
		
		Thread.sleep(5000);
	}
	
	@Test(priority = 4)
	public void suggestionList()
	{
		GoStay go=new GoStay();
		driver.navigate().back();
		String title=driver.getTitle();
		while(title.equals("Results"))
		{
			driver.navigate().back();
			title=driver.getTitle();
		}
		ArrayList<String> actualList=new ArrayList<String>(Arrays.asList("Beach Vacations","Weekend Getaways","Mountains Calling",
				"Stay Like Royals","Indian Pilgrimages","Party Destinations"));
		Reuse re=new Reuse();
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(go.suggestions()));
		ArrayList<String> expectedList=re.addElements(go.suggestions(),"li");
		Assert.assertEquals(actualList, expectedList);		
	}
	
	@Test(priority = 5,dataProvider ="vacationType")
	public void suggestionListSelection(String vacation) throws InterruptedException
	{
		GoStay go=new GoStay();
		int actual=10;
		Reuse re=new Reuse();
		List<WebElement> elements=go.suggestions().findElements(By.tagName("li"));
		for (WebElement webElement : elements) {
			if(webElement.getText().equalsIgnoreCase(vacation))
			{
				Actions act=new Actions(driver);
				act.doubleClick(webElement).build().perform();
				break;
			}
		}
		int expected1=re.sizeOfList(go.citiesName(),"li");
		System.out.println("size of list :"+expected1);
		Thread.sleep(2000);
		re.javaScriptClick(go.buttonClick());
		Thread.sleep(2000);
		int expected2=re.sizeOfList(go.citiesName(),"li");
		System.out.println("size of list after click :"+expected2);
		int finalExpected=expected1+expected2;
		Assert.assertEquals(actual, finalExpected);		
	}
	
	@Test(priority = 6)
	public void validationBootomLinks() throws InterruptedException
	{
		Reuse re=new Reuse();
		GoStay go=new GoStay();
		Thread.sleep(5000);
		re.clickMultipleLink(go.bottomElement(),"a");
		String parentId=driver.getWindowHandle();
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		while (it.hasNext()) {
			String childId=it.next();
			if(!parentId.equalsIgnoreCase(childId))
			{
				driver.switchTo().window(childId);
				System.out.println(driver.getTitle());
				driver.close();
			}			
		}
	}
	
	@DataProvider(name="sourceDestinationDate")
	public Object[][] getDataProvider() throws IOException
	{
		String location="C:\\Users\\HP\\eclipse-workspace\\Maven Project\\Testing\\src\\main\\java\\resources\\TestData.xlsx";
		  ExcelUtilities exe=new ExcelUtilities(location);
		  int sheetIndex=exe.indexSheet("GoStay");
		  System.out.println("sheet index is :"+sheetIndex);
		  int testIndex=exe.indexTestCase(sheetIndex,"maxmValidationRule");
		  System.out.println("test case index is :"+testIndex);
		  int rowIndex=exe.rowIndex("maxmValidationRule");
		  System.out.println("row index is :"+rowIndex);
		  Object[][] data=exe.readData(sheetIndex, testIndex, rowIndex);
		  return data;
	}
	
	@DataProvider(name="hotelAmenitiesFilter")
	public Object[][] getDataProvider1() throws IOException
	{
		String location="C:\\Users\\HP\\eclipse-workspace\\Maven Project\\Testing\\src\\main\\java\\resources\\TestData.xlsx";
		  ExcelUtilities exe=new ExcelUtilities(location);
		  int sheetIndex=exe.indexSheet("GoStay");
		  System.out.println("sheet index is :"+sheetIndex);
		  int testIndex=exe.indexTestCase(sheetIndex,"validationOfFilter");
		  System.out.println("test case index is :"+testIndex);
		  int rowIndex=exe.rowIndex("validationOfFilter");
		  System.out.println("row index is :"+rowIndex);
		  Object[][] data=exe.readData(sheetIndex, testIndex, rowIndex);
		  return data;
	}
	
	@DataProvider(name="vacationType")
	public Object[][] getDataProvider2() throws IOException
	{
		String location="C:\\Users\\HP\\eclipse-workspace\\Maven Project\\Testing\\src\\main\\java\\resources\\TestData.xlsx";
		  ExcelUtilities exe=new ExcelUtilities(location);
		  int sheetIndex=exe.indexSheet("GoStay");
		  System.out.println("sheet index is :"+sheetIndex);
		  int testIndex=exe.indexTestCase(sheetIndex,"suggestionListSelection");
		  System.out.println("test case index is :"+testIndex);
		  int rowIndex=exe.rowIndex("suggestionListSelection");
		  System.out.println("row index is :"+rowIndex);
		  Object[][] data=exe.readData(sheetIndex, testIndex, rowIndex);
		  return data;
	}
	
	

	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
 
}
