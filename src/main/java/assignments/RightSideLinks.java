package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Selenium_07_FindElements_TotalLinks_Images_Inputs_GetElementsUtil_GetEleText_AttributesListUtils.mp4

public class RightSideLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		// Links from Login upto Newsletter

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		 List<WebElement> links =
		 driver.findElements(By.className("list-group-item"));
//		By locator = By.className("list-group-item");
//		getElement(locator); 
//		
		for (WebElement e : links) {
			String linkText = e.getText();
			System.out.println(linkText);
		}

	}

}
