package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/* Day 57 - 27th March
 * testng_02_TestNG_features_BaseTest_Parameters_ParallelRun_TestngRunner_Verbose.mp4
 * part 2_1 */

public class OpenCartLoginTest extends BaseTest {	

	@Test (priority = 1)
	public void titleTest() {		
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Account Login", "Title didn't match");
	}

	@Test (priority = 2)
	public void imageTest() {
		boolean flag = driver.findElement(By.cssSelector(".img-responsive")).isDisplayed();
		Assert.assertEquals(flag, true);
		Assert.assertTrue(flag);
	}

	@Test (priority = 3)
	public void urlTest() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("account/login"));
	}	

}
