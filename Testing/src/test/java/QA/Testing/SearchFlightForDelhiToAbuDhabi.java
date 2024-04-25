package QA.Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.EmiratesflightQA.base.Base;
import com.EmiratesflightQA.pages.MakeABooking;
import com.EmiratesflightQA.pages.SearchFlightDelToAbu;
import com.EmiratesflightQA.pages.Setup;

public class SearchFlightForDelhiToAbuDhabi extends Base {

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
	
	@Test()
	public void SecondDesinationWithTwoPassAndPreEcoClass() {
		SearchFlightDelToAbu searchFlightDelToAbu =new SearchFlightDelToAbu(driver);
		searchFlightDelToAbu.DepartureAirportSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement departurePlace = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Indira Gandhi International Airport']")));
		departurePlace.click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		searchFlightDelToAbu.ArrivalAirportSearch();
		action.pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		searchFlightDelToAbu.clickOnflexibleCheckbox();
		searchFlightDelToAbu.clickOnoneWayCheckBox();
		searchFlightDelToAbu.clickOnselectDate();
		searchFlightDelToAbu.clickOnincreasePassenger();
		searchFlightDelToAbu.clickOnEcoClass();
		//driver.findElement(By.xpath("//label[text()='Class']/following-sibling::input[1]")).click();
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		searchFlightDelToAbu.clickOnsearchFlight();
		String actualTitle = driver.getTitle();
		MakeABooking makeABooking =new MakeABooking(driver);
		Assert.assertEquals(actualTitle,makeABooking.MakeABookingTitle());
		
	}
}
