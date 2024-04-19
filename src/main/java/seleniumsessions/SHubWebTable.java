package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/* Day 42 - 27th Feb
 * Selenium_12_XpathAxes_WebTableHandling_Parent_Child_Ancestor_Siblings.mp4
 * part 3 */

public class SHubWebTable {

	static WebDriver driver;
	public static void main(String[] args) {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		driver = new ChromeDriver(co);
		driver.get("https://selectorshub.com/xpath-practice-page/");
//		 String xpath = "//a[text()='Joe.Root']/ancestor::tr//input[@type='checkbox']";
//		 String xpath = "//a[text()='John.Smith']/ancestor::tr//input[@type='checkbox']";
//		 driver.findElement(By.xpath(xpath)).click();
		
		selectUser("Joe.Root");
		selectUser("John.Smith");
		
		System.out.println(getUserDetails("Joe.Root"));
		System.out.println(getUserDetails("John.Smith"));
	}

	//Application specific utility
	public static void selectUser(String userName) {
		String xpath = "// a[text()='" + userName + "']/ancestor::tr//input[@type='checkbox']"; // Have to maintain the
																								// single quote. It will
																								// behave as a string
																								// concatenation with
																								// the single quote
		driver.findElement(By.xpath(xpath)).click();
	}

	
	public static List<String> getUserDetails(String userName) {
		String xpath = "// a[text()='"+userName+"']/parent::td/following-sibling::td";
		List<WebElement> userInfoEles = driver.findElements(By.xpath(xpath));
		List<String> userInfoList = new ArrayList<String>();
				
		for (WebElement e:userInfoEles) {
			String text = e.getText();
			userInfoList.add(text);
		}
		
		return userInfoList;
	}
}
