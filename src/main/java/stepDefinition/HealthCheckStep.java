package stepDefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;

public class HealthCheckStep {
	private HomePage homepage;
	private WebDriver driver;

	public HealthCheckStep(Hooks hook) {
		this.driver = hook.getDriver();
		homepage = new HomePage(driver);
	}

	@When("^User navigates to homepage$")
	public void user_navigates_to_homepage() {
		homepage.navigateToHomePage();
	}

	@Then("^Home page should be loaded successfully$")
	public void home_page_should_be_loaded_successfully() {
		homepage.isHomePageDisplayedSuccessfully();
	}

	@When("^User checks for the status of all links in the application$")
	public void user_checks_for_the_status_of_all_links_in_the_application() {
		homepage.navigateToHomePage();
	}

	@Then("^User should get the information related to active and broken url$")
	public void user_should_get_the_information_related_to_active_and_broken_url() {
		homepage.performHealthCheck();
	}

}
