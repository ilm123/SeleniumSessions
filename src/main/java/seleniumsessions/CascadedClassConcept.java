package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 43 - 28th Feb
 * Selenium_13_webtableUtils_StaticWebTableHandling_CascadedClasses_InvalidSelectorException.mp4
 * part 3 */

public class CascadedClassConcept {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");

		// ***The Email Address field has 3 class names. Each name is separated by a space

		// InvalidSelectorException: Compound class names not permitted
		// Invalid
//		driver.findElement(By.className("form-control private-form__control login-email")).sendKeys("ilma");

		// Valid
//		driver.findElement(By.xpath("//input[@class='form-control private-form__control login-email']")).sendKeys("test1");

		// NoSuchElementException: no such element: Unable to locate element
		// Invalid
//		driver.findElement(By.xpath("//input[@class='login-email']")).sendKeys("test1");		

		// Valid
//		driver.findElement(By.xpath("//input[contains(@class,'login-email')]")).sendKeys("test123");

		// How do we find if a class name is unique in the DOM?
		// Search with a "." e.g-> .login-email
		// This method is only used to search unique class names
		// Valid
//		driver.findElement(By.className("login-email")).sendKeys("ilma");
		
		// cssSelector can be used with compound classes 
		// valid
//		driver.findElement(By.cssSelector("input.form-control.private-form__control.login-email")).sendKeys("testttt");
		
		
		//valid
//		driver.findElement(By.cssSelector("input.login-email")).sendKeys("testttt");

		//cssSelector - can combine classes in any order - class 1.class 3 or class3.class 1
		//valid
//		driver.findElement(By.cssSelector("input.form-control.login-email")).sendKeys("testttt");
		
		//InvalidSelectorException: invalid selector: Unable to locate an element with the xpath
		driver.findElement(By.xpath("//input[@#@#@id=-12'username']")).sendKeys("testing@gmail.com");
		
	}

}
