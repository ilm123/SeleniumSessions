package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 43 - 28th Feb
 * Selenium_13_webtableUtils_StaticWebTableHandling_CascadedClasses_InvalidSelectorException.mp4
 * part 1 */

public class WebTableTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("Apiautomation");
		driver.findElement(By.name("password")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Thread.sleep(4000);
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		
		// Since there are two 'Joe Root' it will pick the first one
		selectContact("An Jacob");
		
		String compName = getCompanyName("An Jacob");
		System.out.println(compName);
		
		String phoneNo = getPhoneNumber("An Jacob");
		System.out.println(phoneNo);
		
		List<String> contactsInfoList = getContactsInfoList("An Jacob");
		System.out.println(contactsInfoList);

	}

	public static void selectContact(String contactName) {
		// driver.findElement(By.xpath("//a[text()='"+contactName+"']/parent::td/preceding-sibling::td/input[@name='contact_id']")).click();
		String xpath = "//a[text()='" + contactName
				+ "']/parent::td/preceding-sibling::td/child::input[@type='checkbox']";
		driver.findElement(By.xpath(xpath)).click();
	}

	public static String getCompanyName(String contactName) {
		// dont use company name bcz that is what we need to fetch
		String xpath = "//a[text()='" + contactName
				+ "']/parent::td/following-sibling::td/child::a[@context='company']";
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public static String getPhoneNumber(String contactName) {
		String xpath = "//a[text()='" + contactName
				+ "']/parent::td/following-sibling::td/child::span[@context='phone']";
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public static List<String> getContactsInfoList(String contactName) {
		
		List <String> contactInfoList = new ArrayList<String>();
		
		String xpathCompName = "//a[text()='" + contactName+ "']/parent::td/following-sibling::td/child::a[@context='company']";
		String xpathPhone = "//a[text()='" + contactName+ "']/parent::td/following-sibling::td/child::span[@context='phone']";
		String xpathEmail = "//a[text()='" + contactName+ "']/parent::td/following-sibling::td/child::a[contains(@href, 'mailto')]";
		
		String compName = driver.findElement(By.xpath(xpathCompName)).getText();
		String email = driver.findElement(By.xpath(xpathEmail)).getText();
		
		contactInfoList.add(compName);
		contactInfoList.add(email);
		
		List<WebElement> phoneEles = driver.findElements(By.xpath(xpathPhone));
		
		for(WebElement e:phoneEles) {
			String phone = e.getText();
			contactInfoList.add(phone);
		}
		
		return contactInfoList;
		
	}

}

// When ever the link text in the DOM is different from that on the page, use the text visible on the page.
// Hence use CONTACTS and not Contacts. But... it will give .NoSuchElementException
// Contact is available inside the frame. 
// Driver is inside the html. Driver has to be moved into the frame part - driver.switchTo().frame("mainpanel");
// Create the data and use it in your scenario. Don't rely on already created data. If there are two contacts
// with the same name, use indexing to pick the second one. 
//a[text()='Josh Buttler'])[2]/parent::td/preceding-sibling::td/child::input
