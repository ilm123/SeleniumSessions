package testngsessions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/* Day 56 - 26th March
 * testng_01_Annotations__SeleniumIntegration_BeforeTest_vs_BeforeClass.mp4
 * part 4 */

public class InvocationCountTest {
	
	@BeforeTest
	public void createUser() {
		System.out.println("BT - Create User");
	}

	@Test (invocationCount=10, priority =2)
	public void createUserTest() {
		System.out.println("createUserTest");
	}
	
	@Test (priority =1 )
	public void paymentTest() {
		System.out.println("paymentTest");
	}
	
	@AfterTest 
	public void deleteUser() {
		System.out.println("AT - delete User");
	}
	
}

// Invoke means execute; Execution count
// In Selenium there is no use case for invocation count. It is a feature of testNg
// invocation count and priority cannot be give for the Before and After annotations
// Maybe in API performance test creating user back to back
// In real time we avoid using priority
