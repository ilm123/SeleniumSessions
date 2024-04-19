package seleniumsessions;

import java.util.UUID;

public class StringUtil {
	
	private StringUtil() {}// Prevents unnecessary creation of the object - A private-blank constructor

	public static String getRandomEmail() {
		return "automation" + System.currentTimeMillis() + "@" + "opencart.com";
//		 return "automation"+UUID.randomUUID()+"@"+"opencart.com";
	}
}
