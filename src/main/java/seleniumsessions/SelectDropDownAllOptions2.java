package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

/* Day 39 - 21st Feb
 * Selenium_09_SelectClass_DropDownHandling_DropDownUtils.mp4
 * part 2_2 */

public class SelectDropDownAllOptions2 {

	static WebDriver driver;

	public static void main(String[] args) {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		driver = new ChromeDriver(co);

		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		By country = By.id("Form_getForm_Country");
		doSelectDropDownValue(country, "Egypt");

	}

	public static List<String> getDropDownOptionsText(By locator) {
		List<WebElement> optionList = getDropDownOptionsList(locator);
		List<String> optionsTextList = new ArrayList<String>(); // convert list of WE to list of String. Top Casting
																// done here, but can also use Array List. It is a blank
																// Array List PC==0

		for (WebElement e : optionList) {
			String optionsText = e.getText();
			optionsTextList.add(optionsText);
		}

		return optionsTextList;
	}

	public static List<WebElement> getDropDownOptionsList(By locator) {
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);
		return select.getOptions();
	}

	public static int getDropDownValuesCount(By locator) {
		return getDropDownOptionsList(locator).size();
	}

	public static void doSelectDropDownValue(By locator, String value) {

		List<WebElement> optionList = getDropDownOptionsList(locator);

		for (WebElement e : optionList) {
			String text = e.getText();
			System.out.println(text);

			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	public static void printSelectDropDownValue(By locator) {

		List<WebElement> optionList = getDropDownOptionsList(locator);

		for (WebElement e : optionList) {
			String text = e.getText();
			System.out.println(text);
		}
	}

}
