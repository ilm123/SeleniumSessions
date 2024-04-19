package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 49 - 12th March
 * Selenium_19_RelativeLocators_SVGElement.mp4
 * part 4 */

public class SVGElements {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("macbook");
		driver.findElement(By.xpath("//button//*[local-name()='svg' and @fill='none']")).click(); // single slash or two
																									// slashrd can be
																									// written

	}

}
