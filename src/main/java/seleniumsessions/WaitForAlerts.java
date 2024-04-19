package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Day 53 - 19th March
 * Selenium_23_WebDriverWait_Alerts_URL_Title_Window_Elements_PollingTime.mp4
 * part 2 */

public class WaitForAlerts {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent()); //until() returns an Alert. Switches the driver to the alert
//		System.out.println(alert.getText());
//		alert.accept();
		
		String alertText = getAlertText(2);
		System.out.println(alertText);
		acceptAlert(2);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		String confirmationText = getAlertText(2);
		System.out.println(confirmationText);
		dismissAlert(2);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		String promptText = getAlertText(2);
		System.out.println(promptText);
		alertSendKeys(2, "Hi, this is Ilma");
		acceptAlert(2);
	}

	public static Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public static String getAlertText(int timeOut) {
		return waitForJSAlert(timeOut).getText();
	}

	public static void acceptAlert(int timeOut) {
		waitForJSAlert(timeOut).accept();
	}

	public static void dismissAlert(int timeOut) {
		waitForJSAlert(timeOut).dismiss();
	}

	public static void alertSendKeys(int timeOut, String value) {
		waitForJSAlert(timeOut).sendKeys(value);
	}
}

//No need to write dirver.swithTo().alert();
