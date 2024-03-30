package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_To_Facebook {

	public static void main(String[] args) throws Throwable {
		// Create a Instance Object
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("jolly266");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("bhfbry1565");
		driver.findElement(By.name("Log in")).click();
		
		
		

		
		
		
		
	}

}
