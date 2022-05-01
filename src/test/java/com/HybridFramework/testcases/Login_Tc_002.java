package com.HybridFramework.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HybridFramework.pageobjects.Login_Page;

public class Login_Tc_002 extends BaseClass {

		//public WebDriver driver;
		
		@Test
		public void Login() throws IOException 
		{
			driver.get(URL);
			driver.manage().window().maximize();
		
			
		Login_Page LP = new Login_Page(driver);
		
		LP.SetUname(Uname);
		LP.SetPwd(Pname);
		LP.Setsubmit();
		if(driver.getTitle().equals("Login: Mercury Tours1"))
		{
			Assert.assertTrue(true);
				
		}
		else
		{
			Assert.assertTrue(false);
			captureScreen(driver,"Login_Tc_002");
			
		}
		LP.SetLogoff();
		
		}   
		
	}

