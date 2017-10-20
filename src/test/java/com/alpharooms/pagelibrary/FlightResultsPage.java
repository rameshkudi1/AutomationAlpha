package com.alpharooms.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.alpharooms.testbase.TestBase;

public class FlightResultsPage {


	WebDriver driver;
	TestBase tpage;
	static Logger log = Logger.getLogger(FlightResultsPage.class.getName());
	By propertiestxt = By.xpath(".//*[@id='accommodationresults']/div[12]/div/div[2]/div[3]/div[5]/div[1]/h2[1]");
	By alphaLogo = By.xpath("//*[@id='main-content']/div[1]/header/div/div/div[3]/a/div");
	By SelectFlight = By.xpath(".//*[@id='flightresults']/div[7]/div/div[2]/div[9]/div[1]/div[1]/div[2]/div[3]/div[3]/form/div");
	
	public FlightResultsPage(WebDriver driver){
		this.driver = driver;
	}
	public String getTitle() {
		log.debug("The title of the current page is - ");
		return driver.getTitle();
	}
	public FlightAccomResultsPage  selectFlight(String selectflight){
		List<WebElement> xpath = driver.findElements(By.xpath(".//*[@class='select-flight-btn btn btn-orange']"));
		int xpathCount = xpath.size();
		System.out.println("Total xpath: " + xpathCount);
		for(WebElement options: xpath){
			System.out.println(options.getText() +"With Text");
			String itemName=options.getText();
			if (itemName.trim().equalsIgnoreCase(selectflight)) {
				xpath.get(0).click();
				break;
			}
			//System.out.println(options.getAttribute("value") +"With Attribute");
		}
		return new FlightAccomResultsPage(driver);
		//return null;
	}
	

}
