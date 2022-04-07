package com.HC.pageObjects;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
import com.HC.utilities.Constants;
import com.HC.utilities.ExcelUtils;
import com.HC.utilities.CreateXML;

public class DriverScript {

	public static String sTestCaseID;
	public static String sRunMode;

    public static void main(String[] args) throws Exception {
	  ExcelUtils.setExcelFile(Constants.Path_TestData);
	  
	  DriverScript startEngine = new DriverScript();
	  startEngine.execute_TestCase(); }
	 
    public void execute_TestCase() throws Exception {
		//This will return the total number of test cases mentioned in the Test cases sheet
    	ExcelUtils.setExcelFile(Constants.Path_TestData);
		int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);
		//Object[] tests = null;
    	System.out.println("iTotalTestCases: "+iTotalTestCases);
		//This loop will execute number of times equal to Total number of test cases
		List<String> li=new ArrayList<String>();
		for(int iTestcase=1;iTestcase<=iTotalTestCases;iTestcase++){
			//This is to get the Test case name from the Test Cases sheet
			sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases); 
			//This is to get the value of the Run Mode column for the current test case
			sRunMode = ExcelUtils.getCellData(iTestcase, Constants.Col_RunMode,Constants.Sheet_TestCases);
			//This is the condition statement on RunMode value
			if (sRunMode.equals("Yes")){
				System.out.println("output: "+sTestCaseID);
				li.add(sTestCaseID);
				System.out.println("added"+li);
			}
    	}
	
		CreateXML.writeFile(li);		
		TestNG runner=new TestNG();
		List<String> suitefiles=new ArrayList<String>();
		suitefiles.add("C:\\Users\\venkata\\Downloads\\NapierHeathCareProject\\testng2.xml");

		runner.setTestSuites(suitefiles);
		
		runner.run();
    }
 }