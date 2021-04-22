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
import org.openqa.selenium.support.ui.Select;

public class EbayHomePage {
	WebDriver driver;
	By homePageUserName = By.xpath("//*[@id=\"gh-ug\"]/b[1]");
	By homeTitle = By.xpath("//*[@id=\"gh-la\"]");
	
	
	public EbayHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Get the User name from Home page
	public String getHomePageDashboardUserName() {
		return driver.findElement(homePageUserName).getText();
	}
	
	public String getHomeTitle() {
		return driver.findElement(homeTitle).getAttribute("href");
	}
}
