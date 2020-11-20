package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelsPageObjects {


	public WebDriver driver;
	
	public HotelsPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	By Internationalradio = By.xpath("//h4[text()='International']");
	By whereInputBox = By.xpath("//input[@class='HomePageAutosuggeststyles__SearchInputStyles-sc-1v6s32j-1 cYUrYT']");
	By GoaDropOption = By.xpath("//input[@id='downshift-1-input' and @value='Goa']");
	By searchHotelsButton = By.xpath("//button[text()='Search Hotels']");

	public WebElement getInternationalradio() {
		return driver.findElement(Internationalradio);
	}
	public WebElement getWhereInputBox() {
		return driver.findElement(whereInputBox);
	}
	public WebElement getGoaDropOption() {
		return driver.findElement(GoaDropOption);
	}
	public WebElement getSearchHotelsButton() {
		return driver.findElement(searchHotelsButton);
	}
	
}
