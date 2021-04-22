package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EbayRegisterPage {
	
	WebDriver driver;
	By firstName = By.name("firstname");
	By lastname = By.name("lastname");
	By email = By.name("Email");
	By password = By.name("password");
	By registerTitle = By.xpath("//*[@id=\"mainContent\"]/div[3]/h1");
	By registerBtn = By.name("EMAIL_REG_FORM_SUBMIT");
	By homeTitle = By.xpath("//*[@id=\"gh-la\"]");
	
	public EbayRegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Set first name
	public void setFirstName(String strFirstName) {
		driver.findElement(firstName).sendKeys(strFirstName);
	}
	
	//Set last name
	public void setLastName(String strLastName) {
		driver.findElement(lastname).sendKeys(strLastName);
	}
	
	//Set email
	public void setEmail(String strEmail) {
		driver.findElement(email).sendKeys(strEmail);
	}
	
	//Set password 
	public void setPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}
	
	//Click on register button
	public void clickRegister() {
		driver.findElement(registerBtn).click();
	}
	
	//Get the title of Login Page
	public String getRegisterTitle() {
		return driver.findElement(registerTitle).getText();
	}
	
	//Get the title of Home Page
	public String getHomeTitle() {
		return driver.findElement(homeTitle).getAttribute("href");
	}
	
	public void registerToEbay(String strFirstName, String strLastName, String Email, String strPassword) {
		//Fill first name
		this.setFirstName(strFirstName);
		//Fill last name
		this.setLastName(strLastName);
		//Fill email
		this.setEmail(Email);
		//Fill password
		this.setPassword(strPassword);
		//Click register button
		this.clickRegister();
	}
}
