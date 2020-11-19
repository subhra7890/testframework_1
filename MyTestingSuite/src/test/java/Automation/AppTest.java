package Automation;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest{
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://selenium//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		
		driver.manage().window().maximize();
		
		System.out.println("Title: "+ driver.getTitle());
		driver.findElement(By.linkText("Flights")).click();
		//linkText("Flights")
		
		///////////////////////////////////
		System.out.println(driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame")).isDisplayed());
		WebElement frameid=driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
		driver.switchTo().frame(frameid);
		//driver.switchTo().frame("notification-frame-~251442c09");
		System.out.println("stuiched to frame");
		
		driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
		
		driver.switchTo().defaultContent();
		
		boolean logodispalyed=driver.findElement(By.xpath("//img[@src=\"https://goibibo.ibcdn.com/styleguide/images/goLogo.png\"]")).isDisplayed();
		assertEquals(true, logodispalyed);
		
		
		driver.findElement(By.xpath("(//a[@href=\"/hotels/\"])[1]")).click();
		driver.findElement(By.cssSelector("input.SearchBlockUIstyles__RadioButton-fity7j-7.jeRUsJ")).click();
		driver.findElement(By.cssSelector("input.HomePageAutosuggeststyles__SearchInputStyles-sc-1v6s32j-1.cYUrYTJ")).sendKeys("Goa");
		driver.findElement(By.xpath("//input[@id='downshift-1-input' and @value='Goa']")).click();
		
		driver.findElement(By.xpath("//button[text()='Search Hotels']")).click();
	}
  
}
