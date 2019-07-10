package com.magento.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import eCommerce.base.TestBase;
import eCommerce.pages.DashbooardPage;
import eCommerce.pages.HomePage;
import eCommerce.pages.Login;
import eCommerce.pages.MobilePage;
import eCommerce.pages.RegisterPage;
import eCommerce.pages.ShoppingCartPage;

public class ShoppingCartPageTest extends TestBase{
	
	HomePage homePage;
	MobilePage mobilePage;
	ShoppingCartPage shoppingCartPage;
	RegisterPage registerPage;
	Login login;
	DashbooardPage dashbooardPage;
		
	public ShoppingCartPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage =  new HomePage();
		
	}
	
	@Test(priority = 1)
	public void errorMessageTest() {
		mobilePage = homePage.verifyMobileLink();
		shoppingCartPage = mobilePage.addToCarXperia();
		
		Assert.assertTrue(shoppingCartPage.errorMessage("000"),"Message quantity exceeded  was not displayed");
	}
	
	@Test(priority = 2)
	public void emptyCartTest() {
		mobilePage = homePage.verifyMobileLink();
		shoppingCartPage = mobilePage.addToCarXperia();
		
		shoppingCartPage.errorMessage("000");
		shoppingCartPage.emptyCart();
	}
	
	@Test(priority = 3)
	public void flatRateShippingTest() throws InterruptedException {
		login = homePage.loginLnk();
		dashbooardPage = login.login("SSaadsrer@hotmail.com", "pasddso123");
		shoppingCartPage = dashbooardPage.addToCart();
		String [] toValidate = shoppingCartPage.flatRateShipping();
		
		for(String s:toValidate) {
			System.out.println(s);
		}

		//For printing array
		//System.out.println(Arrays.toString(toValidate)); 
						
		String subTotal =   toValidate[1].replace("$", "");//Subtotal
		String flatRate =   toValidate[2].replace("$", "");//Flat Rate
		String grandTotal = toValidate[3].replace("$", "");//Grand Total
		
		float subTotalFlt = Float.parseFloat(subTotal);
		float flatRateFlt = Float.parseFloat(flatRate);
		float grandTotalFlt = Float.parseFloat(grandTotal);
		
		System.out.println(subTotalFlt);
		System.out.println(flatRateFlt);
		System.out.println(grandTotalFlt);
		
		Assert.assertEquals(toValidate[0], "true","Flate rate of $5.00 not displayed");//Price Flat Rate
		Assert.assertEquals(toValidate[4], "true","Order NOT placed");//Order Placed
		Assert.assertEquals(subTotalFlt + flatRateFlt, grandTotalFlt,"Sum of totals does not match");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}


}
