package Config;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class App_Util {

		public static WebDriver driver;
		public static Properties conpro;
		@BeforeTest
		public static void SetUp()throws Throwable
		{
			conpro= new Properties();
			conpro.load(new FileInputStream("./PropertyFile/Environment.properties"));
			if(conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
			else if(conpro.getProperty("Browser").equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("Browser Value is Not matching");
			}
		}
		@AfterTest
		public static void tearDown()
		{
			driver.quit();
		}
	
}

