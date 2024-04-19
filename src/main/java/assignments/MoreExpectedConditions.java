package assignments;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Selenium_24_WaitForIframe_FluentWait_PageLoadiTimeOut_Document_ReadyState.mp4
// 59:50
// Few things to explore on our own

public class MoreExpectedConditions {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
//		wait.until(ExpectedConditions.attributeToBe(null, null, null); //Attirbute value should change Enabled to Disabled
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(null); //very rare
//		wait.until(ExpectedConditions.numberOfElementsToBe(null, null) // Expecting 2 login buttons

	}

}


