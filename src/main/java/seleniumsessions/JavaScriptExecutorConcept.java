package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 50 - 13th March
 * Selenium_20_JavaScriptExecutor_JSUtils.mp4
 * part 1 */

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {
		
		//browser : JS
		//JS --> JavascriptExecutor --> executeScript()
				
		WebDriver driver = new ChromeDriver();
//		driver.get("https://naveenautomationlabs.com/opencart/");
//		driver.get("https://classic.freecrm.com/");
//		driver.get("https://www.amazon.com/");
		driver.get("https://app.hubspot.com/login");
		
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		String title = js.executeScript("return document.title;").toString(); //JS 'return'
//		System.out.println(title);
//		
//		String url = js.executeScript("return document.URL;").toString();
//		System.out.println(url);
		
		JavaScriptUtil js = new JavaScriptUtil(driver);
		String titleByJS = js.getTitleByJS();
		System.out.println(titleByJS);
		
//		js.generateAlert("Hi, this is Ilma"); // used for debugging
//		js.generateConfirmPopUp("test");
		
//		String pageText = js.getPageInnerText();
//		System.out.println(pageText); // returns the entire text on the page
//		
//		if (pageText.contains("Deal Pipeline")) {
//			System.out.println("PASS");
//		}
		
//		WebElement laptopElement = driver.findElement(By.xpath("//h2[text()='Laptops for every need']"));
//		js.scrollIntoView(laptopElement);
//		js.zoomChromeEdgeSafari("10");
//		js.zoomChromeEdgeSafari("300");
		
		WebElement loginElement = driver.findElement(By.id("hs-login"));
		WebElement emailElement = driver.findElement(By.id("username"));
		WebElement pwdElement = driver.findElement(By.id("password"));
		WebElement loginbuttonElement = driver.findElement(By.id("loginBtn"));
		
		js.drawBorder(loginElement);
		js.flash(emailElement);
		emailElement.sendKeys("Test@gmail.com");
		js.flash(pwdElement);
		pwdElement.sendKeys("Test@123");
		js.clickElementByJS(loginbuttonElement);
		
	}

}

/**
Chrome Dev Tools > Console
To print something in the JS console (like we have system.out.println), type console.log(100) -> will print '100'
Same JS we want to run it from the selenium code. So we have to, convert the driver to the JavaScriptExecutor
ChromeDriver - > ChromiumDriver -> RemoteWebDriver
RemoteWebDriver class has two interfaces - WebDriver and JavascriptExecutor (There are more stuff...)
Fortis hospital class has US Medical interface and UK Medical interface
A class can implement multiple interfaces

TopCasting has been done with WebDriver
Now do a casting from one interface to another interface
WebDriver and JavascriptExecutor are both interfaces
converting USMedical to UK Medical
One interface is getting casted into another interface

(JavascriptExecutor)driver; This line is now a JavascriptExecutor

in Selenium we have driver.getTitle(). But just to test this JS document.title
Better to right the semicolon

document.URL equivalent is driver.getCurrentURL()

scrollIntoView - if you get an exception bcz it is not in view then use this method

Zoom in, zoom out, highlight - no method in selenium

JS SendKeys limitation - only ID attribute can be used

JS sendkeys and click are the last options.
JS is just a back door entry. You are trying to click from the DOM. This is not the actual user action.
Actual click is the normal click and Actions class click. Preference is:
1. Actions class click
2. Normal .click
3. JS click
 */
