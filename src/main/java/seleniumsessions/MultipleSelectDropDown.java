package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

/* Day 40 - 22nd Feb
 * Selenium_10_MultiSelectionDropDown_GoogleSearchUtil_JqueryDropDown_MultiSelection.mp4
 * part 1 */

public class MultipleSelectDropDown {

	public static void main(String[] args) {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(co);

		driver.get("https://html.com/attributes/select-multiple/");

		WebElement eleDropDown = driver.findElement(By.xpath("//select[@multiple]"));
		Select select = new Select(eleDropDown);
		System.out.println(select.isMultiple());// true

		if (select.isMultiple()) {
			System.out.println("multi select is possible");
			select.selectByVisibleText("American flamingo");
			select.selectByVisibleText("Chilean flamingo");
			select.selectByVisibleText("James's flamingo");
		}
		
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		
		for(WebElement e:allSelectedOptions) {
			String text = e.getText();
			System.out.println(text);
		}
		
		select.deselectByVisibleText("Chilean flamingo");
		select.deselectAll();

	}

}

