package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/* Day 56 - 26th March
 * testng_01_Annotations__SeleniumIntegration_BeforeTest_vs_BeforeClass.mp4
 * part 1 */

public class OpenCartTest {

//	BS - DB Connection
//	BT - Create User
//	BC - Launch Browser
	
//	BM - Login to the App
//	Header test
//	AM - logout
	
//	BM - Login to the App
//	Title test
//	AM - logout
	
//	BM - Login to the App
//	Url test
//	AM - logout
	
//	AC - close browser
//	AT - delete User		
//	AS - Disconnect With DB
	
	
	//before ---- test -- after

	// before annotations:
	//1.
	// before annotations:
	@BeforeSuite
	public void dbConnection() {
		System.out.println("BS - DB Connection");
	}
	
	//2
	@BeforeTest
	public void createUser() {
		System.out.println("BT - Create User");
	}
	
	//3
	@BeforeClass
	public void LaunchBrowser() {
		System.out.println("BC - Launch Browser");
	}
	
	//4. //7 //10
	@BeforeMethod
	public void login() {
		System.out.println("BM - Login to the App");
	}
	
	//8
	@Test
	public void titleTest() {
		System.out.println("Title test");
	}
	
	//5.
	@Test
	public void headerTest() {
		System.out.println("Header test");
	}
	
	//11.
	@Test
	public void urlTest() {
		System.out.println("Url test");
	}
	
	//after annotations:
	//6. //9. //12
	@AfterMethod
	public void logout() {
		System.out.println("AM - logout");
	}
	
	//13
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC - close browser");
	}
	
	//14
	@AfterTest
	public void deleteUser() {
		System.out.println("AT - delete User");
	}
	
	//15
	@AfterSuite
	public void disconnectWithDB() {
		System.out.println("AS - Disconnect With DB");
	}
}

// class name should be post fixed with 'Test' - OpenCartTest
// methods under @Test should be post fixed with 'Test' - urlTest 
// There are 3 test cases - the count of @Test

// Methods will run in the sequence of:
// Before Suite, Before Test, Before Class. But it is not mandatory to write it in this order. But better to write in the order
// Before Suite, Before Test, Before Class will run only once . They are like global to global pre-conditions
// Before Method will run before each and every test. Same with After Method
// @Test will run in alphabetical order
// It is not mandatory to write all the pre condition annotations. It is a feature that allows to divide your pre-conditions
// in multiple annotations

// What is the difference between Before Suite and Before Test?
// Only difference is that Before Suite will run first