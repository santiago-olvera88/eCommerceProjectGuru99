package eCommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerce.base.TestBase;

public class HomePage extends TestBase{
	
	//PAGE FACTORY
	@FindBy(xpath = "//img[@src='http://live.guru99.com/skin/frontend/rwd/default/images/logo.gif']")
	WebElement magentoLogo;
	
	@FindBy(xpath ="//a[contains(text(),'Mobile')]")
	WebElement mobileLink;
	
	@FindBy(xpath ="//a[contains(text(),'TV')]")
	WebElement tvLink;
	
	@FindBy(xpath ="//a[@class='skip-link skip-account']")
	WebElement accountLnk;
	
	@FindBy(linkText ="Register")
	WebElement registertLnk;
	
	@FindBy(xpath = "//a[contains(text(),'Log In')]")
	WebElement logInLnk;
	
	//INITIALIZATION
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//ACTIONS
	public String titlePage() {
		return driver.getTitle();
	}
	
	public MobilePage verifyMobileLink() {
		mobileLink.click();
		
		return new MobilePage();
	}
	
	public RegisterPage registerLink() throws InterruptedException {
		accountLnk.click();
		Thread.sleep(1000);
		registertLnk.click();
		
		return new RegisterPage();
	}
	
	public Login loginLnk() throws InterruptedException {
		accountLnk.click();
		Thread.sleep(1000);
		logInLnk.click();
		
		return new Login();
	}

}
