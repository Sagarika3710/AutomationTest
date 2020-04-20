package com.flipkart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.ProductCheckPage;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.ProductListPage;
import com.flipkart.util.TestUtil;

public class ProductSelectTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ProductListPage productListPage;
	ProductCheckPage productCheckPage;

	public ProductSelectTest() {
		super();
	}

		
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
	   	loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		productListPage = homePage.itemSearch(prop.getProperty("inputItem"));
		productCheckPage = new ProductCheckPage();
	}
	
	
	@Test(priority=1)
	public void selectItemTest() throws InterruptedException {
	   productCheckPage=productListPage.select();		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	 

}
