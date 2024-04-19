package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/*
 * Day 34 - 13th Feb
 * Selenium_04_BrowserUtil_GenericFunctions_NavigationMethods_Back_Forward_To_Refresh_HeadLess_Incognito
 * .mp4 part 3
 */

public class HeadlessConcept {

	public static void main(String[] args) {

		// headless vs headed
		// headless: no browser visibility
		// faster - There is no time spent in launching the browser. Hence the initial time is saved
		// run tcs on CI CD/Jenkins/Linux: headless
		// recommended: not recommended
		// local:
		// problems: its not an actual user simulation
		// complex apps/HTML DOM:
		// alerts/popups : could be a problem
		// Debug mode: cannot be visualized on the browser

//		ChromeOptions co = new ChromeOptions();
////		co.addArguments("--headless"); //argument name is --headless
//		co.addArguments("--incognito");	// Opens the browser in incognito mode	
//		WebDriver driver = new ChromeDriver(co); //supply object reference in constructor of ChromeDriver

		FirefoxOptions fo = new FirefoxOptions();
//		fo.addArguments("--headless");
		fo.addArguments("--private"); //my test
		WebDriver driver = new FirefoxDriver(fo);// call by reference
		
		// assignment. Launch edge browser in headless mode. 
		// For edge browser its not headless. some other argument needs to be passed
//		EdgeOptions eo = new EdgeOptions();
//		eo.addArguments("--inprivate");
////		eo.addArguments("--headless=new");
////		eo.addArguments("--headless");
//		EdgeDriver driver = new EdgeDriver(eo);

		driver.get("https://naveenautomationlabs.com/opencart/");
		System.out.println(driver.getTitle());
		// driver.quit();

		// headless options(3rd Party):
		// ghostdriver
		// phantomJS
		// htmlunitdriver

		// aws -- ec2 linux -- black box -- headlesss -- docker(LINUX) -- UI

	}

}

// *****This class tests both headless and incognito mode*****
// Earlier version of Selenium such as Sel 4.1 had co.setHeadless. Now it is removed 
// There are other arguments with chromeOptions. we will see in upcoming chapters
// headless, incognito need to be supplied as an argument

// what is the purpose of headless?
// No browser visibility, so it won't interrupt you
// It is not recommended
// You have low budget, only one machine, want write your code, while the test cases run in the background
// When you run in the CI/CD, there is no look and feel