package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/* Day 40 - 22nd Feb
 * Selenium_10_MultiSelectionDropDown_GoogleSearchUtil_JqueryDropDown_MultiSelection.mp4
 * part 3_1 */

public class JqueryDropDown {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		driver = new ChromeDriver(co);

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");
		
		driver.findElement(By.id("justAnInputBox")).click();
		
		Thread.sleep(2000);
		
		List<WebElement> choicesList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));//44
		System.out.println(choicesList.size());
		
		for (WebElement e:choicesList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals("choice 6")) {
				e.click();
				break;
			}
		}
	}
}
