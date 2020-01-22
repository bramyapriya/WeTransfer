package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.ConfigFileReader;
import utils.Constants;
import utils.Waiter;

/**
 * The Class holds the information related to the OrderPlacementPage. All the
 * actions on order payment page is executed in this class.
 */
public class OrderPlacementPage {
	private static final Logger Log = Logger.getLogger(OrderPlacementPage.class);

	/** The driver. */
	private WebDriver driver;

	/**
	 * Instantiates a new order placement page.
	 * 
	 * @param driver the driver
	 */
	public OrderPlacementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/** The btn duck breast. */
	@FindBy(how = How.CSS, using = "[id='popularQ1N30PNRN']")
	private WebElement btnDuckBreast;

	/** The btn salami. */
	@FindBy(how = How.CSS, using = "[id='popularQON30PNRN']")
	private WebElement btnSalami;

	/** The btn coke. */
	@FindBy(how = How.CSS, using = "[id='QQ010PNRN']")
	private WebElement btnCoke;

	/** The cbx tomato. */
	@FindBy(how = How.XPATH, using = "//*[@id='isidedishselectionformQ1N30PNRN']/div[1]/div[2]/div[1]/label")
	private WebElement cbxTomato;

	/** The btn add to cart duck. */
	@FindBy(how = How.CSS, using = "[class='cartbutton-button cartbutton-button-sidedishes add-btn-icon']")
	private WebElement btnAddToCartDuck;

	/** The btn shopping cart. */
	//@FindBy(how = How.CSS, using = "[class='btn-text-placeholder']")
	//private WebElement btnShoppingCart;

	/** The btn to order. */
	@FindBy(how = How.CSS, using = "[class='basket__order-button cartbutton-button']")
	private WebElement btnToOrder;

	/** The tbx street name. */
	@FindBy(how = How.CSS, using = "[id='iaddress']")
	private WebElement tbxStreetName;

	/** The tbx post code. */
	@FindBy(how = How.CSS, using = "[id='ipostcode']")
	private WebElement tbxPostCode;

	/** The tbx place name. */
	@FindBy(how = How.CSS, using = "[id='itown']")
	private WebElement tbxPlaceName;

	/** The tbx user name. */
	@FindBy(how = How.CSS, using = "[id='isurname']")
	private WebElement tbxUserName;

	/** The tbx useremail. */
	@FindBy(how = How.CSS, using = "[name='email']")
	private WebElement tbxUseremail;

	/** The tbx mobile phone. */
	@FindBy(how = How.CSS, using = "[id='iphonenumber']")
	private WebElement tbxMobilePhone;
	
	/** The tbx company name. */
	@FindBy(how = How.CSS, using = "[id='icompanyname']")
	private WebElement tbxCompanyName;

	/** The ddwn delivery time arrow. */
	@FindBy(how = How.CSS, using = "[id='ideliverytime']")
	private WebElement ddwnDeliveryTimeArrow;

	/** The ddwn delivery time values. */
	@FindBy(how = How.XPATH, using = "//*[@id='ideliverytime']/option")
	private List<WebElement> ddwnDeliveryTimeValues;

	@FindBy(how = How.ID, using = "ideliverytime")
	private WebElement ddwnSelectDeliveryTime;

	/** The tbx remarks. */
	@FindBy(how = How.ID, using = "iremarks")
	private WebElement tbxRemarks;

	/** The btn ideal payments. */
	@FindBy(how = How.CSS, using = "#ipaymentmethods > div.paymentbuttonwrapper.payment-method-type-online.paymentmethod3")
	private WebElement btnIdealPayments;

	/** The ddwn bank arrow. */
	@FindBy(how = How.ID, using = "iidealbank")
	private WebElement ddwnBankArrow;

	/** The ddwn bank values. */
	@FindBy(how = How.XPATH, using = "//*[@id='iidealbank']/option")
	private List<WebElement> ddwnBankValues;

	@FindBy(how = How.ID, using = "iidealbank")
	private WebElement ddwnSelectBank;

	/** The btn buy now. */
	@FindBy(how = How.CSS, using = "[class='button_form cartbutton-button'][type='submit']")
	private WebElement btnBuyNow;

