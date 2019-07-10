package eCommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerce.base.TestBase;

public class TVPage extends TestBase{
	
	@FindBy(xpath = "//a[contains(@href,'http://live.guru99.com/index.php/wishlist/index/add/product/4/')]")
	WebElement wishLstLG;
	
	
	//INITIALIZATION
	public TVPage() {
		PageFactory.initElements(driver, this);
	}
	
	//ACTIONS
	public DashbooardPage verifyWishLstLGLink() {
		wishLstLG.click();
		
		return new DashbooardPage();
	}
	
}
