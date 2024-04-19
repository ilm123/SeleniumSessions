package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 48 - 11th March
 * Selenium_18_BrowserWindowHandling_WindowHandler_NewWindowConcept.mp4
 * part 2 */

public class BrowserMultipleWindowHandlng {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//parent
		String parentWindowId = driver.getWindowHandle(); //persist window in the beginning
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")).click(); //child
		driver.findElement(By.xpath("//a[contains(@href,'facebook')]")).click(); //child
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click(); //child
		driver.findElement(By.xpath("//a[contains(@href,'youtube')]")).click(); //child
		
		//fetch the window ids
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator(); // Iterator is for non order based collections
		
		while (it.hasNext()) { // while loop always takes a boolean value
			String windowId = it.next();
			driver.switchTo().window(windowId);
			System.out.println("window url: " + driver.getCurrentUrl());
			
			if (!windowId.equals(parentWindowId)) {				
				driver.close();
			}
			
			Thread.sleep(1000);			
		}		
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getCurrentUrl() + " " + driver.getTitle());
		

	}

}

// Iterator can be used on both order based and non order based, but for loop is the based for order based
