package test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Orange_HRM {

	WebDriver driver;
	@Test
	public void launchURL() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		
	}
	@Test
	public void hrmLogin() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}
	

	@Test
	public void validateLogin() throws Throwable {
		WebElement element = driver.findElement(By.id("pET75jh8"));
		Thread.sleep(3000);
		element.isDisplayed();
		System.out.println(element.isDisplayed());
		System.out.println(element.getText());
		driver.quit();
	}
	
	@Test
	public void nevigateToMyInfo() {
		driver.findElement(By.xpath("//*[@class='oxd-icon bi-chevron-left']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();
	}

	@Test
	public void validateMyInfo() {
		WebElement element =  driver.findElement(By.name("firstName"));
		element.isDisplayed();
		System.out.println(element.isDisplayed());
		System.out.println(element.getText());
		driver.quit();
	}

	
	
}

