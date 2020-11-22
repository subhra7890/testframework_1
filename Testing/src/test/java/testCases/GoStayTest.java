package testCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModel.GoStay;
import pageObjectModel.HomePage;
import pageObjectModel.HotelSearch;
import resources.Base;
import resources.Reuse;

public class GoStayTest extends Base{
	
	@BeforeTest
	public void initialize() {
		driver = initializeDriver();
		driver.get("https://www.goibibo.com/");
	}
	
	@Test(priority = 0)
	public void trendingDestinationCount() {
		int actual=6;
		HomePage hp=new HomePage();
		GoStay go=hp.goStay();
		Reuse re=new Reuse();
		go.radioOptions().click();
		Assert.assertTrue(go.radioOptions().isSelected());
		go.source().click();
		int expected=re.sizeOfList(go.trendingCity(),"li");
		Assert.assertEquals(actual,expected);
	}
	
	@Test(dependsOnMethods = {"trendingDestinationCount"})
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
	
	@Test(dependsOnMethods = {"selectTrendingCity"})
	public void suggestionList()
	{
		GoStay go=new GoStay();
		ArrayList<String> actualList=new ArrayList<String>(Arrays.asList("Beach Vacations","Weekend Getaways","Mountains Calling",
				"Stay Like Royals","Indian Pilgrimages","Party Destinations"));
		Reuse re=new Reuse();
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(go.suggestions()));
		ArrayList<String> expectedList=re.addElements(go.suggestions(),"li");
		Assert.assertEquals(actualList, expectedList);		
	}
	
	@Test(dependsOnMethods = {"suggestionList"})
	public void suggestionListSelection()
	{
		GoStay go=new GoStay();
		int actual=8;
		Reuse re=new Reuse();
		List<WebElement> elements=go.suggestions().findElements(By.tagName("li"));
		for (WebElement webElement : elements) {
			if(webElement.getText().equalsIgnoreCase("Mountains Calling"))
			{
				Actions act=new Actions(driver);
				act.doubleClick(webElement).build().perform();
				break;
			}
		}
		int expected1=re.sizeOfList(go.citiesName(),"li");
		re.javaScriptClick(go.buttonClick());
		int expected2=re.sizeOfList(go.citiesName(),"li");
		int finalExpected=expected1+expected2;
		Assert.assertEquals(actual, finalExpected);		
	}
	
	@Test(dependsOnMethods = {"suggestionListSelection"})
	public void validationBootomLinks()
	{
		Reuse re=new Reuse();
		GoStay go=new GoStay();
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
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
 
}
