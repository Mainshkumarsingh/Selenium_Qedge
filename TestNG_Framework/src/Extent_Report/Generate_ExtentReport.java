package Extent_Report;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Generate_ExtentReport {

	WebDriver driver;
	ExtentReports reports;
	ExtentTest logger;
	@BeforeTest
	public void generateReport()
	{
		//define path of html
		reports = new ExtentReports("./test-output/Reports/Demo.html");
	}
	@BeforeMethod
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
	}
	@Test
	public void testPass()
	{
		//test case starts here
		logger = reports.startTest("Pass test Case");
		logger.assignAuthor("Ranga");
		logger.assignCategory("Functional");
		String Expected_title ="Google";
		String Actual_Title = driver.getTitle();
		if(Expected_title.equalsIgnoreCase(Actual_Title))
		{
			logger.log(LogStatus.PASS,Expected_title+"   "+ Actual_Title+"  "+"Title is matching");
		}
		else
		{
			logger.log(LogStatus.FAIL,Expected_title+"   "+ Actual_Title+"  "+"Title is not matching");
		}
	}
	@Test
	public void testfail()
	{
		//test case starts here
		logger = reports.startTest("Fail test Case");
		logger.assignAuthor("Ranga");
		logger.assignCategory("Functional");
		String Expected_title ="yahoo";
		String Actual_Title = driver.getTitle();
		if(Expected_title.equalsIgnoreCase(Actual_Title))
		{
			logger.log(LogStatus.PASS,Expected_title+"   "+ Actual_Title+"  "+"Title is matching");
		}
		else
		{
			logger.log(LogStatus.FAIL,Expected_title+"   "+ Actual_Title+"  "+"Title is not matching");
		}
	}
	@AfterMethod
	public void tearDown()
	{
		reports.endTest(logger);
		reports.flush();
		driver.quit();
	
	}
}
