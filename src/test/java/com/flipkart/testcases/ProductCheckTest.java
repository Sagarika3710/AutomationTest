package com.flipkart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.CheckOutPage;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.ProductCheckPage;
import com.flipkart.pages.ProductListPage;
import com.flipkart.util.TestUtil;

public class ProductCheckTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ProductListPage productListPage;
	ProductCheckPage productcheck;
	CheckOutPage checkout;
	

	public ProductCheckTest() {
		super();
	}

		
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
	   	loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		productListPage = homePage.itemSearch(prop.getProperty("inputItem"));
		productcheck = productListPage.select(); 
        checkout= new CheckOutPage();
		
	}
	
	
	@Test(priority=1)
	public void verifyProductTest(){
		Assert.assertTrue(productcheck.verifyCorrectProducName());
		Assert.assertTrue(productcheck.verifyCorrectProductPrice());
		
	}
	
	@Test(priority=2)
	public void AddtoCartTest() {
		
		checkout= productcheck.cartAdd();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	


}
