package com.Techbee.SeleniumTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TargetText {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/michellemlq/Downloads/Tools/chromedriver");
		
	    WebDriver targetDriver = new ChromeDriver();
	    targetDriver.get("http://www.target.com/");
	    
	    WebElement searchInput = targetDriver.findElement(By.id("search"));
	    targetDriver.findElement(By.id("search")).sendKeys("iPhone");
	    targetDriver.findElement(By.xpath("//*[@id=\"headerMain\"]/div[1]/button")).click();
	    
	    WebElement webElement = targetDriver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div[4]/div[2]/div/div[1]/div[3]/div/ul"));
	    ArrayList<WebElement> allIPhones = (ArrayList<WebElement>) webElement.findElement(By.tagName("li"));
	    ArrayList<ArrayList<String>> res = new ArrayList<>();
	    
	    int count = allIPhones.size();
	    File file2 = new File("iphone_target.txt");
	    FileWriter fw = new FileWriter(file2);
	    
	    for (int i = 0; i < count; i++) {
	    	ArrayList<String> item = new ArrayList<>();
	    	String description = allIPhones.get(i).findElement(By.cssSelector("h-display-flex")).getText();
	    	String price = allIPhones.get(i).findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/div[5]/div[1]/span")).getText();
	    	String text = description + "-" + price;
	    	item.add(text);
	    	res.add(item);
	    	fw.write(text);
	    }
	    
	    System.out.println(res);
	}
}
