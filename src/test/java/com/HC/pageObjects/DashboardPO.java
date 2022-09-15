package com.HC.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
		IRcode.clear();
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
	public boolean assertAcknowledge(){
		boolean f3 = assertAcknowledge.isDisplayed();
		return f3;
	}

	@FindBy(xpath="//*[starts-with(@class,\"incidentReporting_ack_\")]")
	WebElement assertAcknowledgeBanner;
	public boolean assertAcknowledgeBanner(){
		boolean f2 = assertAcknowledgeBanner.isDisplayed();
		return f2;
	}
	
	@FindBy(xpath="//*[@stroke=\"currentColor\" and @style='color: rgb(21, 164, 40);']//parent::button")
	WebElement assertFlag;
	public boolean assertFlag(){
		actions.click();
		boolean f1 = assertFlag.isDisplayed();
		return f1;
	}
	
	
	
	@FindBy(xpath="//td[starts-with(@class,\"irDashboard_irCode\")]/following-sibling::td[9]")
	WebElement statusText;
	public String getStatusText(JavascriptExecutor js){
		js.executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", table);
		String text = statusText.getText();
		return text;
	}

	@FindBy(xpath="//*[contains(text(),'IR Configuration')]")
	WebElement IRConfiguration;
	public void IRConfiguration(){
		IRConfiguration.click();
	}
	
	@FindBy(xpath="(//*[@data-testid=\"toggleInput\"])[8]")
	WebElement riskAssessment;
	public boolean isRiskAssessment(){
		String classR1 = riskAssessment.getAttribute("class");
		System.out.println(classR1);
		boolean isEnabled = classR1.contains("elements_on");
		return isEnabled;
	}
	
	public void enableRiskAssessment(){
		riskAssessment.click();
	}

	@FindBy(xpath="(//*[@data-testid=\"toggleInput\"])[9]")
	WebElement selfReporting;
	public boolean isSelfReporting(){
		String classR1 = selfReporting.getAttribute("class");
		System.out.println(classR1);
		boolean isEnabled = classR1.contains("elements_on");
		return isEnabled;
	}
	
	public void enableSelfReporting(){
		selfReporting.click();
	}

	@FindBy(xpath="(//*[@data-testid=\"toggleInput\"])[10]")
	WebElement IPSGtype;
	public boolean isIPSGtype(){
		String classR1 = IPSGtype.getAttribute("class");
		System.out.println(classR1);
		boolean isEnabled = classR1.contains("elements_on");
		return isEnabled;
	}
	
	public void enableIPSGtype(){
		IPSGtype.click();
	}

	@FindBy(xpath="(//*[contains(text(),\"Save\")])[8]")
	WebElement configSave;
	public void configSave(){
		boolean f2 = configSave.isEnabled();
		System.out.println("save flag: "+f2);
		//configSave.click();
		//configSave.isEnabled()
		configSave.getAttribute("disabled");
	}
	
	@FindBy(xpath="//button[@title=\"IR Investigation\"]")
	WebElement investigationButton;
	public void clickInvestigationButton(){
		investigationButton.click();
	}

	@FindBy(xpath="//*[@class=\"promptLabel\"]")
	WebElement startIRinvestigation;
	public boolean isStartIRinvestigation(){
		boolean startInvestigation = startIRinvestigation.isDisplayed();
		return startInvestigation;
	}
	
	@FindBy(xpath="//button[text()='Yes']")
	WebElement IRinvestigationYes;
	public void IRinvestigationYes(){
		IRinvestigationYes.click();
	}
	
	@FindBy(xpath="//button[text()='No']")
	WebElement IRinvestigationNo;
	public void IRinvestigationNo(){
		IRinvestigationNo.click();
	}

	@FindBy(xpath="//h3[contains(text(),'IR INVESTIGATION')]")
	WebElement IRinvestigationPage;
	public boolean IRinvestigationPage(){
		boolean IRinvestigationPageHeader = IRinvestigationPage.isDisplayed();
		return IRinvestigationPageHeader;
	}
	
	@FindBy(xpath="//h3[text()='INCIDENT REPORTING DASHBOARD']")
	WebElement IRincidentReportingDashboardPage;
	public boolean IRincidentReportingDashboardPage(){
		boolean IRincidentReportingDashboardPageHeader = IRincidentReportingDashboardPage.isDisplayed();
		return IRincidentReportingDashboardPageHeader;
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
	@FindBy(xpath="//*[@data-testid='combobox-Description']")
	WebElement Desc;
	public void selectDescription(){
		IRinfo.click();
		Desc.click();
	}
	
	@FindBy(xpath="//*[@data-testid='combobox-Departments Involved']")
	WebElement departmentsInvolved;
	public void selectdepartmentsInvolved(){
		departmentsInvolved.click();
	}

	@FindBy(xpath="//*[@data-testid='combobox-Copy From Previous']")
	WebElement copyFromPrevious;
	public boolean isCopyFromPreviousDisplayed(){
		boolean flag = copyFromPrevious.isDisplayed();
		return flag;
	}

	public void selectCopyFromPrevious(){
		copyFromPrevious.click();
	}
	
	@FindBy(xpath="//*[@name=\"query\"]")
	WebElement query;
	public void inputQuery(String user){
		query.sendKeys(user);
	}
	
	public void editedInputQuery(String user){
		query.clear();
		query.sendKeys(user);
	}

	@FindBy(xpath="//button[contains(text(),'Submit Query')]")
	WebElement submitQuery;
	public void submitQuery(){
		submitQuery.click();
	}

	@FindBy(xpath="//p[text()='Request submitted successfully.']")
	WebElement successMsg;
	@FindBy(xpath="//button[text()='Ok']")
	WebElement okButton;
	public boolean assertRequestSubmit(){
		boolean msg = successMsg.isDisplayed();
		okButton.click();
		return msg;
	}
	
	
	//IR Query Dashboard
	@FindBy(xpath="//*[contains(text(),\"IR Query Dashboard\")]")
	WebElement IRQueryDashboard;
	public void IRQueryDashboard(){
		IRQueryDashboard.click();
	}
	
	@FindBy(xpath="//input[@name=\"irCode\"]")
	WebElement IRcodeQueryDB;
	public void enterIRcodeQueryDB(String code){
		IRcodeQueryDB.sendKeys(code);
	}
	
	@FindBy(xpath="(//*[@title=\"Response\"])[1]")
	WebElement viewResponse;
	public void viewResponse(){
		viewResponse.click();
	}

	@FindBy(xpath="//*[@name=\"response\"]")
	WebElement responseText;
	public void responseText(String resp){
		responseText.sendKeys(resp);
	}

	@FindBy(xpath="//*[starts-with(@class,\"irDashboard_innerWrapper__\")]/child::p[1]")
	WebElement assertQuery;
	public String assertQuery(){
		String requestQuery = assertQuery.getText();
		return requestQuery;
	}
	
	@FindBy(xpath="//button[text()=\"Submit\"]")
	WebElement responseSubmit;
	public void responseSubmit(){
		responseSubmit.click();
	}

	@FindBy(xpath="(//button[@title=\"View\"])[1]")
	WebElement viewButton;
	public void viewSubmittedResponse(){
		viewButton.click();
	}

	@FindBy(xpath="//*[starts-with(@class,\"style_responses__\")]/child::li/child::p[2]")
	WebElement assertResponse;
	public String assertResponse(){
		String response = assertResponse.getText();
		return response;
	}

	@FindBy(xpath="//button[text()='Close']")
	WebElement closeButtonRequest;
	public void clickCloseButton(){
		closeButtonRequest.click();
	}

	@FindBy(xpath="(//*[@title='Delete'])[2]")
	WebElement deleteButtonRequest;
	public void clickDeleteButtonRequest(){
		deleteButtonRequest.click();
	}

	@FindBy(xpath="//a[contains(text(),'Back to IR Dashboard')]")
	WebElement BacktoDashboard;
	public void BacktoDashboard(){
		BacktoDashboard.click();
	}

	@FindBy(xpath="//button[contains(text(),\"Record Inputs\")]")
	WebElement recordInputs;
	public void recordInputs(){
		recordInputs.click();
	}

	@FindBy(xpath="//*[@name='responseFrom']")
	WebElement loggedUser;
	public String getUser(){
		String user = loggedUser.getAttribute("value");
		return user;
	}

	@FindBy(xpath="//*[@name='dept']//parent::div")
	WebElement department;
	@FindBy(xpath="//*[starts-with(@class,\"elements_options__\")]/child::li[3]")
	WebElement deptOption;
	public String selectDept(){
		department.click();
		String dept = deptOption.getText();
		deptOption.click();
		return dept;
	}
	
	@FindBy(xpath="//*[@name='source']//parent::div")
	WebElement evidenceSource;
	@FindBy(xpath="//*[@data-testid='combobox-Test 1']")
	WebElement sourceOption;
	public void evidenceSource() throws InterruptedException{
		evidenceSource.click();
		Thread.sleep(2000);
		sourceOption.click();
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

	@FindBy(xpath="//p[text()='Record submitted successfully.']")
	WebElement successMsgRecord;
	@FindBy(xpath="//button[text()='Ok']")
	WebElement okButtonRecord;
	public boolean assertRecordSubmit(){
		boolean msg = successMsgRecord.isDisplayed();
		okButtonRecord.click();
		return msg;
	}

	@FindBy(xpath="//p[text()='Response submitted successfully.']")
	WebElement successMsgResp;
	@FindBy(xpath="//button[text()='Ok']")
	WebElement okButtonResp;
	public boolean assertRespSubmit(){
		boolean msg = successMsgResp.isDisplayed();
		okButtonResp.click();
		return msg;
	}
	
	@FindBy(xpath="//tbody/tr/td[4]")
	WebElement getDepts;
	public ArrayList<String> getDepts(){
		ArrayList<String> ar = new ArrayList<String>();
		List<WebElement> text1 = getDepts.findElements(By.xpath("//tbody/tr/td[4]"));
		for(WebElement a:text1) {
			ar.add(a.getText());
		}
		return ar;
	}

	@FindBy(xpath="//*[contains(text(),'Raised on')]/following-sibling::div/span/input")
	WebElement getRaisedOnDateTime;
	public String getRaisedOnDateTime(){
		String date = getRaisedOnDateTime.getAttribute("value");
		return date;
	}

	@FindBy(xpath="//*[contains(text(),'Raised by')]/following-sibling::div/span/input")
	WebElement getRaisedBy;
	public String getRaisedBy(){
		String raisedBy = getRaisedBy.getAttribute("value");
		return raisedBy;
	}
	
	@FindBy(xpath="//*[@name='copyPrev']")
	WebElement previousText;
	public String getPreviousText(){
		String previousText1 = previousText.getAttribute("value");
		return previousText1;
	}
	

	@FindBy(xpath="//tbody/tr/td[1]")
	WebElement getQueryDateTime;
	public ArrayList<String> getQueryDateTime(){
		ArrayList<String> ar = new ArrayList<String>();
		List<WebElement> text1 = getResDateTime.findElements(By.xpath("//tbody/tr/td[1]"));
		for(WebElement a:text1) {
			ar.add(a.getText());
		}
		return ar;
	}
	
	
	public void clickEditInputs(int id) {
		getResDateTime.findElement(By.xpath("(//button[@title='Edit'])["+id+"]")).click();
	}

	@FindBy(xpath="//tbody/tr/td[5]")
	WebElement getResDateTime;
	public ArrayList<String> getResDateTime(){
		ArrayList<String> ar = new ArrayList<String>();
		List<WebElement> text1 = getResDateTime.findElements(By.xpath("//tbody/tr/td[5]"));
		for(WebElement a:text1) {
			ar.add(a.getText());
		}
		return ar;
	}

	@FindBy(xpath="//tbody/tr/td[4]")
	WebElement getDept;
	public ArrayList<String> getDept(){
		ArrayList<String> ar = new ArrayList<String>();
		List<WebElement> text1 = getDept.findElements(By.xpath("//tbody/tr/td[4]"));
		for(WebElement a:text1) {
			ar.add(a.getText());
		}
		return ar;
	}

	@FindBy(xpath="//tbody/tr[1]/td[1]")
	WebElement queryDateTime;
	public boolean assertQueryDateTime(int element){
		String text1 = queryDateTime.findElement(By.xpath("//tbody/tr["+element+"]/td[1]")).getText();
		System.out.println("text1 is: "+text1);
		boolean flagDT = text1.equals("");
		return flagDT;
	}

	@FindBy(xpath="//tbody/tr[1]/td[2]")
	WebElement queryBy;
	public boolean assertQueryBy(int element){
		String text2 = queryBy.findElement(By.xpath("//tbody/tr["+element+"]/td[2]")).getText();
		System.out.println("text2 is: "+text2);
		boolean flagDT = text2.equals("");
		return flagDT;
	}
	
	@FindBy(xpath="//*[starts-with(@class,\"irDashboard_irCode\")]")
	WebElement beyondTATsymbol;
	public boolean assertBeyondTATsymbol(){
		boolean symbol = beyondTATsymbol.isDisplayed();
		return symbol;
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
	
	//IR Details page
	
	@FindBy(xpath="//*[contains(text(),'IR Details')]")
	WebElement IRdetailsTab;
	public void clickIRdetailsTab(){
		IRdetailsTab.click();
	}

	@FindBy(xpath="//*[@id=\"prevSimilarfalse\"]")
	WebElement NoRadioButton;
	public void clickNoRadioButton(){
		NoRadioButton.click();
	}

	@FindBy(xpath="//*[@name=\"details\"]")
	WebElement details;
	public void enterDetails(String text){
		details.sendKeys(text);
	}
	
	@FindBy(xpath="(//*[@name=\"dateTime\"])[1]")
	WebElement TableEventsDateTime;
	public void TableEventsDateTime(String text){
		TableEventsDateTime.sendKeys(text);
	}

	@FindBy(xpath="(//*[contains(text(),'Add')])[1]")
	WebElement addButton;
	public void clickAddButton(){
		addButton.click();
	}

	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement editAddButton;
	public void editAddButton(){
		editAddButton.click();
	}

	@FindBy(xpath="//tbody/tr/td[3]")
	WebElement eventTime;
	public ArrayList<String> assertEvent(){
		ArrayList<String> ar = new ArrayList<String>();
		List<WebElement> text1 = eventTime.findElements(By.xpath("//tbody/tr/td[3]"));
		for(WebElement a:text1) {
			ar.add(a.getText());
		}
		return ar;
	}

	@FindBy(xpath="//tbody/tr/td[2]")
	WebElement eventDetails;
	public ArrayList<String> assertEventDetails(){
		ArrayList<String> ar = new ArrayList<String>();
		List<WebElement> text1 = eventDetails.findElements(By.xpath("//tbody/tr/td[2]"));
		for(WebElement a:text1) {
			ar.add(a.getText());
		}
		return ar;
	}
	
	@FindBy(xpath="(//button[@title='Edit'])[1]")
	WebElement eventEditButton;
	public void clickEditButton(){
		eventEditButton.click();
	}

	public String isDetailsNull(){
		String detailsEvent = details.getText();
		details.clear();
		return detailsEvent;
	}


	@FindBy(xpath="(//button[@title='Delete'])[1]")
	WebElement eventDeleteButton;
	@FindBy(xpath="//td[starts-with(@class,'handle style_handle')]")
	WebElement noOfEvents;
	public int clickDeleteButton(){
		List<WebElement> events = noOfEvents.findElements(By.xpath("//td[starts-with(@class,'handle style_handle')]"));
		eventDeleteButton.click();
		return events.size();
	}
	

	@FindBy(xpath="//*[@class='promptLabel' and text()='CONFIRMATION']")
	WebElement deleteConfirmation;
	public boolean deleteConfirmation(){
		boolean deletePopup = deleteConfirmation.isDisplayed();
		return deletePopup;
	}

	@FindBy(xpath="//button[text()='Yes']")
	WebElement confirmationYes;
	public void confirmationYes(){
		confirmationYes.click();
	}

	public int noOfEvents(){
		List<WebElement> events = noOfEvents.findElements(By.xpath("//td[starts-with(@class,'handle style_handle')]"));
		return events.size();
	}

	
	//Risk Assessment section Displayed
	@FindBy(xpath="//h4[text()='RISK ASSESSMENT']")
	WebElement riskAssessmentDisplayed;
	public boolean isRiskAssessmentDisplayed(){
		boolean riskAssess = riskAssessmentDisplayed.isDisplayed();
		return riskAssess;
	}
	

	//Severity
	@FindBy(xpath="(//*[starts-with(@class,\"elements_displayValue__\")])[2]//parent::div")
	WebElement severityDropdown;
	@FindBy(xpath="//*[@data-testid='combobox-Major']")
	WebElement optionMajor;
	public void selectSeverity(){
		severityDropdown.click();
		optionMajor.click();
	}
	
	//Likelihood
	@FindBy(xpath="(//*[starts-with(@class,\"elements_displayValue__\")])[3]//parent::div")
	WebElement LikelihoodDropdown;
	@FindBy(xpath="//*[@data-testid='combobox-High']")
	WebElement optionHigh;
	public void selectLikelihood(){
		LikelihoodDropdown.click();
		optionHigh.click();
	}

	// Risk included in Risk Register as No
	@FindBy(xpath="//*[@id=\"riskIncludedfalse\"]")
	WebElement NoRadiobutton;
	public void selectRiskRadioButton(){
		NoRadiobutton.click();
	}
	
	
	// Risk inlcuded in Risk Register as Yes
	@FindBy(xpath="//*[@id='riskIncludedtrue']")
	WebElement YesRadiobutton;
	public void selectRiskRadioButtonYes(){
		YesRadiobutton.click();
	}
	
	//Risk ID
	@FindBy(xpath="//input[@name='riskId']")
	WebElement RiskID;
	public void enterRiskID(String riskid){
		RiskID.sendKeys(riskid);
	}

	//self reporting section
	@FindBy(xpath="//label[text()='Self reporting']")
	WebElement isSelfReporting;
	public boolean isSelfReportingDisplayed(){
		boolean selfReporting = isSelfReporting.isDisplayed();
		return selfReporting;
	}
	
	//self reporting No button
	@FindBy(xpath="//input[@id='selfRepfalse']")
	WebElement notesNoButton;
	public void selectSelfReporting(){
		notesNoButton.click();
	}
	
	//self reporting Yes button
	@FindBy(xpath="//input[@id='selfReptrue']")
	WebElement notesYesButton;
	public void selectSelfReportingYes(){
		notesYesButton.click();
	}
		
		
	//NotesName
	@FindBy(xpath="//input[@class=\"reactSelect__input\"]")
	WebElement notesName;
	public void selectName(String name){
		notesName.sendKeys(name, Keys.RETURN);
	}

	//self reporting section
	@FindBy(xpath="//label[text()='IPSG Breach']")
	WebElement isIPSGbreach;
	public boolean isIPSGbreachDisplayed(){
		boolean IPSGbreach = isIPSGbreach.isDisplayed();
		return IPSGbreach;
	}
	
	//Notes_NotesName
	@FindBy(xpath="//input[@name=\"notes\"]")
	WebElement notes;
	public void enterNotes(String name){
		notes.sendKeys(name);
	}
	
	//Notes_Date&Time
	@FindBy(xpath="(//*[@name=\"dateTime\"])[2]")
	WebElement NotesDateTime;
	public void selectDateTime(String text){
		NotesDateTime.sendKeys(text);
	}
	
	//Notes_Add button
	@FindBy(xpath="(//*[contains(text(),'Add')])[2]")
	WebElement NotesaddButton;
	public void clickNotesAddButton(){
		NotesaddButton.click();
	}

	@FindBy(xpath="//tbody/tr/td[2]")
	WebElement notesTime;
	public ArrayList<String> assertNotes(){
		ArrayList<String> ar = new ArrayList<String>();
		List<WebElement> text1 = notesTime.findElements(By.xpath("//tbody/tr/td[2]"));
		for(WebElement a:text1) {
			ar.add(a.getText());
		}
		return ar;
	}
	
	
	//submit button
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement IRdetailsSubmitButton;
	public void SubmitButton(){
		IRdetailsSubmitButton.click();
	}

	@FindBy(xpath="//*[contains(text(),'Investigation detail has been successfully saved.')]")
	WebElement successResponse;
	public boolean assertSuccessResponse(){
		boolean f3 = successResponse.isDisplayed();
		return f3;
	}

	@FindBy(xpath="//button[contains(text(),'Ok')]")
	WebElement buttonOK;
	public void OKbutton(){
		buttonOK.click();
	}
	
	@FindBy(xpath="//*[@name='eviType']/preceding-sibling::p")
	WebElement evidenceTypeDropdown;
	@FindBy(xpath="//*[@data-testid='combobox-Evidence Type 1']")
	WebElement evidenceTypeOption;
	public void selectEvidenceType(){
		evidenceTypeDropdown.click();
		evidenceTypeOption.click();
	}

	@FindBy(xpath="//input[@name='eviSource']/preceding-sibling::p")
	WebElement evidenceSourceDropdown;
	@FindBy(xpath="//*[@data-testid='combobox-Test 1']")
	WebElement evidenceSourceOption;
	public void selectEvidenceSource(){
		evidenceSourceDropdown.click();
		evidenceSourceOption.click();
	}

	@FindBy(xpath="//*[@name='eviDesc']")
	WebElement evidenceDesc;
	public void evidenceDesc(String desc){
		evidenceDesc.sendKeys(desc);
	}
		
	@FindBy(xpath="//input[@name='dateTime']")
	WebElement evidenceDateTime;
	public void evidenceDateTime(String date){
		evidenceDateTime.sendKeys(date);
	}
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement EvidenceSubmit;
	public void addEvidence(){
		EvidenceSubmit.click();
	}

	@FindBy(xpath="//tbody/tr/td[4]")
	WebElement getEvidenceDateTime;
	public ArrayList<String> getEvidenceDateTime(){
		ArrayList<String> ar = new ArrayList<String>();
		List<WebElement> text1 = getEvidenceDateTime.findElements(By.xpath("//tbody/tr/td[4]"));
		for(WebElement a:text1) {
			ar.add(a.getText());
		}
		return ar;
	}
	
	
	//(//*[starts-with(@class,"elements_displayValue__")])[2]
	
	
	
	//div/table/tbody/tr/td[contains(text(),"Assigned")]
	//(//td[contains(text(),"Assigned")])[3]/following-sibling::td[2]
	//(//td[contains(text(),"Submitted")])[1]/following-sibling::td[2]
	//div/table/thead/tr/th[contains(text(),"Days")]//parent::tr//parent::thead/following-sibling::tbody/tr/td
	//(//*[starts-with(@class,"elements_displayValue__")])
	//*[starts-with(@class,"irDashboard_innerWrapper__")]/child::p[1]
	//*[starts-with(@class,"style_responses__")]/child::li/child::p[2]
	//*[starts-with(@class,"elements_field__")]
	
	//*[@name='eviType']/parent::div
	//*[@data-testid='combobox-Evidence Type 1']
	//input[@name='eviSource']/parent::div
	//*[@data-testid='combobox-Test 1']
	//*[@name='eviDesc']
	
}

