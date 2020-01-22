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

	@When("^Customer opens the Thuisbezorgd application url$")
	public void customer_opens_the_Thuisbezorgd_application_url() {
		homepage.navigateToHomePage();
	}

	@Then("^application home page should be displayed successfully$")
	public void application_home_page_should_be_displayed_successfully() {
		homepage.isHomePageDisplayedSuccessfully();
	}

	@When("^Customer tries to check each and every thuizbezorgd urls to check their status$")
	public void customer_tries_to_check_each_and_every_thuizbezorgd_urls_to_check_their_status() {
		homepage.navigateToHomePage();
	}

	@Then("^Customer should get the information related to active and broken url status$")
	public void customer_should_get_the_information_related_to_active_and_broken_url_status() {
		homepage.performHealthCheck();
	}

}
