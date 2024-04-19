package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/* Day 40 - 22nd Feb
 * Selenium_10_MultiSelectionDropDown_GoogleSearchUtil_JqueryDropDown_MultiSelection.mp4
 * part 2_1 */

public class GoogleSearchSuggestions {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		driver = new ChromeDriver(co);

		driver.get("https://www.google.com/");

		driver.findElement(By.name("q")).sendKeys("selenium");

		Thread.sleep(3000);

		List<WebElement> suggList = driver
				.findElements(By.xpath("//ul[@class='G43f7e' and  @role='listbox']//div[@class='wM6W7d']/span"));
								
		System.out.println(suggList.size());
		
		for (WebElement e : suggList) {
			
			String text = e.getText();
			System.out.println(text);
			if (text.contains("python")) {
				e.click();
				break;
			}

		}

	}

}
