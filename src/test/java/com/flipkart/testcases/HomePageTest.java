package com.flipkart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.ProductListPage;
import com.flipkart.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ProductListPage productListPage;

	public HomePageTest() {
		super();
	}

		
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		productListPage = new ProductListPage();
	}
	
	
	@Test(priority=1)
	public void verifyUserNameTest(){
		Assert.assertTrue(homePage.verifyCorrectUserName());
		
	}
	
	@Test(priority=2)
	public void searchResultTest() {
		
		productListPage=homePage.itemSearch(prop.getProperty("inputItem"));
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	


}
