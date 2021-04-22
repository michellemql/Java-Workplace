package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	public static WebDriver driver = null;	
	
	public TestBase() {
		// TODO Auto-generated constructor stub
		
	}
	public TestBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@BeforeSuite
	public void setup() throws IOException{
		System.setProperty("webdriver.chrome.driver", "/Users/michellemql/Downloads/Tools/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com/");
	}
	
	public void clickLoginLink() {
		driver.findElement(By.linkText("Sign in")).click();
	}
	
	public void clickRegisterLink() {
		driver.findElement(By.linkText("register")).click();
	}
}






























