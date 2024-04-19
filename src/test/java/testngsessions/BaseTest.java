package testngsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import seleniumsessions.BrowserException;

/* Day 57 - 27th March
 * testng_02_TestNG_features_BaseTest_Parameters_ParallelRun_TestngRunner_Verbose.mp4
 * part 2_3 */

public class BaseTest {	
	
	WebDriver driver;
	
	@Parameters({ "url", "browser", "headless" })
	@BeforeTest
	public void setupTest(String url, String browserName, String headless) { //3 holding params need to be maintained
	
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			
			ChromeOptions co = new ChromeOptions();
			if (Boolean.parseBoolean(headless)) {				
				co.addArguments("--headless");				
			}
			driver = new ChromeDriver(co);
			break;			
			
		case "firefox":
			FirefoxOptions fo = new FirefoxOptions();
			
			if (Boolean.parseBoolean(headless)) {
				fo.addArguments("--headless");
			}
			
			driver = new FirefoxDriver(fo);
			break;
			
		case "edge":
			EdgeOptions eo = new EdgeOptions();
			
			if (Boolean.parseBoolean(headless)) {
				eo.addArguments("--headless");
			}
			
			driver = new EdgeDriver(eo);
			break;

		default:
			System.out.println("Please pass the right browser");
			throw new BrowserException("browser not found");
		}		
				
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}	
	
	@AfterTest
	public void tearDown() {
		driver.quit();		
	}

}

// Exactly 1-1 mapping is given with url parameter from @Parameter to the method setupTest(String url) 
// if the condition is not satisfied co will be blank. Blank co doesn't have any impact