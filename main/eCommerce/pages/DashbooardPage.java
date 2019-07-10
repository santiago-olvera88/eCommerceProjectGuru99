package eCommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerce.base.TestBase;

public class DashbooardPage extends TestBase{
	
	
	@FindBy(xpath ="//img[@alt='Magento Commerce' and @class='large']")
	WebElement magentoLogo;
	
	@FindBy(xpath ="//a[contains(text(),'TV')]")
	WebElement tvLink;
	
	@FindBy(xpath = "//button[@name='save_and_share']")
	WebElement shareWishLstBtn;	

	@FindBy(id = "email_address")
	WebElement emailTxtArea;
	
	@FindBy(id = "message")
	WebElement messageArea;
	
	@FindBy(xpath = "//button[@title='Share Wishlist']")
	WebElement shareWishBtn;
	
	@FindBy(xpath = "//span[contains(.,'Your Wishlist has been shared')]")
	WebElement wishListShared;
	
	@FindBy(xpath = "//a[contains(.,'My Wishlist')]")
	WebElement myWishLstLink;
	
	@FindBy(xpath = "//button[@title='Add to Cart']")
	WebElement addBttn;
	
	@FindBy(xpath = "//td[contains(text(),'100007385')]")
	WebElement NoNewOrder;

	@FindBy(xpath = "//em[contains(text(),'Pending')]")
	WebElement orderStatus;
	
	@FindBy(xpath = "//a[contains(text(),'View Order')]")
	WebElement viewOrderLink;
	
	@FindBy(xpath = "//a[contains(text(),'Print Order')]")
	WebElement printOrderLink;
	
	//INITIALIZATION
	public DashbooardPage() {
		PageFactory.initElements(driver, this);
	}
	
	//ACTIONS
	public TVPage verifyTVLink() {
		tvLink.click();
		
		return new TVPage();
	}
	
	public boolean verifyshareWishLstBtn(String emailTxt, String messageA) throws InterruptedException {
		shareWishLstBtn.click();
		emailTxtArea.sendKeys(emailTxt);
		messageArea.sendKeys(messageA);
		shareWishBtn.click();
		Thread.sleep(2000);
		
		boolean flag = wishListShared.isDisplayed();
		System.out.println("1. >>>>>>>>>>>>>>>>" + flag);
		return flag;
	}
	
	public ShoppingCartPage addToCart() throws InterruptedException {

		driver.navigate().to("http://live.guru99.com/index.php/wishlist/");
		Thread.sleep(2000);
		addBttn.click();
		
		return new ShoppingCartPage();
	}
	
	public boolean[] pendingOrders() {
		boolean [] flagsOrders = new boolean [2];
		
		flagsOrders[0]= NoNewOrder.isDisplayed();
		flagsOrders[1]= orderStatus.isDisplayed();
		
		return flagsOrders;
	}
	
	public void printOrderAsPDF() {
		viewOrderLink.click();
		printOrderLink.click();
	}

}
