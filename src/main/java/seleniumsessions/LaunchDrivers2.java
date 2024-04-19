package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 33 - 12th Feb
*  Selenium_03_WebDriverArchitecture_SeleniumManager_QuitvsClose_SessionIDConcept.mp4
*  part 2_3*/

public class LaunchDrivers2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();// open browser: 123
		driver.get("https://www.google.com");// enter url: 123
		String title = driver.getTitle();// get title: 123
		System.out.println("page title: " + title);
		String url = driver.getCurrentUrl();// 123
		System.out.println(url);
		driver.quit();//closes browser with SID = 123

		WebDriver driver1 = new ChromeDriver(); 
		driver1.get("https://www.google.com");// enter url: 456
		String title1 = driver1.getTitle();// get title: 456
		System.out.println("page title: " + title1);// SID=456

		driver1.quit();// closes browser with SID = 456
		

	}

}
