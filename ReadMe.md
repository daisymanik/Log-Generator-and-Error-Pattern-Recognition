Project Title: Log Generator-Error pattern recognization framework

Scope:
Generating the logs for Test case and verify the issues which are related to previous logs history

Description:
Test case executed with Log4j and observerd some error,warn on results.we can search the (current day)same issue on past logs history
to find the root cause of issue.
Its helpful to identify the issues on past logs history  

GITHUB URL location: https://github.com/daisymani/Log-Generator-and-Error-Pattern-Recognition.git

Selenium version: 3.141.59

Environment: Windows10

Installed libraries using Maven dependencies:

RestAssured 3.0.0
com.google.guava 21.0
com.codoid.products 1.18
testng 6.14.3
junit 3.8.1
log4j 1.2.12
com.googlecode.json-simple 1.1.1
httpclient 4.5.8
httpcore 4.4.11
org.json 20180813

Steps to be followed for Executing Test Case:

1)Log4J properties file

2)Base class is configured with properties file

3)Run the TC1_GET test case for creating the log for present day in 'test-output' folder

4)ReadAndWriteLogFile is called to update the logs in directory at the time of each test case execution ->Logs

5)Excel sheet got updated with recent logs ->Common_Issue\log_write.xlsx

6)Mention the common issues on Excel sheet2 location ->Common_Issue\log_write.xlsx

7)Run the 'RetriveLog' Testcase for verify the common issues on past history logs

8)Log will be generated on 'TC_02_logs' folder ->Result to be like ->'issue' is related to 'log name'

Authors:
Madhav
Sai
Nagaraj
Karthik