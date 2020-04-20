package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),\"Enter Email/Mobile number\")]")
	WebElement username;
	
	@FindBy(xpath="//input[@type=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//button//span[contains(text(),\"Login\")]")
	WebElement loginBtn;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
		
	public HomePage login(String un, String pwd) throws InterruptedException{
		Actions actions = new Actions(driver);
		actions.moveToElement(username);
		actions.click();
		actions.sendKeys(un);
		actions.build().perform();
		
		//username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		Thread.sleep(6000);
		    	//JavascriptExecutor js = (JavascriptExecutor)driver;
		    	//js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();

}
}