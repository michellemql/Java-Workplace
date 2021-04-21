package test;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;


public class TestEbayLoginDraft {
	WebDriver driver = new ChromeDriver();
	By ebayUserName = By.name("userid");
	By ebayPassword = By.name("");
	By titleText = By.className(null);
	By loginBtn = By.name("signin-continue-btn");
	
	public TestEbayLoginDraft(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		driver.manage().window().maximize();
	}
	
	public void loginUser(String newUserName) {
		driver.findElement(ebayUserName).sendKeys(newUserName);
		driver.findElement(loginBtn).click();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void signUpUser(String fName, String lName, String email, String password) {
		driver.findElement(By.id("create-account-link")).click();
		String expected = "Create an account";
		String actual = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/h1")).getText();
		Assert.assertEquals(expected, actual);
		driver.findElement(By.name("firstname")).sendKeys(fName);
		driver.findElement(By.name("lastname")).sendKeys(lName);
		driver.findElement(By.name("Email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("EMAIL_REG_FORM_SUBMIT")).click();
		// direct to home page (WebElement element)
		getHomeUrl(driver.findElement(By.id("gh-la")));
		
		
		// direct to contact page
		String contactText = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/h2")).getText();
		Assert.assertTrue(contactText.toLowerCase().contains("Provide your contact info"));
		// - Select country from the dropdown
		Select drpCountry = new Select(driver.findElement(By.name("countryId")));
		drpCountry.selectByVisibleText("United States");
		driver.findElement(By.name("addressSugg")).sendKeys("555 John Muir Dr");
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		 // - Select the address from auto-suggested results
        List<WebElement> elements = driver.findElements(By.id("addressSugg_suggList"));
        elements.get(0).click();
        // - enter phone number
        driver.findElement(By.name("phoneFlagComp1")).sendKeys("2064540722");
		driver.findElement(By.id("sbtBtn")).click();
		
		Assert.assertTrue(contactText.toLowerCase().contains("Provide your contact info"));
	}
	
	public void getHomeUrl(WebElement element) {
		String homeUrl = element.getAttribute("href");
		Assert.assertEquals("https://www.ebay.com/", homeUrl);
	}

}
