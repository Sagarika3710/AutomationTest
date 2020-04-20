package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase;

public class ProductCheckPage extends TestBase {
	
	@FindBy(xpath = "//span[contains(text(),\"Sony Alpha ILCE-6000Y/b in5 Mirrorless Camera Body with Dual Lens : 16-50 mm & 55-210 mm\")]")
	@CacheLookup
	WebElement productNameLabel;
	
	@FindBy(xpath = "//div[contains(text(),\"₹50,990\")]")
	WebElement productPrice;
	
	@FindBy(xpath = "//button[contains(.,'ADD TO CART')]")
	WebElement addToCartBtn;
	

	public ProductCheckPage() {
		PageFactory.initElements(driver, this);
	}
	
		
	public boolean verifyCorrectProducName(){
		return productNameLabel.isDisplayed();
		
	}
	
	public boolean verifyCorrectProductPrice(){
		return productPrice.isDisplayed();
	}
		public CheckOutPage cartAdd(){
		
			Actions actions = new Actions(driver);

			actions.moveToElement(addToCartBtn).build().perform();
			addToCartBtn.click();
		    			    	
		return new CheckOutPage();
	}
	

}
