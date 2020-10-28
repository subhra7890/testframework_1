package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class DemoTesr2 extends Base{
	
	@BeforeTest
	public void initialie()
	{
		driver=initializeDriver();
	}
  @Test
  public void f() {
	  
	  driver.get("https://www.goibibo.com/");
		System.out.println(driver.getTitle());
  }
}
