package com.HC.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Constants {

	//List of System Variables
	//public static final String URL = "https://www.store.demoqa.com";
	public static ExtentReports extent;
	public static ExtentTest Elogger;
	public static final String Path_TestData = "C://Users//venkata//Downloads//NapierHeathCareProject//DataEngine.xlsx";
	public static final String Path_IncidentData = "C://Users//venkata//Downloads//NapierHeathCareProject//DataEngine.xlsx";
	public static final String Path_FileUpload = "C:\\Users\\venkata\\Downloads\\NapierHeathCareProject\\incidentImage1.jpg";
	public static final String Path_TestNG = "C:\\Users\\venkata\\Downloads\\NapierHeathCareProject\\testng2.xml";
	
	//List of Data Sheet Column Numbers
	public static final int Col_TestCaseID = 0;	
	public static final int Col_TestScenarioID =1 ;
	//This is the new column for 'Page Object'
	public static final int Col_PageObject =3 ;
	//This column is shifted from 3 to 4
	public static final int Col_ActionKeyword =4 ;
	public static final int Col_RunMode =2 ;

	//List of Data Engine Excel sheets
	//public static final String Sheet_TestSteps = "Test Steps";
	//New entry in Constant variable
    public static final String Sheet_TestCases = "Test Cases";

	//List of Test Data
	//public static final String UserName = "testuser_3";
	//public static final String Password = "Test@123";

}