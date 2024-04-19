package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/* Day 52 - 18th March
 * Selenium_22_ImplicitlyWait_Vs_ExplicitlyWait_WebDriverWait.mp4
 * part 3_1 */

public class WebDriverWaitConcept {

	public static void main(String[] args) {
		//Wait(I) : until(); --> FluentWait(C): (@overriden)until(){} + other methods --> WebDriverWait (C): no methods
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		
		By fullName = By.id("Form_getForm_Name"); 
		By userName = By.id("Form_getForm_subdomain");
		
		//e1: 10 secs
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
		WebElement fullNameEle = wait.until(ExpectedConditions.presenceOfElementLocated(fullName));
		WebElement userNameEle = wait.until(presenceOfElementLocated(userName));//trying out static import...
		
		fullNameEle.sendKeys("Testing");
		userNameEle.sendKeys("ilma1");
		
		//e2: 0
		driver.findElement(By.id("Form_getForm_Email")).sendKeys("test@gmail.com");
	

	}

}

// Explicitly Wait can be applied in the form of WebDriverWait or FluentWait

// wait until 10 seconds.If the element is present on the page then only return the web element

//What is the return type of the until method? until method will change it's behavior accordingly.
// <V> generics V means it could be any kind of return on the basis of the behavior of the ExpectedConditions that you write

//What are the ways to create a web element?
//1. driver.findElement
//2. JavascriptExecutor - shadow DOM element converted into WebElement
//3. wait.until()