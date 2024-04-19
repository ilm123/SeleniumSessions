package seleniumsessions;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

/* Day 43 - 28th Feb
 * Selenium_13_webtableUtils_StaticWebTableHandling_CascadedClasses_InvalidSelectorException.mp4
 * part 2_1 */

public class StaticWebTable {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		System.out.println("Total rows: " + (rowCount - 1));
//		int dataRows = getRowCount();
//		System.out.println("Total rows: " + dataRows);

		String beforeXpath = "//*[@id=\"customers\"]/tbody/tr["; // *star can be replaced with table tag
		String afterXpath = "]/td[1]";
		ArrayList<String> companyList = getCompanyDataForLoopApproach(beforeXpath, afterXpath);
		System.out.println("Companies: " + companyList);

	
		String beforeContactXpath = "//*[@id=\"customers\"]/tbody/tr[";
		String afterContactXpath = "]/td[2]";
	
		String beforeCountryXpath = "//*[@id=\"customers\"]/tbody/tr[";
		String afterCountryXpath = "]/td[3]";

		System.out.println(getCompleteDataListForLoop(beforeXpath, afterXpath, beforeContactXpath, afterContactXpath,
				beforeCountryXpath, afterCountryXpath));

	}

	public static int getRowCount() {
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		return rowCount - 1;
	}

	public static ArrayList<String> getCompanyDataForLoopApproach(String beforeXpath, String afterXpath) {
		// Study the xpath pattern by using the absolute xpath.
		// Then break it into two
		// for-each loop will not help here. So use index based for loop

		ArrayList<String> companyList = new ArrayList<String>();
		for (int row = 2; row <= getRowCount(); row++) {
			String companyXpath = beforeXpath + row + afterXpath;
			String text = driver.findElement(By.xpath(companyXpath)).getText();
			// System.out.println(text);
			companyList.add(text);
		}

		return companyList;
	}

	public static ArrayList<String> getCompleteDataListForLoop(String beforeXpath, String afterXpath,
			String beforeContactXpath, String afterContactXpath, String beforeCountryXpath, String afterCountryXpath) {

		ArrayList<String> completeDataList = new ArrayList<String>();

		for (int row = 2; row <= getRowCount(); row++) {
			String companyXpath = beforeXpath + row + afterXpath;
			String contactXpath = beforeContactXpath + row + afterContactXpath;
			String countryXpath = beforeCountryXpath + row + afterCountryXpath;

			String companyText = driver.findElement(By.xpath(companyXpath)).getText();
			String contactText = driver.findElement(By.xpath(contactXpath)).getText();
			String countryText = driver.findElement(By.xpath(countryXpath)).getText();

			Arrays.asList(companyText, contactText, countryText);

		}

		return completeDataList;
	}

}
