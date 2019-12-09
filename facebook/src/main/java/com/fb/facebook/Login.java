package com.fb.facebook;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Login extends Browser{

	
	public Login() throws IOException {
		super();
		log=Logger.getLogger(Login.class);
	}
	
	By login=By.xpath(prop.getProperty("login_button"));
	By email=By.cssSelector(prop.getProperty("email_field"));
    By password=By.cssSelector(prop.getProperty("pass_field"));
    
    
    public void LoginScenario()
    {
    	enterEmail();
    	enterPassword();
    	clickLoginBtn();
    	
    }
    public void enterEmail()
    {
    	log.info("entering mail id:"+prop.getProperty("email_val"));
    	driver.findElement(email).sendKeys(prop.getProperty("email_val"));
    }
    public void enterPassword()
    {
    	log.info("entering password....");
    	driver.findElement(password).sendKeys(prop.getProperty("pass_val"));
    }
    public void clickLoginBtn()
    {
    	driver.findElement(login).click();
    	log.info("clicked on login button");
    }

}