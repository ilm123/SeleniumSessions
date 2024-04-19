package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//* Selenium_10_MultiSelectionDropDown_GoogleSearchUtil_JqueryDropDown_MultiSelection.mp4
//**ToDo
public class GrowwSearchSuggestionsWithUtility {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://groww.in/");

		driver.findElement(By.id("globalSearch23")).sendKeys("HDFC");
		Thread.sleep(3000);
		
//		driver.findElement(By.linkText("More results")).click();

		List<WebElement> eleList = driver.findElements(By.xpath("//div[@class='gsc23SuggestionText']"));
		
			//	"//div[@id='globalSearch23-suggestionsContainer']//div[@class='gsc23SuggestionText']"));
				
		System.out.println(eleList.size());
		
		for (WebElement e:eleList) {
			String text = e.getText();			
			System.out.println(text);
			if (text.contains("HDFC Life Insurance Company Ltd.")) {
				e.click();
				break;
			}
		}

	}

}
