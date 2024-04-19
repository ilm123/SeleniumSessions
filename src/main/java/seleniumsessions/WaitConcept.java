package seleniumsessions;

/* Day 52 - 18th March
 * Selenium_22_ImplicitlyWait_Vs_ExplicitlyWait_WebDriverWait.mp4
 * part 1 */

public class WaitConcept {

	public static void main(String[] args) {
		
		//script ----sync--> app(slow, server slowness, network)
		
		//sync: wait
		//1. static wait: JAVA Thread.sleep(10000): 10 secs: 2 secs
		//2. dynamic wait : 10 secs: 2secs: 8 secs will be cancelled
				
		//2.a: Implicitly Wait: global wait for all the webelements
		//2.b: Explicitly Wait: for a specific web element
			//i: WebDriverWait (C)
			//ii: FluentWait (C)
				

		//Wait(I) : until(); --> FluentWait(C): until(){} + other methods --> WebDriverWait (C)

	}

}


// We need a wait concept to sync between the application and the code
// It is a wrong understanding to say that there are 3 types - 
// Implicitly Wait, Explicitly Wait, FluentWait

// FluentWait is a kind of Explicitly wait
