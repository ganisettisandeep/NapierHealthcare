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

public class TC_IRinvestigationRecordInputs extends BaseClass {
	@Test
	public void TC_IRinvestigationRecordInputs() throws IOException, InterruptedException{
			
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

		//recordInputs
		db.recordInputs();
		logger.info("recordInputs clicked");
		Thread.sleep(2000);

		//Source
		db.evidenceSource("Test 1");
		logger.info("Source clicked");
		Thread.sleep(2000);
		
		//receivedOn date
		db.recievedOn("1102202118390");
		logger.info("receivedOn date clicked");
		Thread.sleep(2000);
		
		//response
		db.responseText("test response in automation");
		logger.info("response entered");
		Thread.sleep(2000);
		
		//submit Response
		db.submitResponse();
		logger.info("submit Response clicked");
		Thread.sleep(2000);
		
		capureScreen(driver,"TC_IRinvestigationRecordInputs");
		
	}
}
