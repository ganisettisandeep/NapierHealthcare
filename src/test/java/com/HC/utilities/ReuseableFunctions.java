package com.HC.utilities;

import org.testng.Assert;

import com.HC.pageObjects.DashboardPO;
import com.HC.pageObjects.LoginPage;
import com.aventstack.extentreports.Status;

public class ReuseableFunctions extends BaseClass {
	DashboardPO db = new DashboardPO(driver);

	public void Login() throws InterruptedException {
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
		Elogger.log(Status.PASS, "Login is successful");

	}

	public void IRinvestigation(String IRcode) throws InterruptedException {

		// clicking the incident dashboard on left navigation menu
		db.clickincidentdashboard();
		logger.info("dashboard button clicked");
		Thread.sleep(2500);

		// clicking the quality dashboard inside incident dashboard
		db.clickQualityDashboard();
		logger.info("quality dashboard button clicked");
		Thread.sleep(5000);
		Elogger.log(Status.PASS, "quality dashboard button clicked");

		// enter the IR code in quality dashboard
		db.enterIRcodeQD(IRcode);
		logger.info("entered IR code");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "entered IR code");

		// click on search button in quality dashboard
		db.searchButtonQD();
		logger.info("search button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "search button clicked");

		// click on actions button for an IR code
		db.clickAction();
		logger.info("actions clicked");
		Thread.sleep(2000);

		// click on investigation button in the actions menu
		db.clickInvestigationButton();
		logger.info("investigation button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "investigation button clicked");

		try{
		// checking if confirmation message to start IR investigation
		boolean startIRinvestigation = db.isStartIRinvestigation();
		System.out.println("startIRinvestigation is: "+startIRinvestigation);
		// starts IR investigation by clicking on Yes button in confirmation message
		if (startIRinvestigation) {
			System.out.println("inside if");
			db.IRinvestigationYes();
			Elogger.log(Status.PASS, "Clicked on Yes button in confirmation message");
		}
		Thread.sleep(2000);
		}
		catch(Exception e){
			System.out.println("No confirmation message to start investigation");
		}
		
		boolean investigationPage = db.IRinvestigationPage();
		Assert.assertEquals(true, investigationPage);
	}

	public void IRMasterconfiguration() throws InterruptedException {
		
		//IR Configuration
		db.IRConfiguration();
		logger.info("IR Configuration clicked");
		Thread.sleep(2000);

		// checking the risk assessment
		boolean f1 = db.isRiskAssessment();
		Thread.sleep(2500);
		if (f1 == false) {
			logger.info("enabling the risk assessment");
			db.enableRiskAssessment();
		}
		logger.info("checked the risk assessment");
		Thread.sleep(2500);

		// checking the Self-reporting IRs
		boolean f2 = db.isSelfReporting();
		Thread.sleep(2500);
		if (f2 == false) {
			logger.info("enabling the Self-reporting IRs");
			db.enableSelfReporting();
		}
		logger.info("checked the Self-reporting IRs");
		Thread.sleep(2500);

		// checking the IPSG Type
		boolean f3 = db.isIPSGtype();
		Thread.sleep(2500);
		if (f3 == false) {
			logger.info("enabling the IPSG Type");
			db.enableIPSGtype();
		}
		logger.info("checked the IPSG Type");
		Thread.sleep(2500);
	}
}
