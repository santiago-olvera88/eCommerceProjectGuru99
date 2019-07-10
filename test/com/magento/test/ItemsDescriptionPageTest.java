package com.magento.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import eCommerce.base.TestBase;
import eCommerce.pages.HomePage;
import eCommerce.pages.ItemsDescriptionPage;
import eCommerce.pages.MobilePage;

public class ItemsDescriptionPageTest extends TestBase{
	
	HomePage homePage;
	MobilePage mobilePage;
	ItemsDescriptionPage itemsDescriptionPage;
	
	public ItemsDescriptionPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		
		homePage = new HomePage();
		mobilePage = homePage.verifyMobileLink();
	}
	
	@Test
	public void comparingPrices() {
		String priceMP = mobilePage.verifyXperiaPriceMP();
		itemsDescriptionPage = mobilePage.xperiaDescriptionLink();		
		String priceIP = itemsDescriptionPage.verifyXperiaPriceIP();
		
		Assert.assertEquals(priceMP, priceIP,"Prices not MATCHED");
	}
	

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
