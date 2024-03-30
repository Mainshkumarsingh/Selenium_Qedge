package DataProvider_OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Validate_Orange_HRM {
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
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
