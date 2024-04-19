package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 37 - 19th Feb
 * Selenium_07_FindElements_TotalLinks_Images_Inputs_GetElementsUtil_GetEleText_AttributesListUtils.mp4
 * part 3 */

public class FEsUtils {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");

		By links = By.tagName("a");
		By images = By.tagName("img");

		System.out.println("Total Links: " + getElementsCount(links));
		System.out.println("Total of Images: " + getElementsCount(images));		
		System.out.println(getElementsTextList(links));
		ArrayList <String> eleText = getElementsTextList(links);
		System.out.println(eleText);
		
		if (eleText.contains("Testimonials")) {
			System.out.println("Test Passed");
		}
		
		ArrayList <String> eleAltValues = getElementAttributeList(images, "alt");
		System.out.println(eleAltValues);

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public static ArrayList<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleTextList = new ArrayList<String>(); //pc=0

		for (WebElement e : eleList) {
			String text = e.getText();

			if (text.length() != 0) {
				eleTextList.add(text);
			}
		}

		return eleTextList;
	}

	public static ArrayList<String> getElementAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleAttrList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String attrValue = e.getAttribute(attrName);
			
			if (attrValue.length()!=0) {
				eleAttrList.add(attrValue);
			}
			
		}

		return eleAttrList;
	}

}
