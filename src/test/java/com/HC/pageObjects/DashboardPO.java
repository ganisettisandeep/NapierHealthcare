package com.HC.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy(xpath="(//*[starts-with(@class,\"irDashboard_irCode\")])[1]")
	WebElement getIRcodeText;
	public String getIRcodeText(){
		String text = getIRcodeText.getText();
		return text;
	}

	@FindBy(xpath="//button[@title=\"[object Object]\"][2]")
	WebElement acknowledgeIR;
	public void clickAcknowledgeIR(){
		acknowledgeIR.click();
	}

	@FindBy(xpath="//button[@title=\"Acknowledge IR\"]")
	WebElement inciAcknowledge;
	public void clickInciAcknowledge(){
		inciAcknowledge.click();
	}

	@FindBy(xpath="//button[contains(text(),\"Acknowledge\")]")
	WebElement buttonAcknowledge;
	public void buttonAcknowledge(){
		buttonAcknowledge.click();
	}
	
	@FindBy(xpath="//textarea[@name=\"remark\"]")
	WebElement remark;
	public void enterRemark(String text){
		remark.sendKeys(text);
	}

	@FindBy(xpath="//button[contains(text(),\"Clear\")]/following-sibling::button[1]")
	WebElement confirmAcknowledge;
	public void confirmAcknowledge(){
		confirmAcknowledge.click();
	}
	
	
	@FindBy(xpath="//button[contains(text(),\"Ok\")]")
	WebElement buttonOk;
	public void buttonOk(){
		buttonOk.click();
	}

	@FindBy(xpath="//*[starts-with(@class,\"incidentReporting_icon\")]")
	WebElement assertAcknowledge;
	public void assertAcknowledge(){
		assertAcknowledge.isDisplayed();
	}

	@FindBy(xpath="//*[starts-with(@class,\"incidentReporting_ack_\")]")
	WebElement assertAcknowledgeBanner;
	public void assertAcknowledgeBanner(){
		assertAcknowledgeBanner.isDisplayed();
	}
	
	@FindBy(xpath="//*[@stroke=\"currentColor\" and @style='color: rgb(21, 164, 40);']//parent::button")
	WebElement assertFlag;
	public void assertFlag(){
		actions.click();
		assertFlag.isDisplayed();
	}
	
	
	
	@FindBy(xpath="//td[starts-with(@class,\"irDashboard_irCode\")]/following-sibling::td[9]")
	WebElement statusText;
	public String getStatusText(JavascriptExecutor js){
		js.executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", table);
		String text = statusText.getText();
		return text;
	}
	
	
	@FindBy(xpath="//button[@title=\"IR Investigation\"]")
	WebElement investigationButton;
	public void clickInvestigationButton(){
		investigationButton.click();
	}
	
	@FindBy(xpath="//button[contains(text(),\"Request for Input\")]")
	WebElement requestForInput;
	public void clickRequestForInput(){
		requestForInput.click();
	}
	
	@FindBy(xpath="(//input[@class=\"reactSelect__input\"])[1]")
	WebElement clickDepart;
	public void selectDepartment(String dept){
		clickDepart.sendKeys(dept,Keys.RETURN);
	}
	
	@FindBy(xpath="(//input[@class=\"reactSelect__input\"])[2]")
	WebElement clickUser;
	public void selectUser(String user){
		clickUser.sendKeys(user,Keys.RETURN);
	}
	
	@FindBy(xpath="//*[@name=\"irInformation\"]/..")
	WebElement IRinfo;
	@FindBy(xpath="//*[@data-testid=\"combobox-Description\"]")
	WebElement Desc;
	public void selectIRinfo(){
		IRinfo.click();
		Desc.click();
	}

	@FindBy(xpath="//*[@name=\"query\"]")
	WebElement query;
	public void inputQuery(String user){
		query.sendKeys(user);
	}

	@FindBy(xpath="//button[contains(text(),\"Submit Query\")]")
	WebElement submitQuery;
	public void submitQuery(){
		submitQuery.click();
	}
	
	//IR Query Dashboard
	@FindBy(xpath="//*[contains(text(),\"IR Query Dashboard\")]")
	WebElement IRQueryDashboard;
	public void IRQueryDashboard(){
		IRQueryDashboard.click();
	}
	
	@FindBy(xpath="(//*[@title=\"Reponse\"])[1]")
	WebElement viewResponse;
	public void viewResponse(){
		viewResponse.click();
	}

	@FindBy(xpath="//*[@name=\"response\"]")
	WebElement responseText;
	public void responseText(String resp){
		responseText.sendKeys(resp);
	}
	
	@FindBy(xpath="//button[text()=\"Submit\"]")
	WebElement responseSubmit;
	public void responseSubmit(){
		responseSubmit.click();
	}
	
	@FindBy(xpath="//button[contains(text(),\"Record Inputs\")]")
	WebElement recordInputs;
	public void recordInputs(){
		recordInputs.click();
	}

	@FindBy(xpath="//*[@name=\"source\"]")
	WebElement evidenceSource;
	public void evidenceSource(String text){
		evidenceSource.sendKeys(text);
	}

	@FindBy(xpath="//input[@name=\"recievedOn\"]")
	WebElement recievedOn;
	public void recievedOn(String date){
		recievedOn.sendKeys(date);
	}

	@FindBy(xpath="//button[contains(text(),\"Submit Response\")]")
	WebElement submitResponse;
	public void submitResponse(){
		submitResponse.click();
	}

	@FindBy(xpath="//*[starts-with(@class,\"elements_tableActions\")]/preceding-sibling::td[1]")
	WebElement TAT;
	@FindBy(xpath="//*[starts-with(@class,\"elements_table_\")]")
	WebElement table;
	public void clickTAT(JavascriptExecutor js) throws InterruptedException{
		boolean f =TAT.isEnabled();
		System.out.println(f);
		js.executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", table);
		Thread.sleep(2000);
		TAT.click();
	}

	@FindBy(xpath="//*[starts-with(@class,\"irDashboard_totalDays\")]")
	WebElement getTAT;
	@FindBy(xpath="//button[text()=\"Close\"]")
	WebElement closeButton;
	public String getTAT(){
		String TAT = getTAT.getText();
		closeButton.click();
		return TAT;
	}


	@FindBy(xpath="//th[contains(text(),\"Days\")]//parent::tr//parent::thead/following-sibling::tbody/tr[1]/td[1]")
	WebElement getStatus;
	public String getStatus(){
		String status = getStatus.getText();
		return status;
	}

	@FindBy(xpath="//*[starts-with(@class,\"elements_tableActions\")]/preceding-sibling::td[1]")
	WebElement getTATlink;
	public String getTATlink(){
		String TAT = getTATlink.getText();
		return TAT;
	}
	

	@FindBy(xpath="//*[starts-with(@class,\"irDashboard_irDetail\")]/child::li[1]")
	WebElement IRcodePopup;
	public String IRcodePopup(){
		String IRcode = IRcodePopup.getText();
		return IRcode;
	}

	@FindBy(xpath="//*[starts-with(@class,\"irDashboard_irDetail\")]/child::li[2]")
	WebElement DateTimePopup;
	public String getDateTimePopup(){
		String getDateTimePopup = DateTimePopup.getText();
		return getDateTimePopup;
	}

	@FindBy(xpath="//*[starts-with(@class,\"irDashboard_irDetail\")]/child::li[3]")
	WebElement IncidentTypePopup;
	public String IncidentTypePopup(){
		String getIncidentTypePopup = IncidentTypePopup.getText();
		return getIncidentTypePopup;
	}
	

	@FindBy(xpath="//td[starts-with(@class,\"irDashboard_irCode\")]/following-sibling::td[2]")
	WebElement inciDateTime;
	public String getinciDateTime(){
		String text = inciDateTime.getText();
		return text;
	}
	
	
	
	//(//*[starts-with(@class,"irDashboard_tat")])[31]
	//(//*[starts-with(@class,"irDashboard_tat")])[2]
	
	//div/table/tbody/tr/td[contains(text(),"Assigned")]
	//(//td[contains(text(),"Assigned")])[3]/following-sibling::td[2]
	//(//td[contains(text(),"Submitted")])[1]/following-sibling::td[2]
	//div/table/thead/tr/th[contains(text(),"Days")]//parent::tr//parent::thead/following-sibling::tbody/tr/td
	//*[starts-with(@class,"irDashboard_irDetail")]/child::li[6]
	
}

