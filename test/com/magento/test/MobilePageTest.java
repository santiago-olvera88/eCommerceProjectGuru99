package com.magento.test;

import java.util.ArrayList;
import java.util.Collections;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import eCommerce.base.TestBase;
import eCommerce.pages.HomePage;
import eCommerce.pages.MobilePage;

public class MobilePageTest extends TestBase{
	
	HomePage homePage;
	MobilePage mobilePage;
	
	public MobilePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		mobilePage = new MobilePage();
		homePage.verifyMobileLink();
	}
	
	@Test(priority = 1)
	public void pageTitleTest() {
		Assert.assertEquals(mobilePage.pageTitle(), "Mobile","Title not matched on Mobile Page");
	}
	
	@Test (priority = 2)
	public void checkOrderByNameTest() throws InterruptedException {
		
		ArrayList<String> origialList =  mobilePage.checkOrderByName("Name");
		ArrayList<String> sortedList =  new ArrayList<>();
				
		//Copying arrayList; from origialList to sortedList
		for(String sl:origialList){
			sortedList.add(sl);
			}
		/* For sorting descending
		   Collections.reverse(sortedList); */
		
		//Sorting Ascending
		Collections.sort(sortedList);
								
		Assert.assertTrue(sortedList.equals(origialList),"Lists are no equals");
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
