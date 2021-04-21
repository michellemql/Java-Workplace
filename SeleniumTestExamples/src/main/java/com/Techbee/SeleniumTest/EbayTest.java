package com.Techbee.SeleniumTest;

import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class EbayTest {

	public EbayTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/michellemql/Downloads/Tools/chromedriver");

	    WebDriver ebayDriver = new ChromeDriver();
	    ebayDriver.get("http://www.ebay.com/");
	    
	    // Search for "iphone" in the search bar
	    // Click on search button
	    // Output product description and price for all products displayed on page 1 and save it in a text file
	  
	    ebayDriver.findElement(By.id("gh-ac")).sendKeys("iPhone");
	    ebayDriver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
	    
	    WebElement webElement = ebayDriver.findElement(By.xpath(" //*[@id=\"srp-river-results\"]/ul"));
	    ArrayList<WebElement> allIPhones = (ArrayList<WebElement>) webElement.findElement(By.tagName("li"));
	    ArrayList<ArrayList<String>> res = new ArrayList<>(); 
	    
	    int count = allIPhones.size();
	    File file1 = new File("iphone_ebay.txt");
	    FileWriter fw = new FileWriter(file1);
	    
	    for (int i = 0; i < count; i++) {
	    	ArrayList<String> item = new ArrayList<>();
	    	String description = allIPhones.get(i).findElement(By.className("s-item__title")).getText();
	    	String price = allIPhones.get(i).findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/div[5]/div[1]/span")).getText();
	    	String text = description + "-" + price;
	    	item.add(text);
	    	res.add(item);
	    	fw.write(text);
	    }
	    
   
	    System.out.println(res);
	    
    

	}

}
