package eCommerce.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import eCommerce.base.TestBase;

public class MobilePage extends TestBase{
	
	//PAGE FACTORY
	@FindBy(xpath = "//select[@title='Sort By']")
	WebElement sortBySelect;
	
	@FindBy(xpath = "//a[contains(text(),'Sony Xperia')]")
	WebElement xperiaLink;
	
	@FindBy(xpath = "//span[contains(text(),'$100.00')]")
	WebElement xperiaPrice;
	
	@FindBy(xpath = "//button[contains(@onclick,'http://live.guru99.com/index.php/checkout/"
					+"cart/add/uenc/aHR0cDovL2xpdmUuZ3VydTk5LmNvbS9pbmRleC5waHAvbW9iaWxlLmh0bWw,/product/1/')]")
	WebElement xperiaAddToCart;
	
	@FindBy(xpath = "//a[contains(@href,'http://live.guru99.com/index.php/catalog/product_compare/add/product/1/')]")
	WebElement xperiaCompareLink;
	
	@FindBy(xpath = "//a[contains(@href,'http://live.guru99.com/index.php/catalog/product_compare/add/product/2/')]")
	WebElement iphoneCompareLink;
	
	@FindBy(xpath ="//button[@title='Compare']")
	WebElement compareBtn;
	
	
	//INITIALIZATION
	public MobilePage() {
		PageFactory.initElements(driver, this);
	}
	//ACTIONS
	public String pageTitle() {
		return driver.getTitle();
	}
	
	public ArrayList<String> checkOrderByName(String orderBy) {
		Select select = new Select(sortBySelect);
		select.selectByVisibleText(orderBy);
		
		ArrayList<String> obteinedList = new ArrayList<>();
		List <WebElement> elementList = driver.findElements(By.xpath("//a[contains(@href,'http://live.guru99.com/index.php/mobile/')]"));
		
		//Passing text form WebElments to ArrayList<String> obteinedNamesList
		for (WebElement nl:elementList){
			obteinedList.add(nl.getText());
			}		
		
		obteinedList.removeAll(Arrays.asList(null,""));
		
		return obteinedList;

	}
	
	public String verifyXperiaPriceMP() {
		String priceXperiaMP = xperiaPrice.getText();
		return priceXperiaMP;
	}
	
	public ItemsDescriptionPage xperiaDescriptionLink() {
		xperiaLink.click();
		return new ItemsDescriptionPage();
	}
	
	public ShoppingCartPage addToCarXperia() {
		xperiaAddToCart.click();
		return new ShoppingCartPage();
	}
	
	public AlertPage addingToCompare() {
		xperiaCompareLink.click();
		iphoneCompareLink.click();
		compareBtn.click();
		
		return new AlertPage();
	}

}
