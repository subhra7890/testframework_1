package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.Base;

public class BookingDetail extends Base{
	//private WebDriver driver;
	By fareDetails=By.xpath("//div[@class='flightDetails fl']");
	By offersList=By.xpath("//div[@class='fl width100 padTB15 borderBtm posRel']");
	By alertText=By.xpath("//div[@class='popContent']");
	By alertClick=By.xpath("//button[text()='OK']");
	By promo=By.xpath("//input[@id='goPromo']");
	By promoApply=By.xpath("//input[@value='Apply']");
	By proceed=By.xpath("//button[contains(@class,'orange')]");
	By errorMsg=By.xpath("(//span[contains(@class,'alert_msg')])[3]");
	
	
//	public BookingDetail(WebDriver driver) {
//		this.driver = driver;
//	}

	public WebElement fareDetails()
	{
		return driver.findElement(fareDetails);
	}
	
	public List<WebElement> offersList()
	{
		List<WebElement> elements=driver.findElements(offersList);
		return elements;
	}
	
	public WebElement alertText()
	{
		return driver.findElement(alertText);
	}
	
	public WebElement alertClick()
	{
		return driver.findElement(alertClick);
	}
	
	public WebElement promo()
	{
		return driver.findElement(promo);
	}
	
	public WebElement promoApply()
	{
		return driver.findElement(promoApply);
	}
	
	public WebElement proceed()
	{
		return driver.findElement(proceed);
	}
	
	public WebElement selectOffer(String offer)
	{
		String element="//input[@value='"+offer+"']/following::div[1]";
		return driver.findElement(By.xpath(element));
	}
	
	public WebElement errorMsg()
	{
		return driver.findElement(errorMsg);
	}

}
