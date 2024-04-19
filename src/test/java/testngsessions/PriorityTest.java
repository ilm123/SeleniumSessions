package testngsessions;

import org.testng.annotations.Test;

/* Day 56 - 26th March
 * testng_01_Annotations__SeleniumIntegration_BeforeTest_vs_BeforeClass.mp4
 * part 3 */

public class PriorityTest {

	@Test (priority = 1)
	public void eTest() {
		System.out.println("e test");
	}	
	
	@Test (priority = 2)
	public void dTest() {
		System.out.println("d test");
	}	

	@Test (priority = 3)
	public void cTest() {
		System.out.println("c test");
	}
	
	@Test (priority = -1)
	public void aTest() {
		System.out.println("a test");
	}
	
	@Test 
	public void bTest() {
		System.out.println("b test");
	}
	
}

// if no priority is given then it will run in alphabetical order
// Default priority is 0
// can have negative priority
// duplicate priority - will start alphabetically
// if some methods don't have priority non priority test will run first on the basis of alphabetical order
// if you have a mix of positive priority, negative priority and no priority defined, then will run in the order of:
// negative, no priority (bcz default value is 0), positive priority