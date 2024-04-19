package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSPractice {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/inventory.html");
		
		// id
		// #id
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		// tagname#id
		driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");		

		// class:
		// .class
		driver.findElement(By.cssSelector(".submit-button")).click();
		
		// tagname.class
		System.out.println(driver.findElement(By.cssSelector("div.app_logo")).getText());
		Thread.sleep(2000);

		// class + id
		// .class#id
		driver.findElement(By.cssSelector(".btn_inventory#add-to-cart-sauce-labs-backpack")).click(); //add to cart
		Thread.sleep(2000);
		
		// #id.class
		driver.findElement(By.cssSelector("#remove-sauce-labs-backpack.btn_small")).click();//remove from cart
		
		// .c1.c2.c3....cn
		List<WebElement> listToAdd = driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
		
		for (WebElement e:listToAdd) {			
			e.click();
			Thread.sleep(1000);
		}
		// tagname.c1.c2.c3....cn
		List<WebElement> listToRemove = driver.findElements(By.cssSelector("button.btn.btn_secondary.btn_small.btn_inventory"));
		
		for (WebElement e:listToRemove) {
			e.click();
			Thread.sleep(1000);
		}
		
		// tagname.c1.c2.c3....cn#id
		driver.findElement(By.cssSelector("button.btn.btn_primary.btn_small.btn_inventory#add-to-cart-sauce-labs-bike-light")).click();
		Thread.sleep(1000);//bike light
		
		// tagname.c1.#id.c2.c3....cn
		driver.findElement(By.cssSelector("button.btn.btn_primary.btn_small#add-to-cart-sauce-labs-onesie.btn_inventory")).click();
		Thread.sleep(1000); // onesie
		
		// css with attributes:
		// tagname[attr='value'] - css
		driver.findElement(By.cssSelector("button[id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
		Thread.sleep(1000); // test all thing tshirt-red
		
		driver.findElement(By.cssSelector
		("button[id='add-to-cart-sauce-labs-backpack'][name='add-to-cart-sauce-labs-backpack'][data-test='add-to-cart-sauce-labs-backpack']"))
		.click();
		Thread.sleep(1000);//backpack
		
		driver.findElement(By.cssSelector
		("button#add-to-cart-sauce-labs-bolt-t-shirt[data-test='add-to-cart-sauce-labs-bolt-t-shirt'][name='add-to-cart-sauce-labs-bolt-t-shirt']"))
		.click();//bolt tshirt

		//contains
		System.out.println(driver.findElement(By.cssSelector("a[href*='facebook']")).getTagName());
		
		//starts with
		driver.findElement(By.cssSelector("select[data-test^='product']")).click();
		
		//ends with
		driver.findElement(By.cssSelector("a[class$='ink']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("[alt='Go back']")).click();
		
		//Just for logging out
		driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
		driver.findElement(By.cssSelector("#logout_sidebar_link")).click();
		

		// parent to child:
		int directChildEle = driver.findElements(By.cssSelector("form > div")).size();  //---> direct child -- 3
		System.out.println("Login - direct divs: " + directChildEle);
		
		int allEle = driver.findElements(By.cssSelector("div[class='login_wrapper-inner'] div")).size(); // ---> direct + indirect child -- 5
		System.out.println("Login - direct and indirect divs: " + allEle);
		
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");		
		driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");		
		driver.findElement(By.cssSelector(".submit-button")).click();
		
		driver.findElement(By.cssSelector("select[data-test^='product']")).click();
		int directOptions = driver.findElements(By.cssSelector("select[data-test^='product'] > option")).size();  //---> direct child -- 3
		System.out.println("drop down direct options: " + directOptions); // 4		

		// sibling in css:
		// immediate following sibling
		driver.findElement(By.cssSelector("option[value='az']+option[value='za']")).click();
		
		// all following sibling
		int siblingEle = driver.findElements(By.cssSelector("option[value='az']~option")).size();
		System.out.println("No of siblings in drop down: " + siblingEle);		

		// comma in css:
		
		//checking that 2 elements are present

				int mand_fields_count = 
							driver.findElements(By.cssSelector
				(".bm-burger-button button[style='position: absolute; left: 0px; top: 0px; z-index: 1; width: 100%; height: "
				+ "100%; margin: 0px; padding: 0px; border: none; font-size: 0px; background: transparent; cursor: pointer;'],"
				+ "a[class$='link']")).size();
				
				if(mand_fields_count == 2) {
					System.out.println("Burger Menu and the shopping cart link are present on the page");
				}

		// 'not' in css:
		// excludes twitter field
				List<WebElement> socialMediaList = driver.findElements(By.cssSelector(".social > li:not([class$='twitter'])"));
				for (WebElement e :socialMediaList) {
					System.out.println(e.getText());
				}	
		
		

		// index in css: starts from 1
		// select#Form_getForm_Country > option:nth-of-type(6)
		// select#Form_getForm_Country > option:nth-of-type(n) -- all

//				select#Form_getForm_Country > option:first-child
//				select#Form_getForm_Country > option:last-child
//				select#Form_getForm_Country > option:nth-child(4)
//				select#Form_getForm_Country > option:nth-last-child(2)//from the last give the 2nd last
//				select#Form_getForm_Country > option:nth-child(even)
//				select#Form_getForm_Country > option:nth-child(odd)
//				select#Form_getForm_Country > option:nth-of-type(n+4) //starts from the 4th index
//				select#Form_getForm_Country > option:nth-of-type(5n) //starts at index 5 and jumps to 10,15, etc.Increments by 5

		// odd and even in xpath:
		// (//select[@id='Form_getForm_Country']/option)[position() mod 2 = 1] -- odd
		// (//select[@id='Form_getForm_Country']/option)[position() mod 2 = !0] -- odd

		// (//select[@id='Form_getForm_Country']/option)[position() mod 2 = 0] -- even
		// (//select[@id='Form_getForm_Country']/option)[position() mod 2 != 1] -- even

		// cascaded classes in css:
		// tagname.c1.c2.c3....cn
//		driver.findElement(By.cssSelector("input.form-control.private-form__control.login-email"));

	}

}
