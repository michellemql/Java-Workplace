package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;	
import org.junit.Before;
import org.junit.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import pages.EbayLoginPage;
import pages.EbayHomePage;

public class TestEbayLogin {	

	WebDriver driver;
	EbayLoginPage objLogin;
	EbayHomePage objHomePage;
			
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/michellemql/Downloads/Tools/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com/");
	}
	
	@Test
	public TestEbayLogin() {
		objLogin = new EbayLoginPage(driver);
		// Verify login page title
		String loginPageTitle = objLogin.getLoginTitle();
		Assert.assertEquals("Hello", loginPageTitle);
		// Login to application
		objLogin.loginToEbay("test123", "mgr!23");
		// Go the next page
		objHomePage = new EbayHomePage(driver);
		// Verify home page
		String homePageUserName = objHomePage.getHomePageDashboardUserName();
		String homePageTitle = objLogin.getHomeTitle();
		Assert.assertEquals("test123", homePageUserName);
		Assert.assertEquals("https://www.ebay.com/", homePageTitle);
	}

}
