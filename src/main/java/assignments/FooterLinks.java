package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		List <WebElement> footer = driver.findElements(By.className("list-unstyled"));
		
		for (WebElement e:footer) {
			String linkText = e.getText();
			System.out.println(linkText);
		}
	}

}
