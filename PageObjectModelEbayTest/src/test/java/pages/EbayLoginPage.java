package pages;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EbayLoginPage {
	
	WebDriver driver;
	By ebayUserName = By.name("userid");
	By ebayPassword = By.name("");
	By loginTitle = By.id("greeting-msg");
	By homeTitle = By.xpath("//*[@id=\"gh-la\"]");
	By loginContinue = By.name("signin-continue-btn");
	By loginBtn = By.name("sgnB");
	
	public EbayLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Set user name 
	public void setUserName(String strUserName) {
		driver.findElement(ebayUserName).sendKeys(strUserName);
	}
	
	//Set password 
	public void setPassword(String strPassword) {
		driver.findElement(ebayPassword).sendKeys(strPassword);
	}
	
	//Click continue button
	public void clickContinue() {
		driver.findElement(loginContinue).click();
	}
	
	//Click on login 
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	
	//Get the title of Login Page
	public String getLoginTitle() {
		return driver.findElement(loginTitle).getText();
	}
	
	public void loginToEbay(String strUserName, String strPassword) {
		//Fill user name
		this.setUserName(strUserName);
		//Click Continue button
		this.clickContinue();
		//Fill password
		this.setPassword(strPassword);
		//Click login button
		this.clickLogin();
	}
}
