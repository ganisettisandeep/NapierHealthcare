package com.HC.testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HC.pageObjects.LoginPage;
import com.HC.utilities.Constants;
import com.HC.utilities.XLUtils;

public class TC_IncidentReportAllDetailsUpload extends BaseClass {
	@Test
	public void TC_IncidentReportAllDetailsUpload() throws IOException, InterruptedException, AWTException{
			
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

		//file upload
		lp.clickFileUpload();
		logger.info("File upload done");
		Thread.sleep(2000);
		
				
		//submit
		//lp.incidentsubmit();
		logger.info("Submit button clicked");
		Thread.sleep(2000);
		lp.popsubmit();
					
	}
}
