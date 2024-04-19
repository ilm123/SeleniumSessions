package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 46 - 6th March
 * Selenium_16_Actions_Scrolling_PageUpDown_ScrollElement_CanvasSignature_SendKeysWithPause_GetElementLocation_BackgroundColor_HeightWidth_WindowSize_Maximize_Minimize_FullScreen.mp4
 * part 5_1 */

public class WindowSize {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); // maximizes to specific limit
		
		// fullscreen maximizes and then shrinks. 
		// Some times full screen means you run your TCs on a big monitor - 21" 
		// So you want it to fit to that screen you can use full screen
		// Generally we use maximize
		// ChromeOptions maximize also does the same thing but don't use it
		
//		driver.manage().window().fullscreen();
		
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		// Sel 4.x
		driver.manage().window().minimize(); //no use case 
		
		driver.manage().window().maximize();
	}

}
