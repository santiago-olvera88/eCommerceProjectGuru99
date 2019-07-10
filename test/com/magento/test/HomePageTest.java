package com.magento.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import eCommerce.base.TestBase;
import eCommerce.pages.HomePage;
import eCommerce.pages.MobilePage;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	MobilePage mobilePage;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}

	
	@Test
	public void titlePageTest() {
		Assert.assertEquals(homePage.titlePage(),"THIS IS DEMO SITE","Title not matched");
	}
	
	@Test
	public void verifyMobileLinkTest() {
		mobilePage = homePage.verifyMobileLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
