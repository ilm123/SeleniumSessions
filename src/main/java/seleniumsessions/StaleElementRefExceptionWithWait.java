package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Day 55 - 21st March
 * Selenium_25_CustomWait_StaleElementRefException.mp4
 * part 3_2 */

public class StaleElementRefExceptionWithWait {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		WebElement emailD = driver.findElement(By.id("input-email"));
		emailD.sendKeys("ilma@test.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		driver.navigate().refresh();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//3 mechanisms of wait are applied
		wait.pollingEvery(Duration.ofMillis(500))
			.ignoring(StaleElementReferenceException.class)
			.withMessage("Element was not found...");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).sendKeys("tom@gmail.com");
		
	}

}

// No need to reinitialize the element when using fluent wait methods



