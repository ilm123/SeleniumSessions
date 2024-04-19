package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 54 - 20th March
 * Selenium_24_WaitForIframe_FluentWait_PageLoadiTimeOut_Document_ReadyState.mp4
 * part 3 */

public class PageLoadTimeOut {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120)); //Dynamic wait Maximum timeout given. Exception thrown after 120 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //internally has a polling time? - documentation is missing
		
		long seconds = driver.manage().timeouts().getPageLoadTimeout().getSeconds();

	}

}
