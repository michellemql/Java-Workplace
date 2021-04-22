package com.Techbee.SeleniumTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestBase {
	public static WebDriver driver = null;
	public TestBase() {
		// TODO Auto-generated constructor stub
	}
	public void searchAndClick(String website, String id, String key, String xpath) {
		WebDriver driver = new ChromeDriver();
		driver.findElement(By.id(id)).sendKeys(key);
		driver.findElement(By.xpath(xpath)).click();
	}
	@BeforeSuite
	public void initialize(String website) throws IOException{
		driver = new ChromeDriver();
		//To maximize browser
		driver.manage().window().maximize();
		// To open the website
		driver.get(website);
	}
	
	@AfterSuite
	//Test cleanup
	public void TeardownTest() {
		TestBase.driver.quit();
	}
}
