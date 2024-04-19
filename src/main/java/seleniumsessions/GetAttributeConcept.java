package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 37 - 19th Feb
 * Selenium_07_FindElements_TotalLinks_Images_Inputs_GetElementsUtil_GetEleText_AttributesListUtils.mp4
 * part 2 */

public class GetAttributeConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		// text --> getText()
		// attribute --> getAttribute()

		// Requirement:
		// get all the links
		// capture href value

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

//		String fname_placeholder = driver.findElement(By.id("input-firstname")).getAttribute("placeholder");
//		String fname_type = driver.findElement(By.id("input-firstname")).getAttribute("type");
//		String fname_name = driver.findElement(By.id("input-firstname")).getAttribute("name");
//		
//		System.out.println(fname_placeholder);
//		System.out.println(fname_type);
//		System.out.println(fname_name);		 

		By fName = By.id("input-firstname");
		By registerLink = By.linkText("Register");
		
		String fName_placeholder = doElementGetAttribute(fName, "placeholder");
		System.out.println(fName_placeholder);
		
		String fName_class= doElementGetAttribute(fName, "class");
		System.out.println(fName_class);
		
		String register_href = doElementGetAttribute(registerLink, "href");
		System.out.println(register_href);

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static String doElementGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

}
