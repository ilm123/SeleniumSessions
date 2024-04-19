package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 51 - 14th March
 * Selenium_21_PsuedoElement_ShadowDOM_NestedIframesHandle.mp4
 * part 2 */

public class ShadowDOMElement {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		driver.get("chrome://settings/");
		
		String search_script = 
		"return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement search = (WebElement)js.executeScript(search_script);
		
		search.sendKeys("Notifications");
		
		
	}

}

// shadow-root is a light weight container that the dev chooses to use when developing the web page
// like iframe this is for data security - to prevent data sniffing, some confidential info can be applied here
// shadow-root has to be in open state to be able to automate with any tool
// if all the elements are written under shadow DOM cannot keep using driver.findElement
// have to use another tool such as Playwright
// Playwright has 'auto piercing' - automatically goes into the shadow-DOM

// js.executeScript(search_script); - returns a HTML element. So it needs to be type casted into WebElement