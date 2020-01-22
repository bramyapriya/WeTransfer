package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
	private static final Logger Log = Logger.getLogger(Waiter.class);
	public static WebDriverWait wait;
	// Since it's used inside the static methods this is made static
	static ConfigFileReader conf = new ConfigFileReader();

	/**
	 * This method is used to perform Javascript click
	 * 
	 * @param element
	 * @param driver
	 */
	public static void clickViaJS(WebElement element, WebDriver driver) {
		Log.info("Performing java script click on the element:" + element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	/**
	 * This method waits for the condition until input string is present in the
	 * application URL
	 * 
	 * @param driver
	 * @param waitCondition
	 * @param explicitTimeOut
	 */
	public static void waitForCondition(WebDriver driver, String waitCondition, int explicitTimeOut) {
		Log.info("Inside waitForCondition, Waiting for the string:" + waitCondition + ""
				+ "to be displayed in the url.");
		new WebDriverWait(driver, explicitTimeOut).until(ExpectedConditions.urlContains(waitCondition));
		Log.info("waitForCondition is completed");
	}

	/**
	 * This methods waits until the element is visible as per the value mentioned in
	 * explicit wait in configuration file In case if the element is visible before
	 * the completion of the explicit mentioned time than it will proceed with the
	 * execution. It also tries to clear the text box before entering the values.
	 * This method internally calls- enterKeys(WebDriver driver, WebElement element,
	 * String value, int explicitTimeOut)
	 * 
	 * @param driver
	 * @param element
	 * @param value
	 */
	public static void enterKeys(WebDriver driver, WebElement element, String value) {
		conf = new ConfigFileReader();
		enterKeys(driver, element, value, conf.getExplicitWaitTime());
	}

	/**
	 * If user want to wait for more than the time mentioned in explicit wait than
	 * this method will be used.
	 * 
	 * @param driver
	 * @param element
	 * @param value
	 * @param explicitTimeOut
	 */
	public static void enterKeys(WebDriver driver, WebElement element, String value, int explicitTimeOut) {
		new WebDriverWait(driver, explicitTimeOut).until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * This methods waits until the element is clickable as per the time value
	 * mentioned in explicit wait in configuration file In case if the element is
	 * visible before the completion of the explicit mentioned time than it will
	 * proceed with the execution. If user wants to different time out than the
	 * value mentioned in . properties file
	 * 
	 * @param driver
	 * @param element
	 * @param value
	 */
	public static void click(WebDriver driver, WebElement element, int explicitTimeOut) {
		new WebDriverWait(driver, explicitTimeOut).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	/**
	 * This methods waits until the element is clickable as per the time value
	 * mentioned in explicit wait in configuration file In case if the element is
	 * visible before the completion of the explicit mentioned time than it will
	 * proceed with the execution. It also tries to clear the text box before
	 * entering the values.
	 * 
	 * @param driver
	 * @param element
	 * @param value
	 */
	public static void click(WebDriver driver, WebElement element) {
		conf = new ConfigFileReader();
		click(driver, element, conf.getExplicitWaitTime());
	}

	/**
	 * This method is used to scroll the page to a particular element or to focus on
	 * the particular element.
	 * 
	 * @param driver
	 * @param element
	 */
	public static void focusOnElement(WebDriver driver, WebElement element) {
		Log.info("Inside focusOnElement, Element to be focused is:" + element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		Log.info("Focus on element is completed.");
	}
}
