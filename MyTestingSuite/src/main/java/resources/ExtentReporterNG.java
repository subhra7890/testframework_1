package resources;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.IReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

 
public class ExtentReporterNG implements IReporter {
    
	static ExtentReports extent;
	public static ExtentReports extentReportGenerator() {
		String path= System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("****************GoIbibo Test Reports*****************");
		reporter.config().setDocumentTitle("GOIBIBO TEST SUITE-QA AUTOMATION");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("TestTeam", "Automation QA");
		return extent;
	}
    
}