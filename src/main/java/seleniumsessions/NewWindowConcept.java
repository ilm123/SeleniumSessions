package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 48 - 11th March
 * Selenium_18_BrowserWindowHandling_WindowHandler_NewWindowConcept.mp4
 * part 3 */

public class NewWindowConcept {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//parent
		String parentWindowId = driver.getWindowHandle(); 
		
		Thread.sleep(3000);
		
		//Sel 4.x
		//driver.switchTo().newWindow(WindowType.TAB); //opens a new tab and automatically switches the driver
		driver.switchTo().newWindow(WindowType.WINDOW); 
		
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle()); //google
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle()); //orange HRM
		

	}

}

//You cannot use default content. It is only for the frame
//enum is a special kind of data type which can maintain N number of constants