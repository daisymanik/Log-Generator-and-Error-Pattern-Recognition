package com.qa.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Createfolder {
     
 //   private static final String FOLDER ="G:\\Nagarajan";
 
    public static void main(String[] args) throws IOException {
    	
    
		  File newFolder = new File("G:/Raju");
		  
		  boolean created = newFolder.mkdir();
		  
		  System.out.println(created);
		  
		  if(created) System.out.println("Folder was created !");
		  else
		  System.out.println("Unable to create folder");
		     }
}