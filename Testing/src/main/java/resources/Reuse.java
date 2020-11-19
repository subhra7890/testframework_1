package resources;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjectModel.HomePage;

public class Reuse extends Base{
	
	public String Time(String time)
	{
		String value="";
		switch (time) {
		case "4am - 11am":
			value="04:11";	
			break;
		case "11am - 4pm":
			value="11:16";
			break;
		case "4pm - 9pm":
			value="16:21";
			break;
		case "9pm - 4am":
			value="21:04";
			break;
	
		}
		return value;
		
	}
	
	public boolean compariosn(String actualTime,String expectedTime)
	{
		int exconTime=Integer.parseInt(expectedTime);
		String[] str=Time(actualTime).split(":");
		int returnValue1=Integer.parseInt(str[0]);
		int returnValue2=Integer.parseInt(str[1]);
		if(exconTime>=returnValue1 && exconTime<=returnValue2)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public Select select(WebElement element)
	{
		Select s=new Select(element);
		return s;		
	}
	
	public void exceptionHandling()
	{
		HomePage hp=new HomePage();
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
	}
	
	public ArrayList<String> addElements(WebElement element,String tagName)
	{
		List<WebElement> elements=element.findElements(By.tagName(tagName));
		ArrayList<String> expectedList=new ArrayList<>();
		for (WebElement listElement : elements) {
				expectedList.add(listElement.getText());			
		}
		return expectedList;		
	}
	
	public int sizeOfList(WebElement element,String tagName)
	{
		List<WebElement> elements=element.findElements(By.tagName(tagName));
		int size=elements.size();
		return size;
	}
	
	public void applyFilter(WebElement element,String label,String text)
	{
		List<WebElement> elements = element.findElements(By.tagName(label));
		for (WebElement webElement : elements) {
			if (webElement.getText().equalsIgnoreCase(text)) {
				webElement.click();
				break;
			}
		}
		
	}
	
	public boolean statusOfLabel(WebElement element,String label,String text)
	{
		boolean flag=true;
		List<WebElement> elements = element.findElements(By.tagName(label));
		for (WebElement webElement : elements) {
			if (webElement.getText().equalsIgnoreCase(text)) {
				flag=webElement.isSelected();
				break;
			}
		}		
		return flag;
	}
	
	public void scrollDown(WebElement element)
	{
		JavascriptExecutor js2=(JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	

}
