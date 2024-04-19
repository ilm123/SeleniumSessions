package assignments;
//!! Error
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

 //* Selenium_11_CustomXpath_XpathFunctions_text()_Contains_StartsWith_Index_Position.mp4


public class CustomXpathPractice {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.vtiger.com/");
		driver.manage().window().maximize();

		// 1. using single attr:
		// tagname[@attrname = 'value']
		driver.findElement(By.xpath("//span[@id='loginspan']")).click();
		driver.navigate().back();		
		Thread.sleep(2000);

		// 2. using multiple attrs:
		// tagname[@attr1='value' and @attr2='value' and @attr3='value']
		driver.findElement(By.xpath("//input[@name='email' and @id='registrationEmail']")).sendKeys("test@test.com"); //2
		Thread.sleep(2000);
		
		// 3. text(): - text is written as a function
		// tagname[text()='value']
		String str = driver.findElement(By.xpath("//strong[text()='Adaptable']")).getText();
		System.out.println(str);

		// 4. text() and attributes: can be written in any order/sequence
		// tagname[@attr='value' and text()='value']
		driver.findElement(By.xpath("//input[@name='email' and @id='registrationEmail']")).sendKeys("test@test.com"); //2
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//input[@id='get_started_terms']")).sendKeys("abc@abc.com");
		
		By loginBtnEle = By.xpath("//button[@type='submit' and text()='Get Started with Vtiger']");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		act.scrollToElement(driver.findElement(loginBtnEle)).click(driver.findElement(loginBtnEle)).build().perform();
		driver.navigate().back();		
		
		// 5. contains() with attr:
		// tagname[contains(@arrName, 'value')]
		driver.findElement(By.xpath("//a[contains(@href, 'begin-free-trial') and @id='nav_button_main']")).click();
		driver.navigate().back();
		Thread.sleep(2000);

		// 6. contains() with text():
		// tagname[contains(text(), 'value')]
		String work = driver.findElement(By.xpath("//strong[contains(text(), 'from where you' )]")).getText();
		System.out.println(work);

		// 7. contains() with text() and attr:
		// tagname[contains(text(),'value') and contains(@attr,'value')]
		driver.findElement(By.xpath("//a[contains(text(), 'Kickstart') and contains(@class, 'display-6')]")).click();
		driver.navigate().back();
		
		// 8. starts-with():
		// tagname[starts-with(@attr, 'value')]
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Your work') and @id='get_started_terms']")).sendKeys("auto@auto.com");

		// 9. starts-with() with text():
		// tagname[starts-with(text(),'value')]
		driver.findElement(By.xpath("//span[starts-with(text(), 'Contact')]")).click();
		
		driver.navigate().back();

		// 10. ends-with() is not supported in xpath

		// 11. index based xpath: - better to avoid but capture group works with only index
		driver.findElement(By.xpath("(//input[@id='registrationEmail'])[1]")).sendKeys("abcd");
		
		driver.findElement(By.xpath("((//a[@class='display-6 text-reset'])[8]")).click();
		driver.navigate().back();
		
		driver.findElement(By.xpath("(//a[@class='display-6 text-reset'])[position()=16]")).click();
		driver.navigate().back();
		
		driver.findElement(By.xpath("(//a[@class='display-6 text-reset'])[last()]")).click();
		driver.navigate().back();
		
		driver.findElement(By.xpath("(//a[@class='display-6 text-reset'])[last()-1]")).click();
		driver.navigate().back();
		
		driver.findElement(By.xpath("(//a[@class='display-6 text-reset'])[last()-5]")).click();
		driver.navigate().back();

		driver.findElement(By.xpath("((//div[@class='col-6 col-md-2 col-lg-2'])[last()]//a)[last()]")).click(); //Open Source vs Cloud
		driver.navigate().back();
		
		driver.findElement(By.xpath("(((//div[@class='col-6 col-md-2 col-lg-2'])[last()])//a)[last()-last()+1]")).click(); //Download
		driver.navigate().back();
		
		driver.findElement(By.xpath("((//div[@class='col-6 col-md-2 col-lg-2'])[last()-1]//a)[last()]")).click(); //Free CRM Tools
		driver.navigate().back();
		
		//SVG Element
		driver.findElement(By.xpath("(//*[local-name()='svg' and @class='icon icon-arrow-right mt-1 ml-3 h1'])[2]")).click();
	}

}
