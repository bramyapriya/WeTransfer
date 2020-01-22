package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.Waiter;

/**
 * The Class LoginPage.
 */
public class LoginPage {

	private WebDriver driver;

	/**
	 * Instantiates a new login page.
	 * 
	 * @param driver the driver
	 */
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/** This is the webelement for tbxUserName. */
	@FindBy(how = How.CSS, using = "#iusername")
	private WebElement tbxUserName;

	/** The tbx user password. */
	@FindBy(how = How.CSS, using = "#ipassword")
	private WebElement tbxUserPassword;

	/** The btn sign in. */
	@FindBy(how = How.CSS, using = "[class='button_form button-cta-small']")
	private WebElement btnSignIn;

	/** The btn log in. */
	@FindBy(how = How.CSS, using = "[data-click='login']")
	private WebElement btnLogIn;

	/** The tbx logged in user. */
	@FindBy(how = How.CSS, using = "[class='name']")
	private WebElement tbxLoggedInUser;

	/** The btn close login screen. */
	@FindBy(how = How.CSS, using = "[class='modal-close']")
	private WebElement btnCloseLoginScreen;

	/** The btn log out. */
	@FindBy(how = How.CSS, using = "[data-click='logout']")
	private WebElement btnLogOut;

	/** The tbx login error text. */
	@FindBy(how = How.CSS, using = "#notification")
	private WebElement tbxLoginErrorText;
	static final Logger Log = Logger.getLogger(LoginPage.class);

	/**
	 * This method is used to log in to the application..
	 * 
	 * @param userName     the user name
	 * @param userPassword the user password
	 */
	public void executeUserLogin(String userName, String userPassword) {
		Waiter.click(driver, tbxUserName);
		Waiter.enterKeys(driver, tbxUserName, userName);
		Log.debug("Entered userName is:" + userName);
		Waiter.enterKeys(driver, tbxUserPassword, userPassword);
		Log.debug("Entered password Is:" + userPassword);
		btnSignIn.click();
		// Closes the login popup window.
		Waiter.click(driver, btnCloseLoginScreen);
	}

	/**
	 * This method is used to log in to the application. This is created to make the
	 * smoke & regression cases independent with each other.
	 * 
	 * @param userName     the user name
	 * @param userPassword the user password
	 */
	public void executeLogin(String userName, String userPassword) {
		Waiter.click(driver, tbxUserName);
		Waiter.enterKeys(driver, tbxUserName, userName);
		Log.debug("Entered userName is:" + userName);
		Waiter.enterKeys(driver, tbxUserPassword, userPassword);
		Log.debug("Entered password Is:" + userPassword);
		btnSignIn.click();
	}

	/**
	 * This method is used to open login page of Thuisbezorgd.nl login page.
	 */
	public void openLogin() {
		if (!tbxLoggedInUser.getText().equalsIgnoreCase("Mijn account")) {
			Waiter.click(driver, btnLogOut);
		}
		btnLogIn.click();
	}

	/**
	 * This method checks if the user login is successful or not
	 * 
	 * @return true, if is login successful
	 * @return false, if the login is unsuccessful.
	 */
	public boolean isLoginSuccessful() {
		if (tbxLoggedInUser.getText() != null && !tbxLoggedInUser.getText().equalsIgnoreCase("Mijn account")) {
			// btnCloseLoginScreen.click();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method checks if the login is unsuccessful or not
	 * 
	 * @return true, if the login is unsuccessful and
	 * @return false, if the login is successful.
	 */
	public boolean isLoginUnSuccessful() {
		if (tbxLoginErrorText.getText().contains("wachtwoord en probeer het opnieuw.")) {
			Log.debug("User successfully logged in to the application");
			return true;
		} else {
			Log.error("Unale to login to the application.");
			return false;
		}
	}

	/**
	 * This method is used to logout from the application.
	 */
	public void executeLogOut() {
		Log.debug("Trying to logout the user.");
		Waiter.focusOnElement(driver, btnLogOut);
		Waiter.clickViaJS(btnLogOut, driver);
		//Waiter.click(driver, btnLogOut);
	}

	/**
	 * Checks if is log out is successful
	 * 
	 * @return true, if is log out successful
	 * @return false, if the logout is unsuccessful
	 */
	public boolean isLogOutSuccessfull() {
		if (btnLogIn.isDisplayed()) {
			Log.debug("User successfully loggedout from the application.");
			return true;
		} else {
			Log.error("Failed to logout from the application.");
			return false;
		}
	}
	/**
	 * This method is used to open login page of Thuisbezorgd.nl login page. This is
	 * created to make the smoke & regression cases independent with each other.
	 */
	public void navigateToLogin() {
	Waiter.click(driver, btnLogIn);
	}
	/**
	 * This method checks if the user login is successful or not for smoke test
	 * cases This is created to make the smoke & regression cases independent with
	 * each other.
	 * 
	 * @return true, if is login successful
	 * @return false, if the login is unsuccessful.
	 */
	public boolean isSuccessfulLogin() {
		if (tbxLoggedInUser.getText() != null && !tbxLoggedInUser.getText().equalsIgnoreCase("Mijn account")) {
			Log.debug("User successfully logged in to the application");
			return true;
		} else {
			Log.error("Unale to login to the application.");
			return false;
		}
	}
}