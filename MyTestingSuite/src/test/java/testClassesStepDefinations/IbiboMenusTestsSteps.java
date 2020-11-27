package testClassesStepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import resources.base;

public class IbiboMenusTestsSteps extends base{
	public WebDriver driver;
	
	@BeforeTest
	public void openIbiboApp() throws IOException {
		driver =initializeDriver();
		driver.get("https://goibibo.com");
		driver.manage().window().maximize(); 
		
	}
	@Test
	public void checkFlightlink() throws InterruptedException {
		HomePageObjects HomePB = new HomePageObjects(driver);
		HomePB.getFlightMenuLink().click();
		System.out.println("Flightlink is clicked");
		
	}
	@Test
	public void checkGostayslink() throws InterruptedException {
		HomePageObjects HomePB = new HomePageObjects(driver);
		HomePB.getGostaysMenuLink().click();
		System.out.println("Gostays link is clicked");
		
	}
	@Test
	public void checkBuslink() throws InterruptedException {
		HomePageObjects HomePB = new HomePageObjects(driver);
		HomePB.getBusMenuLink().click();
		System.out.println("Bus link is clicked");
		
	}
	@Test
	public void checkVisalink() throws InterruptedException {
		HomePageObjects HomePB = new HomePageObjects(driver);
		HomePB.getVisaMenuLink().click();
		System.out.println("Visa link is clicked");
		
	}
	@Test
	public void checkIRCTClink() throws InterruptedException {
		HomePageObjects HomePB = new HomePageObjects(driver);
		HomePB.getIRCTCMenuLink().click();
		System.out.println("IRCTC link is clicked");
		
	}
	
	@AfterTest
	public void afterIbibomenuValidation() {
		System.out.println("All Menus are working");
	}
}
