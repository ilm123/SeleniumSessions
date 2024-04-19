package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/* Day 40 - 22nd Feb
 * Selenium_10_MultiSelectionDropDown_GoogleSearchUtil_JqueryDropDown_MultiSelection.mp4
 * part 3_2 */

public class JqueryDropDownWithUtility {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		driver = new ChromeDriver(co);

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");

		By dropDown = By.id("justAnInputBox");
		By choices = By.xpath("//span[@class='comboTreeItemTitle']");

		// 1. tc_01: single selection
//		selectChoice(dropDown, choices, "choice 1");

		// 2. tc_02: multi selection
		selectChoice(dropDown, choices, "choice 1", "choice 2", "choice 2 1", "choice 2 2");

		// 3. tc 03: all selection
//		selectChoice(dropDown, choices, "all");// length of the array is 1

	}

	/**
	 * This method is used to handle single, multiple and all selections. Please
	 * pass "all" in case of all selections.
	 * 
	 * @param dropDownLocater
	 * @param choices
	 * @param value
	 * @throws InterruptedException
	 */

	public static void selectChoice(By dropDownLocater, By choices, String... value) throws InterruptedException {
		driver.findElement(dropDownLocater).click();

		Thread.sleep(2000);

		List<WebElement> choicesList = driver.findElements(choices);// 45

		if (!value[0].equals("all")) {

			System.out.println(choicesList.size());

			for (WebElement e : choicesList) { //iterating the list
				String text = e.getText();
				System.out.println(text);
				for (String val : value) { //iterating the array
					if (text.equals(val)) {
						e.click();
						break;
					}
				}
			}
		}

		else {
			// all selection logic
			for (WebElement e : choicesList) {//1-14
				try {
					e.click();
				}
				catch(ElementNotInteractableException ex) {
					break;
				}
			}
		}
	}
}

//keep replacing the by locators-hard coded 
// 'value' is the parameter name

//String... value - Behaves like and array. Called a Three dot parameter - spread parameter - varargs
//choice 1 and choice 2 will be given to the value array together. you can now pass N number of values