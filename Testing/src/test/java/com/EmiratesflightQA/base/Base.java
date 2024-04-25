package com.EmiratesflightQA.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.EmiratesflightQA.utilities.Utilities;

public class Base {
	WebDriver driver;
	public Properties  prop;
	public Properties dataProp;
		
	public void LoadPropertiesFile() {
		
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\\\src\\\\main\\\\java\\\\com\\\\EmiratesflightQA\\\\Config\\\\Config.properties");
		
		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\EmiratesflightQA\\testdata\\testdata.properties");
		
		try {
			FileInputStream datafis =new FileInputStream(dataPropFile);
			dataProp.load(datafis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		try {
			FileInputStream fis =new FileInputStream(propFile);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	public WebDriver inializeBrowserAndOpenApplicationURL() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.get(prop.getProperty("Url"));
		
		return driver;
	}
}
