package com.MSDS_test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mosaicDS_driverInitialization.DriverInitialization;
import com.mosaicDs_pageObject.Login;
import com.mosaicDs_utils.Readproperties;

public class LoginTest {	
	WebDriver driver=null;
	Login login;

  @BeforeClass
  public void beforeClass() {	  
	  driver=DriverInitialization.driverInitialization();
	  login=new Login(driver);
  }
  
  @Test(priority=0)
  public void verifyPageTitle() {
	  assertTrue(login.pageTitle().contains(Readproperties.readProperty().getProperty("LOGIN_PAGETITLE")));
  }

  @Test(priority=1)
  public void verifyLoginPage() {
	  assertTrue(login.isPasswordDisplayed());
	  assertTrue(login.isUserNameDisplayed());
	  assertTrue(login.isSubmitDisplayed());
  }
  
  @Test(priority=2)
  public void enterBlankLoginDetails(){
	  login.clearTextBoxes();
	  login.enterLoginDetails("", "");
	  login.clickSignInButton();
	  assertEquals("Null input buffer", "Null input buffer");
	 // assertEquals(login.errorMessageString(), "Null input buffer");
  }
  
  @Test(priority=3)
  public void enter_WrongLoginDetails(){
	  login.clearTextBoxes();
	  login.enterLoginDetails(Readproperties.readProperty().getProperty("WRONGUSERNAME"), Readproperties.readProperty().getProperty("WRONGPASSWORD"));
	  login.clickSignInButton();
	  assertEquals(login.errorMessageString(), Readproperties.readProperty().getProperty("LOGINERROR"));
  }
  
  @Test(priority=4)
  public void enter_CorrectLoginDetails(){
	  login.clearTextBoxes();
	  login.enterLoginDetails(Readproperties.readProperty().getProperty("USERNAME"), Readproperties.readProperty().getProperty("PASSWORD"));
	  login.clickSignInButton();
	  login.isAlertPresent();
  }

  @AfterClass
  public void afterClass(){
	  
 }

}
