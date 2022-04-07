package com.HC.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HC.utilities.Constants;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(name="username")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@class='btn wd-100']")
	WebElement btnLogin;
	
	@FindBy(xpath="//button[@data-testid='logout']")
	WebElement btnLogout;
	
//	@FindBy(xpath="//div[@class='incidentReporting_box__3Fr47']/form[@class='incidentReporting_boxContent__9CzgB']/section[1]//input")
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/form[1]/section[1]/div[1]/span[1]/input[1]")
	WebElement datetime;
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/form[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[2]")
	WebElement incidentlocation;
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/form[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[2]")
	WebElement clickincidentlocation;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/form[1]/section[3]/div[1]/span[1]/input[1]")
	WebElement locationdetail;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[2]/div[1]/section[1]/label[1]/input[1]")
	WebElement typeincident;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]")
	WebElement incidentcat;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[2]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[2]")
	WebElement incidentsubcat;
	
	@FindBy(name="inciDescription")
	WebElement incidescrep;
	
	@FindBy(xpath="//button[@class='btn wd-100']")
	WebElement btnsubmit;
	
	@FindBy(xpath="//*[@data-testid='irFormActions']/button[@class='btn secondary w-100'][2]")
	WebElement btnsave;
	
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	WebElement popsave;
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	WebElement popsubmit;

	@FindBy(css="body:nth-child(2) div:nth-child(4) div.prompt div.content > p.question")
	//@FindBy(xpath="//body/div[@id='prompt']/div[2]/div[1]/p[1]/br/preceding::text()")
	static
	WebElement incidentnumber;
	
	@FindBy(xpath="//p[contains(text(),'Invalid credentials.')]")
	WebElement Logincheck;
	
	public String checkloginpage()
	{
		return Logincheck.getText();
	}
	
	public static String getincidentnumber()
	{
		 return incidentnumber.getText();
		// return incidentnumber.getAttribute("innerText");
	}
	
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clicksubmit() throws InterruptedException
	{
		btnLogin.click();
		Thread.sleep(2000);
		ldriver.manage().window().maximize();
	}
	

	public void clicklogout()
	{
		btnLogout.click();
	}
	
	public void incidentsave()
	{
		btnsave.click();
	}
	
	public void incidentsubmit()
	{
		btnsubmit.click();
	}
	
	public boolean popsave()
	{
		popsave.click();
		return true;
	}
	
	public void popsubmit()
	{
		popsubmit.click();
	}
	
	public void intdate(String date)
	{
		datetime.sendKeys(date);
	}
	
	public void settypeincident()
	{
		typeincident.click();
	}
	

	public void setIncicatclick()
	{
		
		incidentcat.click();
	}
	public void setIncicat(String cat)
	{
		//return setIncicat(cat);
		incidentcat.sendKeys(cat);
	}
	
	public void setincidentlocation(String loc)
	{
		incidentlocation.sendKeys(loc);
	}
	
	public void clickincidentlocation()
	{
		clickincidentlocation.click();
	}
	
	public void setlocationdetail(String detail)
	{
		locationdetail.sendKeys(detail);
	}
	
	public void setincidentsubcat(String subcat)
	{
		incidentsubcat.sendKeys(subcat);
	}
	
	public void setincidescrep(String incides)
	{
		incidescrep.sendKeys(incides);
	}

	public void setIncicat1(Keys arrowDown, Keys enter) {
		incidentcat.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	}
	
	public void setincidentlocation1(Keys arrowDown, Keys enter) {
		incidentlocation.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	}
	
	public void setincidentsubcat1(Keys arrowDown, Keys enter) {
		incidentsubcat.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	}

	
	
	//Incident Dashboard
	
	@FindBy(xpath="//span[contains(text(),'Incident Dashboard')]")
	WebElement btnIncidentdashboard;
	
	
	public void clickincidentdashboard()
	{
		btnIncidentdashboard.click();
	}
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/form[1]/section[1]/div[1]/span[1]/input[1]")
	WebElement sendIRcode;
	
	public void enterIRcode(String IRcode)
	{
		sendIRcode.sendKeys(IRcode);
	}
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/form[1]/section[1]/div[1]/span[1]/input[1]")
	WebElement clickIRcode;
	public void clickcode()
	{
		clickIRcode.click();
	}
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/main[1]/div[1]/div[2]/form[1]/section[8]/button[1]")
	WebElement clicksearch;
	
	public void dashboardsearch()
	{
		clicksearch.click();
	}
	
	@FindBy(xpath="//tbody/tr[1]/td[1]")
	WebElement verifyIrcode;
	
	public String verifyCode()
	{
		return verifyIrcode.getText();
	}
	
	//Below is the newly added code
	

	@FindBy(xpath="//*[@name=\"multiSelectScoreCheckbox91284\" and @value=\"1\"]")
	WebElement checkBoxText;
	public void selectCheckBoxText(){
		checkBoxText.click();
	}

	@FindBy(xpath="//*[@name=\"multiSelectScoreCheckbox34901\" and @value=\"1\"]")
	WebElement checkScore;
	public void selectCheckScore(){
		checkScore.click();
	}

	@FindBy(xpath="//*[@class=\"reactSelect__input\" and @aria-describedby=\"react-select-5-placeholder\"]")
	WebElement deptInvolved;
	public void selectDeptInvolved(String dept){
		deptInvolved.sendKeys(dept,Keys.RETURN);
	}

	@FindBy(xpath="//*[@id=\"preventability1\"]")
	WebElement preventability;
	public void selectpreventability(){
		preventability.click();
	}

	@FindBy(xpath="//*[@name=\"immedActionTaken\"]")
	WebElement immedActionTaken;
	public void immedActionTakenText(String text){
		immedActionTaken.sendKeys(text);
	}

	@FindBy(xpath="//*[@aria-describedby=\"react-select-6-placeholder\"]")
	WebElement immedActionTakenBy;
	public void selectImmedActionTakenBy(String text){
		immedActionTakenBy.sendKeys(text,Keys.RETURN);
	}

	@FindBy(xpath="//*[@name=\"accessDateTime\"]")
	WebElement actionTakenDateTime;
	public void selectActionTakenDateTime(String text){
		actionTakenDateTime.sendKeys(text);
	}

	@FindBy(xpath="//*[@aria-describedby=\"react-select-7-placeholder\"]")
	WebElement witnessedBy;
	public void selectWitnessedBy(String text){
		witnessedBy.sendKeys(text,Keys.RETURN);
	}

	@FindBy(xpath="//*[@aria-describedby=\"react-select-8-placeholder\"]")
	WebElement notifiedTo;
	public void selectNotifiedTo(String text){
		notifiedTo.sendKeys(text,Keys.RETURN);
	}

	@FindBy(xpath="//*[@name=\"notificationDateTime\"]")
	WebElement notifiedDateTime;
	public void selectNotifiedDateTime(String text){
		notifiedDateTime.sendKeys(text);
	}

	@FindBy(xpath="//*[@aria-controls=\"react-select-9-listbox\"]")
	WebElement headofDept;
	public void selectHeadofDept(String text){
		headofDept.sendKeys(text,Keys.RETURN);
	}

	@FindBy(xpath="//button[@title=\"Edit\"]")
	WebElement editButton;
	public void editButton(){
		editButton.click();
	}

	@FindBy(xpath="//*[@id=\"anonymous\"]")
	WebElement anonymous;
	public void clickAnonymous(){
		anonymous.click();
	}
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	WebElement popAnonymous;
	public void popClickAnonymous(){
		popAnonymous.click();
	}

	@FindBy(xpath="//*[@class=\" elements_on__1LxVi\"]")
	WebElement patientCompliantYes;
	public void patientCompliantYes(){
		patientCompliantYes.click();
	}

	@FindBy(xpath="//*[@name=\"complaIntegerDatetime\"]")
	WebElement complaintDateTime;
	public void selectComplaintDateTime(String date){
		complaintDateTime.sendKeys(date);
	}
	
	@FindBy(xpath="//*[@name=\"complaIntegerIdEntry\"]")
	WebElement complaintID;
	public void complaintID(String date){
		complaintID.sendKeys(date);
	}

	@FindBy(xpath="//button[@title=\"Delete\"]")
	WebElement deleteButton;
	public void deleteButton(){
		deleteButton.click();
	}

	@FindBy(xpath="//button[contains(text(),'Yes')]")
	WebElement popDelete;
	public boolean popClickDelete(){
		popDelete.click();
		return true;
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
	
	@FindBy(xpath="//*[@class=\"elements_sort__3eqm9\"]")
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

	//@FindBy(xpath="//*[")
	//WebElement fileUpload;
	public void clickFileUpload() throws InterruptedException, AWTException{
		Actions act= new Actions(ldriver);
		  WebElement chooseFile=ldriver.findElement(By.xpath("//*[@class=\"elements_fileNames__2Jemg\"]"));
		  act.moveToElement(chooseFile).click().perform();
		  Thread.sleep(2000);

		  StringSelection obj= new StringSelection(Constants.Path_FileUpload);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);
		  Thread.sleep(4000);
		  
		  Robot rb= new Robot();
		  rb.keyPress(KeyEvent.VK_CONTROL);
		  rb.keyPress(KeyEvent.VK_V);
		  rb.keyRelease(KeyEvent.VK_CONTROL);
		  rb.keyRelease(KeyEvent.VK_V);
		  rb.keyPress(KeyEvent.VK_ENTER);
		  rb.keyRelease(KeyEvent.VK_ENTER);
		  
		  Thread.sleep(2000);
		  
		  System.out.println("file uploaded successfully");
	}
	
	

	@FindBy(xpath="//*[@type=\"button\" and contains(text(),\"Clear\")]")
	WebElement IRclearButton;
	public void IRclearButton(){
		IRclearButton.click();
	}

	public String verifyClearIR(){
		String text = immedActionTaken.getText();
		return text;
	}
	
	
	
	//Incident Dashboard
	
	@FindBy(xpath="//*[@name=\"sequence\"]")
	WebElement IRCode;
	public void enterIRCode1(String text){
		IRCode.sendKeys(text);
	}
	
	@FindBy(xpath="(//*[@class=\"elements_displayValue__9jUr4 elements_placeholder__1Yfip\"])[2]")
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
	
	@FindBy(xpath="(//*[@class=\"elements_displayValue__9jUr4 elements_placeholder__1Yfip\"])[2]")
	WebElement typeofInci;
	@FindBy(xpath="//*[@data-testid=\"combobox-Unsafe condition\"]")
	WebElement typeofInciOption;
	public void selectTypeofInci() throws InterruptedException{
		fromInciDateTime.click();
		typeofInci.click();
		Thread.sleep(2000);
		typeofInciOption.click();
	}
	
	@FindBy(xpath="(//*[@class=\"elements_displayValue__9jUr4 elements_placeholder__1Yfip\"])[2]")
	WebElement investigator;
	@FindBy(xpath="//*[@data-testid=\"combobox-admin\"]")
	WebElement typeofInvestigator;
	public void selectInvestigator(){
		fromInciDateTime.click();
		investigator.click();
		typeofInvestigator.click();
	}

	@FindBy(xpath="(//*[@class=\"elements_displayValue__9jUr4 elements_placeholder__1Yfip\"])[2]")
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

	@FindBy(xpath="//*[@class=\"btn clear irDashboard_clear__39fwt\"]")
	WebElement clearButton;
	public void clearButton(){
		clearButton.click();
	}
	
	@FindBy(xpath="//*[@id=\"irBydepartment\"]")
	WebElement myDeptIR;
	public void myDeptIR(){
		myDeptIR.click();
	}

	@FindBy(xpath="//*[@class=\"irDashboard_irCode__3cRB0\"]")
	WebElement resultIRcode;
	public boolean resultIRcode(){
		boolean result = resultIRcode.isDisplayed();
		return result;
	}

	public String verifyClear(){
		String result = fromInciDateTime.getText();
		return result;
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
	
	
	
}
