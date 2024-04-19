package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.vtiger.com/");
		driver.findElement(By.xpath("//input[@name='email' and @id='registrationEmail']")).sendKeys("test@test.com"); //2
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//input[@id='get_started_terms']")).sendKeys("abc@abc.com");
		
		By loginBtnEle = By.xpath("//button[@type='submit' and text()='Get Started with Vtiger']");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		act.scrollToElement(driver.findElement(loginBtnEle)).click(driver.findElement(loginBtnEle)).build().perform();
		
				
//		act.click(driver.findElement(loginBtnEle)).perform();
		
			
//		driver.findElement(By.xpath("//button[@type='submit' and text()='Get Started with Vtiger']")).click(); //2	s
//		driver.navigate().back();

	}

}
