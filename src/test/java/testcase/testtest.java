package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import core.CommonMethods;
@Listeners({ ATUReportsListener.class,ConfigurationListener.class,MethodListener.class})
public class testtest extends CommonMethods{
	{System.setProperty("atu.reporter.config", "./config/atu.properties");}
	@Test
	public void d() {
		
		launchBrowser("Chrome");
		launchURL("http://www.google.com");
		verify("asdf", "a");
	}
	
}
