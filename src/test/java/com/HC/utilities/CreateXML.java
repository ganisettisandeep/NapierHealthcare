package com.HC.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateXML {
	public static void writeFile(List<String> li) {
	    try {
	      FileWriter myWriter = new FileWriter(Constants.Path_TestNG);
	      myWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	      myWriter.write("\n");
	      myWriter.write("<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\" >");
	      myWriter.write("\n");
	      myWriter.write("<suite name=\"NapierHealthCareProject\">");
	      myWriter.write("\n");
	      myWriter.write("<test name=\"HealthCare Test\">");
	      myWriter.write("\n");
	      myWriter.write("<parameter name=\"browser\" value=\"chrome\" />");
	      myWriter.write("\n");
	      myWriter.write("<classes>");
	      myWriter.write("\n");
	      for(int i=0;i<li.size();i++) {
	    	  System.out.println(li.get(i).toString());
	      myWriter.write("<class name=\"com.HC.testCases.");
	      myWriter.write(li.get(i).toString());
	      myWriter.write("\" />");
	      myWriter.write("\n");
	      }
	      myWriter.write("</classes>");
	      myWriter.write("\n");
	      myWriter.write("</test>");
	      myWriter.write("\n");
	      myWriter.write("</suite>");
	 
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
}
