package com.fb.facebook;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUp extends Browser{
	
	
	public SignUp() throws IOException {
		super();
		log=Logger.getLogger(SignUp.class);
	}

	
	By fname=By.xpath(prop.getProperty("firstname_field"));
	By lname=By.xpath(prop.getProperty("lastname_field"));
	By email=By.xpath(prop.getProperty("register_email_field"));
	By confirm_email=By.cssSelector(prop.getProperty("re-enter_email"));
	By password=By.xpath(prop.getProperty("register_pass_field"));
	By submit=By.xpath(prop.getProperty("submit"));
	
	
	public void SignUpScenario()
	{
	  enterFirstname();
	  enterLastname();
	  enterEmail();
	  enterPassword();
	  enterDOB();
	  selectGender();
	  clickSubmit();
	  
	}
	
	public void enterFirstname() {
		log.info("entering first name:"+prop.getProperty("firstname_field_val"));
		driver.findElement(fname).sendKeys(prop.getProperty("firstname_field_val"));
		
	}
	public void enterLastname() {
		log.info("entering last name:"+prop.getProperty("lastname_field_val"));
		driver.findElement(lname).sendKeys(prop.getProperty("lastname_field_val"));
		
	}
	public void enterEmail() {	
		log.info("entering email id:"+prop.getProperty("email_val"));
		driver.findElement(email).sendKeys(prop.getProperty("email_val"));
		
		//re-enter email
		driver.findElement(confirm_email).click();
		driver.findElement(confirm_email).sendKeys(prop.getProperty("email_val"));
	}
	
	public void enterPassword() {
		log.info("entering password.....");
		driver.findElement(password).sendKeys(prop.getProperty("pass_val"));
		
	}
	public void clickSubmit()
	{
		driver.findElement(submit).click();
		log.info("clicked on sign up button");
	}
	
    public void enterDOB()
	{
    	Select day = new Select(driver.findElement(By.id("day")));
    	day.selectByVisibleText(prop.getProperty("day"));
    	Select month = new Select(driver.findElement(By.id("month")));
        month.selectByVisibleText(prop.getProperty("month"));
    	Select year = new Select(driver.findElement(By.id("year")));
    	year.selectByVisibleText(prop.getProperty("year"));
    	
		
	}
    void selectGender()
	{
       WebElement female=driver.findElement(By.xpath(prop.getProperty("female")));
  	   female.click();
  	   WebElement male=driver.findElement(By.xpath(prop.getProperty("male")));
 	   male.click();
 	   WebElement custom=driver.findElement(By.xpath(prop.getProperty("custom")));
	   male.click();
	   if(female.getText().equals(prop.getProperty("gender_val")))
 	   {
 		female.click();
 		log.info("selected gender..!!");
 	   }
	   
	   if(male.getText().equals(prop.getProperty("gender_val")))
 	   {
 		male.click();
 		log.info("selected gender..!!");
 	   }
	   if(custom.getText().equals(prop.getProperty("gender_val")))
 	   {
 		custom.click();
 		log.info("selected gender..!!");
 	   }
 	   
	}
}