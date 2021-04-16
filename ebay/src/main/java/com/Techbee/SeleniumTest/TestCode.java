package com.Techbee.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCode {

	public TestCode() {
		// TODO Auto-generated constructor stub
	}
	public void searchAndClick(String website, String id, String key, String xpath) {
		WebDriver driver = new ChromeDriver();
		driver.findElement(By.id(id)).sendKeys(key);
		driver.findElement(By.xpath(xpath)).click();
	}
}
