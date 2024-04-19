package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 35 - 14th Feb
 * Selenium_05__ID_Locator_FindElement_ElementUtil.mp4
 * part 1 */

public class LocatorConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver(); // 123
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// chrome dev tools:
		// DOM: HTML: Document Object Model

		// create a webelement + perform an action on it(click, sendKeys, gettext,isDisplayed)

		// 1.
//		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test123");

		// 2.
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailId.sendKeys("test@gmail.com");
//		password.sendKeys("test123");

		// 3. By locator:
//		By username = By.id("input-email"); // entire right hand side line is represented by the left hand side variable
//		By pwd = By.id("input-password");
//
//		WebElement emailId = driver.findElement(username); // "driver please find the element"
//		WebElement password = driver.findElement(pwd);
//
//		emailId.sendKeys("test@gmail.com");
//		password.sendKeys("test123");

		// 4. By locator with some utility:
//		By username = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		WebElement emailId = getElement(username);
//		WebElement password = getElement(pwd);
//
//		emailId.sendKeys("test@gmail.com");
//		password.sendKeys("password");

		// 5. By locator with element util and action util:
//		
//		By username = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		doSendKeys(username, "test@gmail.com");
//		doSendKeys(pwd, "test123");

		// 6. By locator and create a common util class for elements:
		// Page By Locators: OR - Object Repository

//		By username = By.id("input-email");
//		By pwd = By.id("input-password");
//
//		ElementUtil eleUtil = new ElementUtil(driver);// 123
//		eleUtil.doSendKeys(username, "test@gmail.com");
//		eleUtil.doSendKeys(pwd, "test123");

		// 7. BrUtil + eleUtil
//		OpenCartLoginTest class

		// 8. By util + String locators
		String username = "input-email";
		String pwd = "input-password";

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys("id", username, "test@gmail.com");
		eleUtil.doSendKeys("id", pwd, "test@123");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

}



/*
 * In some projects 99% people use the By locator approach; #6. But there are a
 * few projects that use String based locators; #8 The problem with String base
 * locators - Strings are immutable + a lot of the strings are stored inside the
 * SCP - so that could become a memory issue later but that is ok. If the
 * project is mid size range and less number of locators are available you can
 * easily do it here. Through out the framework we will always use the By
 * locator - #6
 */
 
 

//string --> by --> webelement -- action -- 2nd
// by -- webelement --action -- Ist
// webelement -- action -- 3rd -- not preferred bcz we have in advance creating so many web elements

/// Browser(html/CSS + JS): web pages(JS/TS/React/AngularJS)--->
/// server(Java/GO/PY) -- DB
// selenium Java ---> Angular JS + GO