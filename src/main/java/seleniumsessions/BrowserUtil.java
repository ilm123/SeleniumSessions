package seleniumsessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/* Day 34 - 13th Feb
*  Selenium_04_BrowserUtil_GenericFunctions_NavigationMethods_Back_Forward_To_Refresh_HeadLess_Incognito.mp4
*  part 1*/

/**
 * 
 * @author Ilma Thaha
 */

public class BrowserUtil {

	// This class will contain all the reusable/important functions that will be
	// used whenever required
	// I don't want to write WebD D = new ChromeD/driver.get() etc. all the time
	// Need a generic method with the proper error handling, proper null check

	WebDriver driver; // Class variable

	/**
	 * This method is used to init the driver on the basis of given browser name
	 * 
	 * @param browserName
	 * @return this returns driver
	 */
	public WebDriver launchBrowser(String browserName) {

		System.out.println("Browser name: " + browserName);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Please pass the right browser..." + browserName);
			throw new BrowserException("BROWSER NOT FOUND");
		}

		return driver; // the purpose of returning is to supply it to the ElementUtil class
	}

	// http://google.com
	// https://google.com
	public void launchURL(String url) {
		// These kind of checks are not done by selenium. If https is not there selenium
		// will give an exception without any proper message
		// These are called Null checks, validation checks
		// We have created are own generic function on top of the selenium method - a
		// wrapper

		if (url == null) {
			throw new BrowserException("URL is NULL");
		}

		if (url.indexOf("http") == 0) {
			driver.get(url);
		} else {
			throw new BrowserException("HTTP/s IS MISSING IN THE URL");
		}
	}

	public void launchURL(URL url) {

		if (url == null) {
			throw new BrowserException("URL is NULL");
		}

		String appUrl = String.valueOf(url); // valueOf() can convert any type of data to a string

		if (appUrl.indexOf("http") == 0) {
			driver.navigate().to(appUrl); // created a wrapper on the to()
		} else {
			throw new BrowserException("HTTP/s IS MISSING IN THE URL");
		}

	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
