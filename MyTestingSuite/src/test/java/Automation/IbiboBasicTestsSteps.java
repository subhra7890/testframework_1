package Automation;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.HotelsPageObjects;
import resources.base;

public class IbiboBasicTestsSteps extends base {
	public WebDriver driver;
	HomePageObjects HomePB = new HomePageObjects(driver);
	HotelsPageObjects HotelsPB = new HotelsPageObjects(driver);
	
	/*@BeforeTest
	public void config() {
		
	}   */
	
	
	@Test(priority=1)
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
			 

	}
	@Test(priority=2)
	public void openHomePage() throws IOException, InterruptedException {
		
		driver.get("https://goibibo.com");
		driver.manage().window().maximize();
		//WebDriverWait wait = new WebDriverWait(driver,6);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']")));
		System.out.println("pop up is displayed and to be closed");
		//driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
		
		
	}
	@Test(priority=3)
	public void getTitleOfPage(){
		
		String titlehome = driver.getTitle();
		System.out.println("Title: "+ titlehome);
		
	}
	
	@Test(priority=4)
	public void validateLogoDisplayed() {
		
		//boolean logodispalyed=driver.findElement(By.xpath("//img[@src=\"https://goibibo.ibcdn.com/styleguide/images/goLogo.png\"]")).isDisplayed();
		boolean logodispalyed=HomePB.getGoibiboLogo().isDisplayed();
		assertEquals(true, logodispalyed);
	}
	
	@Test(priority=5)
	public void checkHotelLink() throws InterruptedException {
		
		

		//driver.findElement(By.xpath("(//a[@href=\"/hotels/\"])[1]")).click();
		HomePB.getHotelsMenuLink().click();
		//driver.findElement(By.xpath("//h4[text()='International']")).click();
		HotelsPB.getInternationalradio().click();
		//driver.findElement(By.xpath("//input[@class='HomePageAutosuggeststyles__SearchInputStyles-sc-1v6s32j-1 cYUrYT']")).sendKeys("Goa");
		HotelsPB.getWhereInputBox().sendKeys("Goa");
		WebDriverWait wait = new WebDriverWait(driver,6);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='downshift-1-input' and @value='Goa']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) HotelsPB.getGoaDropOption()));
		//driver.findElement(By.xpath("//input[@id='downshift-1-input' and @value='Goa']")).click();
		HotelsPB.getGoaDropOption().click();
		
		//driver.findElement(By.xpath("//button[text()='Search Hotels']")).click();
		HotelsPB.getSearchHotelsButton().click();
		
	}
	
	@Test(priority=6)
	public void checkRoundTrip() throws InterruptedException {
		driver.navigate().back();
		//driver.findElement(By.xpath("//span[@id='roundTrip']")).click();
		HomePB.getRoundTripOption().click();
	}
	
	@Test(priority=7)
	public void checkCablink() throws InterruptedException {
		//driver.findElement(By.linkText("Cabs")).click();
		HomePB.getCabsMenuLink().click();
		System.out.println("Cab link is clicked");
		
	}
	
	
	@AfterTest
	public void closebrowser(){
		//driver.quit();
		
	}
	
	
	
	
}
