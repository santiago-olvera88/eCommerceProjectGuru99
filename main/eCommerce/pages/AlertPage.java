package eCommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerce.base.TestBase;

public class AlertPage extends TestBase{
	
	//PAGE FACTORY
	@FindBy(xpath = "//a[contains(text(),'Sony Xperia')]")
	WebElement xperiaTxt;
	
	@FindBy(xpath = "//a[contains(text(),'IPhone')]")
	WebElement iphoneTxt;
	
	//INITIALIZATION
	public AlertPage() {
		PageFactory.initElements(driver, this);
	} 
	//ACTIONS
	
	public boolean[] validateItemsAlertPage() {
		boolean[] items = new boolean[2];
		
		items[0] = xperiaTxt.isDisplayed();
		items[1] = iphoneTxt.isDisplayed();
		
//		try {
//			if(xperiaTxt.isDisplayed()) {
//				items[0] = xperiaTxt.isDisplayed();
//			}
//			} catch (NoSuchElementException nsee) {
//				System.out.println("Xperia Element not found");			
//			}
//		
//		try {
//			if(iphoneTxt.isDisplayed()) {
//				items[1] = iphoneTxt.isDisplayed();
//			}
//			} catch (NoSuchElementException nsee) {
//				System.out.println("Iphone Element not found");			
//			}		
		
		return items;
	}


}
