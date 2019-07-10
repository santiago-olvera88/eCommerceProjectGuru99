package eCommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerce.base.TestBase;

public class ItemsDescriptionPage extends TestBase{
	
	//PAGE FACTORY
	@FindBy(xpath = "//span[contains(text(),'$100.00')]")
	WebElement xperiaPrice;
	
	//INTIALIZATION
	public ItemsDescriptionPage() {
		PageFactory.initElements(driver, this);
	}
	
	//ACTIONS
	public String verifyXperiaPriceIP() {
		String priceXperiaIP = xperiaPrice.getText();
		return priceXperiaIP;
	}
	
	public boolean comparingPrices(String priceMP, String priceIP) {
		boolean matchedPrices = priceMP.equals(priceIP);
		return matchedPrices;
	}
}
