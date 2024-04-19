package assignments;

import java.util.UUID;

import org.openqa.selenium.WebDriver;

import seleniumsessions.BrowserUtil;
import seleniumsessions.ElementUtil;
import seleniumsessions.StringUtil;

//Selenium_06_DifferentLocators_Click_GetText_ElementUtil.mp4

public class RegPageWithStringLocator {

//	public static String getRandomEmail() {
//		return "automation"+System.currentTimeMillis()+"@"+"opencart.com";
//		//return "automation"+UUID.randomUUID()+"@"+"opencart.com";		
//	}

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");
		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		brUtil.getPageTitle();

		ElementUtil eleUtil = new ElementUtil(driver);

		String fName = "input-firstname";
		String lName = "input-lastname";
		String email = "input-email";
		String telephone = "input-telephone";
		String password = "input-password";
		String confirm = "input-confirm";
		String isSubscribeYes = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input";
		String isSubscribeNo = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input";
		String policyCheckBox = "agree";
		String continueBtn = "#content > form > div > div > input.btn.btn-primary";
		String sucessMsg = "h1";

		eleUtil.doSendKeys("id", fName, "Test");
		eleUtil.doSendKeys("id", lName, "Automation");
		eleUtil.doSendKeys("id", email, StringUtil.getRandomEmail());
		eleUtil.doSendKeys("id", telephone, "789456123");
		eleUtil.doSendKeys("id", password, "test@123");
		eleUtil.doSendKeys("id", confirm, "test@123");
		eleUtil.doClick("xpath", isSubscribeYes);
		eleUtil.doClick("xpath", isSubscribeNo);
		eleUtil.doClick("name", policyCheckBox);
		eleUtil.doClick("css", continueBtn);

		String actSucessMsg = eleUtil.doGetElementText("tagname", sucessMsg);

		if (actSucessMsg.equals("Your Account Has Been Created!")) {
			System.out.println("User Registration - PASSED");
		} else {
			System.out.println("User Registration - FAILED");
		}

		brUtil.quitBrowser();

	}

}
