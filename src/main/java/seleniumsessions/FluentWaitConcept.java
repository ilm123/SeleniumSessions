package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Day 54 - 20th March
 * Selenium_24_WaitForIframe_FluentWait_PageLoadiTimeOut_Document_ReadyState.mp4
 * part 2 */

public class FluentWaitConcept {

	public static void main(String[] args) {

		// Wait(I) : until(); --> FluentWait(C): until(){} + other methods --> WebDriverWait (C)

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

		By image = By.cssSelector("div#imageTemplateContainer img");

		//Fluent Wait:
		// Top Casting. Child class object referred by parent interface reference variable
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
							   .withTimeout(Duration.ofSeconds(10))
							   .pollingEvery(Duration.ofSeconds(2)) //10/2= 5 intervals
							   .ignoring(NoSuchElementException.class)
							   .ignoring(ElementNotInteractableException.class)
							   .withMessage("time out... element is not present...");
		
		WebElement image_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(image));
		image_ele.click();
		
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
				   .withTimeout(Duration.ofSeconds(10))
				   .pollingEvery(Duration.ofSeconds(2)) //10/2= 5 intervals
				   .ignoring(NoAlertPresentException.class)
				   .withMessage("time out... element is not present...");
		
		//Top Casting with grand child - but generally not used
		Wait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2000));
		
		//WebDriver Wait with Fluent Wait features:
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.pollingEvery(Duration.ofSeconds(2))
//			.ignoring(NoSuchElementException.class)
//			.withMessage("time out... element is not present...");
//		
//		WebElement image_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(image));
//		image_ele.click();

	}

}

// Generics are given bcz it is the signature of the Fluent Wait 
// it is not mandatory to give all those methods but at least the timeout should be given
// it might throw an exception in between - strictly saying not to throw any exception until 10 seconds have passed

// WebDriverWait is the child of FluentWait. So all the FluentWait methods can be used with WebDriverWait object
// Inherit the properties from the parent
// BMW is extending Car class - can inherit everything from the parent
// Whatever we do with FluentWait can also be done with WebDriverWait

// Four features of Fluent Wait (Advanced Features) - withTimeout, pollingEvery, ignoring, withMessage

// Why have selenium given 2 classes?
// We cannot control their design what has been given
// It not documented anywhere
// If you create your own tool and internally want to use selenium features such as:
// Appium, WebDriver IO, Selenoid - So many tools that use selenium internally
// They are all creating there custom Wait with the help of Fluent Wait
// Create NaveenWebDriverWait and internally extend the FluentWait class and can also override all those methods
// Thats is why FluentWait is given as a template
// It is not mandatory to use FluentWAit. It has been created for external automation tools or libraries
// But selenium have not overridden anything in WebDriver Wait
// So technically, both are same. WebDriverWait is a kind of Fluent Wait.But the vise-verse cannot be said
// WebDriverWait is concept of FluentWait. WebDriverWait can be used with or without FluentWait features

// Builder pattern - all methods are calling current class object. That is why are able to call it in a chain
