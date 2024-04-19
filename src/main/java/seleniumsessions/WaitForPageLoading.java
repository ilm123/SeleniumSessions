package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Day 54 - 20th March
 * Selenium_24_WaitForIframe_FluentWait_PageLoadiTimeOut_Document_ReadyState.mp4
 * part 4 */


public class WaitForPageLoading {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();		
		driver.get("https://classic.freecrm.com/");
		
		boolean flag = isPageLoaded(10);
		
		if (!flag) {
			throw new BrowserException("PAGE IS NOT LOADED");
		}

	}
	
	public static boolean isPageLoaded(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		String flag = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"))
				.toString();//"true"
		return Boolean.parseBoolean(flag);//true
	
	}
}

// The best site for understanding the DOM
// https://developer.mozilla.org/en-US/docs/Web/API/Document/readyState
// Java Script comparison operator uses three "equals to"
// This method is better than Selenium's pageLoadTimeout
// Do you want to proceed if the page hasn't loaded within the required time?

//Freeze page to inspect it
//1. Remove Blur
//2. Add a debugger
//3. Add the plugin from Selectors Hub

