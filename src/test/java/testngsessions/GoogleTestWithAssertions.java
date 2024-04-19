package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/* Day 57 - 27th March
 * testng_02_TestNG_features_BaseTest_Parameters_ParallelRun_TestngRunner_Verbose.mp4
 * part 1 */

public class GoogleTestWithAssertions extends BaseTest {

	@Test (priority = 1)
	public void titleTest() {		
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google", "Title didn't match");
	}

	@Test (priority = 2) @Ignore
	public void imageTest() {
		boolean flag = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		Assert.assertEquals(flag, true);
		Assert.assertTrue(flag);
	}

	@Test (priority = 3,enabled = false)
	public void urlTest() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("google"));
	}

}

// Assertions are used for the validation
// No need to call the parent class methods. It will automatically inherit
// why don't we get any error for driver?
// Bcz annotations are associated with the method
// Concept of 'Inheritance' - can access/inherit parent class properties

// to exclude a test use enabled = false. By default it is enabled = true
// can also apply @ignore
