package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 47 - 7th March
 * Selenium_17_JSAlertPopUp_AuthPopUp_FileUpload_FrameHandling.mp4
 * part 1 */

public class AlertJSPopUpHandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		// 1. alert
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		
		Alert alert = driver.switchTo().alert(); // if you switch to, before button click you will get - NoAlertPresentException: no such alert
//		
//		String text = alert.getText(); //Cannot capture the first line. It is not part of the text
//		System.out.println(text);
		
//		alert.accept(); // click OK
//		alert.dismiss(); //Escape/Cancel !!!Works same as click ok
		
		//2. confirmation pop-up
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		Alert alert = driver.switchTo().alert();
//		String text = alert.getText();
//		System.out.println(text);
//		Thread.sleep(2000);
////		alert.accept();
//		alert.dismiss(); 
		
		//3. prompt
//		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
//		Alert alert = driver.switchTo().alert();
//		String text = alert.getText();
//		System.out.println(text);
//		alert.sendKeys("Ilma"); // in selenium sendkeys is not visible
//		Thread.sleep(5000);
////		alert.accept();
//		alert.dismiss(); 
	}

}


// Browser understands only JS
// Cannot inspect anything on JS Alerts. Its not web elements
// 3 types of JS pop-ups:
// 1. Alert popup - has only ok button
// 2. Confirmation popup - Has ok and cancel
// 3. Prompt popup - Has a text field asking for input with ok and cancel button
// After switching to the JS pop-up and clicking it will automatically come back to the main window
// Only one pop-up at a time will appear. While the pop-up is there, you cannot click anywhere else
// prompt will have only one field.
// How many method do we have in alerts? After switching to the pop-up we can:
// capture text, enter the value, accept, dismiss

/*
 * 1:33 Random pop-ups cannot be automated. You will never see such pop ups in
 * the lower env. It could appear in production env random pop-ups are for ads,
 * sign-up, recommendation
 * 
 * Naveen did a POC 2 years back - its out of the box
 */

