package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* Day 45 - 5th March
 * Selenium_15_Actions_MoveToElement_MenuSubMenu_RightClick_DragDrop_Click_SendKeys.mp4
 * part 2 */

public class AcionsMoveToElementUtility {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");		
		
		By parent = By.className("menulink");
		By subMenu = By.linkText("COURSES");
		
		handleMenuSubMenuLevel2(parent, subMenu);		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	// Multi Level Menus - This method handles 2 levels
	public static void handleMenuSubMenuLevel2(By parentMenuLocator, By subMenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).perform();
		Thread.sleep(1500);
		getElement(subMenuLocator).click();
	}

}

