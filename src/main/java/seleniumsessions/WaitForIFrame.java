package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Day 54 - 20th March
 * Selenium_24_WaitForIframe_FluentWait_PageLoadiTimeOut_Document_ReadyState.mp4
 * part 1_1 */

public class WaitForIFrame {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

		driver.findElement(By.cssSelector("div#imageTemplateContainer img")).click();

		By frameLocator = By.xpath("//iframe[contains(@id,'frame-one')]");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		
		driver.findElement(By.id("RESULT_TextField-8")).sendKeys("ilma");

	}

}

// No need to switch to frame