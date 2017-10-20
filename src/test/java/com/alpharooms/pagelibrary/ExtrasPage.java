package com.alpharooms.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtrasPage {

	static Logger log = Logger.getLogger(ExtrasPage.class.getName());
	WebDriver driver;
	By holidayDestHeader = By.xpath("//*[@id='countrylistpage']/div/div/div/div[2]/div[1]/div/h1");
	By baggage = By.xpath(".//*[@id='flightBaggageExtrasList']/div/table/tbody/tr[1]/td[1]/button");
	//*[@id="flightBaggageExtrasList"]/div/table/tbody/tr[1]/td[1]/button
	//*[@id="flightBaggageExtrasList"]/div/table/tbody/tr[1]/td[1]/button
	By continuebtn=By.xpath(".//*[@id='extraspage']/div[12]/div[2]/a");//*[@id="extraspage"]/div[12]/div[2]/a
	//*[@id="extraspage"]/div[12]/div[2]/a
	By baggageGrid = By.id("flightBaggageExtrasList");
	public ExtrasPage(WebDriver driver) {
		this.driver =driver;
		// TODO Auto-generated constructor stub
	}
	public String getTitle(){
		log.debug("The title of the current page is - ");
		return driver.getTitle();
	}
	public void selectBaggage() throws InterruptedException{
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath(".//*[@id='flightBaggageExtrasList']/div/table"));
		List<WebElement> button = ele.findElements(By.tagName("button"));
		button.get(0).click();
		
	}
	
	public PaymentPage CLickonContinue(){
		WebElement ele = driver.findElement(continuebtn);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
		return new PaymentPage(driver);
	}
}
