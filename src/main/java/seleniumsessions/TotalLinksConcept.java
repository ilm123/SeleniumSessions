package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 37 - 19th Feb
 * Selenium_07_FindElements_TotalLinks_Images_Inputs_GetElementsUtil_GetEleText_AttributesListUtils.mp4
 * part 1 */

public class TotalLinksConcept {

	public static void main(String[] args) {

		// 1. total links
		// 2. print the text of each link
		// 3. avoid blank text - a link without text
		// 4. broken link -- later - get 404 error

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// find out all the elements --> FEs

		List<WebElement> allLinks = driver.findElements(By.tagName("a")); // The anchor tag is common for all the links.
																			// List is the parent interface of Array List.
																			// It is an order based collection

		System.out.println("Total Links: " + allLinks.size());

		for (int i = 0; i < allLinks.size(); i++) {
			String text = allLinks.get(i).getText();// " allLinks.get(i)->see the generics. all the web elements are
													// available in this list. not the strings"

			if (text.length() != 0) {// If 100 elements are inside the DOM all elements will not appear on the page
				System.out.println(text);
			}

		}

		System.out.println("------------");

		for (WebElement e : allLinks) {
			String text = e.getText();

			if (text.length() != 0) {
				System.out.println(text);
			}
		}

		System.out.println("------------");

		// total text fields on the page:
		List<WebElement> textFields = driver.findElements(By.className("form-control"));

		System.out.println(textFields.size());

		for (WebElement e : textFields) {
			e.sendKeys("testing"); // Anti Pattern!! Write specific/individual web elements to fill the value;
									// don't use a for loop
		}

	}

}
