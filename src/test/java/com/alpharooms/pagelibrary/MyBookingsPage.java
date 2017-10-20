package com.alpharooms.pagelibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyBookingsPage  {
	
	WebDriver driver;
	By signintxt = By.xpath("//*[@id='signinpage']/div/div/h2");
	By emailtxt = By.id("EmailAddress");
	By itineraryNotxt = By.id("Password");
	By rememberchk = By.id("RememberMe");
	By signinbtn = By.xpath("//*[@id='signinpage']/div/div/div/form/div[7]/button");
	By errormsgsigin= By.xpath(".//*[@id='signinpage']/div/div/div/form/div[1]/div/ul/li");
	// Constrcutor
	public MyBookingsPage(WebDriver driver) {
		this.driver = driver;
	}
	//Get title of the Page
	public String getTitle() {
	
		return driver.getTitle();
	}

	public void Email(String value){
		driver.findElement(emailtxt).sendKeys(value);
	}

	public void ItieneraryNo(String value){
		driver.findElement(itineraryNotxt).sendKeys(value);
	}
	public void ClickRemember(){
		driver.findElement(rememberchk).click();
	}
	public AllMyBookingsPage SignInButton()
	{
		driver.findElement(signinbtn).click();
		return new AllMyBookingsPage(driver);
	}
	public String getErrorMessage(){
		String getText = driver.findElement(errormsgsigin).getText();
		return getText;
	}
}
