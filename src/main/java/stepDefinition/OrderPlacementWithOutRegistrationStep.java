package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OrderPlacementPage;
import utils.Constants;

public class OrderPlacementWithOutRegistrationStep {
	private OrderPlacementPage orderPlacementPage;
	private HomePage homePage;
	private LoginPage loginPage;
	private WebDriver driver;

	// using dependency injection for Hook
	public OrderPlacementWithOutRegistrationStep(Hooks hook) {
		this.driver = hook.getDriver();
		homePage = new HomePage(driver);
		orderPlacementPage = new OrderPlacementPage(driver);
		loginPage = new LoginPage(driver);
	}

	
	@Given("^Customer is on Thuizbezorgd home page$")
	public void customer_is_on_Thuizbezorgd_home_page()  {
		homePage.navigateToHomePage();
		homePage.selectPostalCode();
	}
	
	@Given("^Customer is logged in to Thuizbezorgd$")
	public void customer_is_logged_in_to_Thuizbezorgd() {
		homePage.navigateToHomePage();
		homePage.goToLoginPage();
		loginPage.navigateToLogin();
		loginPage.executeUserLogin(Constants.userName, Constants.userPassword);
		homePage.selectPostalCode();
	}
	
	@Given("^Selects restaurant from the list of available restaurants in their postalcode$")
	public void selects_restaurant_from_the_list_of_available_restaurants_in_their_postalcode()  {
		homePage.searchForRestaurant();
		//homePage.selectRestaurant();
		Assert.assertTrue(homePage.isRestaurantSelectedSuccessfully(), "Unable to select the restaurant.");
	}


	@When("^Customer selects the fooditems as of his choice from the menu options$")
	public void customer_selects_the_fooditems_as_of_his_choice_from_the_menu_options() {
		orderPlacementPage.selectItemsForOrder();
		orderPlacementPage.addToCartAndOrder();
	}
	
	@When("^When Customer selects thier favourite dishes from the menu$")
	public void when_Customer_selects_thier_favourite_dishes_from_the_menu()  {
		orderPlacementPage.selectItemsForOrder();
		
	}
	
	@When("^Customer add comments to the indvidual items in the order basket$")
	public void customer_add_coments_to_the_indvidual_items_in_the_order_basket()  {
		orderPlacementPage.addCommentsToItems();
	}

	@When("^Customer fills in the delivery details and tries to perform ideal payment$")
	public void customer_selects_the_option_of_delivering_at_existing_address_and_tries_to_perform_ideal_payment()  {
		orderPlacementPage.fillInDeliveryDetails();
		orderPlacementPage.performsIdealPayment();
	}
	
	@When("^Cancels the ideal payment and performs cash payment$")
	public void cancels_the_ideal_payment_and_performs_cash_payment() {
		orderPlacementPage.cancelIdealPayment();
		orderPlacementPage.executeCashPayment();
	}

	@Then("^Order should be placed successfully$")
	public void order_should_be_placed_successfully() {
		Assert.assertTrue(orderPlacementPage.IsCashPaymentSuccessful(), "Failed to place the order.");
	}
	

	@When("^Customer selects thier favourite dishes from the menu$")
	public void customer_selects_thier_favourite_dishes_from_the_menu() {
		orderPlacementPage.selectItemsForOrder();
	}
	
	
	@Then("^If customer removes an item from basket than item should be deleted successfully from the basket$")
	public void if_customer_removes_an_item_than_item_should_be_deleted_successfully() {
	Assert.assertTrue(orderPlacementPage.deleteItemFromOrderCart(), "Failed to delete the items from cart.");
	}
	
	@When("^Fill in their delivery details$")
	public void fill_in_their_delivery_details()  {
		orderPlacementPage.addToCartAndOrder();
		orderPlacementPage.fillInDeliveryDetails();
	}

	@Then("^Field validation should be performed on delivery details$")
	public void field_validation_should_be_performed_on_delivery_details()  {
		orderPlacementPage.PerformFieldValidation();
	}
	
	@When("^Customer adds the required food items to the basket$")
	public void customer_adds_the_required_food_items_to_the_basket() {
		orderPlacementPage.selectItemsForOrder();
	}

	@When("^Later on customer tries to add extra quantity of any food item in the basket$")
	public void later_on_customer_tries_to_add_extra_quantity_of_any_food_item_in_the_basket() {
	    orderPlacementPage.orderExtraQuantity();
	}

	@Then("^Extra quantity should be placed successfully$")
	public void extra_quantity_should_be_placed_successfully() {
	    orderPlacementPage.isEditExtraQuantitySuccessful();
	}

@When("^Later on customer tries to remove the extra quantity of duck breast item in the basket$")
public void later_on_customer_tries_to_remove_the_extra_quantity_of_duck_breast_item_in_the_basket() {
	orderPlacementPage.removesExtraQuantity();
   
}

@Then("^Extra quantity should be deleted successfully$")
public void extra_quantity_should_be_deleted_successfully()  {
   orderPlacementPage.isRemovesExtraQuantitySuccessful();
}

}