	/** The btn cancel idel payment. */
	@FindBy(how = How.CSS, using = "[data-translate='Button-Cancel']")
	private WebElement btnCancelIdelPayment;

	/** The btn cancel payment yes. */
	@FindBy(how = How.CSS, using = "[class='pull-right btn btn-primary ng-scope']")
	private WebElement btnCancelPaymentYes;

	/** The btn navigate to payment screen. */
	@FindBy(how = How.CSS, using = "#iresponsediv>a")
	private WebElement btnNavigateToPaymentScreen;

	/** The btn in cash. */
	@FindBy(how = How.CSS, using = "[class='paymentbuttonwrapper payment-method-type-offline paymentmethod0']")
	private WebElement btnInCash;

	@FindBy(how = How.CSS, using = "[class='btn btn-base']")
	private WebElement btnAcceptIdealCookies;

	@FindBy(how = How.CSS, using = "[class='order-reference']")
	private WebElement btnOrderSuccessText;

	@FindBy(how = How.CSS, using = "[class='cart-row'][data-restaurant='Q0ONNOO']")
	private List<WebElement> noOfItemsInOrderCart;

	@FindBy(how = How.CSS, using = "[class='cart-meal-delete']")
	private WebElement btnDeleteIconCart;

	@FindBy(how = How.CSS, using = "[class='cart-meal-edit-comment']")
	private List<WebElement> btnEditComments;

	@FindBy(how = How.XPATH, using = "//*[starts-with(@id,'Q1N')]/div/button[3]")
	private WebElement btnEditCommentsDuck;

	@FindBy(how = How.XPATH, using = "//*[starts-with(@id,'QON')]/div/button[3]")
	private WebElement btnEditCommentsSalami;

	@FindBy(how = How.CSS, using = "[id^='commentinput-Q1N30PNRN']> fieldset > textarea")
	private WebElement tbxRemarksTextArea;
	
	@FindBy(how = How.CSS, using = "[id^='commentinput-QON30PNRN']> fieldset > textarea")
	private WebElement tbxSalamiRemarksTextArea;

	@FindBy(how = How.XPATH, using = "//*[@id=\"commentinput-Q1N30PNRN-QNOQ3N0PR-Q3PQ3N0PR\"]/div/button[3]")
	private WebElement btnNextComments;
	
	@FindBy(how = How.CSS, using = "#commentinput-QON30PNRN > div > button.cart-meal-btn.add")
	private WebElement btnNextCommentsSalami;
	@FindBy(how = How.ID, using = "icustomeraddress")
	private WebElement ddwnExistingAddress;
	@FindBy(how = How.CSS, using = "[id^='Q1N']> div > button.cart-meal-edit-add")
	private WebElement btnPlusItem;
	@FindBy(how = How.CSS, using = "[id^='Q1N30PNRN']> span.cart-meal-amount")
	private WebElement btnPlusItemCount;
	@FindBy(how = How.XPATH, using = "//*[@id='Q1N30PNRN-QNOQ3N0PR-Q3PQ3N0PR']/div/button[1]")
	private WebElement btnMinusItem;
	ConfigFileReader conf = new ConfigFileReader();

	/**
	 * This method helps customer to select food items of his choice.
	 */
	public void selectItemsForOrder() {
		Waiter.click(driver, btnDuckBreast);
		Waiter.click(driver, cbxTomato);
		Waiter.click(driver, btnAddToCartDuck);
		Waiter.click(driver, btnSalami);
	}

	/**
	 * This method add comments to the items in order basket.
	 * @throws InterruptedException 
	 */
	public void addCommentsToItems()  {
		//Waiter.click(driver, btnShoppingCart);
		btnEditCommentsDuck.click();
		//Waiter.enterKeys(driver, tbxRemarksTextArea, Constants.orderComments);
		//Waiter.waitForCondition(driver, tbxRemarksTextArea.isEnabled(), 20);
		tbxRemarksTextArea.sendKeys(Constants.orderComments);
		//btnNextComments.click();
		btnEditCommentsSalami.click();
		tbxSalamiRemarksTextArea.sendKeys(Constants.orderComments);
		//btnNextCommentsSalami.click();
		Waiter.click(driver, btnToOrder);
		Waiter.waitForCondition(driver, "afronden", conf.getExplicitWaitTime());
	}

