package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.junit.Assert;

import pages.EbayHomePage;

public class HomePageTest extends TestBase{
	
	WebDriver driver;
	EbayHomePage homePage;
	 
	
	@Test 
	public void HomePageTest() throws IOException {
		homePage = new EbayHomePage(driver);
		super.setup();
	}
	
	@Test
	public void testHomeTitle() {
		String homeTitle = homePage.getHomeTitle();
		Assert.assertEquals("https://www.ebay.com/", homeTitle);
	}
	
	@Test
	public void testSaved() {
		super.clickLink("Saved");
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.ebay.com/feed");
		driver.navigate().back();
	}
	
	@Test
	public void testNavigationBar() {
		super.mouseHover("Motor");
		super.mouseHover("Fashion");
		super.mouseHover("Electronics");
		super.mouseHover("Collectibles & Art");
		super.mouseHover("Home & Garden");
		super.mouseHover("Sporting Goods");
		super.mouseHover("Toys");
		super.mouseHover("Business & Industrial");
		super.mouseHover("Music");
		super.mouseHover("Deals");
	}
	
	@Test
	public void testDailyDeal() throws InterruptedException {
		super.scrollDown("//*[@id=\"items_list1\"]/div[1]/div/div[1]/h2/a");
		super.clickLink("Today's Deals – All With Free Shipping ");
		String text = super.getText("//*[@id=\"refit-spf-container\"]/div[2]/div[2]/div[1]/h2/span");
		Assert.assertEquals("Spotlight Deal", text);
		driver.navigate().back();
	}
 	
	@Test
	public void testSearch() {
		String item = "iPhone";
		String option1 = "All Categories";
		String option2 = "All Deals";
		
		//Search item in All Categories
		super.sendKeys("gh-ac", item);
		super.dropDownSelect("//*[@id=\"gh-cat\"]", option1);
		super.clickButton("gh-btn");
		String itemText1 = super.getText("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/a/h3");
		Assert.assertTrue(itemText1.contains(item));
		driver.navigate().back();
		
		//Search item in All Deals
		super.sendKeys("gh-ac", item);
		super.dropDownSelect("//*[@id=\"gh-cat\"]", option2);
		super.clickButton("gh-btn");
		String itemText2 = super.getText("//*[@id=\"spokeResultSet\"]/div[1]/div/div[1]/div/div[1]/a/h3/span/span");
		Assert.assertTrue(itemText2.contains(item));
		driver.navigate().back();
	}
	
	@Test
	public void testSignIn() {
		super.clickLink("Sign in");
		String userName = super.getText("//*[@id=\"gh-ug\"]/b");
		if (userName != null) {
			String welcome = super.getTextId("welcome-msg");
			Assert.assertEquals("Welcome", welcome);
		} else {
			String hello = super.getTextId("greeting-msg");
			Assert.assertEquals("Hello", hello);
		}
		driver.navigate().back();
	}
	
	@Test
	public void testAdvancedSearch() {
		super.clickLink("Advanced");
		String URL = driver.getCurrentUrl();
		Assert.assertEquals("https://www.ebay.com/sch/ebayadvsearch", URL);
		driver.navigate().back();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
