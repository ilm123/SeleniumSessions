package assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Selenium_12_XpathAxes_WebTableHandling_Parent_Child_Ancestor_Siblings.mp4

public class CricInfoAxes {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/australia-in-new-zealand-2023-24-1388188/new-zealand-vs-australia-1st-test-1388226/full-scorecard");
		// System.out.print(getWicketTakerName("Usman Khawaja"));
		System.out.println(getScoreCard("Marnus Labuschagne"));
	}

	public static String getWicketTakerName(String batsmanName) {
		return driver
				.findElement(
						By.xpath("//span[text()='" + batsmanName + "']/ancestor::td/following-sibling::td//span/span"))
				.getText();

	}

	public static List<String> getScoreCard(String batsName) {
		List<WebElement> scroreList = driver.findElements(By.xpath(
				"//span[text()='Australia']//following-sibling::span[text()='1st Innings']/ancestor::div[contains(@class,'ds-justify-center')]/../following-sibling::div//span[text()='"
						+ batsName + "']/ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]"));
		List<String> scorecardList = new ArrayList<String>();
		for (WebElement e : scroreList) {
			String text = e.getText();
			scorecardList.add(text);
		}
		return scorecardList;
	}

}
