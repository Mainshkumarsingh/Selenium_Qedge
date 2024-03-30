package test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test_Google {

	@Test
	public void testGoogle() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Jwala Gupta",Keys.ENTER);
		System.out.println(driver.getTitle());	
		driver.quit();
	}
	@Test
	public void testFacebook() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("Jwala Gupta",Keys.ENTER);
		System.out.println(driver.getTitle());	
		driver.quit();
	}
}
