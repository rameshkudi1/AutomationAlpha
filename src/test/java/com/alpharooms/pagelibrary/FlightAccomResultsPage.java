package com.alpharooms.pagelibrary;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.alpharooms.testbase.TestBase;

public class FlightAccomResultsPage {
	WebDriver driver;
	TestBase tpage;
	By hotelname = By.xpath(".//*[@id='accommodationresults']/div[12]/div/div[1]/div[3]/div/div/div[4]/input");
	By hotellink= By.xpath(".//*[@id='result-box-detailed']/div[1]/div[2]/div[1]/h3/a");
	static Logger log = Logger.getLogger(FlightAccomResultsPage.class.getName());
	
	public FlightAccomResultsPage(WebDriver driver){
		this.driver = driver;
	}
	public String getTitle() {
		log.debug("The title of the current page is - ");
		return driver.getTitle();
	}

	public void enterHotelName(String HotelName){
		driver.findElement(hotelname).sendKeys(HotelName);
		driver.findElement(hotelname).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(hotelname).sendKeys(Keys.ENTER);
		
	}
	public HotelDetailsPage ClickonHotelLink() throws InterruptedException{
		
		//Thread.sleep(1000);
		//WebElement ele = driver.findElement(By.xpath(".//*[@id='accommodationresults']/div[12]/div/div[2]/div[3]/div[7]/div[3]/div/div/div[1]/div[2]/div[1]/h3/a"));
		WebElement hotelName = driver.findElement(hotellink);
		hotelName.click();
		/*List<WebElement> xpath = driver.findElements(By.xpath(".//*[@id='accommodationresults']/div[12]/div/div[2]/div[3]/div[7]/div[3]/div/div/div[1]/div[2]/div[1]/h3/a"));
		//List<WebElement> xpath = ele.findElements(By.tagName("a"));
		int xpathCount = xpath.size();
		System.out.println("Total xpath: " + xpathCount);
		Thread.sleep(1500);
		xpath.get(0).click();*/
	/*	for(WebElement options: xpath){
			
		//	Thread.sleep(1000);
			//System.out.println(options.getText() +"With Text all rooms");
		//	System.out.println(options.getAttribute("value")+"with Attribute");
			//String itemName=options.getText();
			if (options.getAttribute("value").trim().contains(hotelName)) {
				options.click();
				break;
			}*/
		/*for (int i = 1; i <=20; i++) {
			                                                                              											//*[@id="accommodationresults"]/div[11]/div/div[2]/div[3]/div[7]/div[3]/div/div[1]/div[2]/div[1]
			List<WebElement> viewallrooms = driver.findElements(By.xpath(".//*[@id='accommodationresults']/div[11]/div/div[2]/div[3]/div[7]/div[3]/div/div["+i+"]/div[2]/div[1]"));
			for(WebElement options : viewallrooms){
				if (options.getAttribute("value").trim().equals(viewallroom)) {
					System.out.println(options.getAttribute("value"));
					viewallrooms.get(1).click();
					waitFor(2);
					break;
				}
			}*/
		
		Thread.sleep(2000);
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		
		return new HotelDetailsPage(driver);
		
	}
}
