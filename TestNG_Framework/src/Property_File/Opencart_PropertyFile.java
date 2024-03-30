package Property_File;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Opencart_PropertyFile {

	Properties p;
	WebDriver driver;

	@BeforeTest
	public void setup() throws Throwable{
		p = new Properties();
		//Load file
		p.load(new FileInputStream("OpenCart.properties"));
		driver=new ChromeDriver();
		driver.get(p.getProperty("Url"));
		driver.manage().window().maximize();   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void validate_login() throws Throwable {
		driver.findElement(By.xpath(p.getProperty("ObjMyAccount"))).click();
		driver.findElement(By.xpath(p.getProperty("ObjRegister"))).click();
		driver.findElement(By.xpath(p.getProperty("Objfname"))).sendKeys(p.getProperty("Enterfname"));
		driver.findElement(By.xpath(p.getProperty("Objlname"))).sendKeys(p.getProperty("Enterlname"));
		driver.findElement(By.xpath(p.getProperty("ObjEmail"))).sendKeys(p.getProperty("EnterEmail"));
		driver.findElement(By.xpath(p.getProperty("Objpassword"))).sendKeys(p.getProperty("Enterpass"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		js.executeScript("document.querySelector(\"#input-newsletter-yes\").click()");
		Thread.sleep(2000);
		js.executeScript("document.querySelector(\"input[value='1'][name='agree']\").click()");
		Thread.sleep(2000);
		js.executeScript("document.querySelector(\"button[type='submit']\").click()");
		Thread.sleep(2000);
	}
	@AfterTest
	public void teardown() {
		driver.quit();

	}
}

