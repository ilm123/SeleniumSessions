package seleniumsessions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 46 - 6th March
 * Selenium_16_Actions_Scrolling_PageUpDown_ScrollElement_CanvasSignature_SendKeysWithPause_GetElementLocation_BackgroundColor_HeightWidth_WindowSize_Maximize_Minimize_FullScreen.mp4
 * part 5_2 */

public class WindowSizeWithDimension {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();		
		
		//responsive - view port -
		Dimension dim = new Dimension(414, 896);
		
		driver.manage().window().setSize(dim);
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		
	}

}

//In Chrome Dev Tools = Next to Inspect. click on 'Toggle Device Toolbar'
//You will see N number of options
//You can select different view ports and test
//Can also give your own height and width