package eCommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerce.base.TestBase;

public class Login extends TestBase{
	
	
	//Page factory
	@FindBy(name = "login[username]")
	WebElement userFld;
	
	@FindBy(name = "login[password]")
	WebElement passFld;

	@FindBy(name = "send")
	WebElement loginBttn;
	
	//INITIALIZATION
	public Login() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public DashbooardPage login(String user, String psw){
		userFld.sendKeys(user);
		passFld.sendKeys(psw);
		loginBttn.click();
		
		return new DashbooardPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
