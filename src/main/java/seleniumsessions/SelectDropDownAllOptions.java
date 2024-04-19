package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

/* Day 39 - 21st Feb
 * Selenium_09_SelectClass_DropDownHandling_DropDownUtils.mp4
 * part 2_1 */

public class SelectDropDownAllOptions {

	static WebDriver driver;

	public static void main(String[] args) {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		driver = new ChromeDriver(co);

		driver.get("https://www.orangehrm.com/30-day-free-trial/");

		WebElement country = driver.findElement(By.id("Form_getForm_Country"));

		Select select = new Select(country);
		List<WebElement> countryOptions = select.getOptions();
		System.out.println(countryOptions.size());

		//Interview Q - You are not allowed to use selectByValue, selectByIndex, SelectByText
		// There is a performance issue but used to solve it programmatically
		for (WebElement e : countryOptions) {
			String text = e.getText();
			System.out.println(text);

			if (text.equals("Sri Lanka")) {
				e.click(); //time complexity - one for loop > O of n-> N number of times it will run
				break; 
			}
		}

	}


}
