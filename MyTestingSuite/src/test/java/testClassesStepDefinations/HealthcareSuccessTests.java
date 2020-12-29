package testClassesStepDefinations;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HealthcareSuccessPageObjects;
import resources.ReadWriteExcelData;
import resources.base;

public class HealthcareSuccessTests extends base {
	
	public WebDriver driver;
	//HealthcareSuccessPageObjects HelSucObjs= new HealthcareSuccessPageObjects(driver);
	
	@BeforeTest
	public void preTest() throws IOException {
		driver =initializeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void openHealthSuccessApp() throws IOException, Exception   {
		
		HealthcareSuccessPageObjects HelSucObjs= new HealthcareSuccessPageObjects(driver);
		ReadWriteExcelData rdata= new ReadWriteExcelData(getTestdataPath());
		
		 
		driver.get(rdata.getCellData("HealthSuccessTest1", "HealthSuccessURL", 2));
		//driver.findElement(By.xpath("//a[text()='Request Proposal']")).click();
		
		
		
		System.out.println("HealthSeccess App loaded ");
		HelSucObjs.getRequestProposalMenu().click(); //click on RequestProposal menu option
		Robot robot = new Robot();
    	robot.mouseMove(295, 40);
    	Thread.sleep(2000);
    	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    	Thread.sleep(2000);
    	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    	Thread.sleep(2000);
	}
	@Test
	public void requestProppsalStep_1_HelSuccess() throws Exception {
		HealthcareSuccessPageObjects HelSucObjs= new HealthcareSuccessPageObjects(driver);
		ReadWriteExcelData rdata= new ReadWriteExcelData(getTestdataPath());
		HelSucObjs.getWhatAreYourGoals_ChkBoxes().click();
		Select orgDrpDwn= new Select(HelSucObjs.getTypeOfOrganization_drpdwn());
		orgDrpDwn.selectByVisibleText(rdata.getCellData("HealthSuccessTest1", "typeOfOrganization_drpdwn", 2));
		HelSucObjs.getCompanynName_input().sendKeys(rdata.getCellData("HealthSuccessTest1", "companynName_input", 2));
		HelSucObjs.getContinue_btn().click();
		
		System.out.println("Step 1 finished");
	
	}	
	
	@Test(invocationCount = 3)
	public void requestProppsalStep_2_HelSuccess() throws Exception {
		HealthcareSuccessPageObjects HelSucObjs= new HealthcareSuccessPageObjects(driver);
		ReadWriteExcelData rdata= new ReadWriteExcelData(getTestdataPath());
		//HelSucObjs.getMarketingBudget_input().click();
		HelSucObjs.getMarketingBudget_input().sendKeys(rdata.getCellData("HealthSuccessTest1", "marketingBudget_input", 2));
		
		Select numOfDocDrpDwn= new Select(HelSucObjs.getNumOfDoctors_drpdwn());
		numOfDocDrpDwn.selectByVisibleText(rdata.getCellData("HealthSuccessTest1", "numOfDoctors_drpdwn", 2));
		//HelSucObjs.getNumOfLocations_input().click();
		HelSucObjs.getNumOfLocations_input().sendKeys(rdata.getCellData("HealthSuccessTest1", "numOfLocations_input", 2));
		HelSucObjs.getAnything_else_txtbox().sendKeys(rdata.getCellData("HealthSuccessTest1", "anything_else_txtbox", 2));
		HelSucObjs.getLastStep_btn().click();
		
		System.out.println("Step 2 finished");
	
	}
	
	@Test
	public void requestProppsalStep_3_HelSuccess() throws Exception {
		HealthcareSuccessPageObjects HelSucObjs= new HealthcareSuccessPageObjects(driver);
		ReadWriteExcelData rdata= new ReadWriteExcelData(getTestdataPath());
		HelSucObjs.getWebsite().sendKeys(rdata.getCellData("HealthSuccessTest1", "website", 2));
		HelSucObjs.getFirstName_input().sendKeys(rdata.getCellData("HealthSuccessTest1", "firstName_input", 2));
		HelSucObjs.getLastName_input().sendKeys(rdata.getCellData("HealthSuccessTest1", "lastName_input", 2));
		HelSucObjs.getPhone_input().sendKeys(rdata.getCellData("HealthSuccessTest1", "phone_input", 2));
		HelSucObjs.getEmail_input().sendKeys(rdata.getCellData("HealthSuccessTest1", "email_input", 2));
		//HelSucObjs.getLetsTlk_submit_btn().click();
		
		System.out.println("Step 3 finished");
		Thread.sleep(3000);
		driver.quit();
	
	}
	
	
}
