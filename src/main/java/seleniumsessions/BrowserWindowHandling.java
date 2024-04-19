package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 48 - 11th March
 * Selenium_18_BrowserWindowHandling_WindowHandler_NewWindowConcept.mp4
 * part 1 */

public class BrowserWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//parent
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();
				
		//1st: fetch the window ids
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		System.out.println("parent window id : " + parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("child window id : " + childWindowId);
		
		//2nd: switching work:
		driver.switchTo().window(childWindowId);
		System.out.println("child window url : " + driver.getCurrentUrl());//tw
		driver.close();//close the child window
		
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window url : " + driver.getCurrentUrl());//orangehrm
		
		driver.quit();

	}

}

// When we click on something if it opens in a new tab or window that is also a kind of pop-up
// Upon inspecting the element, if there is the property target=_blank that means it opens in a new tab
// getWindowHandles - will return set of string
// it will give window ids - two in this case, parent and child
// window ids are always unique
// Set is another kind of collection. it is not index based. List is index based - 0,1,2,3
// Iterator is used to iterate collections that don't maintain an order such as 0,1,2...
// First segment will get filled with the parent id and 2nd segment will filled with the child id
//1:07 if there are 2 segments, 99% of the time it stores in the order of parent and child window id

//Cascaded windows
//-----------------

//Launch main page -orange hrm
//Click on link -> will take you to another site e.g twitter
//Click on link in the 2nd window -> Takes you to a 3rd site/page
// Concept will remain the same
