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
	
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(name="username")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[contains(text(),\"Sign in\")]")
	WebElement btnLogin;
	
	@FindBy(xpath="//button[@data-testid='logout']")
	WebElement btnLogout;
	
	@FindBy(xpath="//input[@name=\"incident_Date_Time\"]")
	WebElement datetime;
	
	@FindBy(xpath="(//*[@class=\"reactSelect__input\"])[1]")
	WebElement incidentlocation;
	
	@FindBy(xpath="//*[@name=\"locationDetailsEntry\"]")
	WebElement locationdetail;
	
	@FindBy(xpath="//*[contains(text(),\"Unsafe condition\")]")	
	WebElement typeincident;
	
	@FindBy(xpath="(//*[@class=\"reactSelect__input\"])[2]")
	WebElement incidentcat;
	
	@FindBy(xpath="(//*[@class=\"reactSelect__input\"])[3]")
	WebElement incidentsubcat;
	
	@FindBy(name="inciDescription")
	WebElement incidescrep;
	
	@FindBy(xpath="//button[contains(text(),\"Submit\")]")
	WebElement btnsubmit;
	
	@FindBy(xpath="//button[contains(text(),\"Save\")]")
	WebElement btnsave;
	
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	WebElement popsave;
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	WebElement popsubmit;

	@FindBy(xpath="//span[@id=\"irCode\"]")
	static
	WebElement incidentnumber;
	
	@FindBy(xpath="//p[contains(text(),'Invalid credentials.')]")
	WebElement Logincheck;
	
	public String checkloginpage(){
		return Logincheck.getText();
	}
	
	public static String getincidentnumber(){
		 return incidentnumber.getText();
	}
	
	public void setUserName(String uname){
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd){
		txtPassword.sendKeys(pwd);
	}
	
	public void clicksubmit() throws InterruptedException{
		btnLogin.click();
		Thread.sleep(2000);
		ldriver.manage().window().maximize();
	}
	
	public void clicklogout(){
		btnLogout.click();
	}
	
	public void incidentsave(){
		btnsave.click();
	}
	
	public void incidentsubmit(){
		btnsubmit.click();
	}
	
	public boolean popsave(){
		popsave.click();
		return true;
	}
	
	public void popsubmit(){
		popsubmit.click();
	}
	
	public void intdate(String date){
		datetime.sendKeys(date);
	}
	
	public void settypeincident(){
		typeincident.click();
	}

	public void setIncicat(String cat){
		//return setIncicat(cat);
		incidentcat.sendKeys(cat,Keys.RETURN);
	}
	
	public void setincidentlocation(String loc){
		incidentlocation.sendKeys(loc);
	}
	
	public void clickincidentlocation(String loc){
		incidentlocation.sendKeys(loc,Keys.RETURN);
	}
	
	public void setlocationdetail(String detail){
		locationdetail.sendKeys(detail);
	}
	
	public void setincidentsubcat(String subcat){
		incidentsubcat.sendKeys(subcat,Keys.RETURN);
	}
	
	public void setincidescrep(String incides){
		incidescrep.sendKeys(incides);
	}

}
