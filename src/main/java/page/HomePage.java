package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author sukumarb
 *
 *	<p> This page class contains web element objects and methods to perform related application actions.
 *</p>
 */

public class HomePage extends BasePage{

	@FindBy(css="#searchDropdownBox")
	WebElement searchdropdown;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchbox;
	
	@FindBy(xpath="//input[@type='submit' and @value='Go']")
	WebElement searchbtn;
	
	@FindBy(css=".nav-search-label")
	WebElement searchLabel;

	@FindBy(css=".a-carousel-goto-prevpage i")
	WebElement previousicon;
	
	@FindBy(css=".a-carousel-goto-nextpage i")
	WebElement nexticon;
	
	/**
	 * This method used to verify the Product category drop down is by default selected as "All".
	 * @return Same class instance
	 */
	public HomePage verifySearchLabel() {
		verifyText(getText(searchLabel), "All");
		return this;
	}
	
	/**
	 * This method used to verify the Home page specific elements to make sure the current page is Home page
	 * 
	 * @return Same class instance
	 */
	public HomePage assertPage() {
		WebElement[] specificelements = {previousicon,nexticon};
		verifyElementsPresence(specificelements);
		return this;
	}
	
	/**
	 * This method used to select the value "Books" from product category drop down from Home page
	 * @return Same class instance
	 */
	public HomePage selectBooksOption() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectByVisibleText(searchdropdown, "Books");
		return this;
	}
	
	/**
	 * 
	 * @param keyword
	 * 
	 * This method used to type the search keyword in search box from Home page
	 * @return Same class instance
	 */
	public HomePage enterSearchKeyWord(String keyword) {
		type(searchbox, keyword);
		return this;
	}
	
	/**
	 * This method used to click the "Search" button from Home page
	 * @return Same class instance
	 */
	public HomePage clickSearchButton() {
		click(searchbtn);
		return this;
	}
	
	
	
	
	
	
	
}
