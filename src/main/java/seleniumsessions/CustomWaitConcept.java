package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 55 - 21st March
 * Selenium_25_CustomWait_StaleElementRefException.mp4
 * part 1_1 */

public class CustomWaitConcept {

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
				try {
					Thread.sleep(500);//default polling time. Replicate what selenium does
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
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
				try {
					Thread.sleep(intervalTime*1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
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

//while loop is used when we are not sure how many attempts we have to perform; how much time we have to wait
//Don't use thread.sleep in the main use case
//converting the static wait to the dynamic wait - A classic example of using thread.sleep
//selenium is also using thread.sleep internally
//in real time don't use it but sometimes it works like magic when the selenium wait doesn't work
