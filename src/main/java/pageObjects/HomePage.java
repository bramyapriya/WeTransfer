package pageObjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utils.ConfigFileReader;
import utils.Constants;
import utils.Waiter;

/**
 * The Class HomePage.
 */
public class HomePage {

	/** The Constant Log. */
	static final Logger Log = Logger.getLogger(HomePage.class);
	private WebDriver driver;

	/**
	 * Instantiates a new home page.
	 * 
	 * @param driver the driver
	 */
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/** The btn user account. */
	@FindBy(how = How.CSS, using = "[class='menu button-myaccount userlogin']")
	private WebElement btnUserAccount;

	/** The btn select post code. */
	@FindBy(how = How.CSS, using = "#dropdown-location")
	private WebElement btnSelectPostCode;

	/** The btn close postal code. */
	@FindBy(how = How.CSS, using = "[class='atom-dropdown-icon']")
	private WebElement btnClosePostalCode;

	/** The tbx postal code. */
	@FindBy(how = How.ID, using = "imysearchstring")
	private WebElement tbxPostalCode;

	/** The tbx restaurant search box. */
	@FindBy(how = How.CSS, using = "[id='irestaurantsearchstring-middle'][placeholder='Zoek op restaurantnaam']")
	private WebElement tbxRestaurantSearchBox;

	/** The btn restaurant search icon. */
	@FindBy(how = How.CSS, using = "#irestaurantQ0ONNOO > div.detailswrapper > h2 > a")
	private WebElement btnRestaurantSearchIcon;

	/** The ddwn search result. */
	@FindBy(how = How.CSS, using = "[class='restaurant'][id^='irestaurant']")
	private List<WebElement> ddwnSearchResult;

	/** The ddwn QA restaurant. */
	@FindBy(how = How.CSS, using = "[class='restaurant'][id='irestaurantQ0ONNOO']")
	private WebElement ddwnQARestaurant;

	@FindBy(how = How.TAG_NAME, using = "a")
	private List<WebElement> healthCheckUrls;

	ConfigFileReader conf = new ConfigFileReader();
	SoftAssert softAssert = new SoftAssert();

	/**
	 * This method navigate the customer to login page of Thuisbezorgd.nl
	 */
	public void goToLoginPage() {
		btnUserAccount.click();
	}

	/**
	 * This method gets the value of the application url from the configuration file
	 * and loads it.
	 */
	public void navigateToHomePage() {
		Log.debug("Application base url is:" + conf.getApplicationURL());
		driver.get(conf.getApplicationURL()); // Reading the application url from configuration file
	}

	/**
	 * This method helps customer to select postal code.
	 */
	public void selectPostalCode() {
		tbxPostalCode.click();
		tbxPostalCode.sendKeys(Constants.postalCode);
		Log.debug("Customer postal code is:" + Constants.postalCode);
		tbxPostalCode.sendKeys(Keys.ENTER);
		Waiter.waitForCondition(driver, "eten", conf.getExplicitWaitTime());
	}

	/**
	 * This method helps customer to search for restaurant.
	 */
	public void searchForRestaurant() {
		Waiter.enterKeys(driver, tbxRestaurantSearchBox, Constants.restaurantName);
		Log.debug("Restaurant Name Is:" + Constants.restaurantName);
		Waiter.click(driver, btnRestaurantSearchIcon);
		//tbxRestaurantSearchBox.sendKeys(Keys.ENTER);
	}

	/**
	 * This method helps customer to Search for restaurant.
	 * 
	 * @param restaurantName the restaurant name
	 */
	public void searchForRestaurant(String restaurantName) {
		Waiter.enterKeys(driver, tbxRestaurantSearchBox, restaurantName);
		Waiter.click(driver, btnRestaurantSearchIcon, conf.getExplicitWaitTime());
	}

	/**
	 * This method helps customer to select QA Restaurant from list of the
	 * restaurants that are displayed.
	 */
	public void selectRestaurant() {
		for (int i = 0; i <= ddwnSearchResult.size(); i++) {
			if (ddwnSearchResult.get(i).getAttribute("id").equalsIgnoreCase(Constants.restaurantId)) {
				ddwnSearchResult.get(i).click();
				break;
			}
		}
	}

	/**
	 * Check whether QA restaurant is selected successfully or not from the
	 * available search options
	 * 
	 * @return true, if restaurant is selected successfully
	 * @return false, if restaurant is unsuccessful
	 */
	public Boolean isRestaurantSelectedSuccessfully() {
		if (driver.getCurrentUrl().contains("qa-restaurant-selenium")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isHomePageDisplayedSuccessfully() {
		if (btnUserAccount.isDisplayed()) {
			Log.info("Home page is displayed successfully.");
			return true;
		} else {
			Log.error("Failed to load the home page.");
			return false;
		}
	}

	/**
	 * Perform the check to verify the broken links in the application Test case
	 * will be marked as failed if any of the link HTTP status is other than 200.
	 * Soft assert is used here as it will verify all the link status even if one
	 * link fails it will continue to verify the status of the rest of the links
	 * with out terminating the program execution and report the overall status
	 * after verifying all the link status.
	 */
	public void performHealthCheck() {
		Log.debug("Total number of urls are:" + healthCheckUrls.size());
		for (int i = 0; i < healthCheckUrls.size(); i++) {
			WebElement element = healthCheckUrls.get(i);
			String url = element.getAttribute("href");
			softAssert.assertEquals(verifyActiveLinks(url), true);
		}
		softAssert.assertAll();
	}

	/**
	 * Verifies whether the internal urls are active or not. Report the status back
	 * to the calling method.
	 * 
	 * @param linkUrl
	 * @return
	 */
	public boolean verifyActiveLinks(String linkUrl) {
		boolean status = true;
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() == 200) {
				Log.debug("Active link url is: " + linkUrl + " - " + httpURLConnect.getResponseMessage());
				return status = true;
			} else {
				Log.error("Inactivate, forbidden, redirect url is: " + linkUrl + ":"
						+ httpURLConnect.getResponseMessage());
				return status = false;
			}
		} catch (Exception e) {
			Log.error("Failed to check the link status:" + e.getMessage());
		}
		return status;
	}
	
}
