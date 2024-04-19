package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* Day 45 - 5th March
 * Selenium_15_Actions_MoveToElement_MenuSubMenu_RightClick_DragDrop_Click_SendKeys.mp4
 * part 1 */

public class AcionsMoveToElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");		
		
		WebElement content = driver.findElement(By.className("menulink"));
		Actions act = new Actions(driver); // create the object of the actions class and supply the driver. There is a constructor in the
		// Actions class
		
		act.moveToElement(content).perform(); 
		//act.moveToElement(content).build().perform();
		
		//Two ways to write the above
		// Single action - .perform()
		// Single action - .build().perform()
		// N number of actions - build().perform()
		
		Thread.sleep(1500);
		
		driver.findElement(By.linkText("COURSES")).click();

	}

}

// Hidden elements that are not hidden in the DOM. It is hidden in the page. You can see it when you mouse over. These are handled
// using Actions class
// Move to element = Mouse Over
// When ever you use an actions method, it mandatory to use the perform method

// *** When the page text is different from the dom text, use the page text. e.g ARTICLES on the page and Articles in the DOM

// ***Topics covered
// -- Actions class
// -- moveToElement(content).build().perform();
// -- Multi-Level Menu - 2 levels
// -- Multi-Level Menu - 4 levels
// -- .sendKeys
// -- .click
// -- .contextClick
// -- DragAndDropConcept