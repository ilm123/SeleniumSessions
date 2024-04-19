package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSPracticeIndex {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Indexes - Odd and Even
		driver.get("https://www.google.com/");
		driver.findElement(By.cssSelector("textarea[title='Search']")).sendKeys("Countries");
		Thread.sleep(2000);
		List<WebElement> oddElements = driver.findElements(By.cssSelector("ul[role='listbox'] li:nth-child(odd) div.wM6W7d > span"));
				
		for (WebElement e:oddElements) {
			String text = e.getText();
			
			System.out.println(text);
		}
		
		

	}

}
