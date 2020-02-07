package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.TransferFilePage;

public class TransferFileStep {
	private HomePage homepage;
	private WebDriver driver;
	private TransferFilePage transferFilePage;

	public TransferFileStep(Hooks hook) {
		this.driver = hook.getDriver();
		homepage = new HomePage(driver);
		transferFilePage = new TransferFilePage(driver);
	}

	@Given("^User is on WeTransfer homepage$")
	public void user_is_on_WeTransfer_homepage() {
		homepage.navigateToHomePage();
		homepage.AcceptConditions();
	}

	@When("^User uploads the file using link transfer$")
	public void user_uploads_the_file_using_link_transfer() throws Exception {
		transferFilePage.AddFiles();
		transferFilePage.UploadFile();
	}

	@Then("^File should be uploaded$")
	public void file_should_be_uploaded() {
		Assert.assertTrue("Failed to upload the file to we transfer", transferFilePage.IsFileUploadedSuccessfully());
	}

}
