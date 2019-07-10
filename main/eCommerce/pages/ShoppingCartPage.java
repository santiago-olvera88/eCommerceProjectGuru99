package eCommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import eCommerce.base.TestBase;

public class ShoppingCartPage extends TestBase{

	//PAGE FACTORY
	@FindBy(xpath = "//input[@class='input-text qty']")
	WebElement qtyInput;
	
	@FindBy(xpath = "//button[@class='button btn-update']")
	WebElement updayeBtn;
	
	@FindBy(xpath ="//span[contains(.,'Some of the products cannot be ordered in requested quantity.')]")
	WebElement ErrorMgs;
	
	@FindBy(xpath ="//button[@class='button2 btn-empty']")
	WebElement emtyCartBtn;
	
	@FindBy(xpath ="//h1[contains(.,'Shopping Cart is Empty')]")
	WebElement msgEmptyCart;
	
	@FindBy(xpath ="//span[contains(@class,'count')]")
	WebElement numEmptyCart;
	
	@FindBy(xpath = "//button[@title='Proceed to Checkout']")
	WebElement checkoutBttn;
	
	//INITIALIZATION
	public ShoppingCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	//ACTIONS
	public boolean errorMessage(String numItems) {
		qtyInput.sendKeys(numItems);
		updayeBtn.click();
		return ErrorMgs.isDisplayed();
	}
	
	public void emptyCart() {
		//System.out.println(">>>>>>>> Before Empty: " + numEmptyCart.getText());
		emtyCartBtn.click();
		//System.out.println(">>>>>>>> After Empty" + numEmptyCart.getText());
	}
	
	public String[] flatRateShipping() throws InterruptedException {
		String [] arr1 = new String[5];
		checkoutBttn.click();
		
		Select state = new Select(driver.findElement(By.id("billing:region_id")));
		state.selectByVisibleText("New York");
		
		Select country = new Select(driver.findElement(By.name("billing[country_id]")));
		country.selectByVisibleText("United States");
		
		driver.findElement(By.name("billing[postcode]")).sendKeys("542896");
		driver.findElement(By.name("billing[street][]")).sendKeys("ABC");
		driver.findElement(By.name("billing[city]")).sendKeys("New Yorw");
		driver.findElement(By.name("billing[telephone]")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@title='Continue']")).click();
		Thread.sleep(1000);
		
		boolean flatRatePrice = driver.findElement(By.xpath("//span[contains(.,'$5.00')]")).isDisplayed();//Price Flat Rate
		arr1[0] = Boolean.toString(flatRatePrice);
		
		driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']")).click();
		driver.findElement(By.id("p_method_checkmo")).click();
		driver.findElement(By.xpath("//button[@type='button' and @onclick='payment.save()']")).click();
		arr1[1] = driver.findElement(By.xpath("//*[@id='checkout-review-table']/tfoot/tr[1]/td[2]/span")).getText();//Subtotal
		arr1[2] = driver.findElement(By.xpath("//*[@id='checkout-review-table']/tfoot/tr[2]/td[2]/span")).getText();//Flat Rate
		arr1[3] = driver.findElement(By.xpath("//*[@id='checkout-review-table']/tfoot/tr[3]/td[2]/strong/span")).getText();//Grand Total
		
		driver.findElement(By.xpath("//button[@class='button btn-checkout']")).click();
		
		boolean orderPlaced = driver.findElement(By.xpath("//h1[contains(.,'Your order has been received.')]")).isDisplayed();//Order Placed
		arr1[4] = Boolean.toString(orderPlaced);
		
		return arr1;

	}
}
