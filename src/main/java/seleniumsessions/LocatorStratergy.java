package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 36 - 15th Feb
 * Selenium_06_DifferentLocators_Click_GetText_ElementUtil.mp4
 * part 2 */

public class LocatorStratergy {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver(); // 123
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// create a webelement + perform an action on it(click, sendKeys, gettext,
		// isDisplayed)

		// 1. id: unique attribute: can not be duplicate -- 1st
//		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test123");

		// 2. name: can be duplicate -- 2nd (90% of the time is it unique)
//		driver.findElement(By.name("firstname")).sendKeys("test");
//		driver.findElement(By.name("lastname")).sendKeys("automation");

//		By firstName = By.name("firstname");
//		By lastName = By.name("lastname");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);		
//
//		eleUtil.doSendKeys(firstName, "test");
//		eleUtil.doSendKeys(lastName, "automation");

		// String locators

//		String fName = "firstname";
//		String lName = "lastname";
//		
//		ElementUtil eleUtil = new ElementUtil(driver);		
//		
//		eleUtil.doSendKeys("name", fName, "test");
//		eleUtil.doSendKeys("name", lName, "automation");

		// 3. class name: its not a unique attribute, can be duplicate - 3rd

//		driver.findElement(By.className("form-control")).sendKeys("test");

		// 4. xpath: its not an attribute: address of the web element in HTML DOM
		// XML PATH
//		driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("testing");
//		driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("automation");

//		By fName = By.xpath("//*[@id=\"input-firstname\"]");
//		By lName = By.xpath("//*[@id=\"input-lastname\"]");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		
//		eleUtil.doSendKeys(fName, "testing");
//		eleUtil.doSendKeys(lName, "automation");

		// String locators

//		String fName = "//*[@id=\"input-firstname\"]";
//		String lName = "//*[@id=\"input-lastname\"]";
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys("xpath", fName, "testing");
//		eleUtil.doSendKeys("xpath", lName, "automation");

		// 5. css: cascaded style sheet: its not an attribute:

//		driver.findElement(By.cssSelector("#input-firstname")).sendKeys("testing"); 
//		driver.findElement(By.cssSelector("#input-lastname")).sendKeys("automation");

//		By fName = By.cssSelector("#input-firstname");
//		By lName = By.cssSelector("#input-lastname");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(fName, "testing");
//		eleUtil.doSendKeys(lName, "automation");

		// String locators

//		String fName = "#input-firstname";
//		String lName = "#input-lastname";
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys("cssselector", fName, "testing");
//		eleUtil.doSendKeys("cssselector", lName, "automation");

		// 6. linkText: only for links : for the text of the link
		// html dom: <a> -- link

//		driver.findElement(By.linkText("Login")).click();

//		By loginLink = By.linkText("Login");
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doClick(loginLink);

		// String locators

//		String linkText = "Login";
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doClick("linktext", linkText);

		// 7. partialLinkText: only for links : for the partial text of the link
//		driver.findElement(By.partialLinkText("Forgotten")).click(); // supply a portion of the text.
		//Forgotten username
		//Forgotten password				
		// be careful when using this locator as there could be other links with the same text
																		
		
//		By forgottenPwd = By.partialLinkText("Forgotten");
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doClick(forgottenPwd);
		
		// String locators
		
//		String linkText = "Forgotten";
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doClick("partiallinktext", linkText);
		
		//8. tagName:html tag: 
		
//		String header = driver.findElement(By.tagName("h1")).getText();
//		System.out.println(header);
		
//		By pageHeader = By.tagName("h1");
//		ElementUtil eleUtil = new ElementUtil(driver);
//		String header = eleUtil.doGetElementText(pageHeader);
//		System.out.println(header);
		
		// String locators
		
		String pageHeader = "h1";
		ElementUtil eleUtil = new ElementUtil(driver);
		String header = eleUtil.doGetElementText("tagname", pageHeader);
		System.out.println(header);
	}

}

//just for today we will capture the css by coping it. Later we will see how to create our own css
//All are locators. But the strategy, behavior, the definition is different
