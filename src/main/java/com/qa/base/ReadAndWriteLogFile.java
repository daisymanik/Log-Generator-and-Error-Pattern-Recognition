package com.qa.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.qa.rest.demo.Base;
import com.qa.utillity.Log4jConfig;

public class ReadAndWriteLogFile extends Base{

	public static String logFilePath=Log4jConfig.getPropertyValue("logFilepath");
	public static String logPath=Log4jConfig.getPropertyValue("logpath");
	private static FileReader fileReader;
	private static BufferedReader bufferReader;
	private static FileWriter filewriter;
	private static BufferedWriter bufferdWriter;
	static String content="";
	static String testCaseNumber;
	static ArrayList<String> testcaseCount=new ArrayList<String>();
	public static File newFile;
	public static Fillo fillo = new Fillo();
	public static int i=1;
	public static int j=1;
	public static int k=1;
	public static int l=1;
	public static int m=1;
//public static void readAndWriteFile(String fileName) throws IOException {
//		createNewFile(fileName+"INFO.log");
//		createNewFile(fileName+"ERROR.log");
//		fileReader = new FileReader(logFilePath+"\\"+fileName);
//		bufferReader = new BufferedReader(fileReader);
//		  while((content = bufferReader.readLine())!= null){
//			  if(content.contains("INFO")) {
//				  FileWriter file = new FileWriter((logFilePath+"\\"+fileName+"INFO.log"));
//				  bufferdWriter = new BufferedWriter(file);
//				  bufferdWriter.write(content);
//				  bufferdWriter.newLine();
//			  }else if(content.contains("ERROR")) {
//				  FileWriter file1 = new FileWriter((logFilePath+"\\"+fileName+"ERROR.log"));
//				  bufferdWriter = new BufferedWriter(file1);
//				  bufferdWriter.write(content);
//				  bufferdWriter.newLine();
//			  }
//		  }
//		  bufferdWriter.flush();
//		  bufferdWriter.close();
//	}
	@Test
	public static void file_read() throws IOException, FilloException {
		
		HashMap<String,String> loginfo = new HashMap<String,String>();
		
		 File file = new File("C:\\Log_Source_code\\RestfulTraining\\Logs\\TC_02_09-08-2019-04-12-04.log"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file));
		  
