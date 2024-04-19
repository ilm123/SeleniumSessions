package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* Day 46 - 6th March
 * Selenium_16_Actions_Scrolling_PageUpDown_ScrollElement_CanvasSignature_SendKeysWithPause_GetElementLocation_BackgroundColor_HeightWidth_WindowSize_Maximize_Minimize_FullScreen.mp4
 * part 3 */

// ****Accessibility Testing***

public class ActionsTabSequence {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//Scenario 1
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
//		
//		Actions act = new Actions(driver);
//		
//		WebElement fNameEle = driver.findElement(By.id("input-firstname"));
//		
//		act.sendKeys(fNameEle, "Ilma")
//			.sendKeys(Keys.TAB)
//			.pause(500)
//			.sendKeys("Thaha")
//			.sendKeys(Keys.TAB)
//			.pause(500)
//			.sendKeys("ilma@test.lk")
//			.sendKeys(Keys.TAB)
//			.pause(500)
//			.sendKeys("99999")
//			.sendKeys(Keys.TAB)
//			.pause(500)
//			.sendKeys("Test@123")
//			.sendKeys(Keys.TAB)
//			.pause(500)
//			.sendKeys("Test@123")
//			.build().perform();	
				
		// Scenario 2
		// In good applications the tab sequence is maintained
		// It is risky. If the tab sequence is gone we can raise a bug
		
		driver.get("https://www.amazon.in/");
		
		Actions act = new Actions(driver);
		
		act.sendKeys(Keys.TAB)
			.sendKeys(Keys.TAB)
			.sendKeys(Keys.TAB)
			.sendKeys(Keys.TAB)
			.sendKeys(Keys.TAB)
			.sendKeys("MacBook Pro")
			.sendKeys(Keys.ENTER)
			.build().perform();

	}

}
