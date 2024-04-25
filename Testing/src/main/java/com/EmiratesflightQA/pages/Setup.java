package com.EmiratesflightQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Setup {
	
	WebDriver driver;
	
	@FindBy(xpath= "//button[@id='onetrust-accept-btn-handler']")
	private WebElement acceptCookie;
	
	@FindBy (xpath = "//div[@id='search-flight-departure']/following-sibling::button[1]")
	private WebElement clearSearchButton;
	
	public Setup (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnAcceptCookie() {
		acceptCookie.click();
	}
	public void clickOnclearButton() {
		clearSearchButton.click();
	}
}

