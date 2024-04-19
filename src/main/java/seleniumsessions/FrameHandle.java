package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 48 - 7th March
 * Selenium_17_JSAlertPopUp_AuthPopUp_FileUpload_FrameHandling.mp4
 * part 6 */

public class FrameHandle {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.londonfreelance.org/courses/frames/index.html");
		//Frame with Index
		driver.switchTo().frame(2);
		
		String header = driver.findElement(By.tagName("h2")).getText();
		
		System.out.println(header);
		

	}

}

// Frame index is risky. If more frames are introduced your script will have to be updated
// If you are sure the index wont change then you can use the index