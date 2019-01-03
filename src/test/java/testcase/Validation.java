package testcase;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import core.CommonMethods;
import page.HomePage;
import page.SearchResultsOf_BooksCategory_Page;


@Listeners({ ATUReportsListener.class,ConfigurationListener.class,MethodListener.class})
/**
 * 
 * @author sukumarb
 * This Class has methods to execute the test scenarios 
 */

public class Validation extends CommonMethods{
	
	/**
	 * Default block to set the ATU Reports properties 
	 */
	{System.setProperty("atu.reporter.config", "./config/atu.properties");}

	/**
	 * 
	 * @param browser
	 * @param url
	 *
	 * This method invokes browser instance based on the browser parameter and launches the url of the application to be automated
	 */
	@Parameters({"browser","url"})
	@BeforeTest
	public void setEnvironment(String browser, String url) {
		launchBrowser(browser);
		launchURL(url);
	}
	
	/**
	 * 
	 * @param searchkeyword
	 * 
	 *<p> This method asserts the Home page of the Amazon web site in order to proceed below test steps.
	 *  <p> 1. Select "Books" from drop down. </p> 
	 *  <p> 2. Type the given search keyword[example: data catalog] in the search box. </p>
	 *  <p> 3. Click "Search" button. </p>
	 */
	@Parameters({"searchkeyword"})
	@Test(priority=1)
	public void testCase_01(String searchkeyword) {
		new HomePage()
		.assertPage()
		.verifySearchLabel()		
		.selectBooksOption()
		.enterSearchKeyWord(searchkeyword)
		.clickSearchButton()
		;
	}
	
	/**
	 * <p> This method asserts the search page by examining search page specific elements 
	 * and Reads the details present in a first search result and displays in console</p>
	 * 
	 */
	@Test(dependsOnMethods = {"testCase_01"})
	public void testCase_02(){
		new SearchResultsOf_BooksCategory_Page()
		.assertPage()
		.readFirstBookDetails()
		.displayBookDetails();
	}
	
}
