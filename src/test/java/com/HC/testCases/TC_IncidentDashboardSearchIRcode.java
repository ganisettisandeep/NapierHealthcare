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

public class TC_IncidentDashboardSearchIRcode extends BaseClass {
	@Test
	public void TC_IncidentDashboardSearchIRcode() throws IOException, InterruptedException{
			
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		System.out.println("Entered Username -->" + username);
		Thread.sleep(1000);
		lp.setPassword(password);
		System.out.println("Entered Password --->" + password);
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

		//enter IR code
		db.enterIRCode1("317 /2022 CONFIG CODE");
		logger.info("IR code is entered");
		Thread.sleep(2500);

		//search button
		db.searchButton();
		logger.info("search button is clicked");
		Thread.sleep(2500);
		
		//validation
		String text = db.getIRcode();
		Assert.assertEquals("317 /2022 CONFIG CODE", text);
		logger.info("validation passed");
		Thread.sleep(2500);
		
		//view button
		db.viewIRcode();
		logger.info("view button is clicked");
		Thread.sleep(2500);

		capureScreen(driver,"TC_IncidentDashboardSearchIRcode");
		
		//result		
		boolean viewPage = db.viewInciPage();
		Assert.assertTrue(viewPage);
	}
}
