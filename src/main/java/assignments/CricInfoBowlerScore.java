package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricInfoBowlerScore{

	//Selenium_12_XpathAxes_WebTableHandling_Parent_Child_Ancestor_Siblings.mp4
	// 1:16:54
	// Selenium_15_Actions_MoveToElement_MenuSubMenu_RightClick_DragDrop_Click_SendKeys.mp4
	// 1:36
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		// Print Bower Score card
		
		driver = new ChromeDriver();		

		driver.get("https://www.espncricinfo.com/series/durham-tour-of-zimbabwe-2023-24-1422048/zimbabwe-a-vs-durham-2nd-match-1422073/full-scorecard");
//		List<WebElement> bowerScList = driver.findElements(By.xpath("(//span[text()='Victor Nyauchi'])[1]/ancestor::td/following-sibling::td[not(contains(@class,'ds-hidden'))]"));
//		
//		for (WebElement e:bowerScList) {
//			String text = e.getText();
//			System.out.println(text);
//		}
		
		getBowlderScoreCard("Victor Nyauchi");

	}	
	
	public static void getBowlderScoreCard(String bowler) {
		
		List<WebElement> bowerScList = driver.findElements(By.xpath("(//span[text()='"+bowler+"'])[1]/ancestor::td/following-sibling::td[not(contains(@class,'ds-hidden'))]"));
		
		for (WebElement e:bowerScList) {
			String text = e.getText();
			System.out.println(text);
		}
	}

}
