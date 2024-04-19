package testngsessions;

import org.testng.Assert;
import org.testng.annotations.Test;

/* Day 57 - 27th March
 * testng_02_TestNG_features_BaseTest_Parameters_ParallelRun_TestngRunner_Verbose.mp4
 * part 2_2 */

public class OrangeHRMTest extends BaseTest {	
	
		@Test (priority = 1)
		public void titleTest() {			
			String title = driver.getTitle();
			System.out.println(title);
			Assert.assertEquals(title, "30-Day Advanced Free Trial | OrangeHRM", "Title didn't match");
		}		

		@Test (priority = 2)
		public void urlTest() {
			String url = driver.getCurrentUrl();
			System.out.println(url);
			Assert.assertTrue(url.contains("30-day-free-trial"));
		}
}
