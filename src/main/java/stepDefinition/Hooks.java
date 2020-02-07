package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import selenium.DriverManager;

public class Hooks {
	private WebDriver driver;
	public Scenario scenario;
	ExtentReports extent;
	ExtentTest logger;
	private static final Logger Log = Logger.getLogger(Hooks.class);

	/**
	 * This methods gets the web driver.
	 * 
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

	/**
	 * This method runs before each and every scenario and loads the web driver.
	 * 
	 * @param scenario
	 */
	@Before
	public void InitiliazeTest(Scenario scenario) {
		Log.debug("Started running the scenario:" + scenario.getName());
		this.scenario = scenario;
		driver = DriverManager.getDriverManagerInstance().getDriver();
	}

	/**
	 * This method runs after the end of the scenario. If it scenario is failed it
	 * takes the screenshot of failure page If it is successful than it will close
	 * the browser.
	 * 
	 * @param scenario
	 */
	@After
	public void TearDownTest(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				Log.error("Scenario:" + scenario.getName() + " is failed." + "Failed page URL is "
						+ driver.getCurrentUrl());
				TakesScreenshot ts = (TakesScreenshot) driver;
				File sourceLocation = ts.getScreenshotAs(OutputType.FILE);
				String screenShotPath = new File("").getAbsolutePath() + "\\Screenshots\\" + "WeTransfer"
						+ System.currentTimeMillis() + ".png";
				Log.info("Screenshots are placed at the location: " + screenShotPath);
				File destinationLocation = new File(screenShotPath);
				FileUtils.copyFile(sourceLocation, destinationLocation);
			} catch (IOException e) {
				Log.error("Failed to capture the screenshot" + e.getMessage());
			}
		} else {
			Log.debug("Scenario:" + scenario.getName() + " completed successfully " + "\n");
		}
		driver.close();
	}
}
