package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase;

public class ProductListPage extends TestBase {
	
	@FindBy(xpath = "//a[@title=\"Sony Alpha ILCE-6000Y/b in5 Mirrorless Camera Body with Dual Lens : 16-50 mm & 55-210 mm\"]")
	WebElement selectItem;
	

	public ProductListPage() {
		PageFactory.initElements(driver, this);
	}
public ProductCheckPage select() throws InterruptedException{
		
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(selectItem).build().perform();
		selectItem.click();
		    			    	
		return new ProductCheckPage();
	}
	
}
