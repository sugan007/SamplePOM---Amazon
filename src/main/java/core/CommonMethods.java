package core;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;


public class CommonMethods {

	public static RemoteWebDriver driver=null;
	private static Logger log = Logger.getLogger(CommonMethods.class);
	String msg = null;
	SoftAssert softassert = new SoftAssert();
	
	/** 
	 * <p> This methods is used to invoke the Chrome Browser instance.
	 */
	public void launchChromeDriver() {
		try {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			msg = "Chrome Driver has launched Successfully!";
			writeToReport("PASS", msg, "");
		} catch (Exception e) {		
				writeToReport("FAIL", msg, e.getMessage());		
		}
	}
	
	/**
	 * <p> This method is used to invoke the Firefox Browser instance.
	 */
	public void launchFirefoxDriver() {
		try {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			msg = "Firefox Driver has launched Successfully!";
			writeToReport("PASS", msg, "");
		} catch (Exception e) {		
				writeToReport("FAIL", msg, e.getMessage());		
		}
	}
	
	/**
	 * @param browser
	 * 
	 * <p> This method used to invoke any one of the browser instances based on browser parameter string value
	 * Refer config.properties file to set browser value
	 */
	public void launchBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			launchChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			launchFirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		ATUReports.setWebDriver(driver);
	}
	
	/**
	 *  @param url
	 *  
	 *  This method used to launch the URL in a browser.
	 */
	public void launchURL(String url) {
		try {
			driver.get(url);
			msg = "URL: "+url+" has launched Successfully!";
			writeToReport("PASS", msg, "");
		}catch(Exception e) {
			writeToReport("FAIL", msg, e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param element
	 * @param input
	 * 
	 * <p> This method used to perform type operation on a specified element by an input string value
	 */
	public void type(WebElement element,String input) {
		
		try {
			softassert.assertTrue(element.isDisplayed());
			element.sendKeys(input);
			msg = "Element : "+element.toString()+" filled by an input: "+input+" Successfully!";
			writeToReport("PASS", msg, "");
		} catch (Exception e) {
			msg = "Element : "+element.toString()+" is unable to find or unable to fill by input: "+input;
			writeToReport("FAIL", msg, e.getMessage());			
		}
	}
	
	/**
	 * 
	 * @param element
	 * @param inputtext
	 * 
	 * <p> This method used to perform selection operation on dropdown list or list box based on the option's text value.
	 */
	public void selectByVisibleText(WebElement element,String inputtext) {
		
		try {
			softassert.assertTrue(element.isEnabled());
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(inputtext);
			msg = "Element : "+element.toString()+" is selected by an option : "+inputtext+" Successfully!";
			writeToReport("PASS", msg, "");
		} catch (Exception e) {
			msg = "Element : "+element.toString()+" is unable to find or unable to fill by input: "+inputtext;
			writeToReport("FAIL", msg, e.getMessage());
			
		}
		
	}
	
	/**
	 * 
	 * @param element
	 * @param index
	 * 
	 * <p> This method used to perform selection operation on a specified web element based on the option's index. 
	 */
	public void selectByIndex(WebElement element,int index) {
		
		try {
			softassert.assertTrue(element.isDisplayed());
			Select dropdown = new Select(element);
			dropdown.selectByIndex(index);
			writeToReport("PASS", msg, "");
		} catch (Exception e) {
			writeToReport("FAIL", msg, e.getMessage());		
		}
	}
	
	/**
	 * 
	 * @param element
	 * @param value
	 * 
	 * <p> This method used to perform selection operation on a specific web element based on the option's value
	 */
	public void selectByValue(WebElement element,String value) {
	
		try {
			softassert.assertTrue(element.isDisplayed());
			Select dropdown = new Select(element);
			dropdown.selectByValue(value);
			writeToReport("PASS", msg, "");
		} catch (Exception e) {
			writeToReport("FAIL", msg, e.getMessage());		
		}
	}
	
	/**
	 * <p> This method used to refresh the current browser page
	 */
	public void refreshPage() {
		
		try {
			driver.navigate().refresh();
			writeToReport("PASS", msg, "");
		} catch (Exception e) {
			writeToReport("FAIL", msg, e.getMessage());			
		}
	}
	
	
	/**
	 * 
	 * @param element
	 * 
	 * <p> This method used to perform clicking operation on a specific web element presents in current web page.
	 */
	public void click(WebElement element) {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {
		softassert.assertTrue(element.isDisplayed());
		jse.executeScript("arguments[0].click();", element);
		msg = "Element: "+element.toString()+" got clicked Successfully!";
		writeToReport("PASS", msg, "");
		}catch(Exception e) {
			msg = "Unable to perform Click operation on Element: "+element.toString();
			writeToReport("FAIL", msg, e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param element
	 * 
	 * <p> This method returns a "text of web element presents in current web page or returns Not Available!!!
	 * @return text of a web element or Not Available!!!
	 */
	public String getText(Object element){
		
		String  text = null;
		
		if(element!=null) {
			if(element instanceof WebElement) {		
				WebElement we = (WebElement) element;
				
			try {
			softassert.assertTrue(we.isDisplayed());
			text =  we.getText();
			msg = "Text :"+text+" is able to read from Element: "+we.toString()+" Successfully!";
			writeToReport("PASS", msg, "");
				
			}catch(NoSuchElementException e) {
				text = "Not Available!!!";
				msg = we.toString()+" Element not Available!!!";
				writeToReport("FAIL", msg, e.getMessage());				
				return text;
				}
			}
			
		}else {
			text = "Not Available!!!";
		}
		return text;
	}
	
	/**
	 * 
	 * @param actual	 
	 * @param expected
	 * 
	 * <p> This method used to verify given two string parameters are equal
	 */
	public void verifyText(String actual,String expected) {
	
		if(actual.equals(expected)) {
			msg = "Expected text: "+expected+" matches with Actual text: "+actual;
		writeToReport("PASS", msg, "");
		}else {		
			msg = "Expected text: "+expected+" does not match with Actual text: "+actual;
			writeToReport("Fail", msg, "");
		}
	}
	
	
/*	public void isPresentOptional(WebElement webElement) {
		try {
			softassert.assertTrue(webElement.isDisplayed());
		writeToReport("PASS", msg, "");
		}catch(Exception e) {
			writeToReport("FAIL", msg, e.getMessage());
		}
	}
	
	public void isPresent(WebElement element) {
		try {
			softassert.assertTrue(element.isDisplayed());
		writeToReport("PASS", msg, "");
		}catch(Exception e) {
			writeToReport("FAIL", msg, e.getMessage());
		}
	}*/
	
	/**
	 * 
	 * @param elements
	 * 
	 * <p> This method used to verify the given array of web elements present in current web page
	 */
	public void verifyElementsPresence(WebElement[] elements) {
			
		for(WebElement element:elements) {
			try {
			softassert.assertTrue(element.isDisplayed());
			msg = "Element: "+element.toString()+"is available in UI";
			writeToReport("PASS", msg, "");
		}catch(Exception e) {
			msg = "Element: "+element.toString()+"is not available in UI";
			writeToReport("FAIL", msg, e.getMessage());
		}
		}
	}
	
	/**
	 * 
	 * @param root
	 * @param rootindex
	 * @param locatorvalue
	 * 
	 * <p> This method used to construct a dynamic web element at run time based on the locator and index of a root element and a locator of sub element
	 * 
	 * @return
	 */
	public WebElement constructElement(String root,int rootindex,String locatorvalue) {
		
		WebElement ele = null;
		try {
				ele = driver.findElement(By.xpath(root+"["+rootindex+"]"+locatorvalue));
		} catch (Exception e) {			
			//System.out.println(e.getMessage());
		}		
		return ele;		
	}
	

	/**
	 * 
	 * @param status
	 * @param msg
	 * @param excemsg
	 * 
	 * <p> This method used to log the status of all the methods present in this class and being called at run time.
	 * <p> This method also logs the execution details in ATU Reporter[Test report generator]
	 */
	public void writeToReport(String status, String msg, String excemsg) {
		
		
		if (status.equalsIgnoreCase("PASS")) {
			
			log.info(msg);
			ATUReports.add(msg, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		} else if (status.equalsIgnoreCase("FAIL")) {
	
			log.error(msg+"\n"+excemsg);
			
		ATUReports.add(msg+"\n"+excemsg, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
			
		}

	}
	
	public void verify(String exp,String act) {
	String msg = null;
		
		try {			 
			if(exp.equals(act)) {
			msg = "Expected Text : ["+exp+"] is available";
			writeToReport("PASS", msg, "");
			}else {
					msg = "Expected Text : ["+exp+"] is not matches with actual text: "+act;
					writeToReport("FAIL", msg, "");
			}
				
		} catch(NullPointerException n) {
			writeToReport("FAIL", msg, n.toString());
		} catch (Exception e) {
			msg = "Expected text: ["+exp+"] does not match with actual text ["+act +" ]";
			writeToReport("FAIL", msg, e.toString());
			
		}
	}
	
}
