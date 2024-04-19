package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Day 53 - 19th March
 * Selenium_23_WebDriverWait_Alerts_URL_Title_Window_Elements_PollingTime.mp4
 * part 4 */

public class PollingTimeConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//parent
		
		By twitter = By.xpath("//a[contains(@href,'twitter')]");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2), Duration.ofSeconds(1)); //interval time is 2 seconds
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(twitter)).click();
//		wait.until(ExpectedConditions.visibilityOf(null);
	
		/**visibilityOfElementLocated
		 * An expectation for checking that an element is present on the DOM of a page and visible.
		 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
		 */
	
		/**visibilityOf
		 * An expectation for checking that an element, known to be present on the DOM of a page, is visible. 
		 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
		 */

	}

}


// Default polling time is 500ms
// clock and sleeper method is not usefull