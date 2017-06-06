package com.mosaicDs_pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.ByAngular;

public class Login {	
	   
	   public static final String login_duplicatesessionAlert = "//*[@id='app']/div[3]/div/div";
	   public static final String login_acceptDuplicatesessionAlert = "//*[@id='app']/div[3]/div/div/div[3]/button[1]";
	 
	   public By userName=ByAngular.model("emailId");
	   public By password=ByAngular.model("password");
	   public By submit=ByAngular.buttonText("Submit");
	   public By errorMessage=By.xpath("html/body/div[1]/div[3]/section/div/div[2]/div/div/form/fieldset/div[3]/span");
	
	   WebDriver driver;
	   
	   public Login(WebDriver driver){
			
			this.driver=driver;
		}
	   
	   public String pageTitle(){
		   return driver.getTitle();
	   }
   
	   public void clearTextBoxes(){
		   driver.findElement(userName).clear();
		   driver.findElement(password).clear();
	   }
	   
	   public boolean isPasswordDisplayed(){
		  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(password)); 
		  return driver.findElement(password).isDisplayed(); 
	   }
	   
	   public boolean isUserNameDisplayed(){
		    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(userName));
			return driver.findElement(userName).isDisplayed(); 
	   }
	   
	   public boolean isSubmitDisplayed(){
		   new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(submit));
		   return driver.findElement(submit).isDisplayed();
 	   }

	   public void enterLoginDetails(String user_Name,String passwd)
	   {
	     try
	     {
	      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(userName));
	      driver.findElement(userName).sendKeys(user_Name);
	      driver.findElement(password).sendKeys(passwd);
	     }catch (Exception e) {
	      System.out.println("Error msg is: " + e.getMessage());
	    }
	  }
	   
	   public void clickSignInButton(){
		   driver.findElement(submit).click();		   
	   }
	   
	   public boolean checkerrorOrAlert(){
		   if(driver.findElement(errorMessage).isDisplayed()){
			   	return true;		   
		   }else if(driver.findElement(By.xpath(login_duplicatesessionAlert)).isDisplayed()){
			   isAlertPresent();
			   return true;
		   }
		return false;		   
	   }
	   
	   public String errorMessageString(){
		   new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElementLocated(errorMessage, "The email or password you entered is incorrect."));
		   return driver.findElement(errorMessage).getText();
	   }
	    
	  public void isAlertPresent() {
	    try { 
	    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	 	if (driver.findElement(By.xpath(login_duplicatesessionAlert)).isDisplayed())
	    		{
		        	driver.findElement(By.xpath(login_acceptDuplicatesessionAlert)).click();
		        }
		    }
	    catch (Exception e) {
	      System.out.println("Error message is" +e.getMessage() );
	    }
	  }
}
