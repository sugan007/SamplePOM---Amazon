package page;

import org.openqa.selenium.support.PageFactory;

import core.CommonMethods;
/**
 * 
 * @author sukumarb
 *	 <p> This class used to initialize page object elements in this project
 */
public class BasePage extends CommonMethods{

	/**
	 * <p>Constructor used to initialize all the page objects elements present in the sub classes.</p>
	 */
	public BasePage() {
		PageFactory.initElements(CommonMethods.driver, this);
	}
}
