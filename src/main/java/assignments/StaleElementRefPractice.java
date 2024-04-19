package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

// Selenium_25_CustomWait_StaleElementRefException.mp4
// 51:09

public class StaleElementRefPractice {

	public static void main(String[] args) throws InterruptedException {
		// Open Cart login - enter email
//		Click About Us
//		Click Back button
//		Try to enter tom@gmail.com -> will give stale element
//		Re-initialize the webEle		

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		List<WebElement> footerList = driver.findElements(By.cssSelector("footer ul.list-unstyled > li >a"));

		for (int i = 0; i < footerList.size(); i++) {
			String text = footerList.get(i).getText();
			System.out.println(text);

			footerList.get(i).click();
			driver.navigate().back();

			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(1))
					.ignoring(NoSuchElementException.class)
					.withMessage("time out... element is not present...");

			footerList = wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(By.cssSelector("footer ul.list-unstyled > li >a")));

		}

	}

}
