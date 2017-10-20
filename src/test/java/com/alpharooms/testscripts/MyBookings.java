package com.alpharooms.testscripts;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alpharooms.pagelibrary.AllMyBookingsPage;
import com.alpharooms.pagelibrary.HomePage;
import com.alpharooms.pagelibrary.MyBookingsPage;
import com.alpharooms.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class MyBookings  extends TestBase{
	//Test Script Class

	@BeforeClass
	public void setUp(){
		try {
			init();
			test = extent.startTest("Alpharooms Test",
					"This test will verify My Bookings Page");
			test.log(LogStatus.PASS, "My Booking Test Case");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@DataProvider(name="MyBookings")
	public Object[][] MyBookingsPage() {
		Object[][] data = getData("testDataHotel.xlsx", "MyBookings");
		return data;
	}
	
	//String testCaseName, String email, String itienaryNo, String RunMode
	@Test(alwaysRun= true,dataProvider="MyBookings")
	public void verifyMyBookingwithValidDetails(String testCaseName, String email, String itienaryNo, String RunMode) throws IOException{
		try {
			if (RunMode.equalsIgnoreCase("N")) {
				throw new SkipException("Skip all the tests which are set to N");
			}
			//page Landing - Title , text, sucessmsg.
			HomePage homePage = new HomePage(driver);
			test.log(LogStatus.PASS, "Click on Menu Icon in Home Page");
			homePage.ClickonMenuIcon();
			MyBookingsPage mybookingPage= homePage.ClickOnMenuMyBoookings();
			test.log(LogStatus.PASS, "enter Email Address");
			mybookingPage.Email(email);
			test.log(LogStatus.PASS, "enter Itinerary number");
			mybookingPage.ItieneraryNo(itienaryNo);
			test.log(LogStatus.PASS, "Click on Signin button");
			AllMyBookingsPage allmybookingPage =  mybookingPage.SignInButton();
		} catch (Exception e) {
			// TODO: handle exception
			getScreenShot("MyBookingwithValidDetails");
		}
	
		
	}
	@Test(enabled=false)
	public void verifyMyBookingswithEmptyDetails() throws IOException{
		try {
		
			HomePage homePage = new HomePage(driver);
			test.log(LogStatus.PASS, "Click on Menu Icon in Home Page");
			homePage.ClickonMenuIcon();
			MyBookingsPage mybookingPage= homePage.ClickOnMenuMyBoookings();
			test.log(LogStatus.PASS, "Click on Signin Button in my bookings Page");
			mybookingPage.SignInButton();
			Assert.assertEquals(mybookingPage.getErrorMessage(), "The or itinerary number provided is incorrect");
			
		} catch (Exception e) {
			// TODO: handle exception
			getScreenShot("MyBookingEmptyErrormsg");
		}
		
	}
	@AfterClass
	public void closeBrowser(){
		extent.endTest(test);
		extent.flush();
		extent.close();
		driver.close();
		
		
	}
}
