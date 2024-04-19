package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Selenium_16_Actions_Scrolling_PageUpDown_ScrollElement_CanvasSignature_SendKeysWithPause_GetElementLocation_BackgroundColor_HeightWidth_WindowSize_Maximize_Minimize_FullScreen.mp4
// 1:18

public class HDFCBank {
// To open Chrome Dev Tools - CTRL+SHFT+C or F12
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		
		Thread.sleep(4000);
		
		By productTypeEle = By.xpath("//a[contains(@class,'dropdown-toggle') and (text()='Select Product Type')]");
		By productEle = By.xpath("//a[text()='Select Product']");
		
		
		
		getPersanalBankingService(productTypeEle, productEle, "Cards", "Credit Cards");		

	}
	
	public static WebElement getElement (By locator) {
		return driver.findElement(locator);
	}
	
	public static void getPersanalBankingService 
		(By parentLocator, By childLocator, String productType, String product) throws InterruptedException {
		getElement(parentLocator).click();
		
		List<WebElement> productTypeList = driver.findElements(By.cssSelector("ul.dropdown1.dropdown-menu > li"));
		
		for (WebElement e:productTypeList) {
			String text = e.getText();
			System.out.println(text);
			
			if (text.equals(productType)) {
				e.click();
				Thread.sleep(4000);					
				
				//2nd drop down
				getElement(childLocator).click();
				List<WebElement> productList = driver.findElements(By.cssSelector("ul.dropdown2.dropdown-menu > li"));
				
				for (WebElement childEle : productList) {
					String productText = childEle.getText();
					System.out.println(productText);
					if (productText.equals(product)) {
						childEle.click();
						break;
					}
				}

			}
			
		}
	}

}