	/**
	 * This method adds items to the basket and proceeds further to the payment.
	 */
	public void addToCartAndOrder() {
		//Waiter.click(driver, btnShoppingCart);
		Waiter.click(driver, btnToOrder);
		Assert.assertTrue(driver.getCurrentUrl().contains("bestelling"), "Failed to place the order");
	}

	/**
	 * This method adds the items to the basket.
	 */
	public void orderExtraQuantity() {
		//Waiter.click(driver, btnShoppingCart);
		Waiter.click(driver, btnPlusItem);
	}

	/**
	 * This method check whether the extra quantity is added successfully to the
	 * basket or not.
	 * 
	 * @return
	 */
	public boolean isEditExtraQuantitySuccessful() {
		if (btnPlusItemCount.getText().equalsIgnoreCase("2x")) {
			Log.debug("successfully extra quantity is added to the basket");
			return true;
		} else {
			Log.error("Unable to add the extra quantity to the basket");
			return false;
		}
	}

	/**
	 * This method minuses the items to the basket individually.
	 */
	public void removesExtraQuantity() {
		//Waiter.click(driver, btnShoppingCart);
		Waiter.click(driver, btnMinusItem);
	}

	/**
	 * This method check whether the extra quantity is deleted successfully from the
	 * basket or not.
	 * 
	 * @return
	 */
	public void isRemovesExtraQuantitySuccessful() {
		Assert.assertTrue(noOfItemsInOrderCart.size() <= 2, "Unable to delete the item from cart");
	}

	/**
	 * This method fills in delivery details of the customer.
	 */
	public void fillInDeliveryDetails() {
		Waiter.enterKeys(driver, tbxStreetName, Constants.streetName);
		Waiter.enterKeys(driver, tbxPostCode, Constants.postalCode);
		Waiter.enterKeys(driver, tbxUserName, Constants.customerName);
		Waiter.enterKeys(driver, tbxMobilePhone, Constants.customerNameTelephone);
		Waiter.enterKeys(driver, tbxRemarks, Constants.orderComments);
		Waiter.enterKeys(driver, tbxPlaceName, Constants.streetName);
		Waiter.enterKeys(driver, tbxCompanyName, Constants.companyName);
		//Checks whether email id is already prefilled or not.
		if (!"hidden".equals(tbxUseremail.getAttribute("type"))) {
			Waiter.enterKeys(driver, tbxUseremail, Constants.userName);
		}
		//selectDeliveryTime();
	}

	/**
	 * This method will select the exsting address from the drop down
	 */
	public void selectExistingAddress() {
		Select existingAddress = new Select(ddwnExistingAddress);
		existingAddress.selectByIndex(1);
	}

	public void PerformFieldValidation() {
		Assert.assertTrue(IsPostalCodeValid(Constants.postalCode), "Invalid post code");
		Assert.assertTrue(IsNameValid(Constants.customerName), "Invalid customer name");
		Assert.assertTrue(IsTelephoneNumberValid(Constants.customerNameTelephone), "Invalid Telephone Number");
		Assert.assertTrue(IsEmailValid(Constants.userName), "Invalid email address");
	}

	/**
	 * Matches wheather the input postal code is as per the dutch standard. It will
	 * check whether the first number starts with non zero number. Followed by 3
	 * digit number and than followed with with or with space and than 2 alphabets.
	 * 
	 * @param postalCode
	 * @return
	 */
	public boolean IsPostalCodeValid(String postalCode) {
		return postalCode.matches("^[1-9][0-9]{3}\\s?([a-zA-Z]{2})?$");
	}

	/*
	 * José Brasão
	 */

	// Name validations
	public boolean IsNameValid(String customerName) {
		return customerName.matches("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}");
	}

	/**
	 * Validates whether the input telephone number is as per dutch standard or not
	 * 
	 * @param customerTelephoneNumber
	 * @return
	 */
	public boolean IsTelephoneNumberValid(String customerTelephoneNumber) {
		return customerTelephoneNumber.matches("^06[0-9]{8}$|^00316[0-9]{8}$");
	}

