package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 32 - 8th Feb
*  Selenium_02_SeleniumMavenProject_FirstSeleniumCode_SeleniumWD_Hirerachy_TopCastingOptions.mp4
*  part 1*/

public class WebDriverBasics {

	public static void main(String[] args) {

		// open browser: chrome
		// enter url
		// get the title
		// verify the title - act vs exp

		// automation steps - it is not verifying anything
		WebDriver driver = new ChromeDriver(); // Launches a replica of the chrome browser / fresh browser
		driver.get("https://www.google.com"); // Reference Type Check = Passed. Mandatory to write URL with https or
												// http
		String title = driver.getTitle();
		System.out.println("The title of the page is: " + title);

		// checkpoint/verification point/act vs exp: (not using testNg for now)
		if (title.equals("Google")) {
			System.out.println("Correct title - PASSED");
		} else {
			System.out.println("Incorrect title - FAILED");
		}

		// automation steps + verification point ---> Automation Testing
		// test steps + verification point -- test case

		String url = driver.getCurrentUrl(); // e.g URL can change when navigating between pages. so we want to find out
												// the url
		System.out.println(url);

		// verification point for the url
		if (url.contains("google.com")) { //up to you on which method to use. .contains or .equals
			System.out.println("url -- PASSED");
		} else {
			System.out.println("url -- failed");
		}
		
		//  close the browser:quit() and close()
		driver.close();

	}
}
