package QA.Testing;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.EmiratesflightQA.base.Base;
import com.EmiratesflightQA.pages.MakeABooking;
import com.EmiratesflightQA.pages.SearchFlightBomToDXB;
import com.EmiratesflightQA.pages.Setup;


public class SearchFlightForBombayToDubai extends Base {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		LoadPropertiesFile();
		driver = inializeBrowserAndOpenApplicationURL(); 
		Setup setup = new Setup(driver);
		setup.clickOnAcceptCookie();
		setup.clickOnclearButton();	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close(); 
	}
	
	@Test
	public void FirstDesinationWithOnePassAndEcoClass() {
		SearchFlightBomToDXB searchFlightBomToDXB = new SearchFlightBomToDXB(driver);
		searchFlightBomToDXB.DepartureAirportSearch();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		searchFlightBomToDXB.ArrivalAirportSearch();
		action.pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		searchFlightBomToDXB.clickOnflexibleCheckbox();
		searchFlightBomToDXB.clickOnoneWayCheckBox();
		searchFlightBomToDXB.clickOnselectDate();
		searchFlightBomToDXB.clickOnsearchFlight();
		String actualTitle = driver.getTitle();
		MakeABooking makeABooking =new MakeABooking(driver);
		Assert.assertEquals(actualTitle,makeABooking.MakeABookingTitle());
		
	}
}
