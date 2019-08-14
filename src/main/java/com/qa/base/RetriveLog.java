package com.qa.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
//import com.sun.tools.javac.util.List;

public class RetriveLog {

	String content = "";
	int issue = 0;
	String testCaseID = "TC_02";

	Fillo fillo = new Fillo();
	Connection connection;
	HashMap<String, String> excelHashMapValues = new HashMap<>();

	@Test
	public void searchlog() throws IOException, InterruptedException, FilloException {

		File directory = new File("C:\\Log_Source_code\\RestfulTraining\\Logs");

		System.out
				.println("Number of files in the Logs directory of " + testCaseID + "=" + directory.listFiles().length);

		// --------------------------------- Reading a common issue from the Common
		// Issue
		// File--------------------------------------------------------------------------

		connection = fillo.getConnection(System.getProperty("user.dir") + "/Common_Issue/log_write.xlsx");

		String strQuery = "Select * from Sheet2 ";

		Recordset recordset = connection.executeQuery(strQuery);

		Multimap<String, String> myMultimap = ArrayListMultimap.create();

		while (recordset.next()) {
			ArrayList<String> ColCollection = recordset.getFieldNames();
			int Iter;
			int size = ColCollection.size();
			for (Iter = 0; Iter <= (size - 1); Iter++) {

				String ColName = ColCollection.get(Iter);
				// System.out.println(ColName);
				String ColValue = recordset.getField(ColName);
				// System.out.println(ColValue);
				// String colname = ColName+Iter;
				// HashMap<String, String> excelHashMapValues = new HashMap <String, String>();
				myMultimap.put(ColName, ColValue);

			}
		}
		// System.out.println("The hashmap contains " + myMultimap.get("Common Issue"));
		
		
		// ---------------------------------- Create Run Time Directory---------------------------------------------------------------
		
		
			   File f=new File("C:\\Log_Source_code\\RestfulTraining\\"+testCaseID +"_logs");
					
			   String TC_log=f.toString();
			   System.out.println("My directory Name is"+TC_log);
			   try {
			       if (!f.exists()) 
			       {
			           f.mkdirs();
			           System.out.println("Directory  is created");
			       } else 
			          System.out.println("Directory is already Exist!");  
			       
			      } 
			   
			   catch (Exception e) 
			   {
			       e.printStackTrace();
			   }
			   
			

		// ---------------------------------Read a file from the Directory
		// List----------------------------------------------------------

		File[] myarray = new File[directory.listFiles().length];

		myarray = directory.listFiles();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");

		File file = new File(TC_log+"\\" + testCaseID + "_"
				+ dateFormat.format(new Date()) + ".txt");
		System.out.println("My file Name is"+file);

		if (file.createNewFile())

			System.out.println("New File is Created!");

		else

			System.out.println("Error, file already exists.");

		try {

			FileWriter fstream = new FileWriter(file, true);

			BufferedWriter out = new BufferedWriter(fstream);

			out = new BufferedWriter(fstream);

			out.write("OPPS ! The Same Issue have  Found on below Previous Logs..");
			out.newLine();
			out.newLine();

			out.write("-----------------------------------------------------" + testCaseID
					+ "----------------------------------------------------");

			out.newLine();
			out.newLine();
			out.close();

		} catch (Exception e) {
			System.out.println(e);

		}

		for (int j = 0; j < myarray.length; j++) {
			System.out.println(myarray[j] + "  File is Reading..");

			int size = myMultimap.size();
			File path = myarray[j];
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);

			while ((content = br.readLine()) != null) {

				Object ob[] = myMultimap.get("Common Issue").toArray();
				for (int o = 0; o < size; o++) {
					System.out.println("Hey " + ob[o]);

					if (content.contains(ob[o].toString())) {
						// System.out.println("Issue Found here.");
						try {

							issue++;
							FileWriter fstream = new FileWriter(file, true);
							BufferedWriter out = new BufferedWriter(fstream);

							out = new BufferedWriter(fstream);
							out.write(ob[o].toString() + " --> issue is related with --> " + myarray[j]);
							out.newLine();
							out.close();

						} catch (Exception e) {
							System.out.println(e);

						}

					}

				}

			}

			try {
				FileWriter fstream = new FileWriter(file, true);
				BufferedWriter out = new BufferedWriter(fstream);

				out = new BufferedWriter(fstream);
				out.write(
						"-------------------------------------------------------------------------------------------------------------------------------------");
				out.newLine();
				// out.write("Total Number of Log files Which Have the Same issue is " + issue);
				// out.newLine();
				out.close();
			} catch (Exception e) {
				System.out.println(e);

			}

		}

	}

}
