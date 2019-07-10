package eCommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerce.base.TestBase;

public class RegisterPage extends TestBase{
	
	//PAGE FACTORY
	@FindBy(id = "firstname")
	WebElement firstNameBx;
	
	@FindBy(id ="middlename")
	WebElement middleNameBx;
	
	@FindBy(id ="lastname")
	WebElement lastNameBx;
	
	@FindBy(id ="email_address")
	WebElement emailBx;
	
	@FindBy(name ="password")
	WebElement passBx;
	
	@FindBy(name ="confirmation")
	WebElement confirmPassBx;
	
	@FindBy(xpath ="//button[@title='Register']")
	WebElement registerBtn;

	//INITIALIZATION
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	//ACTIONS
	
	public DashbooardPage registering(String fstName, String mdName, String ltName, String email,String password) {
		firstNameBx.sendKeys(fstName);
		middleNameBx.sendKeys(mdName);
		lastNameBx.sendKeys(ltName);
		emailBx.sendKeys(email);
		passBx.sendKeys(password);
		confirmPassBx.sendKeys(password);
		registerBtn.click();

		return new DashbooardPage();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	


}
