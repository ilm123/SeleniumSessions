package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 37 - 19th Feb
 * Selenium_07_FindElements_TotalLinks_Images_Inputs_GetElementsUtil_GetEleText_AttributesListUtils.mp4
 * part 3 */

public class TotalImages {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://lassana.com/");

		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		System.out.println("Total images= " + imageList.size());

		for (WebElement e : imageList) {
			String altVal = e.getAttribute("alt");
			String srcVal = e.getAttribute("src");

			System.out.println(altVal + "----" + srcVal);
		}
	}
}

// Web Scraping