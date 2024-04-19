
package seleniumsessions;

/* Day 42 - 27th Feb
 * Selenium_12_XpathAxes_WebTableHandling_Parent_Child_Ancestor_Siblings.mp4
 * part 2 */

public class XpathAxes {

	public static void main(String[] args) {

		// parent to direct child: /
		// form/div/input

		// ***https://naveenautomationlabs.com/opencart/index.php?route=account/login
		// parent to direct + indirect child: //
		// select[@id='Form_getForm_Country']//option
		// div[@id='content']//img

		// *** child to parent:-Backward traversing
		// input[@id='input-email']/../../../../../../../../../..
		// input[@id='input-email']/parent::div/parent::form

		// input[@id='input-email']/ancestor::form //jump from child to the grandparent
		// input[@id='input-email']/ancestor::form/ancestor::body/ancestor::html

		// a[text()='Recurring payments']/ancestor::aside

		// *** Single slash or double slash anything is ok
		// a[text()='Recurring payments']/preceding-sibling::a[text()='Downloads']
		// a[text()='Recurring payments']/following-sibling::a[text()='Returns']

		// input[@id='input-email']/preceding-sibling::label
		// label[text()='E-Mail Address']/following-sibling::input

		// ***https://selectorshub.com/xpath-practice-page/
		// ***Select the checkbox for Joe Root - starting point is always a tag
		// ***option 1: Go to my grand parent-tr. Go to the td below - 'td is my parent
		// and the td above is my uncle'
		// a[text()='Joe.Root']//ancestor::tr/td/input[@type='checkbox']

		// *** options 2: Go to my parent. Go to parent's preceding sibling
		// a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']

		// *** options 3: Go to my grand parent and directly go to the grandchild i.e
		// checkbox - the best one - shortest path
		// a[text()='Joe.Root']/ancestor::tr//input[@type='checkbox']

		// Selenium_13_webtableUtils_StaticWebTableHandling_CascadedClasses_InvalidSelectorException.mp4

		// child keyword
		// child::input[@type='checkbox']
	}

}

//"You cannot write super dynamic xpaths. If a new coloumn is introduced between the checkbox and the user id 
//then your script will need to be updated"