package com.HC.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HC.pageObjects.DashboardPO;
import com.HC.pageObjects.LoginPage;
import com.HC.utilities.BaseClass;
import com.HC.utilities.Constants;
import com.HC.utilities.XLUtils;

public class TC_IRinvestigation extends BaseClass {
	@Test
	public void TC_IRinvestigation() throws IOException, InterruptedException{
			
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(usernameHIS);
		logger.info("Entered username");
		System.out.println("Entered Username -->" + usernameHIS);
		Thread.sleep(1000);
		lp.setPassword(passwordHIS);
		System.out.println("Entered Password --->" + passwordHIS);
		Thread.sleep(1000);
		logger.info("Entered Password");
		lp.clicksubmit();
		logger.info("Login button pressed");
		Thread.sleep(5000);

		DashboardPO db = new DashboardPO(driver);
		
		//dashboard
		db.clickincidentdashboard();
		logger.info("dashboard button clicked");
		Thread.sleep(2500);
		
		//quality dashboard
		db.clickQualityDashboard();
		logger.info("quality dashboard button clicked");
		Thread.sleep(5000);

		//actions
		db.clickAction();
		logger.info("actions clicked");
		Thread.sleep(2000);

		//investigation button
		db.clickInvestigationButton();
		logger.info("investigation button clicked");
		Thread.sleep(2000);

		//RequestForInput button
		db.clickRequestForInput();
		logger.info("RequestForInput button clicked");
		Thread.sleep(2000);
		
		//select department
		db.selectDepartment("lab");
		logger.info("dept is selected");
		Thread.sleep(2000);
		
		//select user
		db.selectUser("new user");
		logger.info("user is selected");
		Thread.sleep(2000);
		
		//select IR information
		db.selectIRinfo();
		logger.info("IR information is selected");
		Thread.sleep(2000);
		
		//writing query
		db.inputQuery("test query for automation");
		logger.info("query noted");
		Thread.sleep(2000);
		
		//submit Query
		db.submitQuery();
		logger.info("query submitted");
		Thread.sleep(2000);
		
		//IR Query Dashboard
		db.IRQueryDashboard();
		logger.info("IR Query Dashboard clicked");
		Thread.sleep(2000);
		
		//view Response
		db.viewResponse();
		logger.info("view response clicked");
		Thread.sleep(2000);
		
		//enter the response
		db.responseText("Test response");
		logger.info("response is entered");
		Thread.sleep(2000);
		
		//submit response
		db.responseSubmit();
		logger.info("submit response is clicked");
		Thread.sleep(2000);
		
		capureScreen(driver,"TC_IRinvestigation");
		
		//result
		boolean result = db.resultIRcode();
		Assert.assertTrue(result);
		
	}
}