		  String pattern = "^20 INFO$";

	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);
		  
		  String st=null; 
		  while ((st = br.readLine()) != null) {
		   // System.out.println(st);
		    //System.out.println("---line--"+i);
		    //i++;
		    String[] se=st.split(" - ");
		    loginfo.put(se[0], se[1]);
		   // String se=st.replaceAll("(2019-*)Verify(API*)", "");
		   // System.out.println(se);
		    for(String s:se) {
		    	
		    	System.out.println(s);
		    	
		    }
		    
		    /*if(st.contains("ERROR")) {
		    	System.out.println("Error");
		    	System.out.println(st);
		    }else if (st.contains("FATAL")) {
		    	System.out.println("warn");
		    	System.out.println(st);
		    }*/
		    
		  }
		  
		  for(Map.Entry<String,String> da:loginfo.entrySet()) {
			  
			  System.out.println("TC0"+i+"Key:"+da.getKey()+"Value:"+da.getValue());
//			  excelwriting_logs("TC0"+i, "Sheet1", "TC_NAME", da.getKey());
//			  excelwriting_logs("TC0"+i, "Sheet1", "TC_RESULT", da.getValue());
		//	  i++;
			  //System.out.println(loginfo.get("2019-08-09 16:12:11 ERROR VerifyRestfulAPI:107"));
		  }
		
	}
	
	public static void readAndWriteFile(String fileName, String TC_No) throws IOException, InterruptedException, FilloException {
	//createNewFile(fileName+"ERROR.log");
		System.out.println("File Name "+fileName);
		HashMap<String,String> logsplit = new HashMap<String,String>();
	//createFile(fileName+"PatternIdentification.log");
		
		
		String values =Log4jConfig.getPropertyValue("log4j");
		System.out.println(values);
		String[] arr = values.split("\\|");
		System.out.println("test" +arr[0]);
		String comfilename= TC_No+"_"+fileName+".log";
		
		// Create New Folder with the Name of Test Case ID
		
		//String givedirname=createDirectory(TC_No);

		// create New File Name		
		createFile(comfilename);
		
		//createNewFile(fileName);
	 System.out.println("filename="+comfilename);
	 
//	File FR = new File(logFilePath+"\\"+fileName);
	File FR = new File("C:\\Log_Source_code\\RestfulTraining\\" +fileName);
	 
	FileReader fr = new FileReader(FR);
	BufferedReader br=new BufferedReader(fr);

	
	
	File infoFile = new File("C:\\Log_Source_code\\RestfulTraining\\Logs\\" +comfilename);

	 FileWriter fw=new FileWriter(infoFile);
	 BufferedWriter bw = new BufferedWriter(fw);
	  
	 
	// System.out.println("sdfas"+info);
	
	  
	  while((content = br.readLine())!= null){
		  
	//	  System.out.println(" i came here ---------------");
		  
	  if(content.contains(Log4jConfig.getPropertyValue("log4j_info"))) {
		  bw.write("-------------------------- ######INFO## -------------------------------");
	     bw.write(content);
	    String[] split=content.split(" - ");
	    logsplit.put(split[0], split[1]);
	  
	  excelwriting_logs("TC0"+i, "Sheet1", "INFO_TC_NAME",split[0]);
	  excelwriting_logs("TC0"+i, "Sheet1", "INFO_TC_VALUE", split[1]);
	  bw.newLine();
	  i++;
	  }else if(content.contains(Log4jConfig.getPropertyValue("log4j_warn"))) {
		  bw.write("-------------------------- ######WARN## -------------------------------");
		  bw.write(content);
		   String[] split=content.split(" - ");
		   logsplit.put(split[0], split[1]);
		 // excelwriting_logs("TC0"+i, "Sheet1", "WARN", content);
		  excelwriting_logs("TC0"+j, "Sheet1", "WARN_TC_NAME",split[0]);
		  excelwriting_logs("TC0"+j, "Sheet1", "WARN_TC_VALUE", split[1]);
		  bw.newLine();	  
		 i++;
	  }
	  else if(content.contains(Log4jConfig.getPropertyValue("log4j_error"))) {
		 bw.write("-------------------------- ######ERROR## -------------------------------");
	  bw.write(content);
	 // excelwriting_logs("TC0"+i, "Sheet1", "ERROR", content);
	    String[] split=content.split(" - ");
	    logsplit.put(split[0], split[1]);
	  excelwriting_logs("TC0"+k, "Sheet1", "ERROR_TC_NAME",split[0]);
	  excelwriting_logs("TC0"+k, "Sheet1", "ERROR_TC_VALUE", split[1]);
	  bw.newLine();
	  i++;
	  }else if(content.contains(Log4jConfig.getPropertyValue("log4j_fatal"))){   
		 bw.write("-------------------------- ######FATAL## -------------------------------");
		 //excelwriting_logs("TC0"+i, "Sheet1", "FATAL", content);
		  String[] split=content.split(" - ");
		  logsplit.put(split[0], split[1]);
		  excelwriting_logs("TC0"+l, "Sheet1", "FATAL_TC_NAME",split[0]);
		  excelwriting_logs("TC0"+l, "Sheet1", "FATAL_TC_VALUE", split[1]);
		  bw.write(content);
		  bw.newLine(); 
		  i++;
	  }else{   
			 bw.write("-------------------------- ######COMMON## -------------------------------");
			 //excelwriting_logs("TC0"+i, "Sheet1", "FATAL", content);
			  String[] split=content.split(" - ");
			  logsplit.put(split[0], split[1]);
			  excelwriting_logs("TC0"+m, "Sheet1", "COMMON_TC_NAME",split[0]);
			  excelwriting_logs("TC0"+m, "Sheet1", "COMMON_TC_VALUE", split[1]);
			  bw.write(content);
			  bw.newLine(); 
			  i++;
		  }
	  }
	  bw.flush();
	  bw.close();
	}
	
	public static void excelwriting_logs(String testCaseID, String sheetName, String Columnname, String columnvalue) throws FilloException   {
		
		Connection connection = fillo.getConnection("C:\\Log_Source_code\\RestfulTraining\\Common_Issue\\log_write.xlsx");

		String strQuery = "Update " + sheetName + " Set " + Columnname + "='" + columnvalue + "' where TestCaseID='" + testCaseID + "' ";

		connection.executeUpdate(strQuery);
		
		connection.close();
		
		

		/*Multimap<String, String> myMultimap = ArrayListMultimap.create();

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

			}*/
		//}
		
		
	}
	public static ArrayList<String> createNewFile(String fileName) throws IOException {
		File FR = new File(logFilePath+"\\"+fileName);
		FileReader fr = new FileReader(FR);
		BufferedReader br=new BufferedReader(fr);
		BufferedWriter ebw = null;
		try {
		while((content = br.readLine())!=null) {
		if(content.contains("Test Case")) {
		testCaseNumber=content.split("Test Case")[1].split(" ")[1];
		testcaseCount.add(testCaseNumber);
		newFile = new File(logPath + "\\" + testCaseNumber+".log");
		            if (!newFile.exists()) {
		            
		newFile.createNewFile();
		                System.out.println("File is created");
		            } else {
		               //System.out.println("File already exist");
		            }}
		FileWriter ewriter=new FileWriter(newFile);
		  ebw = new BufferedWriter(ewriter);
		  ebw.write(content);
		  ebw.newLine();
		        }
		ebw.flush();
		} catch (IOException e) {
		            e.printStackTrace();
		        }
		return testcaseCount;
		 
		}
	
	
	
	public static String createDirectory(String TC_No) {
		
		   File f=new File("C:\\Log_Source_code\\RestfulTraining\\"+TC_No +"_logs");
		  // C:\\Log_Source_code\\RestfulTraining\\src\\main\\java\\log4j.properties
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
		   
		   return f.toString();
		}
	
	public static void createFile(String fileName) {
		
		// G\:\\Nagarajan\\Log Code\\RestfulTraining\\Logs
		
		File file = new File(logPath + "\\" + fileName);
		 
		// File file = new File(TC_No+"\\"+ fileName);
		 
		 System.out.println("My File is="+file);
		 
		 
		 try {
	            if (!file.exists()) {
	                file.createNewFile();
	                System.out.println("File is created");
	            } else {
	               System.out.println("File already exist");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	
	
	
	public static void main(String a[]) throws IOException {
		System.out.println(Log4jConfig.getPropertyValue("log4j.appender.file.File"));
		//readAndWriteFile("TC1.log");
	}
}
