package com.HC.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HC.pageObjects.LoginPage;
import com.HC.utilities.Constants;
import com.HC.utilities.XLUtils;

public class TC_QualityDashboardAssignedIRs extends BaseClass {
	@Test
	public void TC_QualityDashboardAssignedIRs() throws IOException, InterruptedException{
			
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

		//dashboard
		lp.clickincidentdashboard();
		logger.info("dashboard button clicked");
		Thread.sleep(2500);
		
		//quality dashboard
		lp.clickQualityDashboard();
		logger.info("quality dashboard button clicked");
		Thread.sleep(2000);

		//Assigned IRs for radio button
		lp.radioAssignedIRs();
		logger.info("radio but for Assigned IRs clicked");
		Thread.sleep(2000);
		
		//search button
		lp.searchButton();
		logger.info("search button is clicked");
		Thread.sleep(2500);
		
		/*
		//result
		boolean result = lp.resultIRcode();
		Assert.assertTrue(result);
		*/
		
	}
}
