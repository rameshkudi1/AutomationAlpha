package com.alpharooms.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alpharooms.testbase.TestBase;

public class AccommodationresultsPage {

	WebDriver driver;
	TestBase tpage;
	static Logger log = Logger.getLogger(AccommodationresultsPage.class.getName());
	By propertiestxt = By.xpath(".//*[@id='accommodationresults']/div[12]/div/div[2]/div[3]/div[5]/div[1]/h2[1]");
	By alphaLogo = By.xpath("//*[@id='main-content']/div[1]/header/div/div/div[3]/a/div");
	By SelectFlight = By.xpath(".//*[@id='flightresults']/div[7]/div/div[2]/div[9]/div[1]/div[1]/div[2]/div[3]/div[3]/form/div");
	
	public AccommodationresultsPage(WebDriver driver){
		this.driver = driver;
	}
	public String getTitle() {
		log.debug("The title of the current page is - ");
		return driver.getTitle();
	}
	// Wait for certain element to be loaded on the web page
	public void waitFor(ExpectedCondition<WebElement> condition,
			Integer timtOutinSeconds) {
		timtOutinSeconds = timtOutinSeconds != null ? timtOutinSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(condition);
	}
	public void getAllHotelsCount(){
		tpage.getAllHotelCount();
	}
	public String getProperties() throws InterruptedException {
        Thread.sleep(2500);
		String getText = driver.findElement(propertiestxt).getText();
		
		System.out.println("Properties Count it : "+getText);
		return getText;
	}
	//	driver.findElement(SelectFlight).click();
		//tpage.SelectFlight(SelectFlight);
	
	public HomePage backToHomePage() {
		 driver.findElement(alphaLogo).click();
		 return new HomePage(driver);
		// TODO Auto-generated method stub
		
	}
	
}
