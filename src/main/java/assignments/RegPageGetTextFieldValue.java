package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import seleniumsessions.ElementUtil;

//Selenium_08_IsDisplayed_IsEnabled_IsSelected_ElementExist_DisabledElement_Click_SendKeys_CharSequence.mp4

//Enter the values and fetch all the values
public class RegPageGetTextFieldValue {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

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

		String firstN = eleUtil.doElementGetAttribute(fName, "value");
		String lastN = eleUtil.doElementGetAttribute(lName, "value");
		String emailId = eleUtil.doElementGetAttribute(email, "value");
		String phone = eleUtil.doElementGetAttribute(telephone, "value");
		String pw = eleUtil.doElementGetAttribute(password, "value");
		String confirmPw = eleUtil.doElementGetAttribute(confirm, "value");
		
		System.out.println("First Name: " + firstN);
		System.out.println("Last Name: " + lastN);
		System.out.println("Email: " + emailId);
		System.out.println("Telephone: " + phone);
		System.out.println("Passoword: " + pw);
		System.out.println("Confirm Passoword: " + confirmPw);

	}

}
