package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

/* Day 39 - 21st Feb
 * Selenium_09_SelectClass_DropDownHandling_DropDownUtils.mp4
 * part 1_2 */

public class SelectDropDownNullPointer {

	static WebDriver driver;

	public static void main(String[] args) {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		driver = new ChromeDriver(co);

		driver.get("https://www.orangehrm.com/30-day-free-trial/");

		By countryID = By.id("Form_getForm_Country");

		doSelectByVisibileText(countryID, null);

		doSelectByValue(countryID, "null");
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public static void doSelectByVisibileText(By locator, String visibleText) {
		if (visibleText == null || visibleText.length() == 0) {
			throw new MyElementException("Visible text cannot be null"); // create the object of the class and throw
																			// the exception
		}
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);

	}

	public static void doSelectByValue(By locator, String value) {
		if (value == null || value.length() == 0) {
			throw new MyElementException("Visible text cannot be null");
		}

		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

}
