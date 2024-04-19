package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Day 53 - 19th March
 * Selenium_23_WebDriverWait_Alerts_URL_Title_Window_Elements_PollingTime.mp4
 * part 1 */

public class WaitForTitleUrl {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");

//		System.out.println(driver.getTitle()); // we don't directly use this		

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.
//		titleContains("Free CRM software for customer relationship"));
//		System.out.println(driver.getTitle()); // returns the complete title

		String title = waitForTitleContains("Free CRM software for customer relationship", 1);
		System.out.println(title);
		
		driver.findElement(By.linkText("Sign Up")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.urlContains("register"));
//		System.out.println(driver.getCurrentUrl());
		
		String url = waitForURLContains("register", 2);
		System.out.println(url);
		
		
	}
	
	public static String waitForURLContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
				return driver.getCurrentUrl();
			}
		} catch (Exception e) {
			System.out.println("Url was not found within: " + timeOut + " seconds");
		}
		return null;
	}
	
	public static String waitForUrlToBe(String Url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.urlToBe(Url))) {
				return driver.getCurrentUrl();
			}
		} catch (Exception e) {
			System.out.println("Url was not found within: " + timeOut + " seconds");
		}
		return null;
	}

	public static String waitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
				return driver.getTitle();
			}
		} catch (Exception e) {
			System.out.println("Title was not found within: " + timeOut + " seconds");
		}
		return null;
	}
	
	public static String waitForTitleIs(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.titleIs(title))) {
				return driver.getTitle();
			}
		} catch (Exception e) {
			System.out.println("Title was not found within: " + timeOut + " seconds");
		}
		return null;
	}

}

//.until returns a boolean here. it changes it's behavior based on the expected condition
// so generics are not only about WebElement or String