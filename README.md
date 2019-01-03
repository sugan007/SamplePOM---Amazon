#SDET Assignment

## A simple test automation framework to write test script(s) in selenium which does the following steps:
  
	• Go to amazon.com   
		
	• In the search dropdown list, choose ‘Books’ option.   
	
	• Enter search text ‘data catalog’.  
	
	• Choose the first test result (first product listed on the search result page).  
	
		• Choose the first test result (first product listed on the search result page) and read/record as many details related to that particular test result as possible.  
		
		• For example, 
		 title of the book, price of the book for different editions, be it paperback/hardcopy or kindle edition, etc.   
	
	• Make the above functionality as generic as possible and componentize this functionality. 
	
------------------------------------------------------------------------

### Description of Project Files

1. 	CommonMethods.java : This class contains methods to perform and handle browser related actions such as clicking a button or typing a word in search box. 

2. 	BasePage.java : BasePage has a default constructor block to initialize all the page objects of it's child classes. 

3. 	HomePage.java : This class has page objects and methods to perform page specific actions respective to the Homepage. 

4. 	SearchResultsOf_BooksCategoryPage.java : This class has page objects and methods to perform page specific actions respective to the Search Results Page. 

5.	Validation.java	: This class has methods to perform the test execution. 

------------------------------------------------------------------------

### Resource and .exe files

1. chromedriver - This folder contains the chromedriver.exe.

2. geckodriver - This folder contains the geckodriver.exe.

3. src/main/resources/log4j.properties - This file has the property settings to generate log files in .log and .html formats.

4. src/test/resources/testng.xml - This file has configured to execute the test step by step. 
    
------------------------------------------------------------------------
    
### Test Report
Test Reports are generated under Resources folder:
1. ATU Reports : `./ATU Reports/.index.html`  
2. TestNG Reports : `./test-output/index.html`  

------------------------------------------------------------------------

### Running the Framework
To run the scripts in command prompt: Go to directory of our project and command `mvn clean test` 

------------------------------------------------------------------------

### Setup and Installation of the Framework


	