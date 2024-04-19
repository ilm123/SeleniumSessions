package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 47 - 7th March
 * Selenium_17_JSAlertPopUp_AuthPopUp_FileUpload_FrameHandling.mp4
 * part 3 */

public class FileUploadPopUp {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		//file upload pop-up cannot be handled by selenium, that pop-up is part of the OS
		//type = file is mandatory
		//The only time we use sendkeys on a button
		//This is a hack. There is no permanent solution given by Selenium
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\User\\Desktop\\XpathQ.png");

		//External 3rd party libraries
		//sikuli - image based/resolution based
		//autoIT -- only for windows machine -- wont work in docker, headless, jenkins, linux, macos
	}

}
