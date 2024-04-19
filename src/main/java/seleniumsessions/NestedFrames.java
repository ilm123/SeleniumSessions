package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 51 - 14th March
 * Selenium_21_PsuedoElement_ShadowDOM_NestedIframesHandle.mp4
 * part 4 */

public class NestedFrames {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-scenario/");
		Thread.sleep(3000);
		
		driver.switchTo().frame("pact1"); //frame 1
		driver.findElement(By.id("inp_val")).sendKeys("Testing");
		
		driver.switchTo().frame("pact2"); //frame 2
		driver.findElement(By.id("jex")).sendKeys("Automation");
		
		driver.switchTo().frame("pact3"); //frame 3
		driver.findElement(By.id("glaf")).sendKeys("Gardens");
		
		//f3 --> f2 using switch().frame()? : NOOOOOO
		//f3  ---> parentFrame() : f2 : YESSSS
		//f2 --> parentFrame(): f1 : YESSS
		
		driver.switchTo().frame("pact1"); //frame 3 to frame 1 
		driver.findElement(By.id("inp_val")).sendKeys(" 999"); // NoSuchFrameException: No frame element found
		
//		driver.switchTo().defaultContent(); // goes to the main page
//		String header = driver.findElement(By.tagName("h3")).getText();
//		System.out.println(header);			
		
		//Sel 4.x
//		driver.switchTo().parentFrame(); // Goes to frame 2
//		driver.findElement(By.id("jex")).sendKeys(" is technical"); 
//		
//		driver.switchTo().parentFrame(); // Goes to frame 1
//		driver.findElement(By.id("inp_val")).sendKeys(" is fun"); 
		
//		driver.switchTo().parentFrame(); //Goes to the main page
//		String header = driver.findElement(By.tagName("h3")).getText();
//		System.out.println(header);		
		
//		driver.switchTo().defaultContent(); //Goes to the main page
//		String header = driver.findElement(By.tagName("h3")).getText(); 
//		System.out.println(header);		
		
	}

}

// Cannot jump from page to inner frame - cannot jump directly to frame 3
// Cannot jump from inner frame to a grand parent frame - cannot jump from frame 3 to frame 1
// Follow the hierarchy
// If you are on frame 1 both switchTo().defaultContent() and switchTo().parentFrame() will go to the main page
// Always has to be step by step, sequential
// Difficult to find these kind of apps
// switchTo - forward direction
// parentFrame - backward direction