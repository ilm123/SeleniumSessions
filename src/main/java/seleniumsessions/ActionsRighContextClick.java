package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* Day 45 - 5th March
 * Selenium_15_Actions_MoveToElement_MenuSubMenu_RightClick_DragDrop_Click_SendKeys.mp4
 * part 6 */

public class ActionsRighContextClick {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).perform();
		
		// Directly click on Cut
		driver.findElement(By.xpath("//span[text()='Cut']")).click();
		
		// Capture all the submenu options
//		List<WebElement> rightEles = driver.findElements(By.cssSelector("ul.context-menu-list > li:not(.context-menu-separator)"));
//		
//		for (WebElement e:rightEles) {
//			String text = e.getText();
//			System.out.println(text);
//			
//			if (text.equals("Copy")) {
//				e.click();
//				break;
//			}
//		}

	}

}
// How do you do a context click? A: Do a right click with the help of the Actions class