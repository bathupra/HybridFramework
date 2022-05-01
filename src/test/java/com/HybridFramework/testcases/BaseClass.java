package com.HybridFramework.testcases;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Parameters;

import com.HybridFramework.Utilsfiles.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig RC = new ReadConfig();
	public String URL= RC.GetURL();
	public String Uname = RC.GetUsername();
	public String Pname = RC.GetPassword();
	public String Submit = RC.Getsubmit();
	public String HomeTtl = RC.Gettitle();
	public String Flight = RC.GetFlights();
	public String FlightTtl = RC.GetFlighttitle();
	public String Logoff = RC.Getlogoff();
	
	
 public static WebDriver driver;
 
 @Parameters("browser")
 @BeforeClass
 
 /*public void Setup()
 {
	 WebDriverManager.chromedriver().setup();
	 //driver = new ChromeDriver();
 }*/
 
 public void Setup(String BR)
 {
	 if(BR.equals("Chrome"))
	 {
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 }
	 /*else if(BR.equals("FireFox"))
	 {
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	 }*/
	 else if(BR.equals("edge"))
	 {
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	 }
 }
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	 
	public static String RandomString() 
	{
		String RandomGeneratedString = RandomStringUtils.randomAlphabetic(5);
		return(RandomGeneratedString);	
		
	}
	public static void captureScreen(WebDriver driver, String tr) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(".//ScreenShots/" + tr + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}

