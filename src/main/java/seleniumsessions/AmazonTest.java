package seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) {
		
		String browserName = "chrome";
		BrowserUtil brUtil = new BrowserUtil();
		brUtil.launchBrowser(browserName);
		
		brUtil.launchURL("https://www.amazon.com");
		
		String actTitle = brUtil.getPageTitle();
		
		if (actTitle.contains("Amazon")) {
			System.out.println("Title -- pass");
		}
		else {
			System.out.println("Title -- fail");
		}
		
		String url = brUtil.getPageUrl();
		
		if (url.contains("amazon.com")) {
			System.out.println("URL -- pass");
		}
		else {
			System.out.println("URL -- fail");
		}
		
		brUtil.closeBrowser();

	}

}
