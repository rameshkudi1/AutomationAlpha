package com.alpharooms.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alpharooms.testbase.TestBase;

public class HomePage {
	WebDriver driver;
	static Logger log = Logger.getLogger(HomePage.class.getName());
	// Flights Properties
	By flightDestination = By.xpath("//*[@id='DestinationAirportName']");
	By departingFrom = By.xpath(".//*[@id='departureAirport']/div/button");
	// SignUp
	By signUptxt = By.name("email");
	By signUpbtn = By
			.xpath(".//*[@id='homepage']/div[9]/div/div[1]/div[2]/form/div[1]/div[2]/button");
	By signUpmsg = By.xpath(".//*[@id='homepage']/div[9]/div/div[2]/p");
	// Hotel Properties
	By destinationtextBox = By.id("DestinationName");
	By holidayExtras = By.linkText("Holiday Extras");
	By aToZDestinations = By.linkText("A-Z Destinations");
	By FAQ = By.linkText("FAQ");
	By groups = By.linkText("Groups");
	By myAccount = By.linkText("My Account");
	By headerHome = By
			.xpath(".//*[@id='searchFormForm']/div[2]/div[2]/div[2]/h1");
	By doneBtn = By
			.xpath(".//*[@id='seach-box-wrapper']/div[1]/div[10]/div[2]/div[2]/a");
	By searchbtn = By.id("searchFormSubmit");
	By oneFoundDepositsection = By
			.xpath(".//*[@id='homepage']/div[1]/div[4]/div/ul/li[3]");
	By flexiblePayments = By
			.xpath(".//*[@id='homepage']/div[1]/div[4]/div/ul/li[5]");
	By LowestPriceGurantee = By
			.xpath(".//*[@id='homepage']/div[1]/div[4]/div/ul/li[6]");
	By googleLogo = By.xpath("//img[@src='/Content/Images/Trust/google.png']");
	By ttaLogo = By.xpath("//img[@src='/Content/Images/Trust/tta.png']");
	By atollogo = By.xpath("//img[@src='/Content/Images/Trust/atol.png']");
	By trustPilologo = By
			.xpath("//img[@src='/Content/Images/Trust/trustpilot.png']");
	By reviewCenterLogo = By
			.xpath("//img[@src='/Content/Images/Trust/reviewcentre.png']");
	By feefoLogo = By.xpath("//img[@src='/Content/Images/Trust/feefo.png']");
	By nortonLogo = By.xpath("//img[@src='/Content/Images/Trust/norton.png']");
	By allLogo = By.xpath("//*[@class='row-fluid hidden-phone barOfTrust']");
	By myaccountmenu = By
			.xpath("/html/body/div[2]/div[3]/div[1]/header/div/div/div[4]/div/ul/li[2]/a/i");
	By menuMyBookings = By.xpath(".//*[@id='channel-switcher']/ul/li[2]/ul/li[1]/a"); 
	
	TestBase tpage = new TestBase();

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Title of the Current Web page
	public String getTitle() {
		log.debug("The title of the current page is - ");
		return driver.getTitle();
	}

