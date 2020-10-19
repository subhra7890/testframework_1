package newpackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyClass {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		//System.out.println("hello world");
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		WebElement typeOfTravel=driver.findElement(By.id("roundTrip"));
		typeOfTravel.click();
		WebElement sourceCity=driver.findElement(By.id("gosuggest_inputSrc"));
		sourceCity.sendKeys("DELHI");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(8000);
		/*
		 * sourceCity.sendKeys(Keys.ARROW_DOWN); sourceCity.sendKeys(Keys.ENTER);
		 */
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		String source=sourceCity.getAttribute("value");
		System.out.println("source plce is :"+source);	
		WebElement destinationCity=driver.findElement(By.id("gosuggest_inputDest"));
		destinationCity.sendKeys("MUMBAI");
		/*
		 * r.keyPress(KeyEvent.VK_DOWN); r.keyRelease(KeyEvent.VK_DOWN);
		 * r.keyPress(KeyEvent.VK_ENTER); r.keyRelease(KeyEvent.VK_ENTER);
		 */
		Thread.sleep(8000);
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		String destination=destinationCity.getAttribute("value");
		System.out.println("destination plce is :"+destination);
		Thread.sleep(5000);
		driver.findElement(By.id("fare_20201015")).click();
		driver.findElement(By.id("fare_20201029")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("gi_search_btn")).click();
		Thread.sleep(10000);
		/* to check price are sorted*/
		WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(@class,'fltHpyRWrap')][2]"))));
		WebElement price=driver.findElement(By.xpath("//li[@id='PRICE']"));
		price.click();
		//WebElement priceElement=driver.findElement(By.xpath("//span[@class='ico20']"));
		/*
		 * System.out.println(priceElement.getText());
		 * System.out.println(priceElement.getAttribute("value"));
		 */
		List<WebElement> flightPrice=driver.findElements(By.xpath("//span[@class='ico20']"));
		  System.out.println(flightPrice.size());
		  /* to add the values in newly created list*/
		  ArrayList<String> priceValue=new ArrayList<>();
//		  for(int i=0;i<flightPrice.size();i++)
//		  {
//			  String price1=flightPrice.get(i).getText();
//			  String modifiedPrice1=price1.replaceAll(",","");
//			  priceValue.add(modifiedPrice1);
//			  System.out.println(modifiedPrice1); 
//		  } 
		  int[] newArr=new int[priceValue.size()];
		  for(int i=0;i<newArr.length;i++)
		  {
			  String price1=flightPrice.get(i).getText().replaceAll(",","");
			  int price2=Integer.parseInt(price1);
			  newArr[i]=price2;
		  }
//		  System.out.println("********in new arry*****************");
//		  for(int i=0;i<newArr.length;i++)
//		  {
//			  System.out.println(newArr[i]);
//		  }
		  System.out.println("*******************************");
		  int[] copiedArr=new int[newArr.length];
		  for(int j=0;j<copiedArr.length;j++)
		  {
			  copiedArr[j]=newArr[j];
		  }
		 
//		  System.out.println("************in coped array************");
//		  for(int j=0;j<copiedArr.length;j++)
//		  {
//			  System.out.println(copiedArr[j]);
//		  }
//		  System.out.println("******************");
		  Arrays.sort(copiedArr);
		  boolean b=Arrays.equals(newArr, copiedArr);
		  System.out.println(b);
		  if((Arrays.equals(newArr, copiedArr))==true)
		  {
			  System.out.println("values are sorted");
		  }
		  else
		  {
			  System.out.println("values are not sorted");
		  }
//		  ArrayList<String> copiedList=new ArrayList<>(priceValue);
//		  for (String  string1 : copiedList) 
//		 {
//				/*
//				 * System.out.println("******value added in new list*************");
//				 * System.out.println(string);
//				 */
//			  //copiedList.add(string);
//			  System.out.println("***********for copied list******");
//			  System.out.println(string1);
//		  
//		  }
//		 
//		  Collections.sort(copiedList);
//		  System.out.println(copiedList.equals(priceValue));
		  
		  
		 
		




		
		
		
	}

}
