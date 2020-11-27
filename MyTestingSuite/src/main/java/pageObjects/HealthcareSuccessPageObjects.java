package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HealthcareSuccessPageObjects {
	
	public WebDriver driver;
	
	By RequestProposalMenu = By.xpath("//a[text()='Request Proposal']");
	
	
	By whatAreYourGoals_ChkBoxes = By.xpath("//input[@type='checkbox' and @value='Attract more patients from the Internet']");
	By typeOfOrganization_drpdwn = By.xpath("//select[@name='type_of_organization']");
	By companynName_input = By.xpath("(//input[@name='company'])[2]");
	By continue_btn = By.xpath("//a[@id='continue']");
	
	By marketingBudget_input = By.xpath("//input[@name='marketing_budget']");
	By numOfDoctors_drpdwn = By.xpath("//select[@name='number_of_doctors']");
	By numOfLocations_input = By.xpath("//input[@name='number_of_locations']");
	By anything_else_txtbox = By.xpath("//textarea[@name='anything_else_you_d_like_us_to_know_']");
	By LastStep_btn = By.xpath("//a[text()='Last Step']");
	
	
	By website = By.xpath("//input[@name='website']");
	By firstName_input = By.xpath("(//input[@name='firstname'])[2]");
	By lastName_input = By.xpath("(//input[@name='lastname'])[2]");
	By phone_input = By.xpath("(//input[@name='phone'])[2]");
	By email_input = By.xpath("(//input[@name='email'])[2]");
	By LetsTlk_submit_btn = By.xpath("(//input[@type='submit'])[2]");
	
	public HealthcareSuccessPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement getRequestProposalMenu() {
		return driver.findElement(RequestProposalMenu);
	}
	
	public WebElement getWhatAreYourGoals_ChkBoxes() {
		return driver.findElement(whatAreYourGoals_ChkBoxes);
	}
	public WebElement getTypeOfOrganization_drpdwn() {
		return driver.findElement(typeOfOrganization_drpdwn);
	}
	public WebElement getCompanynName_input() {
		return driver.findElement(companynName_input);
	}
	public WebElement getContinue_btn() {
		return driver.findElement(continue_btn);
	}
	public WebElement getMarketingBudget_input() {
		return driver.findElement(marketingBudget_input);
	}
	public WebElement getNumOfDoctors_drpdwn() {
		return driver.findElement(numOfDoctors_drpdwn);
	}
	public WebElement getNumOfLocations_input() {
		return driver.findElement(numOfLocations_input);
	}
	public WebElement getAnything_else_txtbox() {
		return driver.findElement(anything_else_txtbox);
	}
	public WebElement getLastStep_btn() {
		return driver.findElement(LastStep_btn);
	}
	public WebElement getWebsite() {
		return driver.findElement(website);
	}
	public WebElement getFirstName_input() {
		return driver.findElement(firstName_input);
	}
	public WebElement getLastName_input() {
		return driver.findElement(lastName_input);
	}
	public WebElement getPhone_input() {
		return driver.findElement(phone_input);
	}
	public WebElement getEmail_input() {
		return driver.findElement(email_input);
	}
	public WebElement getLetsTlk_submit_btn() {
		return driver.findElement(LetsTlk_submit_btn);
	}

}
