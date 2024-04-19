package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Day 35 - 14th Feb
 * Selenium_05__ID_Locator_FindElement_ElementUtil.mp4
 * 7th Approach */

public class OpenCartLoginTest {
	
	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");
		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		String title = brUtil.getPageTitle();
		System.out.println(title);
		
		By username = By.id("input-email");
		By pwd = By.id("input-password");		
		ElementUtil eleUtil  = new ElementUtil(driver);
		eleUtil.doSendKeys(username, "test@gmail.com");
		eleUtil.doSendKeys(pwd, "test123");
		
		brUtil.closeBrowser();

	}

}
