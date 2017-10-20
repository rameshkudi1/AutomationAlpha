package com.alpharooms.pagelibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.alpharooms.testbase.TestBase;

public class PaymentPage {

	WebDriver driver;
	TestBase tpage;
	By fullyfelxiblepayment = By.id("paymentFlexible");
	By emailaddress = By.id("ContactAddress_Email");
	By contactdetails = By.xpath("//*[@id='contactDetails']/span/a");
	By guestDetails = By.xpath("//*[@id='guestDetails']/span/a");
	By paymentDetails = By.xpath("//*[@id='paymentDetails']/div[4]/div/span/a");
	By staffDetails = By.xpath("//*[@id='StaffDetails']/span/a");
	static Logger log = Logger.getLogger(PaymentPage.class.getName());

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		log.debug("The title of the current page is - ");
		return driver.getTitle();
	}

	public void clickpayemenyFlixible() {
		driver.findElement(fullyfelxiblepayment).click();
	}

	public void enterEmail(String value) {
		driver.findElement(emailaddress).sendKeys(value);
	}

	public void populateContactDetails() {
		driver.findElement(contactdetails).click();
	}

	public void guestDetails() {
		driver.findElement(guestDetails).click();
	}

	public void payementDetails() {
		driver.findElement(paymentDetails).click();
	}

	public void StaffDetails() {
		driver.findElement(staffDetails).click();
	}
}
