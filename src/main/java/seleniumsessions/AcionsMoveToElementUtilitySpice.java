package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* Day 45 - 5th March
 * Selenium_15_Actions_MoveToElement_MenuSubMenu_RightClick_DragDrop_Click_SendKeys.mp4
 * part 3 */

public class AcionsMoveToElementUtilitySpice {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");		
		Thread.sleep(3000);
		
		By parent = By.xpath("//div[text()='Add-ons']");
		By subMenu = By.xpath("//div[text()='You1st']");
		
		handleMenuSubMenuLevel2(parent, subMenu);		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void handleMenuSubMenuLevel2(By parentMenuLocator, By subMenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).perform();
		Thread.sleep(1500);
		getElement(subMenuLocator).click();
	}

}

