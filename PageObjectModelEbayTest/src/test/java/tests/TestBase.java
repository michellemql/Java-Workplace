package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
	
	/************************* Test Methods ***************************/
	public void sendKeys(String id, String input) {
		 driver.findElement(By.id(id)).sendKeys(input);
	}
	
	public void clickButton(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clickLink(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}
	
	public String getText(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public String getTextId(String id) {
		return driver.findElement(By.id(id)).getText();
	}
	
	public void mouseHover(String linkText) {
		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.linkText(linkText));
		actions.moveToElement(target).perform();
	}
	
	public void scrollDown(String xpath) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", 1);
	    Thread.sleep(800);
	}
	
	public void dropDownSelect(String xpath, String option) {
		Select result = new Select(driver.findElement(By.xpath(xpath)));
		result.selectByValue(option);
	}
	
	
}






























