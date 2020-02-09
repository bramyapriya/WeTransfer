package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utils.ConfigFileReader;
import utils.LinkChecker;
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

	@FindBy(how = How.CSS, using = ".welcome__agree")
	private WebElement btnIagree;

	@FindBy(how = How.CSS, using = "[viewBox='0 0 72 72']")
	private WebElement btnUpload;

	@FindBy(how = How.TAG_NAME, using = "a")
	private List<WebElement> healthCheckUrls;

	ConfigFileReader conf = new ConfigFileReader();
	SoftAssert softAssert = new SoftAssert();

	/**
	 * This method gets the value of the application url from the configuration file
	 * and loads wetransfer home page.
	 */
	public void navigateToHomePage() {
		Log.debug("Application base url is:" + conf.getApplicationURL());
		driver.get(conf.getApplicationURL()); // Reading the application url from configuration file
	}

	public void AcceptConditions() {
		Waiter.click(driver, btnIagree);
	}

	public boolean isHomePageDisplayedSuccessfully() {
		if (Waiter.isClickable(driver, btnUpload)) {
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
			softAssert.assertEquals(LinkChecker.verifyActiveLinks(url), true);
		}
		softAssert.assertAll();
	}

}
