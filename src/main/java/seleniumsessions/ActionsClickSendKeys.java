package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* Day 45 - 5th March
 * Selenium_15_Actions_MoveToElement_MenuSubMenu_RightClick_DragDrop_Click_SendKeys.mp4
 * part 7_1 */

public class ActionsClickSendKeys {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By emailEle = By.id("input-email");
		By pwdEle = By.id("input-password");
		By loginBtnEle = By.xpath("//input[@value='Login']");

		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(emailEle), "test@gmail.com").perform();
		act.sendKeys(driver.findElement(pwdEle), "testing123").perform();
		act.click(driver.findElement(loginBtnEle)).perform();
	}
}
// When do we use Actions class sendkeys and click method?
// When normal sendKeys and click don't work, then we can use Actions class methods as an alternative
// This way is powerful (Actions class)
// E.g When you launch some sites, a chat-bot or cookies pop-up appears which prevents you from interacting with the element
// Element Not Interactable exception or Element Intercepted Exception is thrown.
// In such cases we use the Action class. It will internally mouse over to the element and then click on it.
// Sometimes we need to remove the pop-up and then interact with element
// The 3rd and last option is Java Script Executor - will see in an upcoming chapter
