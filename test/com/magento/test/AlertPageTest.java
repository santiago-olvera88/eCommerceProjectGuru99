package com.magento.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import eCommerce.base.TestBase;
import eCommerce.pages.AlertPage;
import eCommerce.pages.HomePage;
import eCommerce.pages.MobilePage;
import eCommerce.util.TestUtil;

public class AlertPageTest extends TestBase{
	
	HomePage homePage;
	MobilePage mobilePage;
	AlertPage alertPage;
	TestUtil testUtil;
	static String parentWindowId = "";

	public AlertPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homePage = new HomePage();
		testUtil = new TestUtil();
		
		mobilePage = homePage.verifyMobileLink();
		alertPage = mobilePage.addingToCompare();
		
		Thread.sleep(2000);
		parentWindowId = testUtil.changeWindowsPopUp();
        		
	}
	
	@Test(priority = 1)
	public void validateItemsAlertPageTest() {
		boolean [] items = alertPage.validateItemsAlertPage();
				
		Assert.assertTrue(items[0],"Xperia was not found");
		Assert.assertTrue(items[1],"Iphone was not found");
	}
	

	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.close();//Close childWindow
		Thread.sleep(1000);
		
		//Change to parentWindow
		driver.switchTo().window(parentWindowId);
		Thread.sleep(1000);
		driver.quit();
	}

}
