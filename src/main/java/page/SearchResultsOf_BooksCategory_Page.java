package page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author sukumarb
 *	
 *	<p> This page contains Web Element objects present in Books Search page </p>
 */
public class SearchResultsOf_BooksCategory_Page extends HomePage{

	@FindBy(id="nav-subnav")
	WebElement categorytab;
	
	@FindBy(xpath="//span[contains(text(),'results for')]//following-sibling::span[2]")
	WebElement searchkeyword;
	
	
	@FindBy(xpath="//div[@id='nav-subnav']/a[1]/span[contains(text(),'Books')]")
	WebElement bookslabel;
	
	String results_root_xpath = "//*[contains(@data-cel-widget,'search_result_') or contains(@id,'result_')]";
	WebElement results_root;
	
	String prodimage_xpath = "//img";
	WebElement prodimage;
	
	String titleofelement_xpath = "//a/h2 | //h5/a/span";		
	WebElement titleofelement;
	
	String publishedon_xpath = "//a/h2/parent::a/following-sibling::span[3]";	
	WebElement publishedon;
	
	String authors_xpath = "//span[text()='by ']/parent::div";
	WebElement authors;

	String eligibleforindia_xpath = "//span[contains(text(),'Eligible')]";
	WebElement eligibleforindia;
	
	String paperback_xpath = "//a[@title='Paperback']";
	WebElement paperback;
	
	String pbprice_xpath = "//a[@title='Paperback']/parent::div[1]/following-sibling::div[1]/a";
	WebElement paperbackprice;
	
	String hardcover_xpath = "//*[@title='Hardcover']";
	WebElement hardcover;
	
	String hardcoverprice_xpath = "//*[@title='Hardcover']/parent::div[1]/following-sibling::div[1]/a";
	WebElement hardcoverprice;
	
	String librarybinding_xpath = "//*[@data-attribute='Library Binding']";
	WebElement librarybinding;
	
	String lbprice_xpath = "//a[@title='Library Binding']/parent::div[1]/following-sibling::div/a";
	WebElement lbprice;
	
	String morebuyingchoiceslb_xpath = "//a[@title='Library Binding']/parent::div/following-sibling::div/div/a";
	WebElement morebuyingchoiceslb;			
	
	String suggesstedprice_xpath = "//span[contains(@aria-label,'Suggested')]";
	WebElement suggesstedprice;
		
	String instock_xpath = "//*[text()='In Stock']";
	WebElement instock;
	
	String pricemorebuyingchoices_xpath = "//*[text()='More Buying Choices']";
	WebElement morebuyingchoices;
	
	String priceusedandnew_xpath = "//*[text()='More Buying Choices']/parent::div/following-sibling::div/a";
	WebElement priceusedandnew;
	
	String kindleedition_xpath = "//a[@title='Kindle Edition'] | //a/[contains(text(),'Kindle')]";
	WebElement kindleedition;
	
	String kindleprice_xpath = "//a[@title='Kindle Edition']/parent::div/following-sibling::div/a//sup[1]/parent::span | //a/[contains(text(),'Kindle')]/parent::div/following-sibling::div/a//sup[1]/parent::span";
	WebElement kindleprice;
	
	String seeneweredition_xpath = "//a[contains(text(),'newer edition')]";
	WebElement seeneweredition;	
	
	String leftinstock_xpath = "//span[contains(text(),'left in stock')]";
	WebElement leftinstock;
	
	public SearchResultsOf_BooksCategory_Page() {
		assertPage();
	}
	
	/**
	 * This method used to verify the Search page specific elements to make sure the current page is Books Search page
	 * 
	 * @return Same class instance
	 */
	public SearchResultsOf_BooksCategory_Page assertPage() {
		WebElement[] specificelements = 
			{categorytab,bookslabel,searchkeyword};
		verifyElementsPresence(specificelements);
		return this;
	}

