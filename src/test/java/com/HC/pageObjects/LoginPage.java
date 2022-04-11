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
	
	@FindBy(xpath="//button[contains(text(),\"Save\")]")
	WebElement btnsave;
	
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	WebElement popsave;
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	WebElement popsubmit;

	//@FindBy(css="body:nth-child(2) div:nth-child(4) div.prompt div.content > p.question")
	//@FindBy(xpath="//body/div[@id='prompt']/div[2]/div[1]/p[1]/br/preceding::text()")
	@FindBy(xpath="//span[@id=\"irCode\"]")
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
	
		
}
