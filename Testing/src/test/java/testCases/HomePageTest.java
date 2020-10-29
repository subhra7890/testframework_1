package testCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
		Set<String> string=driver.getWindowHandles();
		Iterator<String> ids=string.iterator();
		while(ids.hasNext())
		{
			driver.switchTo().window(ids.next());
			//System.out.println(ids.next());
			//System.out.println(driver.getTitle());
			String title=driver.getTitle();
			if(title.contains("Cab")|| title.contains("IRCTC") || title.contains("Gostays") || title.contains("Hotel") || title.contains("Goibibo") ||title.isEmpty())
			{
				values.add(true);
			}
			else
			{
				values.add(false);
			}
		}
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
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
