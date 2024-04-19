package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Day 54 - 20th March
 * Selenium_24_WaitForIframe_FluentWait_PageLoadiTimeOut_Document_ReadyState.mp4
 * part 1_2 */

public class WaitForIFrameWithUtility {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

		driver.findElement(By.cssSelector("div#imageTemplateContainer img")).click();

		By frameLocator = By.xpath("//iframe[contains(@id,'frame-one')]");

		waitForFrameAndSwitchToIt(frameLocator, 10);
		driver.findElement(By.id("RESULT_TextField-8")).sendKeys("ilma");

		// To switch back to the main page
		driver.switchTo().defaultContent(); // if you want you can create a wrapper

		String text = driver.findElement(By.cssSelector("h3.details__form-preview-title")).getText();
		System.out.println(text);

	}

	public static void waitForFrameAndSwitchToIt(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

}
