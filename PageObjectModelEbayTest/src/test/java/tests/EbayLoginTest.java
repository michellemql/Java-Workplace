package tests;

import org.testng.annotations.Test;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pages.EbayHomePage;
import pages.EbayLoginPage;

public class EbayLoginTest extends TestBase{
	
	WebDriver driver;

	EbayLoginPage objLogin;
	EbayHomePage objHomePage;
	
	@Test
	public EbayLoginTest() throws IOException {
		super.setup();
		objLogin = new EbayLoginPage(driver);
		// direct to login page
		super.clickLoginLink();
		
		// Verify login page title
		String loginPageTitle = objLogin.getLoginTitle();
		Assert.assertEquals("Hello", loginPageTitle);
		
		// Login to ebay
		objLogin.loginToEbay("test123", "mgr!23");
		
		// Verify if direct to home page
		objHomePage = new EbayHomePage(driver);
		String homePageUserName = objHomePage.getHomePageDashboardUserName();
		String homePageTitle = objHomePage.getHomeTitle();
		Assert.assertEquals("test123", homePageUserName);
		Assert.assertEquals("https://www.ebay.com/", homePageTitle);
	}

}
