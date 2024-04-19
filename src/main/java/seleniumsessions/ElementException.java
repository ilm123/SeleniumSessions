package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 38 - 20th Feb
 * Selenium_08_IsDisplayed_IsEnabled_IsSelected_ElementExist_DisabledElement_Click_SendKeys_CharSequence.mp4
 * part 1 */

public class ElementException {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		//driver.findElement(By.name("search111")).sendKeys("test"); //NoSuchElementException - Internally creates the CSS selector
		
		List <WebElement> link = driver.findElements(By.tagName("ilma"));
		//Empty array list
		System.out.println(link.size()); //0
		System.out.println(link); //[]

	}

}

//*** findElement - if element doesn.t exits, it throws an exception but findElements doesn't throw any exception