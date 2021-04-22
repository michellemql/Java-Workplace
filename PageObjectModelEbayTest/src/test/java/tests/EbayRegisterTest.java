package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import org.junit.Assert;
import pages.EbayHomePage;
import pages.EbayRegisterPage;

public class EbayRegisterTest extends TestBase {
	
	WebDriver driver;
	EbayRegisterPage objRegister;
	EbayHomePage objHomePage;
	
	@Test
	public EbayRegisterTest() throws IOException {
		super.setup();
		objRegister = new EbayRegisterPage(driver);
		// Direct to registration page
		super.clickRegisterLink();
		
		//verify register page title
		String registerPageTitle = objRegister.getRegisterTitle();
		Assert.assertEquals("Create an account", registerPageTitle);
		
		// Register to ebay
		objRegister.registerToEbay("user1", "user1", "user1@gmail.com", "User1@ebay");
		objHomePage = new EbayHomePage(driver);
		
		// Verify if direct to home page
		String homePageUserName = objHomePage.getHomePageDashboardUserName();
		String homePageTitle = objHomePage.getHomeTitle();
		Assert.assertEquals("user1", homePageUserName);
		Assert.assertEquals("https://www.ebay.com/", homePageTitle); 
	}

}
