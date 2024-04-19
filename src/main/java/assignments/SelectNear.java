package assignments;
//!!not working
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SelectNear {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		Thread.sleep(3000);
	
		WebElement countryDropDown = driver.findElement(By.id("Form_getForm_Country"));
		
		Select dropDownEle = new Select(countryDropDown);	
		dropDownEle.selectByValue("Albania");
		
		WebElement countryEle = driver.findElement(By.xpath("//option[@value ='Albania']"));
		
		String nearestEle = driver.findElement(with(By.tagName("option")).below(countryEle)).getText();
		System.out.println(nearestEle);

	}

}
