package com.EmiratesflightQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFlightBomToDXB{
WebDriver driver;
	
	@FindBy(xpath= "//button[@name='clear Departure airport']/preceding-sibling::input[1]")
	private WebElement departureAirportSearch;
	
	@FindBy (xpath = "//p[text()='Indira Gandhi International Airport']")
	private WebElement departureDestination;
	
	@FindBy (xpath = "//div[@id='search-flight-arrival']/preceding-sibling::input[1]")
	private WebElement ArrivalAirportSearch;
	
	@FindBy (xpath = "//input[@class='checkbox__input js-flexible-dates']")
	private WebElement flexibleCheckbox;
	
	@FindBy (xpath = "//label[@class='checkbox one-way']")
	private WebElement oneWayCheckBox;
	
	@FindBy (xpath = "//button[@aria-label='Tuesday, 30  April 2024'][1]")
	private WebElement selectDate;
	
	@FindBy (xpath = "/button[@class='js-increment-increase increment-field__button increment-field__increase'][1]")
	private WebElement increasePassenger;
	
	@FindBy (xpath = "//button[@class='cta cta--large cta--primary js-widget-submit ']/child::span[1]")
	private WebElement searchFlight;
	
	public SearchFlightBomToDXB (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void DepartureAirportSearch() {
		departureAirportSearch.sendKeys("Mumbai");
	}
	public void ArrivalAirportSearch() {
		ArrivalAirportSearch.sendKeys("DXB");
	}
	public void clickOnflexibleCheckbox() {
		flexibleCheckbox.click();
	}
	public void clickOnoneWayCheckBox() {
		oneWayCheckBox.click();
	}
	public void clickOnselectDate() {
		selectDate.click();
	}
	public void clickOnincreasePassenger() {
		increasePassenger.click();
	}
	public void clickOnsearchFlight() {
		searchFlight.click();
	}
	
}