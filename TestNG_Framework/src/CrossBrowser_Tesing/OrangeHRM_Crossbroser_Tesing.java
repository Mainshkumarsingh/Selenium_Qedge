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

public class OrangeHRM_Crossbroser_Tesing {
	WebDriver driver;

	@Test(dataProvider = "dp")
	public void Validate_Orange_HRM_login(String User, String pass) {
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("txtUsername")).sendKeys(User); 
		driver.findElement(By.name("txtPassword")).sendKeys(pass);
		driver.findElement(By.name("Submit")).click();
		String expected= "dashboard";
		String actual = driver.getCurrentUrl();
	
		if(actual.contains(expected)) {
			Reporter.log("Login Sucessfull"+"   "+expected+"   "+actual);
		}
		else
		{
			Reporter.log("Login Failed"+"   "+expected+"   "+actual);
		}
	
	}
	@DataProvider
	public Object[][] dp() {
		Object login[][]= new Object[5][2];
		login[0][0]="Admin";
		login[0][1]="Qedge123!@#";
		login[1][0]="Admi";
		login[1][1]="Qedge123!@#";
		login[2][0]="Adminn";
		login[2][1]="Qedge123!@#";
		login[3][0]="Admin";
		login[3][1]="Qedge123!@";
		login[4][0]="Admin";
		login[4][1]="Qedge123!@#$";  
		return login;    
	}
	@Parameters({"Browser"})
	@BeforeTest
	public void setup(String brw) {
		switch (brw) {
		case "chrome":
			driver = new ChromeDriver();
			
			break;
		case "firefox":
			driver= new FirefoxDriver();
		break;
		case "edge":
			driver = new EdgeDriver();
			break;


		default:
			break;
		}	
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
