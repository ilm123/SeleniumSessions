package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 55 - 21st March
 * Selenium_25_CustomWait_StaleElementRefException.mp4
 * part 1_2 */

public class CustomWaitConceptWithTimeUtil {

	public static WebElement retryingElement(By locator, int numberOfAttempts) {

		WebElement element = null;
		int count = 1;

		while (count <= numberOfAttempts) {

			try {
				element = driver.findElement(locator);
				System.out.println("Element" + locator + "was found in attempt no. " + count);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element was not found in attempt no." + count);
				TimeUtil.minTime();
			}
			count++;
		}

		if (element == null) {
			System.out.println("Element was not found in " + numberOfAttempts + " attempts"+" with an interval time of 500 milliseconds");			
			throw new MyElementException("No Such Element");
		}		
		return element;
	}
	
	public static WebElement retryingElement(By locator, int numberOfAttempts, int intervalTime) {

		WebElement element = null;
		int count = 1;

		while (count <= numberOfAttempts) {

			try {
				element = driver.findElement(locator);
				System.out.println("Element" + locator + "was found in attempt no. " + count);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element was not found in attempt no." + count);
				TimeUtil.applyWait(intervalTime); //Giving my own interval time
			}
			count++;
		}

		if (element == null) {
			System.out.println("Element was not found in " + numberOfAttempts + " attempts"+" with an interval time of " +intervalTime+ " seconds");			
			throw new MyElementException("No Such Element");
		}		
		return element;
	}

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By emailElement = By.id("input-email11");

		retryingElement(emailElement, 10, 1).sendKeys("ilma@test.com");

	}

}

// The target is not to expose the thread.sleep and not to write another try - catch block
