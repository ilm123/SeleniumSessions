package testngsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/* Day 56 - 26th March
 * testng_01_Annotations__SeleniumIntegration_BeforeTest_vs_BeforeClass.mp4
 * part 2 */

public class GoogleTest {
	WebDriver driver;

	@BeforeMethod
	public void setupTest() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test (priority = 1)
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test (priority = 3)
	public void imageTest() {
		driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
	}

	@Test (priority = 2)
	public void urlTest() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();		
	}

}

// priority is a pre defined variable and it is an integer