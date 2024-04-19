package seleniumsessions;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 47 - 7th March
 * Selenium_17_JSAlertPopUp_AuthPopUp_FileUpload_FrameHandling.mp4
 * part 2 */

public class AuthPopup {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		String username = "admin";
		String password = "admin";
		
//		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
//		driver.get("https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");
		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		//sel 4.x:
		//HasAuthentication
		
		//convert/type cast driver into HasAuthentication. driver type is still WebDriver. 
		//we don't have a supplier. So give () and put it as a Lambda
		// we have to supply as functional interface with the help of Lambda
		// After -> it is giving something to the class UsernameAndPassword
		// Credentials are given in the form of supplier
		// supplier is a function interface in java where we use the Lambda
		// with this method you use pw having @
		// Don't need to expose un, pw in the url
		// There are multiple types of function interfaces. Supplier, Consumer, Print
		// Supplier means always give a blank supplier according to the functional interface
		// So when ever we write a supplier we write it with a lambda - A supplier expression () ->
		// It is pre-defined to use the class UsernameAndPassword
		// Default supplier is () -> 
		// Actual supplier comes in the form of un, pw
		// How do we know that has to be blank? Bcz of the signature of the register method
		// When we cover the chapter on streams and lambda we can understand better
		
		
		((HasAuthentication)driver).register(() -> new UsernameAndPassword(username, password));
		
		driver.get("https://the-internet.herokuapp.com/basic_auth");

	}

}

// This is called a Basic Auth
// You cannot inspect, there is no HTML DOM
// To handle it you have to append the un, pw in the URL - before sel 4.x
// after https:un,pw+@+domain name+basic auth page
// Limitation/problem - if your pw has @ this solution will not work