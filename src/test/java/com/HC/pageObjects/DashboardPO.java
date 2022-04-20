package com.HC.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPO {

	WebDriver ldriver;
	
	public DashboardPO(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		

	//Incident Dashboard
	
	
	@FindBy(xpath="//span[contains(text(),'Incident Dashboard')]")
	WebElement btnIncidentdashboard;
	public void clickincidentdashboard()
	{
		btnIncidentdashboard.click();
	}
	
	
	@FindBy(xpath="//*[@name=\"sequence\"]")
	WebElement IRCode;
	public void enterIRCode1(String text){
		IRCode.sendKeys(text);
	}
	
	@FindBy(xpath="(//*[starts-with(@class,\"elements_displayValue__\")])[2]")
	WebElement categorydropdown;
	@FindBy(xpath="//*[@data-testid=\"combobox-Medical\"]")
	WebElement categogyOption;
	public void selectCategory(){
		categorydropdown.click();
		categogyOption.click();
	}

	@FindBy(xpath="//*[@name=\"fromIncidentDateTime\"]")
	WebElement fromInciDateTime;
	public void selectFromInciDateTime(String text){
		fromInciDateTime.click();
		fromInciDateTime.sendKeys(text);
	}

	@FindBy(xpath="//*[@name=\"toIncidentDateTime\"]")
	WebElement toInciDateTime;
	public void selectToInciDateTime(String text){
		toInciDateTime.sendKeys(text);
	}

	@FindBy(xpath="//*[@name=\"fromreportingDate\"]")
	WebElement fromRepoDateTime;
	public void selectFromRepoDate(String text){
		fromRepoDateTime.sendKeys(text);
	}

	@FindBy(xpath="//*[@name=\"toreportingDate\"]")
	WebElement toRepoDateTime;
	public void selectToRepoDate(String text){
		toRepoDateTime.sendKeys(text);
	}

	@FindBy(xpath="(//*[starts-with(@class,\"elements_displayValue__\")])[3]")
	WebElement typeofInci;
	@FindBy(xpath="//*[@data-testid=\"combobox-Unsafe condition\"]")
	WebElement typeofInciOption;
	public void selectTypeofInci() throws InterruptedException{
		fromInciDateTime.click();
		typeofInci.click();
		Thread.sleep(2000);
		typeofInciOption.click();
	}

	@FindBy(xpath="(//*[starts-with(@class,\"elements_displayValue__\")])[4]")
	WebElement investigator;
	@FindBy(xpath="//*[@data-testid=\"combobox-admin\"]")
	WebElement typeofInvestigator;
	public void selectInvestigator(){
		fromInciDateTime.click();
		investigator.click();
		typeofInvestigator.click();
	}

	@FindBy(xpath="(//*[starts-with(@class,\"elements_displayValue__\")])[5]")
	WebElement status;
	@FindBy(xpath="//*[@data-testid=\"combobox-Assigned\"]")
	WebElement statusOption;
	public void selectStatus(){
		fromInciDateTime.click();
		status.click();
		statusOption.click();
	}

	@FindBy(xpath="//*[@class=\"btn secondary\"]")
	WebElement searchButton;
	public void searchButton(){
		searchButton.click();
	}

	@FindBy(xpath="//button[contains(text(),\"Clear\")]")
	WebElement clearButton;
	public void clearButton(){
		clearButton.click();
	}
	
	@FindBy(xpath="//*[@id=\"irBydepartment\"]")
	WebElement myDeptIR;
	public void myDeptIR(){
		myDeptIR.click();
	}

	@FindBy(xpath="//*[starts-with(@class,\"irDashboard_irCode\")]")
	WebElement resultIRcode;
	public boolean resultIRcode(){
		boolean result = resultIRcode.isDisplayed();
		return result;
	}

	public void verifyClear(){
		Assert.assertEquals("", fromInciDateTime.getText());
		Assert.assertEquals("", fromRepoDateTime.getText());
		Assert.assertEquals("", toInciDateTime.getText());
		Assert.assertEquals("", toRepoDateTime.getText());
	}
	
	

	@FindBy(xpath="//button[@title=\"Review IR\"]")
	WebElement viewIRcode;
	public void viewIRcode(){
		viewIRcode.click();
	}

	@FindBy(xpath="//*[contains(text(),\"View\")]")
	WebElement viewInciPage;
	public boolean viewInciPage(){
		boolean page = viewInciPage.isDisplayed();
		return page;
	}
	
	@FindBy(xpath="//*[contains(text(),\"Submitted IRs\")]")
	WebElement submittedIRs;
	public void submittedIRs(){
		submittedIRs.click();
	}
	
	@FindBy(xpath="//*[contains(text(),\"Current Months IRs\")]")
	WebElement currentMonthsIRs;
	public void currentMonthsIRs(){
		currentMonthsIRs.click();
	}

	@FindBy(xpath="//*[contains(text(),\"Open sentinel events\")]")
	WebElement sentinelEvents;
	public void sentinelEvents(){
		sentinelEvents.click();
	}
	
	@FindBy(xpath="//*[contains(text(),\"Open Patient complaints\")]")
	WebElement patientComplaints;
	public void patientComplaints(){
		patientComplaints.click();
	}
	
	

	@FindBy(xpath="//*[@id=\"viewassigned\"]")
	WebElement radioAssignedIRs;
	public void radioAssignedIRs(){
		radioAssignedIRs.click();
	}
	

	@FindBy(xpath="//button[@title=\"Delete\"]")
	WebElement deleteButton;
	public void deleteButton(){
		deleteButton.click();
	}


	@FindBy(xpath="//a[contains(text(),'Quality Dashboard')]")
	WebElement qualityDashboard;
	public void clickQualityDashboard(){
		qualityDashboard.click();
	}
	

	@FindBy(xpath="//input[@name=\"sequence\"]")
	WebElement IRcode;
	public void enterIRcodeQD(String data){
		IRcode.sendKeys(data);
	}
	
	@FindBy(xpath="//*[contains(text(),\"Search\")]")
	WebElement QDsearch;
	public void searchButtonQD(){
		QDsearch.click();
	}
	
	@FindBy(xpath="//*[@data-testid=\"gear-btn\"]")
	WebElement actions;
	public void clickAction(){
		actions.click();
	}

	@FindBy(xpath="//button[@title=\"Assign IR\"]")
	WebElement assignIR;
	public void clickAssignIR(){
		assignIR.click();
	}

	@FindBy(xpath="//button[@title=\"Re-assign IR\"]")
	WebElement reAssignIR;
	public void clickReAssignIR(){
		reAssignIR.click();
	}
	
	@FindBy(xpath="//*[@id=\"portal\"]/div[2]/div[2]/form/section[1]/div/p")
	WebElement selectOption1;
	@FindBy(xpath="//*[@data-testid=\"combobox-admin\"]")
	WebElement assignUser;
	public void selectAssignUser(){
		selectOption1.click();
		assignUser.click();	
	}

	@FindBy(xpath="//*[@data-testid=\"combobox-yashtech\"]")
	WebElement assignUser1;
	public void selectReAssignUser(){
		selectOption1.click();
		assignUser1.click();	
	}
	
	@FindBy(xpath="//button[contains(text(),\"Assign\")]")
	WebElement assignButton;
	public boolean clickAssignButton(){
		assignButton.click();
		return true;
	}

	@FindBy(xpath="//*[contains(text(),\"CODE\")]")
	WebElement IRcodeText;
	public String getIRcode(){
		String text = IRcodeText.getText();
		return text;
	}
	
}
