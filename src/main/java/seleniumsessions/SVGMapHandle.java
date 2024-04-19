package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/* Day 49 - 12th March
 * Selenium_19_RelativeLocators_SVGElement.mp4
 * part 5 */

public class SVGMapHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		WebDriver driver = new FirefoxDriver();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		Thread.sleep(5000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
		//CSS - svg#map-svg g#regions g.region
		
		String map_xpath = "//*[local-name()='svg']//*[name()='g' and @id='regions']/*[name()='g']";
		List<WebElement> statesList = driver.findElements(By.xpath(map_xpath));
		System.out.println(statesList.size());
		
		
		Actions act = new Actions(driver);
				
		for (WebElement e:statesList) {
			act.moveToElement(e).perform();
//			act.moveToElement(e,  50, -50).perform();
			String stateId = e.getAttribute("id");			
			System.out.println(stateId);
			Thread.sleep(500);
		}
		

	}

}

// for svg start with local-name() and for all the sub elements, use name()
// You can start with name() instead of local-name