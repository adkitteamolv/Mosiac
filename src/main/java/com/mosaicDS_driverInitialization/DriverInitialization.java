package com.mosaicDS_driverInitialization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mosaicDs_utils.Readproperties;


public class DriverInitialization {

	public static WebDriver driver;
	public static WebDriver driverInitialization(){
		
		System.setProperty(Readproperties.readProperty().getProperty("DRIVER"),Readproperties.readProperty().getProperty("DRIVER_PATH"));
		 
		 driver=new ChromeDriver();
		 driver.get(Readproperties.readProperty().getProperty("SIGNINURL"));
		 //driver.manage().window().maximize();
		 
		 return driver;
		 		
	}
}
