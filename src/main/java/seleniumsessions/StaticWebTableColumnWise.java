package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 43 - 28th Feb
 * Selenium_13_webtableUtils_StaticWebTableHandling_CascadedClasses_InvalidSelectorException.mp4
 * part 2_2 */

public class StaticWebTableColumnWise {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		// Go to every tr and capture the first td
		// can pass any column name. i.e Contact etc
		String companyXpath = "//th[text()='Company']/parent::tr/following-sibling::tr/td[1]"; 
		
		// Another xpath
		String companyXpath2 = "//table[@id='customers']//tr/td[1]";
		
		List<WebElement> companyList = driver.findElements(By.xpath(companyXpath2));
		
		for (WebElement e:companyList) {
			String text = e.getText(); 
			System.out.println(text);
		}

	}

}
