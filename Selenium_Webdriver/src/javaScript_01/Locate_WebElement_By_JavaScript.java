package javaScript_01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Locate_WebElement_By_JavaScript {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.location='https://eprisons.nic.in/public/MyVisitRegistration'");

// Locate webElemnt by Java Script
		js.executeScript("document.getElementById('ContentPlaceHolder1_txtVisitorName').value='Jwala Gupta'");
		js.executeScript("document.getElementById('ContentPlaceHolder1_txtVisitorFatherName').value='Jagat Sah'");
		js.executeScript("document.getElementById('ContentPlaceHolder1_txtVisitorAddress').value='Patna'");
		
		driver.findElement(By.xpath("(//div[@class='chosen-container chosen-container-single'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='chosen-container chosen-container-single']"));
	
				
		
	}

}
