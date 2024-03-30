package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Login_To_Primus_Bank {

	public static void main(String[] args) throws Throwable {
	
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://primusbank.qedgetech.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtuId']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPword']")).sendKeys("Admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='admin_banker_master.aspx']//img")).click();
		driver.findElement(By.xpath("//input[@id='BtnNewBR']")).click();
		driver.findElement(By.xpath("//input[@id='txtbName']")).sendKeys("kondapur");
		driver.findElement(By.xpath("//input[@id='txtAdd1']")).sendKeys("shreeSaiEnclave");
		driver.findElement(By.xpath("//input[@id='txtadd3']")).sendKeys("roomnumber302");
		driver.findElement(By.xpath("//input[@id='txtZip']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='Txtadd2']")).sendKeys("galinumber2");
		driver.findElement(By.xpath("//input[@id='txtArea']")).sendKeys("hanumanNagar");
		// for selecting of list box
		
		
		
		 
		WebElement dropedown=driver.findElement(By.name("lst_counrtyU"));
		Select select = new Select(dropedown);
		select.selectByValue("INDIA");
		
		
		
		
		
		
		
		
		Thread.sleep(3000);
		
		
		
		
	}

}
