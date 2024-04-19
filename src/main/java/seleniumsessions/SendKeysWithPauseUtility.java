package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* Day 46 - 6th March
 * Selenium_16_Actions_Scrolling_PageUpDown_ScrollElement_CanvasSignature_SendKeysWithPause_GetElementLocation_BackgroundColor_HeightWidth_WindowSize_Maximize_Minimize_FullScreen.mp4
 * part 2_2 */

/**
 * 
 * @author Ilma Thaha
 */
public class SendKeysWithPauseUtility {

	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");		
 		
//		WebElement search = driver.findElement(By.name("search"));
		By search = By.name("search");
		
		String value = "macbook";		
			
		doSendKeysWithPause(search, value);

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	

	public static void doSendKeysWithPause(By locator, String value) {
		
		Actions act = new Actions(driver);
		char[] charArray = value.toCharArray();
		
		for (char val:charArray) {			
			act.sendKeys(getElement(locator), String.valueOf(val)).pause(500).build().perform();
		}	
	}

}
