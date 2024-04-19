package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 38 - 20th Feb
 * Selenium_08_IsDisplayed_IsEnabled_IsSelected_ElementExist_DisabledElement_Click_SendKeys_CharSequence.mp4
 * part 3 */

public class GetTextFieldValue {	
	
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.findElement(By.id("input-email")).sendKeys("ilma@gmail.com");
		String emailId = driver.findElement(By.id("input-email")).getAttribute("value");
		System.out.println(emailId);
		
		
//		String email = driver.findElement(By.id("input-email")).getText(); // Will not work. getText: link, header, label, span
//		System.out.println(email);
		

	}

}
