package eCommerce.util;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import eCommerce.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIME_OUT = 20;
	public static long IMPLICIT_WAIT = 5;

	
    public void scrollPageDown(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    
    public String changeWindowsPopUp() throws InterruptedException {
    	
    	Set<String> handler = driver.getWindowHandles();
        Iterator<String> it = handler.iterator();
        
        String parentWindowId = it.next();        
        String childWindowId = it.next();
        
        driver.switchTo().window(childWindowId);        
        Thread.sleep(1000);
        
        return parentWindowId;
    }

    
	
}
