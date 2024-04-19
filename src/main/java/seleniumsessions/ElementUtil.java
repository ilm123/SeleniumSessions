package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//SRP: Single Responsibility Principle
//OOP concept used - Encapsulation. Private driver accessed via public layer; Either via public constructor or via public methods
public class ElementUtil {

	private WebDriver driver; // It is not initialized. The current value of driver is the default value. The
								// default value of non primitive is always null.
	// Private keyword is used to prevent unnecessary access to the driver. The
	// problem with public - Anyone can create the object of this class and try to
	// access it. If there is no constructor it will start giving null unnecessarily

	private final String DEFAULT_ELEMENT_TIME_OUT_MESSAGE = "Time out... Element is not found...";
	private final String DEFAULT_ALERT_TIME_OUT_MESSAGE = "Time out... Alert is not found...";

	// Why are we applying a public constructor? The target/req. is to get the
	// driver where the session id is 123. Bcz to call the methods I have to
	// create the object of ElementUtil. When the object is created the constructor
	// will be called

	public ElementUtil(WebDriver driver) {// parameterized constructor. It is behaving like a setter.(covered in
											// Enacp.-constructor can be used to set the values)
		this.driver = driver; // class variable is equal to the local constructor variable
	}

	private void nullBlankCheck(String value) {
		if (value == null || value.length() == 0) {
			throw new MyElementException(value + "----value text cannot be null or blank"); // create the object of the
																							// class and throw the
																							// exception
		}
	}