	/**	 
	 * @param index
	 * 
	 * <p> This method used to return the text value of title of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if title is not available.
	 * @return Same class instance
	 */
	public String getTitle(int index) {
		titleofelement = constructElement(results_root_xpath, index,  titleofelement_xpath);
		return getText(titleofelement);
	}
	/**	 
	 * @param index
	 * 
	 * <p> This method used to return the text value of Published on date of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if Published on date is not available.
	 * @return Same class instance
	 */
	public String getPublishedOn(int index) {
		publishedon= constructElement(results_root_xpath, index, publishedon_xpath);
		return getText(publishedon);
	}
	
	
	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of Authors of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if Authors detail is not available.
	 * @return Same class instance
	 */
	public String getAuthors(int index) {
		authors = constructElement(results_root_xpath, index, authors_xpath);
		return getText(authors);
	}
	
	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of Eligible for ship to India detail of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if Shipping detail is not available.
	 * @return Same class instance
	 */
	public String getShippingEligible(int index) {
		eligibleforindia = constructElement(results_root_xpath, index,   eligibleforindia_xpath);
		return getText(eligibleforindia);
	}
	
	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of Paperback option of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if Paperback option is not available.
	 * @return Same class instance
	 */
	public String getPaperBack(int index) {
		paperback = constructElement(results_root_xpath, index,  paperback_xpath);	
		return getText(paperback);
	}
	
	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of Paperback price of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if Paperback price is not available.
	 * @return Same class instance
	 */
	public String getPriceOfPaperBack(int index) {
		paperbackprice= constructElement(results_root_xpath, index,  pbprice_xpath);		
		return getText(paperbackprice);
	}
	
	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of Suggested price option for paperback edition of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if Suggested price option for paperback edition is not available.
	 * @return Same class instance
	 */
	public String getSuggesstedPrice(int index) {
		suggesstedprice = constructElement(results_root_xpath, index, suggesstedprice_xpath);	
		return getText(suggesstedprice);
	}
	
	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of In stock details of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if In Stock detail is not available.
	 * @return Same class instance
	 */
	public String getInStock(int index) {
		instock = constructElement(results_root_xpath, index,  instock_xpath);
		return getText(instock);
	}
	
	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of More Buying choices of Paperback edition of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if More Buying choices of Paperback edition is not available.
	 * @return Same class instance
	 */
	public String getMoreBuyingChoices(int index) {
		morebuyingchoices = constructElement(results_root_xpath, index,  pricemorebuyingchoices_xpath);
		return getText(morebuyingchoices);
	}
	
	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of Used & New details of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if Used & New details is not available.
	 * @return Same class instance
	 */
	public String getUseAndNewDetails(int index) {
		priceusedandnew = constructElement(results_root_xpath, index, priceusedandnew_xpath);
		return getText(priceusedandnew);
	}
	
	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of Kindle edition option of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if Kindle edition option is not available.
	 * @return Same class instance
	 */
	public String getKindleEdition(int index) {
		kindleedition = constructElement(results_root_xpath, index,  kindleedition_xpath);	
		return getText(kindleedition);
	}
	
	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of Kindle edition price of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if Kindle edition price is not available.
	 * @return Same class instance
	 */
	public String getKindlePrice(int index) {
		kindleprice = constructElement(results_root_xpath, index,  kindleprice_xpath);		
		return getText(kindleprice);
	}
	
	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of Hard Cover option of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if Hard Cover option is not available.
	 * @return Same class instance
	 */
	public String getHardCover(int index) {
		hardcover = constructElement(results_root_xpath, index, hardcover_xpath);
		return getText(hardcover);
	}
	
	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of Hard Cover price of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if Hard Cover price is not available.
	 * @return Same class instance
	 */
	public String getHardCoverPrice(int index) {
		hardcover = constructElement(results_root_xpath, index, hardcoverprice_xpath);
		return getText(hardcoverprice);
	}

	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of Library Binding option of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if Library Binding option is not available.
	 * @return Same class instance
	 */
	public String getLibraryBinding(int index) {
		librarybinding = constructElement(results_root_xpath, index, librarybinding_xpath);
		return getText(librarybinding);
	}

	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of Library Binding price of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if Library Binding price is not available.
	 * @return Same class instance
	 */
	public String getLibraryBindingPrice(int index) {
		lbprice = constructElement(results_root_xpath, index, lbprice_xpath);
		return getText(lbprice);
	}

	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of More Buying choice for Library Binding option of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! ifMore Buying choice for Library Binding option is not available.
	 * @return Same class instance
	 */
	public String getMoreBuyingChoicesOfLB(int index) {
		morebuyingchoiceslb = constructElement(results_root_xpath, index, morebuyingchoiceslb_xpath);
		return getText(morebuyingchoiceslb);
	}
	
	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of See Newer Edition option of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if See Newer Edition is not available.
	 * @return Same class instance
	 */
	public String getSeeNewerEdition(int index) {
		seeneweredition = constructElement(results_root_xpath, index, seeneweredition_xpath);
		return getText(seeneweredition);
	}
	
