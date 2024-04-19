package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 46 - 6th March
 * Selenium_16_Actions_Scrolling_PageUpDown_ScrollElement_CanvasSignature_SendKeysWithPause_GetElementLocation_BackgroundColor_HeightWidth_WindowSize_Maximize_Minimize_FullScreen.mp4
 * part 5_3 */

public class ElementSizeLocationAndCSSProperty {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebElement fName = driver.findElement(By.id("input-firstname"));
		
		int height = fName.getSize().getHeight();
		int width = fName.getSize().getWidth();
		
		System.out.println(height); //34
		System.out.println(width); //576
		
		int x = fName.getLocation().getX();
		int y = fName.getLocation().getY();
		
		System.out.println(x + " " + y);
		
		WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
		String continueBtnColor = continueBtn.getCssValue("background-color");
		System.out.println(continueBtnColor);
		
		System.out.println(fName.getCssValue("font-size"));

	}

}
