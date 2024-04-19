package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* Day 46 - 6th March
 * Selenium_16_Actions_Scrolling_PageUpDown_ScrollElement_CanvasSignature_SendKeysWithPause_GetElementLocation_BackgroundColor_HeightWidth_WindowSize_Maximize_Minimize_FullScreen.mp4
 * part 2_1 */

public class SendKeysWithPause {

	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		Actions act = new Actions(driver);
 		
		WebElement search = driver.findElement(By.name("search"));
		
		String value = "macbook";
		
		char[] charArray = value.toCharArray();
		
		for (char val:charArray) {
			//convert char to string -> 'm' is converted to "m"
			//Don't use toString. toString is used for class objects			
			//2 actions - sendkeys and pause			
			//sleep is the java method and pause is the selenium method
			act.sendKeys(search, String.valueOf(val)).pause(500).build().perform();
		}		

	}
	

}
