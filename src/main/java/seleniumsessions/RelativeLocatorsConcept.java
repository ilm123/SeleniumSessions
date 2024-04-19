package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;


/* Day 49 - 12th March
 * Selenium_19_RelativeLocators_SVGElement.mp4
 * part 1 */

public class RelativeLocatorsConcept {

	public static void main(String[] args) throws InterruptedException {
		
		//Sel 4.x: 
//								above of ele
//        							  |
//				  left of ele <----  ele   --> right of ele
//									  |
//			near of ele			below of ele


			WebDriver driver = new ChromeDriver();
			driver.get("https://www.aqi.in/dashboard/canada");
			Thread.sleep(4000);
			
			WebElement baseEle = driver.findElement(By.linkText("Calgary, Canada"));
			
			String leftRank = driver.findElement(with(By.tagName("p")).toLeftOf(baseEle)).getText();
			System.out.println(leftRank);
			
			String rightAqi = driver.findElement(with(By.tagName("p")).toRightOf(baseEle)).getText();
			System.out.println(rightAqi);
			
			String aboveCity = driver.findElement(with(By.tagName("p")).above(baseEle)).getText();
			System.out.println(aboveCity);
			
			String belowCity = driver.findElement(with(By.tagName("p")).below(baseEle)).getText();
			System.out.println(belowCity);
			
			String nearestEle = driver.findElement(with(By.tagName("p")).near(baseEle)).getText();
			System.out.println(nearestEle);

	}

}

// only 5 immediate combinations are allowed
// near - nearest to the base element, if you find an element with p tag within 50 pixels, return the text of that element
// There is no left or right. it is a periphery
// The maximum distance between the base element and the p tag should be 50 pixels.
// When you apply get text on the p tag you get the same base element text
