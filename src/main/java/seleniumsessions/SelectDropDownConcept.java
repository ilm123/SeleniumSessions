package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

/* Day 39 - 21st Feb
 * Selenium_09_SelectClass_DropDownHandling_DropDownUtils.mp4
 * part 1_1 */

public class SelectDropDownConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		driver = new ChromeDriver(co);

		driver.get("https://www.orangehrm.com/30-day-free-trial/");

		WebElement country = driver.findElement(By.id("Form_getForm_Country"));
//
		Select select = new Select(country);
//		select.selectByIndex(500);//NoSuchElementException
		select.selectByVisibleText("ilma");// NoSuchElementException null ->NullPointerException
//		select.selectByValue("Sri Lanka33");//NoSuchElementException

		/*
		 * Between index and visibletext, visibletext is better bcz the index could
		 * change if new countries get added to the List. Index can be used when the
		 * list is fixed like in list of months. Between VisibleText and Value it
		 * depends on which one to use. It is not mandatory for the value attribute to
		 * have a value. Sometimes the Value could be the country code. In that case we
		 * should use the visibleText
		 */

		By countryID = By.id("Form_getForm_Country");
		doSelectByIndex(countryID, 5);
		Thread.sleep(2000);
		doSelectByVisibileText(countryID, "Jordan");
		Thread.sleep(2000);
		doSelectByValue(countryID, "Fiji");
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
			throw new MyElementException("Visible text cannot be null"); // create the object for the class and throw
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
