package com.alpharooms.testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.alpharooms.pagelibrary.AccommodationresultsPage;
import com.alpharooms.pagelibrary.ExtrasPage;
import com.alpharooms.pagelibrary.FlightAccomResultsPage;
import com.alpharooms.pagelibrary.FlightResultsPage;
import com.alpharooms.pagelibrary.HomePage;
import com.alpharooms.pagelibrary.HotelDetailsPage;
import com.alpharooms.pagelibrary.PaymentPage;
import com.alpharooms.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class TC001_VerifyAlpharoomsHomePage extends TestBase {

	HomePage homePage;
	FlightResultsPage flightResultsPage;
	AccommodationresultsPage accomPage;
	FlightAccomResultsPage flightaccomResultsPage;
	HotelDetailsPage hoteldetailPage;

	@Test(dataProvider = "Channels")
	public void setChannelAlphaHomePage(String TestCaseName,
			String channelName, String url, String runMode) {
		// String channelName = "Ireland";
		// String url =
		// "http://ie.qasearchexperiance.eu-west-1.elasticbeanstalk.com/";
		test.log(LogStatus.PASS, "naviating to  " + channelName + "  channel");

		try {
			// SwitchToChannel(channelName, url);
			waitFor(2);
			Assert.assertEquals(driver.getCurrentUrl(), url);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void verifyAllUspBlocksHomePage() {
		homePage = new HomePage(driver);
		try {
			test.log(LogStatus.PASS,
					"Verifying all the USp block section available");
			homePage.getAllUSPBlocks();
			Assert.assertTrue(
					homePage.get1FoundDepositUSPBlock().isDisplayed(),
					"1 Found Logo section is not visible");
			Assert.assertTrue(homePage.getFlexiblePayments().isDisplayed(),
					"flexible payment logo is no there");
			Assert.assertTrue(homePage.getLowestPriceGuranty().isDisplayed(),
					"Lowest price guranty is not found");
		} catch (Exception e) {
			try {
				getScreenShot("AlphaHOme - UspBlockIssue");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Test
	public void verifyTrustedBrandUnderUspBlocks() {

		try {
			test.log(LogStatus.PASS,
					homePage.getGoogleLogo().getAttribute("alt"));
			Assert.assertTrue(homePage.getGoogleLogo().isDisplayed(),
					"google logo is not visible");
			Assert.assertTrue(homePage.getttaLogo().isDisplayed(),
					"tta logo is not visible");
			Assert.assertTrue(homePage.getatolLogo().isDisplayed(),
					"atol logo is not visible");
			Assert.assertTrue(homePage.getTrustPilotLogo().isDisplayed(),
					"trust logo is not visible");
			Assert.assertTrue(homePage.getfeefoLogo().isDisplayed(),
					"feefo logo is not visible");
			Assert.assertTrue(homePage.getNortonLogo().isDisplayed(),
					"norton logo is not visible");
			Assert.assertTrue(homePage.getReviewCenterLogo().isDisplayed(),
					"review center logo is not visible");

		} catch (Exception e) {
			try {
				getScreenShot("Trusted branded Issue from alpha homePage");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	@Test
	public void selectTabsFromAlpha() throws InterruptedException {
		test.log(LogStatus.PASS,
				"alpha home Page will be open in Firefox Browser");
		// Create an instance for homePage
		String channelLink = "United Kingdom (£)";

		if ((modelPopup().isDisplayed())) {
			setChannelPopUp(channelLink);
		}
		Thread.sleep(2000);
		selectTab("FLIGHTS");
	}

	@BeforeClass
	public void setUP() throws IOException {
		init();
		// starting test
		test = extent.startTest("Alpharooms Test",
				"This test will verify alpharoomsHomePage");
		test.log(LogStatus.PASS, "Basic set up for test is done");
	}

	@DataProvider(name = "SignUp")
	public Object[][] loginData() {
		Object[][] data = getData("testDataHotel.xlsx", "SignUp");
		return data;
	}

	@DataProvider(name = "Channels")
	public Object[][] Channels() {
		Object[][] data = getData("testDataHotel.xlsx", "Channels");
		return data;
	}

	@DataProvider(name = "HotelSearch")
	public Object[][] hotelSearch() {
		Object[][] data = getData("testDataHotel.xlsx", "HotelSearch");
		return data;
	}

	@DataProvider(name = "FlightSearch")
	public Object[][] FlightSearch() {
		Object[][] data = getData("testDataHotel.xlsx", "FlightSearch");
		return data;
	}

	@DataProvider(name = "FlightHotelSearch")
	public Object[][] FlightHotelSearch() {
		Object[][] data = getData("testDataHotel.xlsx", "FlightHotelSearch");
		return data;
	}

	@Test(priority = 4)
	public void verifyCheckoutourmostpopularholidaydestinations() {
		test.log(LogStatus.PASS, getMostPopularTwelveHotelDestinations());
		// getMostPopularTwelveHotelDestinations();
	}

	@Test(dataProvider = "brokenlinks")
	public void verifyBrokenLinksFromHomePage(String linkUrl) {
		findBrokenLinks(linkUrl);
	}

	@Test(dataProvider = "SignUp")
	public void verifyAlphaSignUp(String TestCaseName, String Email,
			String SuccessMsg, String runMode) throws InterruptedException {
		test.log(LogStatus.PASS, "I am from data provider gest");
		if (runMode.equals("N")) {
			throw new SkipException("Skipping the test");
		}
		test.log(LogStatus.PASS, "User enter email address -- " + Email);
		homePage.setEmailSignUp(Email);
		test.log(LogStatus.PASS, "User click on SignUp button- ");

		try {
			homePage.clickOnSignUpButton();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.PASS, "Assert the Message from SignUp -- "
				+ SuccessMsg);
		Assert.assertEquals(homePage.getSignupSuccessmsg(SuccessMsg),
				SuccessMsg);
		// Assert.assertTrue(homePage.getSignupSuccessmsg(successmesg));
		// homePage.getSignupSuccessmsg(successmesg);
	}

	@Test(dataProvider = "FlightSearch", description = "Test is under construction")
	public void VerifyFlightSearchResults(String TestCaseName,
			String destination, String departure, String day, String mon,
			String year, String nights, String adults, String runMode) {
		try {
			// test.log(LogStatus.PASS, "I am from data provider test");
			if (runMode.equals("N")) {
				throw new SkipException("Skipping the test");
			}
			test.log(LogStatus.PASS,
					"alpha home Page will be open in Chrome Browser");
			// Create an instance for homePage
			homePage = new HomePage(driver);
			test.log(LogStatus.PASS, "Title of Alpha room home page   - > "
					+ driver.getTitle());

			test.log(LogStatus.PASS,
					"verify all the links of Alpharooms homepage");

			selectTab("FLIGHTS");
			test.log(LogStatus.PASS, "click on Flight Destination");
			homePage.clickFlightDestination(destination);
			homePage.getFlight_Destinations(destination);
			test.log(LogStatus.PASS, "Enter the destination as : "
					+ destination);
			// homePage.selectDestinationfrmPopUp(destination);
			test.log(LogStatus.PASS, "Click on Flight Departure");
			homePage.clickFlightDeparture();
			test.log(LogStatus.PASS, "Enter the departure as : " + departure);
			homePage.getDepartureAirport(departure);
			test.log(LogStatus.PASS, "select the start date as : " + day + " "
					+ mon + " " + year);
			homePage.selectFromDate(day, mon, year);
			// Choose Number of nIghts
			test.log(LogStatus.PASS, "select the NUmberof nights : " + nights);
			homePage.selectNumberOfNights(nights);
			test.log(LogStatus.PASS, "click on Room and Guest search ");
			homePage.clickOnRoomsAndGuest();
			// Choose Number of Rooms or Guests

			test.log(LogStatus.PASS, "User Select the Adults : " + adults);
			homePage.setAdultCount(adults);
			test.log(LogStatus.PASS, "User Click on Done button ");
			homePage.clickDoneButton();
			// Click on Search button
			test.log(LogStatus.PASS, "User Click Search button");
			AccommodationresultsPage accomPage = homePage.clickSearchButton();
			waitForPageToLoad(60);
			test.log(LogStatus.PASS, accomPage.getTitle());
			test.log(
					LogStatus.PASS,
					"Hey ! I am the Hotel search Page Title  : "
							+ driver.getTitle());
			// accomPage.selectFlight();
		} catch (Exception e) {
			try {
				getScreenShot("HomePageError");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		extent.endTest(test);
		extent.flush();
		// return homePage;
	}

	@Test(dataProvider = "HotelSearch")
	public void VerifyHotelSearchResults(String TestCaseName,
			String destination, String day, String mon, String year,
			String nights, String adults, String runMode)
			throws InterruptedException, IOException {
		try {
			test.log(LogStatus.PASS, "I am from data provider gest");
			if (runMode.equals("N")) {
				throw new SkipException("Skipping the test");
			}

			String hotelSearchPageTitle = "Cheap hotels and apartments, low cost flights, and cheap holidays worldwide with alpharooms.com";
			test.log(LogStatus.PASS,
					"alpha home Page will be open in Firefox Browser");
			// Create an instance for homePage
			homePage = new HomePage(driver);
			test.log(LogStatus.PASS, "Title of Alpha room home page   - > "
					+ driver.getTitle());
			test.log(LogStatus.PASS,
					"verify all the links of Alpharooms homepage");
			test.log(LogStatus.PASS, "Enter the destination as : "
					+ destination);
			homePage.clickHotelDestination();

			homePage.selectDestinationfrmPopUp(destination);
			// homePage.destination(destination);
			test.log(LogStatus.PASS, "select the start date as : " + day + " "
					+ mon + " " + year);
			homePage.selectFromDate(day, mon, year);
			// Choose Number of nIghts
			test.log(LogStatus.PASS, "select the NUmberof nights : " + nights);
			homePage.selectNumberOfNights(nights);
			test.log(LogStatus.PASS, "click on Room and Guest search ");
			homePage.clickOnRoomsAndGuest();
			// Choose Number of Rooms or Guests
			test.log(LogStatus.PASS, "User Select the Adults : " + adults);
			homePage.setAdultCount(adults);
			test.log(LogStatus.PASS, "User Click on Done button ");
			homePage.clickDoneButton();
			// Click on Search button
			test.log(LogStatus.PASS, "User Click Search button");
			accomPage = homePage.clickSearchButton();
			waitFor(6);
			test.log(LogStatus.PASS, accomPage.getTitle());
			test.log(
					LogStatus.PASS,
					"Hey ! I am the Hotel search Page Title  : "
							+ driver.getTitle());
			Assert.assertEquals(driver.getTitle(), hotelSearchPageTitle);
			waitFor(8);
			String propertiesCount = accomPage.getProperties();
			test.log(LogStatus.PASS, "accommodationresults Page Url - "
					+ homePage.getCurrentPageUrl());
			test.log(LogStatus.PASS, "Here is the Properties Count : "
					+ propertiesCount);
			// accomPage.getProperties(destination);
			test.log(LogStatus.PASS, "Back to home Page");
			waitFor(3);
			// homePage = accomPage.backToHomePage();
			waitFor(6);
		} catch (Exception e) {
			getScreenShot("HomePageError");
		}
		extent.endTest(test);
		extent.flush();
		// return homePage;
	}

	@Test(dataProvider = "FlightHotelSearch")
	public void VerifyFlightAndHotelsSearch(String TestCaseName,
			String destination, String departure, String day, String mon,
			String year, String nights, String adults, String runMode)
			throws InterruptedException, IOException {
		try {
			test.log(LogStatus.PASS, "I am from data provider test");
			if (runMode.equals("N")) {
				throw new SkipException("Skipping the test");
			}
			test.log(LogStatus.PASS,
					"alpha home Page will be open in Chrome Browser");
			// Create an instance for homePage
			homePage = new HomePage(driver);
			test.log(LogStatus.PASS, "Title of Alpha room home page   - > "
					+ driver.getTitle());

			test.log(LogStatus.PASS,
					"verify all the links of Alpharooms homepage");

			selectTab("FLIGHT & HOTEL");
			test.log(LogStatus.PASS, "click on Flight Destination");
			homePage.clickHotelDestination();

			homePage.selectDestinationfrmPopUp(destination);
			test.log(LogStatus.PASS, "Enter the destination as : "
					+ destination);
			// homePage.selectDestinationfrmPopUp(destination);
			test.log(LogStatus.PASS, "Click on Flight Departure");
			homePage.clickFlightDeparture();
			test.log(LogStatus.PASS, "Enter the departure as : " + departure);
			homePage.getDepartureAirport(departure);
			test.log(LogStatus.PASS, "select the start date as : " + day + " "
					+ mon + " " + year);
			homePage.selectFromDate(day, mon, year);
			// Choose Number of nIghts
			test.log(LogStatus.PASS, "select the NUmberof nights : " + nights);
			homePage.selectNumberOfNights(nights);
			test.log(LogStatus.PASS, "click on Room and Guest search ");
			homePage.clickOnRoomsAndGuest();
			// Choose Number of Rooms or Guests

			test.log(LogStatus.PASS, "User Select the Adults : " + adults);
			homePage.setAdultCount(adults);
			test.log(LogStatus.PASS, "User Click on Done button ");
			homePage.clickDoneButton();
			// Click on Search button
			test.log(LogStatus.PASS, "User Click Search button");
			flightResultsPage = homePage.clickOnSearchButton();
			// test.log(LogStatus.PASS, accomPage.getTitle());
			waitForPageToLoad(5);
			test.log(
					LogStatus.PASS,
					"I am the Flight search Results Page Title  -: "
							+ driver.getTitle());
			// waitForPageToLoad(20);

			Assert.assertEquals(flightResultsPage.getTitle(),
					"Flight Search Results");
		//	waitForPageToLoad(15);
			String hotelName = "HSM Canarios Park";
			test.log(LogStatus.PASS, "User Click Select Flight button");
			
			flightaccomResultsPage = flightResultsPage
					.selectFlight("Select flight");
			test.log(LogStatus.PASS,
					"User enter the hotel name in hotel text box " + hotelName);
			
			flightaccomResultsPage.enterHotelName(hotelName);
			waitForPageToLoad(10);
			test.log(LogStatus.PASS, "User Click on Hotel link");
			
			hoteldetailPage = flightaccomResultsPage.ClickonHotelLink();
			
			test.log(LogStatus.PASS, "User  Select room in the hotel");
			ExtrasPage extrasPage = hoteldetailPage.SelectRoom();
			waitForPageToLoad(20);
			
			// Assert.assertEquals(extrasPage.getTitle(), "Holiday extras");
			test.log(LogStatus.PASS, "User  Select the baggage");
			extrasPage.selectBaggage();
			test.log(LogStatus.PASS, "User  Click on Continue button");
			waitForPageToLoad(20);
			PaymentPage paymentPage = extrasPage.CLickonContinue();
			waitForPageToLoad(20);
			test.log(LogStatus.PASS, "User  Click on Flexible Payment option ");
			paymentPage.clickpayemenyFlixible();
			test.log(LogStatus.PASS, "User Enter the Contact Details ");
			paymentPage.populateContactDetails();
			test.log(LogStatus.PASS, "User enter the email address");
			paymentPage.enterEmail("ramesh.k@alpharooms.com");
			test.log(LogStatus.PASS, "User enter the guest details");
			paymentPage.guestDetails();
			test.log(LogStatus.PASS, "User  enter the payment details");
			paymentPage.payementDetails();
			test.log(LogStatus.PASS, "User enter the staff details");
			paymentPage.StaffDetails();

			// fhotelResultsPage
			// waitFor(6);
		} catch (Exception e) {
			getScreenShot("Error");
		}
	}

	@Test
	public void ChooseHotelName() {
		// accomPage.getAllHotelsCount();
		// getAllHotelCount("Vistasol Apartments");
	}

	@AfterClass
	public void closeBrowser() {
		test.log(LogStatus.PASS, "Closing browser");
		extent.endTest(test);
		extent.flush();
		driver.close();
		// driver.quit();

	}
}
