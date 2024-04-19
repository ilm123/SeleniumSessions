package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

/* Day 49 - 12th March
 * Selenium_19_RelativeLocators_SVGElement.mp4
 * part 3 */

public class WebTableWithRelativeLocator {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
				
		WebElement user = driver.findElement(By.linkText("John.Smith"));
		
		driver.findElement(with(By.id("ohrmList_chkSelectRecord_21")).toLeftOf(user)).click();
		
		//!! This returns unnecessary data. So better to use the Xpath approach
//		List<WebElement> userList = driver.findElements(with(By.xpath("//table[@id='resultTable']//td")).toRightOf(user));
		List<WebElement> userList = driver.findElements(with(By.xpath("//table[@id='resultTable']//tr[@class='plan rit']//td[@class='left']")).toRightOf(user));
		
		for (WebElement e:userList) {
			System.out.println(e.getText());
		}

	}

}