	/**
	 * Validates whether input email address is per the standard email format or not
	 * 
	 * @param customerEmail
	 * @return
	 */
	public boolean IsEmailValid(String customerEmail) {
		return customerEmail.matches("^[a-zA-Z0-9._%+-]+@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,24}$");
	}

	/**
	 * This method selects the delivery time from the delivery time drop down
	 * option.
	 */
	/*
	 * public void selectDeliveryTime() { ddwnDeliveryTimeArrow.click(); for (int i
	 * = 0; i < ddwnDeliveryTimeValues.size(); i++) { if
	 * (ddwnDeliveryTimeValues.get(i).getText().equalsIgnoreCase(Constants.
	 * timeOfDelivery)) { ddwnDeliveryTimeValues.get(i).click(); break; } } }
	 */

	
	public void selectDeliveryTime() {
		Select deliveryTime = new Select(ddwnSelectDeliveryTime);
		deliveryTime.selectByValue(Constants.timeOfDelivery);
	}

	/**
	 * This method selects bank from the dropdown for making the ideal payment.
	 */
	/*
	 * public void selectBankForIdealPayment() { ddwnBankArrow.click(); for (int i =
	 * 0; i < ddwnBankValues.size(); i++) { if
	 * (ddwnBankValues.get(i).getText().equalsIgnoreCase(Constants.customerIdealBank
	 * )) { ddwnBankValues.get(i).click(); } } }
	 */

	public void selectBankForIdealPayment() {
		Select selectBank = new Select(ddwnSelectBank);
		selectBank.selectByValue(Constants.customerIdealBank);
	}

	/**
	 * This method
	 */
	public void performsIdealPayment() {
		Waiter.click(driver, btnIdealPayments);// selectBankForIdealPayment();
		Waiter.click(driver, btnBuyNow);
		Waiter.waitForCondition(driver, "abnamro", conf.getExplicitWaitTime());
		Waiter.click(driver, btnAcceptIdealCookies);

	}

	/**
	 * This method is used to cancel ideal payment.
	 */
	public void cancelIdealPayment() {
		Waiter.focusOnElement(driver, btnCancelIdelPayment);
		Waiter.click(driver, btnCancelIdelPayment);// Waits until ABN AMRO Ideal page is loaded.
		Waiter.waitForCondition(driver, "abnamro", conf.getExplicitWaitTime());
		Waiter.click(driver, btnCancelPaymentYes);
		Waiter.waitForCondition(driver, "thuisbezorgd", conf.getExplicitWaitTime());
	}

	/**
	 * This method is used to execute cash payment option.
	 */
	public void executeCashPayment() {
		Waiter.click(driver, btnNavigateToPaymentScreen);
		Waiter.waitForCondition(driver, "bestelling", conf.getExplicitWaitTime());
		Waiter.click(driver, btnInCash);
		Waiter.click(driver, btnBuyNow);
	}

	/**
	 * This method is used to check whether cash payment successful.
	 * 
	 * @return true, if successful
	 * @return false, if failed
	 */
	public boolean IsCashPaymentSuccessful() {
		Log.debug("Order is successfully placed and order number is:" + btnOrderSuccessText.getText());
		if (driver.getCurrentUrl().contains("besteld") && btnOrderSuccessText.getText() != null) {
			Log.debug("Cashpayment is successfull");
			return true;
		} else {
			Log.error("Unable to perform cash payment.");
			return false;
		}

	}

	public boolean deleteItemFromOrderCart() {
		//Waiter.click(driver, btnShoppingCart);
		// Check whether are there any items in the cart or not before trying to delete
		// the items
		Assert.assertTrue(noOfItemsInOrderCart.size() > 0, "There are no items in the cart to delete.");
		int itemsCount = noOfItemsInOrderCart.size();
		Log.info("Number of items in the cart before deletion:" + noOfItemsInOrderCart.size());
		Waiter.click(driver, btnDeleteIconCart);
		if (noOfItemsInOrderCart.size() < itemsCount) {
			Log.info("Number of items in the cart after deletion:" + noOfItemsInOrderCart.size());
			return true;
		} else {
			Log.error("Unable to delete the items from the cart");
			return false;
		}
	}

}
