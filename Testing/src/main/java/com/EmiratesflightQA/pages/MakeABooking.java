package com.EmiratesflightQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakeABooking {
WebDriver driver;
	
	@FindBy(xpath= "//button[@id='onetrust-accept-btn-handler']")
	private WebElement acceptCookie;
	
	public MakeABooking (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String MakeABookingTitle() {
		String expectedTitle = "Search results | Make a booking | Emirates";
		return expectedTitle;
	}
}
