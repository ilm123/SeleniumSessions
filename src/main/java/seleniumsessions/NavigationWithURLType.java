package seleniumsessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 34 - 13th Feb
*  Selenium_04_BrowserUtil_GenericFunctions_NavigationMethods_Back_Forward_To_Refresh_HeadLess_Incognito.mp4
*  part 2_2*/

public class NavigationWithURLType {

	public static void main(String[] args) throws MalformedURLException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		System.out.println(driver.getTitle());

		driver.navigate().to(new URL("https://www.google.com")); // create the object of the URL class and in the
																	// constructor supply the url string

		// The usage of this method is rare.
		// use case - If you have created a framework and someone has give the url in this format
		// (in the URL class format) then you have to use this method
		
		System.out.println(driver.getTitle());

		driver.navigate().back();
		System.out.println(driver.getTitle());

		driver.navigate().forward();
		System.out.println(driver.getTitle());

		driver.navigate().back();
		System.out.println(driver.getTitle());

	}

}
