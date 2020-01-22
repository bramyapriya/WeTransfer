package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LogOutStep {
	private HomePage homepage;
	private LoginPage loginPage;
    private WebDriver driver;

    public LogOutStep(Hooks hook) {
        this.driver = hook.getDriver();
        homepage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
    
    @When("^Customer clicks on logout button$")
    public void customer_clicks_on_logout_button() {
       homepage.goToLoginPage();
       loginPage.executeLogOut();
    }

    @Then("^Customer should be logged out from the aplication successfully$")
    public void customer_should_be_logged_out_from_the_aplication_successfully() {
       Assert.assertTrue(loginPage.isLogOutSuccessfull(), "Failed to logout from the application.");
    }


}
