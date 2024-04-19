package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 38 - 20th Feb
 * Selenium_08_IsDisplayed_IsEnabled_IsSelected_ElementExist_DisabledElement_Click_SendKeys_CharSequence.mp4
 * part 2 */

public class ElementIsDisplayed {
	
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
//		Boolean flag = driver.findElement(By.className("img-responsive111")).isDisplayed();//NSE
//		System.out.println(flag);		
		
//		if (flag) {
//			System.out.println("Logo is displayed");
//		}
//		else {
//			System.out.println("Logo is not displayed");
//		}
		
//		By logo = By.className("img-responsive");
//
//		if (isElementDisplayed(logo)) {
//			System.out.println("Logo is displayed");
//		}
		
		
		// Solving it programmatically - better than isDisplayed - used only for a single element
//		List <WebElement> logo = driver.findElements(By.className("img-responsive"));
//		
//		if (logo.size()==1) {
//			System.out.println("Logo is displayed");
//		}
//		else {
//			System.out.println("Logo is not displayed");
//		}
		
		By locator = By.className("img-responsive11");		
		
		if (isElementExist(locator)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
	}
	
	public static boolean isElementExist(By locator) {
		if (getElements(locator).size()==1) {
			return true;
		}
		return false;
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	

}

//*** isDisplayed method is not a preferred method bcz if the element doesn't exits it will never reach the else part.It does not reach
//the isDisplayed part. While creating the element it throws the exception - NSE