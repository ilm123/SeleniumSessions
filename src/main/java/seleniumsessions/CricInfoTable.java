package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Day 42 - 27th Feb
 * Selenium_12_XpathAxes_WebTableHandling_Parent_Child_Ancestor_Siblings.mp4
 * part 4 */

public class CricInfoTable {

	static WebDriver driver;
	
	public static void main(String[] args) {
		driver = new ChromeDriver();		
		driver.get("https://www.espncricinfo.com/series/women-s-premier-league-2023-24-1411373/delhi-capitals-women-vs-up-warriorz-women-4th-match-1417719/full-scorecard");
		
//		String wkt_takerName = 
//				driver.findElement(By.xpath("//span[text()='Dinesh Vrinda']/ancestor::td/following-sibling::td//span/span"))
//				.getText();
//		
//		System.out.println(wkt_takerName);
		
		System.out.println(getWicketTakerName("Dinesh Vrinda"));
		System.out.println(getWicketTakerName("Grace Harris"));
		System.out.println(getScoreCard("Dinesh Vrinda"));
		System.out.println(getScoreCard("Grace Harris"));
	}
	
	public static String getWicketTakerName(String batsmanName) {
		String wkt_takerName = 
				driver.findElement(By.xpath("//span[text()='"+batsmanName+"']/ancestor::td/following-sibling::td//span/span"))
				.getText();
		return wkt_takerName;
	}
	
	public static List<String> getScoreCard(String batsmanName) {
		List<WebElement> scoreEles = driver.
			findElements(By.xpath("//span[text()='"+batsmanName+"']/ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]"));
		List<String> scoreCardList = new ArrayList<String>();
		
		for (WebElement e:scoreEles) {
			String text = e.getText();
			
			scoreCardList.add(text);
		}
		
		return scoreCardList;
	}

}

//getText method will give the text of both parent and child. In this xpath the parent doesn't have any text