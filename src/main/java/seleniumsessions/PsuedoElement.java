package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 51 - 14th March
 * Selenium_21_PsuedoElement_ShadowDOM_NestedIframesHandle.mp4
 * part 1 */

public class PsuedoElement {

	public static void main(String[] args) {
		
		String script = "return window.getComputedStyle(document.querySelector('label[for=\"input-firstname\"]'),'::before').getPropertyValue('content');";
		String script2 = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"),'::before').getPropertyValue('content');";
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String mand_text = js.executeScript(script2).toString();
		System.out.println(mand_text);
		
		//Sanity Test - UI
		if (mand_text.contains("*")) {
			System.out.println("First Name is a mandatory field");
		}

	}

}

// We have to use JS to handle PsuedoElements
// The asterisk is an example of a pseudo element. In the DOM it is represent by ::before
// It doesn't have any attributes such as id, name etc.
// In the styles panel the content = *

// window is the object. getComputedStyle is the method that takes two parameters
// actual label element and content property
// Don't use with the relative locators bcz we are not using driver.findElement
// CSS selector - if using double quotes, then you need to escape the character