	public By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "css":
			locator = By.cssSelector(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;
		case "tagname":
			locator = By.tagName(locatorValue);
			break;

		default:
			break;
		}
		return locator;
	}

	// static will not work in parallel mode. So all the selenium related utilities
	// are never created with the static keyword
	public WebElement getElement(By locator) {
		WebElement element = null; // for the time being

		try {
			element = driver.findElement(locator);
		} catch (NoSuchElementException e) {
			System.out.println("Element is not present on the page");
			e.printStackTrace();
			return null; // can avoid this line if you want
		}

		return element;
	}

	public WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}

	public void doSendKeys(By locator, String value) {
		nullBlankCheck(value);
		getElement(locator).sendKeys(value);
	}

	public void doSendKeys(By locator, String value, int timeOut) {
		nullBlankCheck(value);
		waitforElementVisible(locator, timeOut).sendKeys(value);
	}

	public void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(locatorType, locatorValue).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doClick(By locator, int timeOut) {
		waitforElementVisible(locator, timeOut).click();
	}

	public void doClick(String locatorType, String linkText) {
		getElement(locatorType, linkText).click();
	}

	public String doGetElementText(By locator) {
		return getElement(locator).getText();
	}

	public String doGetElementText(String locatorType, String locatorHeader) {
		return getElement(locatorType, locatorHeader).getText();
	}

	public String doElementGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean isElementExist(By locator) {
		if (getElements(locator).size() == 1) {
			return true;
		}
		return false;
	}

	public boolean multipleElementExist(By locator) {// to be tested
		if (getElements(locator).size() > 0) {
			return true;
		}
		return false;
	}

	public boolean multipleElementExist(By locator, int elementCount) {// to be tested
		if (getElements(locator).size() == elementCount) {
			return true;
		}
		return false;
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public ArrayList<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleTextList = new ArrayList<String>(); // pc=0

		for (WebElement e : eleList) {
			String text = e.getText();

			if (text.length() != 0) {
				eleTextList.add(text);
			}
		}

		return eleTextList;
	}

	public ArrayList<String> getElementAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleAttrList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String attrValue = e.getAttribute(attrName);

			if (attrValue.length() != 0) {
				eleAttrList.add(attrValue);
			}

		}

		return eleAttrList;
	}

	// ***********************Select based Drop Down utils*********************************//

	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectByVisibileText(By locator, String visibleText) {
		nullBlankCheck(visibleText);
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);

	}

	public void doSelectByValue(By locator, String value) {
		nullBlankCheck(value);
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public List<WebElement> getDropDownOptionsList(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions();
	}

	public List<String> getDropDownOptionsText(By locator) {
		List<WebElement> optionList = getDropDownOptionsList(locator);
		List<String> optionsTextList = new ArrayList<String>();

		for (WebElement e : optionList) {
			String optionsText = e.getText();
			optionsTextList.add(optionsText);
		}

		return optionsTextList;
	}

	public int getDropDownValuesCount(By locator) {
		return getDropDownOptionsList(locator).size();
	}

	public void doSelectDropDownValue(By locator, String value) {
		nullBlankCheck(value);
		List<WebElement> optionList = getDropDownOptionsList(locator);

		for (WebElement e : optionList) {
			String text = e.getText();
			System.out.println(text);

			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	public void printSelectDropDownValue(By locator) {

		List<WebElement> optionList = getDropDownOptionsList(locator);

		for (WebElement e : optionList) {
			String text = e.getText();
			System.out.println(text);
		}
	}

	/*
	 * // without select class, select the drop down value
	 */
	public void doSelectValueDropDown(By locator, String value) {
		List<WebElement> optionList = getDropDownOptionsList(locator);
		for (WebElement e : optionList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
			}
		}
	}

	public void doSearch(By searchLocator, String searchKey, By searchSuggestions, String value)
			throws InterruptedException {
		doSendKeys(searchLocator, searchKey);
		Thread.sleep(3000);
		List<WebElement> suggList = getElements(searchSuggestions);

		System.out.println(suggList.size());

		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(value)) {
				e.click();
				break;
			}

		}
	}

	// ************************** Actions Utils *******************************//

	public void handleMenuSubMenuLevel2(By parentMenuLocator, By subMenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).perform();
		Thread.sleep(1500);
		doClick(subMenuLocator);
	}

	public void handleMenuSubMenuLevel4(By level1Menu, By level2Menu, By level3Menu, By level4Menu)
			throws InterruptedException {
		Actions act = new Actions(driver);
		doClick(level1Menu);
		Thread.sleep(1500);
		act.moveToElement(getElement(level2Menu)).perform();
		Thread.sleep(1500);
		act.moveToElement(getElement(level3Menu)).perform();
		Thread.sleep(1500);
		doClick(level4Menu);
	}

	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}

	/**
	 * @author Ilma Thaha
	 */
	public void doSendKeysWithPause(By locator, String value) {

		Actions act = new Actions(driver);
		char[] charArray = value.toCharArray();

		for (char val : charArray) {
			act.sendKeys(getElement(locator), String.valueOf(val)).pause(500).build().perform();
		}
	}

	// ************************** Wait Utils *******************************//

	/**
	 * An expectation for checking an element is visible and enabled such that you
	 * can click it.
	 * 
	 * @param locator
	 * @param timeOut
	 */
	public void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitforElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut)); // long can hold int. Concept of
																						// widening. can write long
																						// instead of int
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that there is at least one element present on a
	 * web page.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForElementsPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public List<WebElement> waitForElementsPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.withMessage(DEFAULT_ELEMENT_TIME_OUT_MESSAGE);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that isgreater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitforElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitforElementVisible(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that all elements present on the web page that
	 * match the locator are visible. Visibility means that the elements are not
	 * only displayed but also have a height and width that is greater than 0.
	 */
	public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public String waitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
				return driver.getTitle();
			}
		} catch (Exception e) {
			System.out.println("Title was not found within: " + timeOut + " seconds");
		}
		return null;
	}

	public String waitForTitleIs(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.titleIs(title))) {
				return driver.getTitle();
			}
		} catch (Exception e) {
			System.out.println("Title was not found within: " + timeOut + " seconds");
		}
		return null;
	}

	public String waitForURLContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
				return driver.getCurrentUrl();
			}
		} catch (Exception e) {
			System.out.println("Url was not found within: " + timeOut + " seconds");
		}
		return null;
	}

	public String waitForUrlToBe(String Url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.urlToBe(Url))) {
				return driver.getCurrentUrl();
			}
		} catch (Exception e) {
			System.out.println("Url was not found within: " + timeOut + " seconds");
		}
		return null;
	}

	public Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public Alert waitForJSAlertWithFluentWait(int timeOut, int pollingTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoAlertPresentException.class)
				.withMessage(DEFAULT_ALERT_TIME_OUT_MESSAGE);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public String getAlertText(int timeOut) {
		return waitForJSAlert(timeOut).getText();
	}

	public void acceptAlert(int timeOut) {
		waitForJSAlert(timeOut).accept();
	}

	public void dismissAlert(int timeOut) {
		waitForJSAlert(timeOut).dismiss();
	}

	public void alertSendKeys(int timeOut, String value) {
		waitForJSAlert(timeOut).sendKeys(value);
	}
	
	/**
	 * 
	 * @author Ilma Thaha
	 */
	public boolean isPageLoaded(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		String flag = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"))
				.toString();
		return Boolean.parseBoolean(flag);
	
	}

	public boolean waitFoWindow(int totalNomberOfWindowsToBe, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.numberOfWindowsToBe(totalNomberOfWindowsToBe));
	}

	public void waitForFrameAndSwitchToIt(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public void waitForFrameAndSwitchToIt(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public void waitForFrameAndSwitchToIt(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	//****Custom Wait****
	
	public WebElement retryingElement(By locator, int numberOfAttempts) {

		WebElement element = null;
		int count = 1;

		while (count <= numberOfAttempts) {

			try {
				element = getElement(locator);
				System.out.println("Element" + locator + "was found in attempt no. " + count);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element was not found in attempt no." + count);
				TimeUtil.minTime();
			}
			count++;
		}

		if (element == null) {
			System.out.println("Element was not found in " + numberOfAttempts + " attempts"+" with an interval time of 500 milliseconds");			
			throw new MyElementException("No Such Element");
		}		
		return element;
	}
	
	public WebElement retryingElement(By locator, int numberOfAttempts, int intervalTime) {

		WebElement element = null;
		int count = 1;

		while (count <= numberOfAttempts) {

			try {
				element = getElement(locator);
				System.out.println("Element" + locator + "was found in attempt no. " + count);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element was not found in attempt no." + count);
				TimeUtil.applyWait(intervalTime); //Giving my own interval time
			}
			count++;
		}

		if (element == null) {
			System.out.println("Element was not found in " + numberOfAttempts + " attempts"+" with an interval time of " +intervalTime+ " seconds");			
			throw new MyElementException("No Such Element");
		}		
		return element;
	}
	
}
