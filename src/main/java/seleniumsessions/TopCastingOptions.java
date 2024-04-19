package seleniumsessions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/* Day 32 - 8th Feb
*  Selenium_02_SeleniumMavenProject_FirstSeleniumCode_SeleniumWD_Hirerachy_TopCastingOptions.mp4
*  part 2*/

public class TopCastingOptions {

	public static void main(String[] args) {

		// 1.WD d = new CD();
		// valid - recommended
		// run tests on local machine
		// WebDriver driver = new ChromeDriver();

		// 2.SC driver = new CD();
		// valid - not recommended
		// SearchContext driver = new ChromeDriver();

		// 3.RWD driver = new CD();
		// valid - recommended
		// RemoteWebDriver driver = new ChromeDriver();

		// 4.
		// valid -- not recommended
		// ChromiumDriver driver = new ChromeDriver();

		// 5.WD driver = new RWD();
		// valid - recommended
		// run tests on the remote/server/cloud machine/grid//sauce labs/browsertsack/lambdatest
		// RemoteWebDriver class doesn't have a default constructor
		// WebDriver driver = new RemoteWebDriver(serverURL, capabilities); // Give the ip address of that machine along
																			// with some capabilities (browser name,
																			// browser version etc.)

		// 6.
		// valid - not recommended
		//SearchContext driver = new RemoteWebDriver(serverURL, capabilities);

		// 7.CD driver = new ChromeDriver();
		// valid but works only for chrome browser. This is NOT top casting
		//ChromeDriver driver = new ChromeDriver();
		//FirefoxDriver driver = new FirefoxDriver();
	}

}
