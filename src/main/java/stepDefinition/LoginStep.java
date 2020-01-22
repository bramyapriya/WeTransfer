package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.Constants;

public class LoginStep {
	private HomePage homepage;
	private LoginPage loginPage;
    private WebDriver driver;

    public LoginStep(Hooks hook) {
        this.driver = hook.getDriver();
        homepage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
    
	@Given("^Customer is on ThuisBezorgd home page$")
	public void customer_is_on_ThuisBezorgd_home_page()  {
		homepage.navigateToHomePage();
	}

	@Given("^Customer navigates to login page$")
	public void customer_navigates_to_login_page() {
		homepage.goToLoginPage();
		loginPage.openLogin();
	}
	
	@Given("^Customer navigates to application login page$")
	public void customer_navigates_to_application_login_page()  {
		homepage.goToLoginPage();
		loginPage.navigateToLogin();
	}
	
	@When("^Customer enters the credentials \"([^\"]*)\" and \"([^\"]*)\" submit the login button$")
	public void customer_enters_valid_username_password_and_submit_login(String userName, String userPassword) {
		loginPage.executeLogin(userName, userPassword);
	}
	
	@When("^Customer enters username and password and submit the login button$")
	public void customer_enters_username_and_password_and_submit_the_login_button()  {
		loginPage.executeUserLogin(Constants.userName, Constants.userPassword);
	}

	@Then("^Customer should be successfully logged in to the application$")
	public void customer_should_be_successfully_logged_in_to_the_application()  {
		Assert.assertTrue("User failed to login to the application.", loginPage.isLoginSuccessful());
	}
	
	@Then("^Customer should not be able to login to the application$")
	public void customer_should_not_be_able_to_login_to_the_application()  {
		Assert.assertTrue("User login is successful.", loginPage.isLoginUnSuccessful());
	}
	
}
