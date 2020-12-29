package testClassesStepDefinations;

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
import resources.ReadWriteExcelData;
import resources.base;

public class IbiboBasicTestsSteps extends base {
	public WebDriver driver;	
	

	
	@Test(priority=1)
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
			 

	}
	@Test(priority=2)
	public void openHomePage() throws Exception {
		
		
		ReadWriteExcelData rdata = new ReadWriteExcelData(getTestdataPath());
		//driver.get("https://goibibo.com");
		driver.get(rdata.getCellData("IbiboBasicTestsSteps","goIBIBOurl", 2));
		driver.manage().window().maximize();
		
		System.out.println("pop up is displayed and to be closed");
		
		
	}
	@Test(priority=3)
	public void getTitleOfPage(){
		
		String titlehome = driver.getTitle();
		System.out.println("Title: "+ titlehome);
		
	}
	
	@Test(priority=4)
	public void validateLogoDisplayed() {
		
		HomePageObjects HomePB = new HomePageObjects(driver);
		//boolean logodispalyed=driver.findElement(By.xpath("//img[@src=\"https://goibibo.ibcdn.com/styleguide/images/goLogo.png\"]")).isDisplayed();
		boolean logodispalyed=HomePB.getGoibiboLogo().isDisplayed();
		assertEquals(true, logodispalyed);
	}
	
	@Test(priority=5)
	public void checkHotelLink() throws IOException, Exception {
		
		HomePageObjects HomePB = new HomePageObjects(driver);
		HotelsPageObjects HotelsPB = new HotelsPageObjects(driver);
		ReadWriteExcelData rdata = new ReadWriteExcelData(getTestdataPath());
		//driver.findElement(By.xpath("(//a[@href=\"/hotels/\"])[1]")).click();
		HomePB.getHotelsMenuLink().click();
		//driver.findElement(By.xpath("//h4[text()='International']")).click();
		HotelsPB.getInternationalradio().click();
		//driver.findElement(By.xpath("//input[@class='HomePageAutosuggeststyles__SearchInputStyles-sc-1v6s32j-1 cYUrYT']")).sendKeys("Goa");
		HotelsPB.getWhereInputBox().sendKeys(rdata.getCellData("IbiboBasicTestsSteps","getWhereInputBox", 2));
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
		HomePageObjects HomePB = new HomePageObjects(driver);
		driver.navigate().back();
		//driver.findElement(By.xpath("//span[@id='roundTrip']")).click();
		HomePB.getRoundTripOption().click();
	}
	
	@Test(priority=7)
	public void checkCablink() throws InterruptedException {
		HomePageObjects HomePB = new HomePageObjects(driver);
		//driver.findElement(By.linkText("Cabs")).click();
		HomePB.getCabsMenuLink().click();
		System.out.println("Cab link is clicked");
		
	}
	
	
	@AfterTest
	public void closebrowser() throws InterruptedException{
		Thread.sleep(3000);
		driver.quit();
		
	}
	
	
	
	
}
