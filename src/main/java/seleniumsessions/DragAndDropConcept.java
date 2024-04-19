package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/* Day 45 - 5th March
 * Selenium_15_Actions_MoveToElement_MenuSubMenu_RightClick_DragDrop_Click_SendKeys.mp4
 * part 5 */

public class DragAndDropConcept {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		//ele to ele on the page -- valid
		//file on the page -- N/A

		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));

		Actions act = new Actions(driver);

		//***Method 1
//		act.clickAndHold(sourceEle).moveToElement(targetEle).release().build().perform(); 
		
		//***Method 2
		// After selenium 4 the build method is not necessary. The perform() will internally call build the build methods
//		act.clickAndHold(sourceEle).moveToElement(targetEle).release().perform(); 
		
		//***Method 3
		Action action = act.clickAndHold(sourceEle).moveToElement(targetEle).release().build();
		action.perform();
		
		//***Method 4
//		act.dragAndDrop(sourceEle, targetEle).perform();

	}

}

// This is just for the interview. In real time we will hardly use this drag and drop
// Use case for Method 3 - To collect all the actions and build it. Later call the perform method. May call it multiple times.
// Action interface is used here
// Actions is a class and Action is an interface