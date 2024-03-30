package Inheritance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parent {
public static WebDriver driver;
public static void launchurl(String url) {
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get(url);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
}

public static void login(String username,String password) {
driver.findElement(By.name("txtuId")).sendKeys(username);
driver.findElement(By.name("txtPword")).sendKeys(password);
driver.findElement(By.name("login")).click();
}

}


