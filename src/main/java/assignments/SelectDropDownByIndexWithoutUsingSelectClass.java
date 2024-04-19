package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/* Day 39 - 21st Feb
 * Selenium_09_SelectClass_DropDownHandling_DropDownUtils.mp4
 * part 3 */

public class SelectDropDownByIndexWithoutUsingSelectClass {
	// **** not allowed to use select class and select value from drop down***/

	static WebDriver driver;

	public static void main(String[] args) {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		driver = new ChromeDriver(co);

		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		By options = By.xpath("//select[@id='Form_getForm_Country']/option");
		doSelectIndexDropDown(options, 5);		
	}

	public static void doSelectIndexDropDown(By locator, int value) {
		List<WebElement> optionList = driver.findElements(locator);
		int i=0;

		for (WebElement e : optionList) {
			//String text = e.getText();
			if (i==value) {
				e.click();
				break;
			}
			i++;
		}
	}

}
