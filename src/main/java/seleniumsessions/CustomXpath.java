package seleniumsessions;

import org.openqa.selenium.By;

/* Day 41 - 26th Feb
 * Selenium_11_CustomXpath_XpathFunctions_text()_Contains_StartsWith_Index_Position.mp4
 * part 1 */

public class CustomXpath {

	public static void main(String[] args) {
		// Xpath: address of the element in the DOM
		// XMLPath
		// 1. absolute xpath - inspect and copy
		// html/body/div[2]/div/div/div[3]/div[2]/div/div/div[2]/h4/a
//		Very risky. If a another div is introduced then the xpath will change

		// 2. relative xpath(custom xpath)

		// 1. using single attr:
		// tagname[@attrname = 'value']
		// input[@id = 'input-email']
		// input[@name='email']

		// input[@name] --5
		// input[@value='Login'] --1

		// 2. using multiple attrs:
		// tagname[@attr1='value' and @attr2='value' and @attr3='value']
		// input[@type='submit' and @value='Login' ] --- 1

		// input[@type='submit'] -- 3
		// input[@type='text' or @type='email' ]
		// input[@type and @value='Login']
		// input[@type and @value]
		// a[@href] ---81 - returns all the links available. Use findElements method

		// 3. text(): - text is written as a function
		// tagname[text()='value']
		// h2[text()='New Customer']
		// a[text()='Desktops']

		// 4. text() and attributes: can be written in any order/sequence
		// tagname[@attr='value' and text()='value']
		// a[@class='dropdown-toggle' and text()='Desktops']
		// a[@class='dropdown-toggle' and text()='Desktops' and @data-toggle='dropdown']
		// a[text()='Desktops' and @class='dropdown-toggle' and @data-toggle='dropdown']

		// 5. contains() with attr:
		// tagname[contains(@arrName, 'value')]
		// input[contains(@placeholder, 'E-Mail')]
		// input[contains(@placeholder, 'Address')]

		// tagname[contains(@arrName1, 'value') and @attr2='value']
		// input[contains(@placeholder, 'Address') and @name='email']
		// input[contains(@placeholder, 'Address') and @name='email' and
		// contains(@id,'email')]
		// a[contains(@href,'wishlist')]

		// dynamic ids:
		// <input id=firstname_123 />
		// <input id=firstname_345 />
		// <input id=firstname_900 />
		// <input id=firstname_987 />

		// input[contains(@id,'firstname_')]

		// 6. contains() with text():
		// tagname[contains(text(), 'value')]
		// p[contains(text(), 'Customer service, IT, and CRM software')]
		// a[contains(text(), 'Customer')]

		// 7. contains() with text() and attr:
		// tagname[contains(text(),'value') and contains(@attr,'value')]
		// a[contains(text(),'Notebooks') and contains(@href,'category&path')]

		// tagname[contains(text(),'value') and contains(@attr1,'value') and
		// @attr2='value']

		// 8. starts-with(): 
		// tagname[starts-with(@attr, 'value')]
		// input[starts-with(@placeholder, 'E-Mail')]

		// 9. starts-with() with text():
		// tagname[starts-with(text(),'value')]
		// a[starts-with(text(),'Forgotten')]

		// dynamic ids:
		// <input id=firstname_123_login />
		// <input id=456_firstname_login />
		// EXT JS

		// input[contains(@id,'firstname_') and contains(@id,'_login')]

		// 10. ends-with() is not supported in xpath

		// 11. index based xpath: - better to avoid but capture group works with only
		// index
		// (//a[text()='Forgotten Password'])[1] - Store it in a capture group and then apply the index
		// (//a[@class='list-group-item'])[13]
		// (//input[@class='form-control'])[6]
		// (//input[@class='form-control'])[position()=4]
		// (//input[@class='form-control'])[4]
		// (//input[@class='form-control'])[last()] //There is no 'first' keyword

		// amazon.com
		// ((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()]

		// ((//div[@class='navFooterLinkCol
		// navAccessibility'])[last()]//a)[last()-last()+1]

		By fgt_pwd = By.xpath("(//a[text()='Forgotten Password'])[1]");
		
		// Selenium_14_CustomCSS_Selectors_MoreFeatures_XpathVsCSS.mp4 
		// 12. normalize-space() https://naveenautomationlabs.com/opencart/index.php?route=account/register
		// This is only for text because spaces appear with text
		//label[normalize-space()='Yes']

		

		/*
		 * Day 42 - 27th Feb
		 * Selenium_12_XpathAxes_WebTableHandling_Parent_Child_Ancestor_Siblings.mp4
		 * part 1
		 */

		// Generally avoid the * - * means consider everything
		// https://naveenautomationlabs.com/opencart/
		// * - "Give me all the elements in the DOM"
		// *[@id] - "Give me all the elements where id is available"
		// *[@class='form-control'] -- 100 ---> 6
		// input[@class='form-control'] -- 20 ---> 6
		// *[@href]
		// ------
		// Difference between //* and //.
		// https://www.orangehrm.com/30-day-free-trial/
		// select[@id='Form_getForm_Country']//* - will give all the child elements
		// under the particular parent
		// select[@id='Form_getForm_Country']//. - will give hidden elements - generally
		// not used

	}

}
