package seleniumsessions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Day 53 - 19th March
 * Selenium_23_WebDriverWait_Alerts_URL_Title_Window_Elements_PollingTime.mp4
 * part 3 */

public class WaitForWindow {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//parent
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		if (wait.until(ExpectedConditions.numberOfWindowsToBe(2))) {
			Set<String> handles = driver.getWindowHandles();
			
			Iterator<String> it = handles.iterator();
			String parentWindowId = it.next();
			System.out.println("parent window id : " + parentWindowId);
			
			String childWindowId = it.next();
			System.out.println("child window id : " + childWindowId);
			
		}		

	}

}

// How many non-web elements have we seen? Four
// Url, title, window, alerts  - has to be handled via explicitly wait

/*
 * New functions introduced in ElementUtility 
 * waitFoWindow  
 * clickWhenReady
 * waitForElementsPresence 
 * waitForElementsVisible
 * waitforElementVisible - intervalTime
 */

