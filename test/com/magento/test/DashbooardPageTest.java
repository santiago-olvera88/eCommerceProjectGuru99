package com.magento.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import eCommerce.base.TestBase;
import eCommerce.pages.DashbooardPage;
import eCommerce.pages.HomePage;
import eCommerce.pages.Login;
import eCommerce.pages.RegisterPage;
import eCommerce.pages.TVPage;


public class DashbooardPageTest extends TestBase{
	
	DashbooardPage dashbooardPage;
	HomePage homePage;
	RegisterPage registerPage;
	TVPage tvPage;
	Login login;


	public DashbooardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homePage = new HomePage();
				
	}
	
	@Test()
	public void verifyshareWishLstBtnTest() throws InterruptedException{
		registerPage = homePage.registerLink();
		dashbooardPage = registerPage.registering("Cristiano3", "Ronaldo", "penaldo", "zzzz554558@hotmail.com", "penalito123");
		tvPage = dashbooardPage.verifyTVLink();
		dashbooardPage = tvPage.verifyWishLstLGLink();
		
		boolean flag = dashbooardPage.verifyshareWishLstBtn("coapan_17@hromail.com", "The best TV in the WORLD");	
		Assert.assertTrue(flag,"WishList not shared correctly");
	}
	
	@Test()
	public void pendingOrdersTest() throws InterruptedException {
		login = homePage.loginLnk();
		dashbooardPage = login.login("SSaadsrer@hotmail.com", "pasddso123");
		boolean [] flagsOrders = dashbooardPage.pendingOrders();
		
		Assert.assertTrue(flagsOrders[0],"No order found");
		Assert.assertTrue(flagsOrders[1],"'pending' is not present");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