	/**	
	 * @param index
	 * 
	 * <p> This method used to return the text value of Left In stock option of a Book in the search result's page based on the index position(1 to greater) from top to bottom </p>
	 * <p> Returns Not Available!!! if Left in Stock option is not available.
	 * @return Same class instance
	 */
	public String getLeftInStock(int index) {
		leftinstock = constructElement(results_root_xpath, index, leftinstock_xpath);
		return getText(leftinstock);
	}
	
	/**	
	 * @param index
	 * 
	 * <p> This method used to read the details present for a book  based on the index
	 * 		in the search results page and Returns a Book class instance which contains the below parameters,/p>
	 * 
	 * 		<p>Title, Published on date, Authors, Eligible for shipping to India, 
	 * 		Paperback edition, Price of Paperback edition, Suggested price for Paper back edition,
	 * 		In Stock details, More Buying choices for Paper back edition, Used and New details,
	 * 		Kindle edition, Price of Kindle edition, Hard cover edition, Price of Hard Cover edition,
	 * 		Library Binding edition, Price of Library Binding edition, 
	 * 		Newer edition option and Minimum number of Products left in stock.</p>
	 * 	
	 * @return Book class instance
	 */
	public Book readFirstBookDetails() {
		int index = 1;
		
		return new Book(
		getTitle(index),
		getPublishedOn(index),
		getAuthors(index),
		getShippingEligible(index),
		getPaperBack(index),
		getPriceOfPaperBack(index),
		getSuggesstedPrice(index),
		getInStock(index),
		getMoreBuyingChoices(index),
		getUseAndNewDetails(index),
		getKindleEdition(index),
		getKindlePrice(index),
		getHardCover(index),
		getHardCoverPrice(index),	
		getLibraryBinding(index),
		getLibraryBindingPrice(index),
		getMoreBuyingChoicesOfLB(index),		
		getSeeNewerEdition(index),
		getLeftInStock(index)
		
			);
	}
	 
	
	/**
	 * 
	 * @author sukumarb
	 *	This class used to hold the properties of a Book displayed 
	 *	in search results page and has getter methods to return values of each properties</p>
	 */
	public class Book{
		
		String title = null;
		String publishedon = null;
		String authors = null;
		String eligibletoshipindia = null;
		String paperback = null;
		String pbprice = null;
		String suggesstedprice = null;
		String instock = null;
		String morebuyingchoices = null;
		String priceusedandnew = null;
		String kindleedition = null;
		String kindleprice = null;
		String hardcover = null;
		String hardcoverprice = null;
		String librarybinding = null;
		String librarybindingprice = null;
		String morebuyingchoicesoflb = null;
		String seeneweredition = null;
		String leftinstock = null;

		/**	
		 * @param index
		 * 
		 * <p> This constructor block is used to initialize the properties of a book 
		 * 		in the search results page and Returns a Book class instance which contains the below parameters,/p>
		 * 
		 * 		<p>Title, Published on date, Authors, Eligible for shipping to India, 
		 * 		Paperback edition, Price of Paperback edition, Suggested price for Paper back edition,
		 * 		In Stock details, More Buying choices for Paper back edition, Used and New details,
		 * 		Kindle edition, Price of Kindle edition, Hard cover edition, Price of Hard Cover edition,
		 * 		Library Binding edition, Price of Library Binding edition, 
		 * 		Newer edition option and Minimum number of Products left in stock.</p>
		 * 	
		 */
		
		public Book(String title,
					String publishedon,
					String authors,
					String eligibletoshipindia,
					String paperback,
					String pbprice, 
					String suggesstedprice,
					String instock,
					String morebuyingchoices,
					String priceusedandnew,
					String kindleedition,
					String kindleprice,
					String hardcover,
					String hardcoverprice, 
					String librarybinding,
					String librarybindingprice, 
					String morebuyingchoicesoflb, 
					String seeneweredition, 
					String leftinstock
					){
			 this.title = title ;
			 this.publishedon = publishedon;
			 this.authors = authors;
			 this.eligibletoshipindia = eligibletoshipindia;
			 this.paperback = paperback;
			 this.pbprice = pbprice;
			 this.suggesstedprice = suggesstedprice;
			 this.instock = instock;
			 this.morebuyingchoices = morebuyingchoices;
			 this.priceusedandnew = priceusedandnew;
			 this.kindleedition = kindleedition;
			 this.kindleprice = kindleprice;
			 this.hardcover = hardcover;
			 this.hardcoverprice = hardcoverprice;
			 this.librarybinding = librarybindingprice;
			 this.librarybindingprice=librarybindingprice;
			 this.morebuyingchoicesoflb = morebuyingchoicesoflb;
			 this.seeneweredition = seeneweredition;
			 this.leftinstock = leftinstock;
			
		}
		
