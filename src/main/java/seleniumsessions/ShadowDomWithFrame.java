package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 51 - 14th March
 * Selenium_21_PsuedoElement_ShadowDOM_NestedIframesHandle.mp4
 * part 3 */

public class ShadowDomWithFrame {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		Thread.sleep(3000);
		

		//sc1: B --> P --> shadowDOM(open) -- element
//		String search_script = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement pizzaName = (WebElement) js.executeScript(search_script);
//
//		pizzaName.sendKeys("Veg Pizza");
		
		
		//sc2:
		//Browser -- page --> shadow DOM(open) ---> iframe --- element

		String frame_script = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#pact1\")";

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement frame = (WebElement) js.executeScript(frame_script);
		
		driver.switchTo().frame(frame);
		
		driver.findElement(By.id("glaf")).sendKeys("Chicken Pizza");

	}

}

// If you copy the JS path of the field element it will not give the js path of the frame
// It is not a good idea to use Selenium for Shadow DOM. WebDriver IO has better compatibility with Shadow DOM
// You need to come out of the frame but no such thing is need with the JSExecutor
