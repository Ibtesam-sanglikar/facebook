package com.fb.facebook;
import org.testng.annotations.Test;
import verify.Screenshot;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestSignUp extends Browser{
   
	public TestSignUp() throws IOException {

	}
	
	//object creation
	
	SignUp s=new SignUp();
	@BeforeTest
	public void initialize() throws IOException
	{
		log.info("executing test case for signup page.....");
		s.launchBrowser();
		s.Maximize(driver);
	}
	
	@Test
	public void runtest() throws IOException
	{
		
		s.SignUpScenario();
		
	}
	@AfterMethod
	  public void screen_shot() throws IOException
	  {
		  
		  //capturing screenshot
		   log.info("taking screenshot of: "+s.getClass());
	       Screenshot.CaptureScreenshot(driver,"SignUp");
	}
	
	@AfterTest
	public void close() {
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		s.Quit(driver);
	}
	
    
}