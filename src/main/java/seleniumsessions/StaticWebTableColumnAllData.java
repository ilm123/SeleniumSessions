package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 43 - 28th Feb
 * Selenium_13_webtableUtils_StaticWebTableHandling_CascadedClasses_InvalidSelectorException.mp4
 * part 2_3 */

public class StaticWebTableColumnAllData {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		System.out.println("Total rows: " + (rowCount - 1));

		int columnCount = driver.findElements(By.xpath("//table[@id='customers']//tr/th")).size();
		System.out.println("Total columns: " + columnCount);

		System.out.println(getCompleteData());

		for (int column=1; column<=columnCount; column++) {// prints column by column
			List<WebElement> dataElements = driver.findElements(
					By.xpath("//table[@id='customers']//tr/td["+column+"]"));
			
			for (WebElement e : dataElements) {
				System.out.println(e.getText());
			}
		}

	}

	public static List<String> getCompleteData() {// prints row by row
		List<WebElement> dataElements = driver.findElements(By.xpath("//table[@id='customers']//tr//td"));
		List<String> completeList = new ArrayList<String>();

		for (WebElement e : dataElements) {
			String text = e.getText();
			completeList.add(text);
		}

		return completeList;

	}

}
