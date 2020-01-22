package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.OrderPlacementPage;

public class OrderPlacementWithRegistrationStep {
	private OrderPlacementPage orderPlacementPage;
	private HomePage homePage;
    private WebDriver driver;

    public OrderPlacementWithRegistrationStep(Hooks hook) {
        this.driver = hook.getDriver();
        homePage = new HomePage(driver);
        orderPlacementPage = new OrderPlacementPage(driver);
    }
    
	  @Given("^Customer enters the postcode of his residence$") public void
	  customer_enters_the_postcode_of_his_residence() {
	  homePage.selectPostalCode(); homePage.searchForRestaurant(); }
	  
	  @Given("^selects QA restaurant selenium from the list of available restaurants$"
	  ) public void
	  selects_QA_restaurant_selenium_from_the_list_of_available_restaurants() {
	  homePage.searchForRestaurant(); homePage.selectRestaurant();
	  Assert.assertTrue(homePage.isRestaurantSelectedSuccessfully(),
	  "Unable to select the restaurant."); }
	  
	  @When("^Customer selects the food items of his choice from the menu options$"
	  ) public void
	  customer_selects_the_food_items_of_his_choice_from_the_menu_options() {
	  orderPlacementPage.selectItemsForOrder();
	  orderPlacementPage.addToCartAndOrder(); }
	 
	  @When("^Customer selects the option of delivering at existing address and tries to perform ideal payment$")
	  public void customer_selects_the_option_of_delivering_at_existing_address()  {
		  orderPlacementPage.selectExistingAddress();
		  orderPlacementPage.performsIdealPayment();
	  }

}
