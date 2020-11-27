package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;



public class base {
	public  WebDriver driver;
	static Properties prop = new Properties();
	
	public  static String getTestdataPath() throws IOException
	{
			FileInputStream fis=new FileInputStream("F:\\Eclipse_Workspace\\E2EProjectCucumber\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
			String testdataPath=prop.getProperty("testdata_XLPath");
			return testdataPath;
	}
	
	@SuppressWarnings("deprecation")
	public  WebDriver initializeDriver() throws IOException {
		
		
		FileInputStream fis =new FileInputStream("F:\\data\\testframework_1\\MyTestingSuite\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome")) {
			System.out.println("Browser is being invoked by Chrome");
			System.setProperty("webdriver.chrome.driver", "C://selenium//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			
		}
		else if(browserName.equals("firefox")) {
			System.out.println("Browser is invoked by firefox");
		}
		else if(browserName.equals("edge")) {
			System.out.println("Browser is being invoked by Edge");
			System.setProperty("webdriver.edge.driver", "C://selenium//msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public String getScreenShot(String TestCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String destpath = System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
		File file= new File(destpath);
		FileUtils.copyFile(source, file);
		return destpath;
	}

}
