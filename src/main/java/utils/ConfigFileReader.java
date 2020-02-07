package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * The Class is used to read the values from Configuration.properties
 */
public class ConfigFileReader {

	/** The properties. */
	private Properties properties;

	/** The property file path. */
	private final String propertyFilePath = "config//Configuration.properties";

	/**
	 * Instantiates a new config file reader.
	 */
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	/**
	 * Gets the WeTransfer application URL(https://wetransfer.com/).
	 * 
	 * @return the application URL
	 */
	public String getApplicationURL() {
		String applicationUrl = properties.getProperty("applicationURL");
		if (applicationUrl != null) {
			return applicationUrl;
		} else {
			throw new RuntimeException("Application URL is not specified in the configuration file.");
		}
	}

	/**
	 * Gets the implicit wait time value from properties file and this value is used
	 * across the application.
	 * 
	 * @return the implicit wait time
	 */
	public int getImplicitWaitTime() {
		String implicitWaittime = properties.getProperty("implicitWaitTime");
		if (implicitWaittime != null) {
			return Integer.parseInt(implicitWaittime);
		} else {
			throw new RuntimeException("Implicit wait time not specified in the configuration file.");
		}
	}

	/**
	 * Gets the browser which is used for program execution.
	 * 
	 * @return the explicit wait time
	 */
	public String getBrowserName() {
		String browser = properties.getProperty("browserName");
		if (browser != null) {
			return browser;
		} else {
			throw new RuntimeException("Browser name is not specified in the configuration file.");
		}
	}

	/**
	 * Gets the explicit wait time value from properties file and this value is used
	 * across the application.
	 * 
	 * @return the explicit wait time
	 */
	public int getExplicitWaitTime() {
		String explicitWaittime = properties.getProperty("explicitWaitTime");
		if (explicitWaittime != null) {
			return Integer.parseInt(explicitWaittime);
		} else {
			throw new RuntimeException("Explicit wait time not specified in the configuration file.");
		}
	}

	/**
	 * Gets the pageload timeout value from properties file and this value is used
	 * across the application.
	 * 
	 * @return the explicit wait time
	 */
	public int getPageLoadTimeOut() {
		String pageLoadTime = properties.getProperty("pageLoadTimeOut");
		if (pageLoadTime != null) {
			return Integer.parseInt(pageLoadTime);
		} else {
			throw new RuntimeException("page load time not specified in the configuration file.");
		}
	}

	public String getUploadFileName() {
		String uploadFileName = properties.getProperty("uploadFileName");
		if (uploadFileName != null) {
			return uploadFileName;
		} else {
			throw new RuntimeException("page load time not specified in the configuration file.");
		}
	}

}
