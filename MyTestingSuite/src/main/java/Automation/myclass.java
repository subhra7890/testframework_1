package Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class myclass {
	
	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis =new FileInputStream("F:\\Eclipse_Workspace\\MyTestingSuite\\src\\main\\java\\Automation\\data.properties");
		
		prop.load(fis);
		String FrameworkIdea= prop.getProperty("FrameworkIdea");
		System.out.println(FrameworkIdea);
		System.out.println((prop.getProperty("FrameworkIdea")));
		System.out.println(prop.getProperty("baseClass"));
		System.out.println(prop.getProperty("pageObjects"));
		System.out.println(prop.getProperty("testng_MVN_POM"));
		
		
	}

}
