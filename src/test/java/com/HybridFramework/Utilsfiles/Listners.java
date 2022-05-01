package com.HybridFramework.Utilsfiles;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listners extends TestListenerAdapter {

	

        

        public ExtentSparkReporter spark;

        public ExtentReports extent;

        public ExtentTest test;

       

        public void onStart(ITestContext TestContest)

        {

                   spark = new ExtentSparkReporter("target/spark listeners.html");

                   extent = new ExtentReports();

                   extent.attachReporter(spark);

                  

                   extent.setSystemInfo("Host Name", "Local Host");

                   extent.setSystemInfo("Environment", "QA");

                   extent.setSystemInfo("User", "Sreeni");

                  

                   spark.config().getTimeStampFormat();

                   spark.config().setTheme(Theme.DARK);

                   spark.config().setDocumentTitle("Automation Reports");

                   spark.config().setReportName("Test Reports Summary");

                  

                   /*final File conf = new File("extentconfig.xml");

                   try {

                              spark.loadXMLConfig(conf);

                   } catch (IOException e) {

                              // TODO Auto-generated catch block

                              e.printStackTrace();

                   } */

                  

        }

       

        public void onTestSuccess(ITestResult tr)

        {

                   test = extent.createTest(tr.getName());

                   test.log(Status.PASS, MarkupHelper.createLabel(tr.getTestName(),ExtentColor.GREEN));

        }

       

        public void onTestFailure(ITestResult tr)

        {

                   test =extent.createTest(tr.getName()); // create new entry in the report

                   test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted

                  

                   String screenshotPath=".//target/"+tr.getName()+".png";

                  

                   File f = new File(screenshotPath);

                  

                   if(f.exists())

                   {

                   test.fail("Screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));

                   }

                  

        }

       

        public void onTestSkipped(ITestResult tr)

        {

                   test =extent.createTest(tr.getName()); // create new entry in th report

                   test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));

        }

       

        public void onFinish(ITestContext testContext)

        {

                   extent.flush();
}
        
}
