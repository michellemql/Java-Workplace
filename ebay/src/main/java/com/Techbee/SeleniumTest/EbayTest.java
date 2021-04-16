package com.Techbee.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayTest {

	public EbayTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/michellemlq/Downloads/Tools/chromedriver");

	    WebDriver ebayDriver = new ChromeDriver();
	    ebayDriver.get("http://www.ebay.com/");
	    WebElement searchInput = ebayDriver.findElement(By.id("gh-ac"));
//	    ebayDriver.findElement(By.id("gh-ac")).sendKeys("Table");
	    searchInput.sendKeys("Table");
	    Thread.sleep(2000); // wait for 5000 sec to click
	    searchInput.clear();
	    
	    searchInput.sendKeys("Car");
	    Thread.sleep(2000); // wait for 5000 sec to click
	    searchInput.clear();
	    
	    searchInput.sendKeys("iPhone");
	    Thread.sleep(2000); // wait for 5000 sec to click
	    searchInput.clear();
	    
	    ebayDriver.findElement(By.linkText("Electronics")).click();
	    

	}

}
