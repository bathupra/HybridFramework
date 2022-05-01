package com.HybridFramework.Utilsfiles;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	
	{
	  File Source = new File("./Configuration/config.properties");
	  
	  try
	  {
		  FileInputStream Fyi = new FileInputStream(Source);
		  pro = new Properties();
		  pro.load(Fyi);
	  }
	  catch (Exception e) {
		  
		  System.out.println("Exception is "+ e.getMessage());
		  
	  }
	}
	 public String GetURL()
	 {
		String url = pro.getProperty("url");
		return url;
		
	}
	
	public String GetUsername()
	{
		String Uname = pro.getProperty("username");
		return Uname;
	}
	
	public String GetPassword()
	{
		String Pswd = pro.getProperty("password");
		return Pswd;
	}
	
	public String Getsubmit()
	{
		String submit = pro.getProperty("submit");
		   return submit;	
	}
	   
	public String Gettitle()
	{
		String Title = pro.getProperty("HomeTtl");
		return Title;
		
	}
	public String GetFlights()
	{
		String Flights = pro.getProperty("Flights");
		return Flights;
	}
	public String GetFlighttitle()
	{
		String FlightTtl = pro.getProperty("FlightsTtl");
		return FlightTtl;
		
	}
	public String Getlogoff()
	{
		String singoff = pro.getProperty("logoff");
		return singoff;
		
	}
	   
	}