	public String getCurrentPageUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public void setEmailSignUp(String email) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(signUptxt).sendKeys(email);
	}

	public void clickOnSignUpButton() throws InterruptedException {
		driver.findElement(signUpbtn).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
	}

	public String getSignupSuccessmsg(String message)
			throws InterruptedException {
		Thread.sleep(1000);
		message = driver.findElement(signUpmsg).getText();
		return "Thanks for signing up! We look forward to keeping you updated with our best offers.";
	}

	// get All flight destinations
	public void getFlight_Destinations(String destination) {
		tpage.get_FlightDestinations(destination);
		driver.findElement(flightDestination).sendKeys(Keys.TAB);
	}

	public MyBookingsPage ClickOnMenuMyBoookings(){
		driver.findElement(menuMyBookings).click();
		return new MyBookingsPage(driver);
	}
	public void ClickonMenuIcon(){
		driver.findElement(myaccountmenu).click();
	}
	// Verify My Bookings Menu - @Ramesh K
	public MyBookingsPage clickOnMyAccount(String screen, String expurl) {
		driver.findElement(myaccountmenu).click();
		for (int i = 1; i <= 3; i++) {
			WebElement menuitem = driver.findElement(By
					.xpath("//*[@id='channel-switcher']/ul/li[2]/ul/li[" + i
							+ "]"));
			List<WebElement> chann = menuitem.findElements(By.tagName("a"));
			for (WebElement options : chann) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (options.getText().equals(screen)) {

					options.click();
					try {
						Thread.sleep(200L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					expurl = driver.getCurrentUrl();
					break;
				}
			}
		}
		return new MyBookingsPage(driver);

	}

	// Wait for certain element to be loaded on the web page
	public void waitFor(ExpectedCondition<WebElement> condition,
			Integer timtOutinSeconds) {
		timtOutinSeconds = timtOutinSeconds != null ? timtOutinSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(condition);
	}

	// /public void
	public boolean verifyAlllinksAvaialbleinAlphaHomePage() {
		log.debug("Capture the error message when email empty in myaccount page");
		// driver.findElement(holidayExtras).isDisplayed();
		driver.findElement(aToZDestinations).isDisplayed();
		driver.findElement(FAQ).isDisplayed();
		driver.findElement(groups).isDisplayed();
		// driver.findElement(myAccount).isDisplayed();
		return true;
	}

	public String getTextofHeader() {
		return driver.findElement(headerHome).getText();
	}

	// destination textbox
	public void clickHotelDestination() {
		driver.findElement(destinationtextBox).click();
	}

	public void clickFlightDestination(String destination) {
		driver.findElement(flightDestination).click();
		// /html/body/div[2]/div[3]/div[1]/div[5]/div[1]/div[3]/div/div/form/div[2]/div[2]/div[3]/div[2]/ul/li[2]/a
		driver.findElement(flightDestination).sendKeys(destination);
	}

	public void clickFlightDeparture() throws InterruptedException {
		Thread.sleep(500L);
		WebElement element = driver.findElement(departingFrom);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// driver.findElement(departingFrom).click();
	}

	public void selectDestinationfrmPopUp(String destination) {

		try {
			tpage.getAllDestinations(destination);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destination(String value) {
		driver.findElement(destinationtextBox).sendKeys(value);
	}

	public void waitforElementPresent(String element) {
		tpage.waitforElementPresent(element);
	}

	public HolidayExtrasPage NavigatetoHolidayExtras() {
		log.debug("Click for Holiday Extras link");
		driver.findElement(holidayExtras).click();
		return new HolidayExtrasPage(driver);
	}

	public AToZDestinationPage NavigateToAToZDestinations() {
		log.debug("Click for A toZ destination  link");
		driver.findElement(aToZDestinations).click();
		return new AToZDestinationPage(driver);
	}

	public FAQPage NavigateToFAQ() {
		log.debug("Click for FAQ link");
		driver.findElement(FAQ).click();
		return new FAQPage(driver);
	}

	public GroupsPage NavigateToGroups() {
		log.debug("Click for Groups link");
		driver.findElement(groups).click();
		return new GroupsPage(driver);
	}

	public MyAccountPage NavigateToMyAccount() {
		log.debug("Click for MyAccount link");
		driver.findElement(myAccount).click();
		return new MyAccountPage(driver);
	}

	public void getAllUSPBlocks() {
		// WebElement divs =
		// driver.findElement(By.xpath("//*[@class='uspBlock AlphaRoomsUK']"));
		for (int i = 0; i <= 4; i++) {
			List<WebElement> items = driver
					.findElements(By
							.xpath("//*[@class='uspBlock AlphaRoomsUK']/ul/li/div/span["
									+ i + "]"));
			for (WebElement options : items) {
				String itemtext = options.getText();
				System.out.println("this is with get text : " + itemtext);

			}
			break;
		}

	}

	public WebElement getAllTrcustedBrandsofAlpha(String logotext) {

		WebElement ele = driver.findElement(allLogo);
		List<WebElement> brand = ele.findElements(By.tagName("img"));
		for (WebElement options : brand) {
			String img = options.getAttribute("alt");
			if (img.contains(logotext)) {
				log.info("Images are displayed");
			}

		}
		return ele;

	}

	public WebElement getGoogleLogo() {
		return driver.findElement(googleLogo);
	}

	public WebElement getttaLogo() {
		return driver.findElement(ttaLogo);
	}

	public WebElement getatolLogo() {

		return driver.findElement(atollogo);
	}

	public WebElement getTrustPilotLogo() {
		return driver.findElement(trustPilologo);
	}

	public WebElement getReviewCenterLogo() {
		return driver.findElement(reviewCenterLogo);
	}

	public WebElement getfeefoLogo() {
		return driver.findElement(feefoLogo);
	}

	public WebElement getNortonLogo() {
		return driver.findElement(nortonLogo);
	}

	public WebElement get1FoundDepositUSPBlock() {

		return driver.findElement(oneFoundDepositsection);

	}

	public WebElement getFlexiblePayments() {

		return driver.findElement(flexiblePayments);

	}

	public WebElement getLowestPriceGuranty() {

		return driver.findElement(LowestPriceGurantee);

	}

	public void selectFromDate(String day, String month, String year)
			throws InterruptedException {
		// TODO Auto-generated method stub
		tpage.dateSelection(day, month, year);
	}

	public void selectNumberOfNights(String nights) {
		try {
			tpage.setNumberOfNights(nights);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setAdultCount(String Adult) {
		tpage.selectAdultS(Adult);
	}

	public void clickDoneButton() {
		driver.findElement(doneBtn).click();
	}

	public AccommodationresultsPage clickSearchButton() {
		driver.findElement(searchbtn).click();
		return new AccommodationresultsPage(driver);
	}

	public FlightResultsPage clickOnSearchButton() {
		driver.findElement(searchbtn).click();
		return new FlightResultsPage(driver);

	}

	public void getDepartureAirport(String departure) {
		tpage.getDepartureAirport(departure);
	}

	public void clickOnRoomsAndGuest() {
		try {
			Thread.sleep(1000);
			tpage.ClickOnRoomAndGuests();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
