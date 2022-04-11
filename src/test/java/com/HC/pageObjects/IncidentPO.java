package com.HC.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HC.utilities.Constants;

public class IncidentPO {

	WebDriver ldriver;
	
	public IncidentPO(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//incident creation

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

	@FindBy(xpath="//*[contains(text(),\"Yes\")]")
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
	


}
