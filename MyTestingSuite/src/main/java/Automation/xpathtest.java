package Automation;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import resources.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

/**
 * Hello world!
 *
 */
public class xpathtest extends base
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args ) throws InterruptedException, AWTException
    {
    	System.setProperty("webdriver.chrome.driver", "C://selenium//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://healthcaresuccess.com/");
		
		
		//Actions action = new Actions(driver);
		 
		// Find element using locator and store into WebElement
		driver.findElement(By.xpath("//a[text()='Request Proposal']")).click();
		System.out.println(driver.getTitle());
		//String mainWindow = driver.getWindowHandle();
		//System.out.println(mainWindow);
        //Set<String> windows= driver.getWindowHandles();
       
        
        	System.out.println("only one ");
        	Robot robot = new Robot();
        	robot.mouseMove(295, 40);
        	Thread.sleep(2000);
        	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        	Thread.sleep(2000);
        	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        	Thread.sleep(2000);
        	String chevlue="'Attract more patients from the Internet'";
    		String chekboxvalueMergerd="//input[@type='checkbox' and @value="+chevlue;
    		driver.findElement(By.xpath("//input[@type='checkbox' and @value='Attract more patients from the Internet']")).click();
        	
        

		
		
		//input[@type='checkbox' and @value='Attract more patients from the Internet']
		 
		// Perform moveToElement operation using action (object) on element.
		//action.moveToElement(element).perform();
		
		//driver.findElement(By.xpath("//input[placeholder='Select a city']")).sendKeys("Kolkata");
		//action.sendKeys(Keys.ENTER);

		
		
		
		Thread.sleep(4000);
		driver.quit();
    }
}
