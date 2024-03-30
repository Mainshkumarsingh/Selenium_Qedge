package javaScript_01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll_To_ParticularElement_inWebPage_Click_Action {

	public static void main(String[] args) throws Throwable {
		// Scroll_To_ParticularElement_in WebPage and Click_Action

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.location='https://www.snapdeal.com/'");
		System.out.println(driver.getTitle());
		//store Gmail link into webelment 
		WebElement tamperedbutton = driver.findElement(By.xpath("//a[normalize-space()='Tempered Glass']"));

		// Scroll down to tampered link 
		js.executeScript("window.scrollBy",tamperedbutton);
		//js.executeScript("window.scrollTo",tamperedbutton);
		//js.executeScript("document.scrollIntoview",tamperedbutton);     
		Thread.sleep(3000);

		tamperedbutton.click();
		System.out.println(driver.getTitle());
		driver.quit();	
	}

}
