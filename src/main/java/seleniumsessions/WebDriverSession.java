package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 33 - 12th Feb
*  Selenium_03_WebDriverArchitecture_SeleniumManager_QuitvsClose_SessionIDConcept.mp4
*  part 2_1*/

public class WebDriverSession {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();// open browser: 123
		driver.get("https://www.google.com");// enter url: 123
		String title = driver.getTitle();// get title: 123
		System.out.println("page title: " + title);

		String url = driver.getCurrentUrl();// 123
		System.out.println(url);

		driver.close();// browser is closed
		// session is invalid with the same id: //NoSuchSessionException: invalid
		// session id
		// sid=123--invalid

		// driver.quit();//browser is closed: 123
		// NoSuchSessionException: Session ID is null. Using WebDriver after calling
		// quit()?

		// sid=null

		driver = new ChromeDriver();// open browser: new session id = 456
		driver.get("https://www.google.com");// enter url: 456

		System.out.println(driver.getTitle());// 456
		// ChromeDriver: chrome on mac (null)

		// NoSuchSessionException: invalid session id
		// When the 1st request is sent to the server it will always create a session id
		// - SID e.g SID=123
		// All the requests will have the same session id
		// driver.close will close the browser. The server will still be running.
		// After closing the browser the session id is the same. However the session id
		// is invalid
		// driver.quit() -> session id is becomes null

		// *** we should never write any selenium code after close or quit method. Both
		// will give
		// the same exception but different session id

		// After close or quit once a the browser is launched again, it will be a new
		// session id

		// Note 1 - Socket Exception when closing the browser it will try to kill the
		// browser. While killing the browser If any network issue or socket issue is
		// there it will not close properly and give the exception from the java side.
		// Ignore this error for now. It has nothing to do with selenium

		// Note 2 - Q. Close doesn't terminate the program but Quit does.
		// A - It is nothing to do with quit and close. It is a Java process. We can
		// manually terminate it. The JVM is getting terminated or not. It is related to
		// that.
		
//		@Yogesh Thakur Socketexception is coming from chromedriver server side, not coz of our code.
//		It can be ignored.

		// Interview Q - What is the difference between Quit and Close?
		// 1. With respect to Session ID

	}

}
