package CrossBrowser_Tesing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Primusbank_Crossbrowser_Testing {
	WebDriver driver;

	@Parameters({"browser"})
	@BeforeTest
	public void beforeTest(String brw) {
		switch (brw) {
		case "chrome":
			driver=new ChromeDriver();

			break;

		case "firefox":
			driver=new FirefoxDriver();
			break;

		case "edge":
			driver=new EdgeDriver();
			break;

		default:
			break;
		}

	}

	@Test(dataProvider = "dp")
	public void Validate_PrimusLogin(String user, String password) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://primusbank.qedgetech.com/"); 
		driver.findElement(By.name("txtuId")).sendKeys(user);
		driver.findElement(By.name("txtPword")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		String expected = "adminflow";
		String actual = driver.getCurrentUrl();
		if(actual.contains(expected))
		{
			Reporter.log("Login Sucessfull"+"  "+expected+"   "+actual);
		}
		else
		{
			Reporter.log("Login fail"+"  "+expected+"   "+actual); 
		}
	}

	@DataProvider
	public Object[][] dp() {
		Object login[][]= new Object[5][2];
		login[0][0]= "Admin";
		login[0][1]= "Admin";
		login[1][0]= "Admi";
		login[1][1]= "Admin";  
		login[2][0]= "Admin";
		login[2][1]= "Admi";
		login[3][0]= "Admin";
		login[3][1]= "Admin12";
		return login;

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
