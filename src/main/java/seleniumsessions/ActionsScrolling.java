package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* Day 46 - 6th March
 * Selenium_16_Actions_Scrolling_PageUpDown_ScrollElement_CanvasSignature_SendKeysWithPause_GetElementLocation_BackgroundColor_HeightWidth_WindowSize_Maximize_Minimize_FullScreen.mp4
 * part 1 */

public class ActionsScrolling {

	public static void main(String[] args) throws InterruptedException {
		
		//Sel 4.x
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://lassana.com/");
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform(); //keys is a pre-defined enum in java. enum is a collection of multiple constant values
//		Thread.sleep(2000);		
//		act.sendKeys(Keys.PAGE_UP).perform();
//		Thread.sleep(2000);
//		act.sendKeys(Keys.PAGE_DOWN).perform();
		
//		act.sendKeys(Keys.END).perform();// This also works
//		Thread.sleep(2000);
//		act.sendKeys(Keys.HOME).perform();// This also works
		
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
//		Thread.sleep(3000);
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();

		// builder pattern
//		act.scrollToElement(driver.findElement(By.xpath("//p[text()='Our Plantations']")))
//				.click(driver.findElement(By.xpath("//p[text()='Our Plantations']")))
//					.build().perform(); // not necessary to write .build
		
		//Refresh???
		
	}
 
}
