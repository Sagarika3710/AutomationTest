package com.flipkart.pages;

import com.flipkart.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[contains(text(),\"Sagarika\")]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(name = "q")
	WebElement inputItem;

	@FindBy(xpath = "//form[@action=\"/search\"]//button[@type=\"submit\"]")
	WebElement searchBtn;
	

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
		
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
		public ProductListPage itemSearch(String item){
		
			Actions actions = new Actions(driver);
			actions.moveToElement(inputItem).build().perform();
		inputItem.sendKeys(item);
		System.out.println(item);
		actions.moveToElement(searchBtn).build().perform();
		searchBtn.click();
		    			    	
		return new ProductListPage();
	}
	
}
	
	
	
	
	
	
	

