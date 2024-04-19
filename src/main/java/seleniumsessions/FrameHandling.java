package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 47 - 7th March
 * Selenium_17_JSAlertPopUp_AuthPopUp_FileUpload_FrameHandling.mp4
 * part 4 */

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		
		//frame: webelement : DOM		
			//Browser 
				//	--Page : webelement
				//		--Frame: webelement
		
		
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("Apiautomation");
		driver.findElement(By.name("password")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(5000);
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();


	}

}

//frame vs iframe
//CRMPro is an old application. Hence frame. According to W3c frame is deprecated
//iframe is another HTML tag
//iframe is seen in modern application
//Doesn't matter if it is frame or iframe. Our target is to switch the driver to the frame and then handle the frame elements
