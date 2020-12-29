package Automation;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import resources.ReadWriteExcelData;
import resources.base;


/**
 * Hello world!
 *
 */
public class xpathtest extends base
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args ) throws Exception
    {
    	System.setProperty("webdriver.chrome.driver", "C://selenium//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.get("https://the-internet.herokuapp.com/");
		driver.get("https://www.amazon.in/");
		System.out.println(driver.findElement(By.xpath("//a[text()='Best Sellers']")).getText());
		driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Your Account' and @class='hmenu-item']")).click();
		
		WebElement element=  driver.findElement(By.xpath("//a[@id='icp-nav-flyout']"));
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		//element.click();
		
		driver.findElement(By.xpath("(//span[text()='हिंदी - HI'])[1]")).click();
		
		//Actions action2 = new Actions(driver);
		action.moveToElement(element).perform();
		driver.findElement(By.xpath("(//span[text()='English - EN'])[1]")).click();
		
		
		
		
		
    	
    	System.out.println(getDataFromProperty("testdata_XLPath"));
    	System.out.println(getDataFromProperty("next"));
    	System.out.println(getDataFromProperty("framework"));
    	System.out.println(getDataFromProperty("browser"));
    	
    	
    	String url;
    	int counter=1;
    	ReadWriteExcelData rwData= new ReadWriteExcelData(getDataFromProperty("testOutputExcel"));
    	rwData.getWriteNumberToExcel(1, 1, 120245.45);
		rwData.getWriteStringToExcel(1, 2, "Hey this is test string");
		rwData.getWriteNumberToExcel(0, 3, 555589);
    	System.out.println("Number of Links: "+ driver.findElements(By.tagName("a")).size());
    	java.util.List<WebElement> allLinks = driver.findElements(By.tagName("a"));
    	Iterator<WebElement> itertr = allLinks.iterator();
    	while(itertr.hasNext()) {
    		url=itertr.next().getText();
    		System.out.println(counter+url);
    		//rwData.getWriteNumberToExcel(counter, 1, counter);
    		//rwData.getWriteStringToExcel(counter, 2, url);
    		counter++;
    
    	}
    	
    	
  
		
		//Actions action = new Actions(driver);
		 
		// Find element using locator and store into WebElement
		//driver.findElement(By.xpath("//a[text()='Request Proposal']")).click();
		//System.out.println(driver.getTitle());
		//String mainWindow = driver.getWindowHandle();
		//System.out.println(mainWindow);
        //Set<String> windows= driver.getWindowHandles();
       
        
//        	System.out.println("only one ");
//        	Robot robot = new Robot();
//        	robot.mouseMove(295, 40);
//        	Thread.sleep(2000);
//        	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        	Thread.sleep(2000);
//        	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        	Thread.sleep(2000);
//        	String chevlue="'Attract more patients from the Internet'";
//    		String chekboxvalueMergerd="//input[@type='checkbox' and @value="+chevlue;
//    		driver.findElement(By.xpath("//input[@type='checkbox' and @value='Attract more patients from the Internet']")).click();
        	
        

		
		
		//input[@type='checkbox' and @value='Attract more patients from the Internet']
		 
		// Perform moveToElement operation using action (object) on element.
		//action.moveToElement(element).perform();
		
		//driver.findElement(By.xpath("//input[placeholder='Select a city']")).sendKeys("Kolkata");
		//action.sendKeys(Keys.ENTER);

		
		
		
		//Thread.sleep(4000);
		//driver.quit();
    }
}
