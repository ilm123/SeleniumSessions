package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Day 52 - 18th March
 * Selenium_22_ImplicitlyWait_Vs_ExplicitlyWait_WebDriverWait.mp4
 * part 3_2 */

public class WebDriverWaitWithUtil {
	
	static WebDriver driver;

	public static void main(String[] args) {		
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		
		By fullName = By.id("Form_getForm_Name");
		By bussEmail = By.id("Form_getForm_Email");
		By phoneNumber = By.id("Form_getForm_Contact");
		
		 waitforElementPresence(fullName, 10).sendKeys("Testing");	
//		 waitforElementPresence(bussEmail, 5).sendKeys("test123@gmail.com");		
		 getElement(bussEmail).sendKeys("test123@gmail.com"); //don't want to wait
		 waitforElementVisible(phoneNumber, 10).sendKeys("123456");

	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitforElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut)); //long can hold int. Concept of widening. can write long instead of int
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed but also has a height and width that isgreater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitforElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}


//Two exceptions appear - Timeout and NoSuchElement

//TimeoutException: Expected condition failed: waiting for presence of element located by: 
//	By.id: Form_getForm_Name11 (tried for 10 second(s) with 500 milliseconds interval)


//driver.get() is not calling any wait internally. it is checking a java script internally
// document.ready state is compete

//ExpectedConditions we can do a static import but this way is more readable and there are so many methods 
// in ExpectedConditions

// WebDriverWait is extending FluentWait
// Documentation to refer - selenium.dev and selenium git hub page