		/**
		 * 	@returns HardCover value of a Book object
		 */
		public String getHardcover() {
			return hardcover;
		}
		
		
		/**
		 * 	@returns HardCover Price of a Book object
		 */
		public String getHardcoverprice() {
			return hardcoverprice;
		}
		/**
		 * 	@returns Library Binding value of a Book object
		 */
		public String getLibrarybinding() {
			return librarybinding;
		}
		/**
		 * 	@returns Library Binding price of a Book object
		 */
		public String getLibrarybindingprice() {
			return librarybindingprice;
		}
		/**
		 * 	@returns More Buying Choices for Library binding of a Book object
		 */
		public String getMorebuyingchoicesoflb() {
			return morebuyingchoicesoflb;
		}

		/**
		 * 	@returns Newer edition option of a Book object
		 */
		public String getSeeneweredition() {
			return seeneweredition;
		}

		/**
		 * 	@returns Limited stock details of a Book object
		 */
		public String getLeftinstock() {
			return leftinstock;
		}
		
		/**
		 * 	@returns Title of a Book object
		 */
		public String getTitle() {
			return title;
		}
		
		/**
		 * 	@returns Published on date of a Book object
		 */
		public String getPublishedon() {
			return publishedon;
		}
		
		/**
		 * 	@returns Authors of a Book object
		 */
		public String getAuthors() {
			return authors;
		}
		
		/**
		 * 	@returns Eligible for shipping to India of a Book object
		 */
		public String getEligibleToShipIndia() {
			return eligibletoshipindia;
		}
		
		/**
		 * 	@returns Paperback value of a Book object
		 */
		public String getPaperback() {
			return paperback;
		}
		
		/**
		 * 	@returns Paperback price of a Book object
		 */
		public String getPaperbackPrice() {
			return pbprice;
		}
		
		/**
		 * 	@returns Suggested price for Paper cover edition of a Book object
		 */
		public String getSuggesstedPrice() {
			return suggesstedprice;
		}
		
		/**
		 * 	@returns In stock details of a Book object
		 */
		public String getInstock() {
			return instock;
		}
		
		/**
		 * 	@returns More Buying choices for Paperback edition of a Book object
		 */
		public String getMoreBuyingChoices() {
			return morebuyingchoices;
		}
		
		/**
		 * 	@returns Used and New details of a Book object
		 */
		public String getUsedAndNew() {
			return priceusedandnew;
		}
		
		/**
		 * 	@returns Kindle edition of a Book object
		 */
		public String getKindleEdition() {
			return kindleedition;
		}
		
		/**
		 * 	@returns Kindle edition price of a Book object
		 */
		public String getKindlePrice() {
			return kindleprice;
		}
		
		/**	
		 * @param index
		 * 
		 * <p> This method used to display the properties of a instance
		 * 
		 * 	<p>Properties details below:-</p>
		 * 		<p>Title, Published on date, Authors, Eligible for shipping to India, 
		 * 		Paperback edition, Price of Paperback edition, Suggested price for Paper back edition,
		 * 		In Stock details, More Buying choices for Paper back edition, Used and New details,
		 * 		Kindle edition, Price of Kindle edition, Hard cover edition, Price of Hard Cover edition,
		 * 		Library Binding edition, Price of Library Binding edition, 
		 * 		Newer edition option and Minimum number of Products left in stock.</p>
		 * 	
		 */
		public void displayBookDetails() {
			System.out.println("Title "+getTitle());
			System.out.println("Published on "+getPublishedon());
			System.out.println("Authors "+getAuthors());
			System.out.println("Eligible for india"+getEligibleToShipIndia());
			System.out.println("Paperback "+getPaperback());
			System.out.println("Paperback price "+getPaperbackPrice());
			System.out.println("Suggessted Paperback price : "+getSuggesstedPrice());
			System.out.println("In Stock "+getInstock());
			System.out.println("More Buying choices "+getMoreBuyingChoices());
			System.out.println("Used and New "+getUsedAndNew());
			System.out.println("Kindle edition "+getKindleEdition());
			System.out.println("Kindle Price "+getKindlePrice());	
			System.out.println("Hard Cover "+getHardcover());
			System.out.println("Hard Cover Price "+getHardcoverprice());
			System.out.println("Library Binding "+getLibrarybinding());
			System.out.println("Library Binding Price "+getLibrarybindingprice());
			System.out.println("See Newer Edition "+getSeeneweredition());
			System.out.println("Left In Stock "+getLeftinstock());

		}
				
	}
	
}
