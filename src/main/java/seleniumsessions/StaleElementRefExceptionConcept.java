package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 55 - 21st March
 * Selenium_25_CustomWait_StaleElementRefException.mp4
 * part 3_1 */

public class StaleElementRefExceptionConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		WebElement emailD = driver.findElement(By.id("input-email"));
		emailD.sendKeys("ilma@test.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.navigate().refresh();
		emailD = driver.findElement(By.id("input-email")); // re-initialized
		emailD.sendKeys("tom@test.com"); //StaleElementReferenceException: stale element reference: stale element not found		

	}

}


// StaleElement - Element is rotten, not fresh
// DOM version changes when the page is refreshed
// The moment you refresh the page, you have to re-initialize the web element

// Debug to notice the difference in the element id
//f.5807CCED332AE4C7EED5EA4A381CFE5A.d.3CDFFACC1EE6962834A2617C3D9D2777.e.4
//f.5807CCED332AE4C7EED5EA4A381CFE5A.d.1D451DDC8B5DDB2941FD68999CC06BDF.e.44

// element ID gets expired when not re-initialized
// This exception occurs not only when refreshing but also when navigating forward and back
// Once returning to the original page, the exception is seen

// There is no method to print the Web element id - have to debug and check
