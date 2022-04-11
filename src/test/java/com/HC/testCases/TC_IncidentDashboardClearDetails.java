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

public class TC_IncidentDashboardClearDetails extends BaseClass {
	@Test
	public void TC_IncidentDashboardClearDetails() throws IOException, InterruptedException{
			
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

		//category
		db.selectCategory();
		logger.info("category selected");
		Thread.sleep(2500);
		
		//incident from date
		db.selectFromInciDateTime("01-02-2021");
		logger.info("incident from date entered");
		Thread.sleep(2500);

		//incident to date
		db.selectToInciDateTime("28-02-2021");
		logger.info("incident to data entered");
		Thread.sleep(2500);

		//reporting from date
		db.selectFromRepoDate("01-03-2022");
		logger.info("reporting from date entered");
		Thread.sleep(2500);

		//reporting to date
		db.selectToRepoDate("31-03");
		logger.info("reporting to data entered");
		Thread.sleep(2500);

		//type of incident
		db.selectTypeofInci();
		logger.info("type of incident selected");
		Thread.sleep(2500);

		//select Investigator
		db.selectInvestigator();
		logger.info("Investigator is selected");
		Thread.sleep(2500);
		
		//select status
		db.selectStatus();
		logger.info("Status is selected");
		Thread.sleep(2500);

		//clear button
		db.clearButton();
		logger.info("clear button is clicked");
		Thread.sleep(2500);

		capureScreen(driver,"TC_IncidentDashboardClearDetails");

		//result
		String result = db.verifyClear();
		Assert.assertEquals(result, "");
		logger.info("Assert verified");
		
	}
}
