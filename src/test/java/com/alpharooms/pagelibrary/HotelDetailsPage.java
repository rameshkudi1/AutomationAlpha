package com.alpharooms.pagelibrary;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.alpharooms.testbase.TestBase;

public class HotelDetailsPage {

	WebDriver driver;
	TestBase tpage;
	static Logger log = Logger.getLogger(HotelDetailsPage.class.getName());
	By propertiestxt = By
			.xpath(".//*[@id='accommodationresults']/div[12]/div/div[2]/div[3]/div[5]/div[1]/h2[1]");
	By alphaLogo = By
			.xpath("//*[@id='main-content']/div[1]/header/div/div/div[3]/a/div");
	By SelectFlight = By
			.xpath(".//*[@id='flightresults']/div[7]/div/div[2]/div[9]/div[1]/div[1]/div[2]/div[3]/div[3]/form/div");

	public HotelDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		log.debug("The title of the current page is - ");
		return driver.getTitle();
	}

	public ExtrasPage SelectRoom() {

		ArrayList<String> tabs2 = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		WebElement item = driver
				.findElement(By
						.xpath("//tr[1]/td[6]/a[contains(@class, 'roomselect btn pull-right hidden-phone btn-orange')]"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", item);

		return new ExtrasPage(driver);
	}

}
