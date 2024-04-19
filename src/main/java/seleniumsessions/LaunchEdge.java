package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchEdge {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();

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
		if (url.contains("google.com")) { // up to you on which method to use. .contains or .equals
			System.out.println("url -- PASSED");
		} else {
			System.out.println("url -- failed");
		}

		//  close the browser:quit() and close()
		driver.close();

	}

}
