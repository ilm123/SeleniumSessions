package assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Selenium_02_SeleniumMavenProject_FirstSeleniumCode_SeleniumWD_Hirerachy_TopCastingOptions.mp4


public class LaunchOpenCartInChrome {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		String title = driver.getTitle();
		System.out.println("The title of the page is: " + title);
		
		if (title.equals("Your Store")) {
			System.out.println("Correct title - PASSED");
		}
		else {
			System.out.println("Correct title - FAILED");
		}
		
//		String url = driver.getCurrentUrl();
//		System.out.println("URL: " + url);
//		
//		if (url.contains("opencart") ) {
//			System.out.println("Url contains 'opencart' - Test Passed");
//		}
//		else {
//			System.out.println("Url contains 'opencart' - Test Failed");
//		}
		driver.close();

	}

}
