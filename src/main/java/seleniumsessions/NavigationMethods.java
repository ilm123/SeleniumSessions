package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 34 - 13th Feb
*  Selenium_04_BrowserUtil_GenericFunctions_NavigationMethods_Back_Forward_To_Refresh_HeadLess_Incognito.mp4
*  part 2_1*/

public class NavigationMethods {

	public static void main(String[] args) {

		// back and forward
		// get vs to
		// refresh

		WebDriver driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/");
		System.out.println(driver.getTitle());

		// driver.navigate().to("https://www.google.com");// This is overloaded and this is the preferred one
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());

		driver.navigate().back();
		System.out.println(driver.getTitle());

		driver.navigate().forward();
		System.out.println(driver.getTitle());

		driver.navigate().back();
		System.out.println(driver.getTitle());

		// ***Difference between get and navigate.to methods***
		// Both are exactly the same. They are synonyms to each other
		// If you mouse over the methods and check the documentation it will say so
		// The to method internally calls the get method
		// Small diff is that the to method is overloaded - implementation difference
		// So you have two options to launch the url
		// https://naveenautomationlabs.com/selenium-webdriver-navigation-commands/
		
		
		// Refresh the page
		driver.navigate().refresh();
	}

}
