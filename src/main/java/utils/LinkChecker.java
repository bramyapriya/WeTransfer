package utils;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

import pageObjects.HomePage;

public class LinkChecker {
	static final Logger Log = Logger.getLogger(HomePage.class);

	/**
	 * Verifies whether the internal urls are active or not. Report the status back
	 * to the calling method.
	 * 
	 * @param linkUrl
	 * @return
	 */
	public static boolean verifyActiveLinks(String linkUrl) {
		boolean status = true;
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() == 200) {
				Log.debug("Active link url is: " + linkUrl + " - " + httpURLConnect.getResponseMessage());
				return status = true;
			} else {
				Log.error("Inactivate, forbidden, redirect url is: " + linkUrl + ":"
						+ httpURLConnect.getResponseMessage());
				return status = false;
			}
		} catch (Exception e) {
			Log.error("Failed to check the link status:" + e.getMessage());
		}
		return status;
	}
}
