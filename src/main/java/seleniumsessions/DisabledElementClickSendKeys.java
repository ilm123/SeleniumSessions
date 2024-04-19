package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 38 - 20th Feb
 * Selenium_08_IsDisplayed_IsEnabled_IsSelected_ElementExist_DisabledElement_Click_SendKeys_CharSequence.mp4
 * part 5 */

public class DisabledElementClickSendKeys {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
//		driver.findElement(By.id("pass")).click();//no exception thrown
//		driver.findElement(By.id("pass")).sendKeys("test"); //ElementNotInteractableException

//		driver.findElement(By.id("fname")).sendKeys(null);// IllegalArgumentException: Keys to send should be a not null CharSequence

		StringBuilder sb = new StringBuilder("testing");
		String str = "automation";
		driver.findElement(By.id("fname")).sendKeys(sb + str);
		driver.findElement(By.id("fname")).clear();
		driver.findElement(By.id("fname")).sendKeys("ilma", sb, str);// Bcz CharSequence behaves like an array. sb is a
																		// string build and two strings

//		driver.get("https://classic.freecrm.com/register/"); 
//		driver.findElement(By.id("submitButton")).click();//ElementClickInterceptedException - button> is not clickable

	}

}

//******SendKeys method******
//CharSequence - interface in java. 
//There are 3 classes. String, String Builder and String Buffer - All these three are child of CharSequence. 
// It is not mandatory to pass only a string
//SendKeys method is not asking for a string parameter. It wants a CharSequence. 
//Hence CharSequence takes in 3 types of data; String, String Builder and String Buffer
//Three dot parameter - Behaves like an array - will see later in the jquery example
//Can supply it as an array - as comma separated or individually