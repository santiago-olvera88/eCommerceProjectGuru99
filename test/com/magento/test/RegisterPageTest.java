package com.magento.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import eCommerce.base.TestBase;
import eCommerce.pages.DashbooardPage;
import eCommerce.pages.HomePage;
import eCommerce.pages.RegisterPage;

public class RegisterPageTest extends TestBase{
	
	HomePage homePage;
	RegisterPage registerPage;
	DashbooardPage dashbooardPage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homePage =  new HomePage();
		registerPage = homePage.registerLink();

	}
	
	@Test(priority = 1)
	public void registeringTest() {
		dashbooardPage = registerPage.registering("Cristiano2", "P", "penaldo", "SSaadsrer@hotmail.com", "pasddso123");
	}

	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}	

}
