package com.qa.utillity;
/////Converting JavaFile to XML  by koushk
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class GenerateTestNG {
	static String saveFilePath ="C:\\Users\\madhavaraon\\SeleniumTest\\RestfulTraining\\NewFile2.xml" ;
	
	    @SuppressWarnings("deprecation")
	    public void runTestNGTest() {

	        //Create an instance on TestNG
	         TestNG myTestNG = new TestNG();

	        //Create an instance of XML Suite and assign a name for it.
	         XmlSuite mySuite = new XmlSuite();
	         mySuite.setName("MySuite");

	        //Create an instance of XmlTest and assign a name for it.
	         XmlTest myTest = new XmlTest(mySuite);
	         myTest.setName("test");


	        //Create a list which can contain the classes that you want to run.
	         List<XmlClass> myClasses = new ArrayList<XmlClass> ();
	         myClasses.add(new XmlClass("com.qa.utillity.RestUtil"));

	       //Assign that to the XmlTest Object created earlier.
	         myTest.setXmlClasses(myClasses);

	        //Create a list of XmlTests and add the Xmltest you created earlier to it.
	         List<XmlTest> myTests = new ArrayList<XmlTest>();
	         myTests.add(myTest);

	        //add the list of tests to your Suite.
	         mySuite.setTests(myTests);

	        //Add the suite to the list of suites.
	         List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
	         mySuites.add(mySuite);

	        //Set the list of Suites to the testNG object you created earlier.
	         myTestNG.setXmlSuites(mySuites);
	         TestListenerAdapter tla = new TestListenerAdapter();
	         myTestNG.addListener(tla);
	         
		        File file = new File(saveFilePath);
		        FileWriter writer = null;
		        try {
		            writer = new FileWriter(file);
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        try {
		            writer.write(mySuite.toXml());
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        System.out.println(mySuite.toXml());
		        try {
		            writer.close();
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }

	        //invoke run() - this will run your class.
	         myTestNG.run();
	        }


	    
		
	public static void main(String[] args)
    {
        GenerateTestNG dt = new GenerateTestNG();
         dt.runTestNGTest();
        
    }

}
