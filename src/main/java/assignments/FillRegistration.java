package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumsessions.BrowserUtil;
import seleniumsessions.ElementUtil;

// Selenium_05__ID_Locator_FindElement_ElementUtil.mp4

public class FillRegistration {

	public static void main(String[] args) {
		// 7. BrUtil + eleUtil
		// 6 By locators
		
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");
		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		brUtil.getPageTitle();
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		By fName = By.id("input-firstname");
		By lName = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirm = By.id("input-confirm");
		
		eleUtil.doSendKeys(fName, "Ilma");
		eleUtil.doSendKeys(lName, "Thaha");
		eleUtil.doSendKeys(email, "ilma@test.com");
		eleUtil.doSendKeys(telephone, "789456123");
		eleUtil.doSendKeys(password, "ilma@123");
		eleUtil.doSendKeys(confirm, "ilma@123");
		
		brUtil.closeBrowser();
	
	}

}
