package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

/* Day 49 - 12th March
 * Selenium_19_RelativeLocators_SVGElement.mp4
 * part 2 */

public class RelativeLocators {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		
		WebElement baseEle = driver.findElement(By.id("input-email"));
		
		String aboveEle = driver.findElement(with(By.cssSelector("label[for='input-email']")).above(baseEle)).getText();
		System.out.println(aboveEle);
		
		WebElement headerBaseEle = driver.findElement(By.xpath("//h2[text()='New Customer']"));
		WebElement continuebtnEle = driver.findElement(By.linkText("Continue"));
		
		List <WebElement> paraList= driver.findElements(with(By.tagName("p")).below(headerBaseEle).above(continuebtnEle));
		
		for (WebElement e:paraList) {
			System.out.println(e.getText());
		}		

	}

}

//use case - if want to check if the register button is below the login button
