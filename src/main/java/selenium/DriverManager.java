package selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import utils.ConfigFileReader;

public class DriverManager {
	private String driverPath;
	private WebDriver driver;
	private static DriverManager _driverHandler;
	private static final Logger Log = Logger.getLogger(DriverManager.class);
	static ConfigFileReader conf = new ConfigFileReader();

	/*
	 * This gets the webdriver based on the value configured in the properties file
	 */
	private DriverManager(String browserName) { // Here the constructor is made private purposely to ensure that this
												// class can't be instantiated.
		Log.debug("Selected Browser Is:" + browserName);
		if (browserName == "Chrome") {
			driverPath = new File("").getAbsolutePath(); // Gets the path - where application is running
			System.setProperty("webdriver.chrome.driver", driverPath + "\\drivers\\Chrome\\chromedriver.exe");
			this.driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Opera")) {
			driverPath = new File("").getAbsolutePath();
			System.setProperty("webdriver.opera.driver", driverPath + "\\drivers\\Opera\\operadriver.exe");
			this.driver = new OperaDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driverPath = new File("").getAbsolutePath();
			System.setProperty("webdriver.edge.driver", driverPath + "\\drivers\\Edge\\MicrosoftWebDriver.exe");
			this.driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driverPath = new File("").getAbsolutePath();
			System.setProperty("webdriver.firefox.marionette", driverPath + "\\drivers\\Firefox\\geckodriver.exe");
			this.driver = new FirefoxDriver();
		} else {
			driverPath = new File("").getAbsolutePath();
			System.setProperty("webdriver.chrome.driver", driverPath + "\\drivers\\Chrome\\chromedriver.exe");
			this.driver = new ChromeDriver();
		}

		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(conf.getImplicitWaitTime(), TimeUnit.SECONDS);
		this.driver.manage().timeouts().pageLoadTimeout(conf.getPageLoadTimeOut(), TimeUnit.SECONDS);
		this.driver.manage().deleteAllCookies();
	}

	/*
	 * singleton pattern is used here, if the instance is null then it will
	 * constructor, else it will return the instance. Available browser options are
	 * Chrome, Opera, IE, Firefox
	 */
	public static DriverManager getDriverManagerInstance() {
		// if (null == _driverHandler)
		_driverHandler = new DriverManager(conf.getBrowserName());
		return _driverHandler;
	}

	// Get the new Webdriver
	public WebDriver getDriver() {
		return driver;
	}

	// Close the web driver
	public void TearDown() {
		Log.info("Closing the browser");
		driver.close();
		driver.quit();
	}

}
