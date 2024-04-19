package seleniumsessions;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Day 36 - 15th Feb
 * Selenium_06_DifferentLocators_Click_GetText_ElementUtil.mp4
 * part 3 */

public class RegPageTest {
	
	public static String getRandomEmail() { //making it static so that it can be called directly
//		return "automation"+System.currentTimeMillis()+"@"+"opencart.com";
		return "automation"+UUID.randomUUID()+"@"+"opencart.com";		
//		uuid format appears with hyphens- automation32a7e52e-97ed-4fa3-abfb-90b835e7ea1c@opencart.com
	}

	public static void main(String[] args) {

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
		By isSubscribeYes = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input");
		By isSubscribeNo = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input");
		By policyCheckBox = By.name("agree");
		By continueBtn = By.cssSelector("#content > form > div > div > input.btn.btn-primary");
		By sucessMsg = By.tagName("h1");
		
		eleUtil.doSendKeys(fName, "Ilma");
		eleUtil.doSendKeys(lName, "Thaha");
		eleUtil.doSendKeys(email, StringUtil.getRandomEmail());		
		eleUtil.doSendKeys(telephone, "789456123");
		eleUtil.doSendKeys(password, "ilma@123");
		eleUtil.doSendKeys(confirm, "ilma@123");
		eleUtil.doClick(isSubscribeYes);
		eleUtil.doClick(isSubscribeNo);
		eleUtil.doClick(policyCheckBox);
		eleUtil.doClick(continueBtn);

		String actSucessMsg = eleUtil.doGetElementText(sucessMsg);

		if (actSucessMsg.equals("Your Account Has Been Created!")) {
			System.out.println("User Registration - PASSED");
		} else {
			System.out.println("User Registration - FAILED");
		}
		
		brUtil.quitBrowser();

	}

}
