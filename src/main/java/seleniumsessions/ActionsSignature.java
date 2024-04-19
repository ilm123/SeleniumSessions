package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/* Day 46 - 6th March
 * Selenium_16_Actions_Scrolling_PageUpDown_ScrollElement_CanvasSignature_SendKeysWithPause_GetElementLocation_BackgroundColor_HeightWidth_WindowSize_Maximize_Minimize_FullScreen.mp4
 * part 4 */

public class ActionsSignature {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://signature-generator.com/draw-signature/");
		
		Actions act = new Actions(driver);
		
		WebElement canvas = driver.findElement(By.id("signature-pad"));
		
		Action signature = act.moveToElement(canvas)
			.clickAndHold(canvas)
//		   .moveToElement(canvas)
		   .moveByOffset(50, -50)
		   .moveByOffset(50, 50)
		   .release(canvas)
		   .build();
		
		signature.perform();
		
//		act.dragAndDropBy(canvas, 300, 0).build().perform();

	}

}

// Limitation with Selenium on a Canvas
// Cannot go inside a canvas. If there a is text field inside canvas, selenium will not be able to go inside
// What can be done is we can mouse over and start drawing
// Target on testing on a canvas is to draw anything. Not to write a real signature which will take along time
