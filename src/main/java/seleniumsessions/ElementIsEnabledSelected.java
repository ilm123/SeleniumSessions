package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 38 - 20th Feb
 * Selenium_08_IsDisplayed_IsEnabled_IsSelected_ElementExist_DisabledElement_Click_SendKeys_CharSequence.mp4
 * part 4 */

public class ElementIsEnabledSelected {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/register/");
		
		//isDiplayed -- element is present on the page
		//isEnabled -- element is obv present on the page but its enabled or not
		
		boolean f1 = driver.findElement(By.name("agreeTerms")).isDisplayed();
		boolean f2 = driver.findElement(By.id("submitButton")).isDisplayed();

		System.out.println(f1); //true
		System.out.println(f2); //true
		
		boolean chk_flag = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(chk_flag); //false
		
		boolean flag = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(flag); //false
		
		driver.findElement(By.name("agreeTerms")).click();
		chk_flag = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(chk_flag); //true
		flag = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(flag); //true

	}

}
