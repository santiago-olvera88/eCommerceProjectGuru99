package eCommerce.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import eCommerce.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Alert alert;
	
	public TestBase() {
		try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream("C:\\Users\\uidq3530\\eclipse-workspace\\"
									+"MagentoProject\\main\\com\\magento\\config\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}	
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
        if(browserName.equals("Chrome")) {            
            driver = new ChromeDriver();
        } else if(browserName.equals("Firefox")){            
            driver = new FirefoxDriver();
        }else if(browserName.equals("InternetExplorer")){
            driver = new InternetExplorerDriver();
        }
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);        
        driver.get(prop.getProperty("url"));

	}

}
