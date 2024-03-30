package Conditional_Methods;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Collections_of_RadioButtons {
public static void main(String[] args) throws Throwable {
	//collection of all radio buttons
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("http://flights.qedgetech.com/");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@type='email']")).sendKeys("pranga82@gmail.com");
	driver.findElement(By.xpath("//*[@type='password']")).sendKeys("ranga123");
	driver.findElement(By.xpath("//*[@type='submit']")).click();
	Thread.sleep(2000);
	
	//Get collections of Radio_buttons
	List<WebElement>radio_button = driver.findElements(By.xpath("//*[@class='radio_b']"));
	System.out.println("No of Radio buttons are     "+radio_button.size());
	for (WebElement each : radio_button) {
		String eachbuttonsnames = each.getText();
		System.out.println(eachbuttonsnames);}
	driver.quit();
	
}
}
