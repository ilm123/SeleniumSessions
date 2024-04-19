package seleniumsessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 55 - 21st March
 * Selenium_25_CustomWait_StaleElementRefException.mp4
 * part 3_3 */

public class StaleElementRefExceptionOnFEs {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

	    List<WebElement> footerList = driver.findElements(By.cssSelector("footer ul.list-unstyled > li >a"));
		
		for (int i=0; i<footerList.size(); i++) {
			System.out.println(footerList.get(i));
			footerList.get(i).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
//			footerList = driver.findElements(By.cssSelector("footer ul.list-unstyled > li >a"));
		}
	    
//	    for (WebElement e:footerList) {
//	    	System.out.println(e.getText());
//	    	e.click();
//	    	driver.navigate().back();
//	    	driver.findElements(By.cssSelector("footer ul.list-unstyled > li >a"));566
//	    	//!! it doesn't work with the for-each loop. maybe there is an impact on the index
//	    }

	}

}



