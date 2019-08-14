	package com.qa.rest.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import com.qa.base.ReadAndWriteLogFile;
import com.qa.testcase.TC1_GET;
import com.qa.utillity.Log4jConfig;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Base {
	
public static RequestSpecification httpreq ;
public static Response response;
public static Logger logger;
public static FileOutputStream outputStream;
public static String currentDate;

    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("currenttime", dateFormat.format(new Date()));
        
        //From here------
        
        Properties prop = new Properties();
        
    	try {
    		FileInputStream input =new FileInputStream(System.getProperty("user.dir")+"/src/main/java/log4j.properties");
			//FileInputStream input=new FileInputStream(new File("G:\\Nagarajan\\Log Code\\RestfulTraining\\src\\main\\java\\log4j.properties"));
			prop.load(input);
			prop.setProperty("log4j.appender.file.File", System.getProperty("currenttime"));
			//prop.store(new FileOutputStream(new File("G:\\Nagarajan\\Log Code\\RestfulTraining\\src\\main\\java\\log4j.properties")), "Heys");
			prop.store(new FileOutputStream(new File(System.getProperty("user.dir")+"/src/main/java/log4j.properties")), "Heys");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	// END-----------
        
		/*
		 * try {
		 * 
		 * TC1_GET.addsystemDate(); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
       
      
    }

    public static final Logger log = Logger.getLogger(Base.class);
@BeforeClass

public void setup()

{
System.out.println(System.getProperty("log4j.appender.file.layout"));
logger=Logger.getLogger("VerifyRestfulAPI");
PropertyConfigurator.configure("C:\\Log_Source_code\\RestfulTraining\\src\\main\\java\\log4j.properties");
//FileInputStream input =new FileInputStream(System.getProperty("user.dir")+"/src/main/java/log4j.properties");
/*logger.setLevel(Level.DEBUG);*/
//logger.setLevel(Level.INFO);
	
//C:\Users\madhavaraon\SeleniumTest\RestfulTraining\src\main\java\log4j.properties
}

}