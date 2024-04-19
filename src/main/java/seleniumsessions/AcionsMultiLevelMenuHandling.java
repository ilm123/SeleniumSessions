package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* Day 45 - 5th March
 * Selenium_15_Actions_MoveToElement_MenuSubMenu_RightClick_DragDrop_Click_SendKeys.mp4
 * part 4 */

public class AcionsMultiLevelMenuHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.get("https://www.bigbasket.com/");		
		
		By level1Menu = By.xpath("(//span[contains(text(),'Shop by')])[2]");
		By level2Menu = By.linkText("Snacks & Branded Foods");
		By level3Menu = By.linkText("Chocolates & Candies");
		By level4Menu = By.linkText("Chocolates");
		
		handleMenuSubMenuLevel4(level1Menu, level2Menu, level3Menu, level4Menu);		

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	// 4 levels, 2 mouse overs
	public static void handleMenuSubMenuLevel4(By level1Menu, By level2Menu, By level3Menu, By level4Menu) throws InterruptedException {
		Actions act = new Actions(driver);
		getElement(level1Menu).click();
		Thread.sleep(1500);
		
		act.moveToElement(getElement(level2Menu)).perform();
		Thread.sleep(1500);
		act.moveToElement(getElement(level3Menu)).perform();
		Thread.sleep(1500);
		getElement(level4Menu).click();
	}

}
