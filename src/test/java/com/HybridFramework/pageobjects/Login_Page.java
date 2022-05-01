package com.HybridFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
public static WebDriver ldriver;
	
	
public Login_Page(WebDriver rdriver)

{

	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
	
}

 @FindBy(name = "userName")
 WebElement Uname;
 
 @FindBy(name="password")
 WebElement Pwrd;
 
 @FindBy(name="submit")
 WebElement Submt;
 
 @FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")
 WebElement signoff;
 
 public void SetUname(String UserName)
 {
	Uname.sendKeys(UserName); 
 }
 public void SetPwd(String Password)
 {
	 Pwrd.sendKeys(Password);
 }
 public void Setsubmit()
 {
	 Submt.click();
 }
 public void SetLogoff()
 
 {
	 signoff.click();
 }
 
 
}
 
 
 
	


