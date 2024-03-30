package Executable_Configuration;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Apputil_PrimusBank {
public static WebDriver driver;
@BeforeClass
public static void login() {
driver= new ChromeDriver();
driver.manage().window().maximize();
driver.get("http://primusbank.qedgetech.com/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.name("txtuId")).sendKeys("Admin");
driver.findElement(By.name("txtPword")).sendKeys("Admin");
driver.findElement(By.name("login")).click();
Reporter.log("Running Precondition",true);
}
@AfterClass
public static void tearoff()
{
driver.close();	
Reporter.log("Running Postcondition",true);
}
}
