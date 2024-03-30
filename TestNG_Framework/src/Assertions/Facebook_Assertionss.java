package Assertions;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Facebook_Assertionss {
	
	WebDriver driver;	
	@Test	
	public void Testfacebook() throws Throwable{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("email")).sendKeys("vgf",Keys.ENTER);
		
		SoftAssert softassert = new SoftAssert();
		
		//Title assertion
		String actualtext=driver.findElement(By.name("email")).getAttribute("value");
		String expectedTitle= "";
		softassert.assertEquals(actualtext, expectedTitle);
		System.out.println("Test is  mismatched");
		
		//boarder assertion
				String actualborder=driver.findElement(By.name("email")).getCssValue("border");
				String expectedborder= "0.8px solid rgb(240, 40, 73)";
				softassert.assertEquals(actualborder, expectedborder);
				System.out.println("Border is  mismatched");
				
		
		
		driver.quit();
		softassert.assertAll();
		
	
		
	}
}