package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 33 - 12th Feb
*  Selenium_03_WebDriverArchitecture_SeleniumManager_QuitvsClose_SessionIDConcept.mp4
*  part 2_2*/

public class LaunchDrivers {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();// open browser: 123
		driver.get("https://www.google.com");// enter url: 123
		String title = driver.getTitle();// get title: 123
		System.out.println("page title: " + title);

		String url = driver.getCurrentUrl();// 123
		System.out.println(url);

		driver = new ChromeDriver(); // Why is WebDriver not written here? A. Reassigning
		driver.get("https://www.google.com");// enter url: 456
		String title1 = driver.getTitle();// get title: 456
		System.out.println("page title: " + title1);// SID=456

//		driver.quit(); // Closes the last opened browser i.e 2nd browser, SID-456 browser-not a right way to write the code
		driver.close(); // same with close
		

	}

}
