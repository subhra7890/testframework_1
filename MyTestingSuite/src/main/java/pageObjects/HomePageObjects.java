package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	
	public WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	By goibiboLogo= By.xpath("//img[@src=\"https://goibibo.ibcdn.com/styleguide/images/goLogo.png\"]");
	By hotelsMenuLink = By.xpath("(//a[@href=\"/hotels/\"])[1]");
	By roundTripOption = By.xpath("//span[@id='roundTrip']");
	By cabsMenuLink = By.linkText("Cabs");
	
	
	public WebElement getGoibiboLogo() {
		return driver.findElement(goibiboLogo);
	}
	public WebElement getHotelsMenuLink() {
		return driver.findElement(hotelsMenuLink);
	}
	public WebElement getRoundTripOption() {
		return driver.findElement(roundTripOption);
	}
	public WebElement getCabsMenuLink() {
		return driver.findElement(cabsMenuLink);
	}


}
