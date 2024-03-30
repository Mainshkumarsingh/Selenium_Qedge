package javaScript_01;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll_TopToBottom_toCertain_Pixel {

	public static void main(String[] args) throws Throwable {
		// Scroll top to bottom,Bottom to TOp,scroll to certain pixel.
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.location='https://amazon.in'");
		Thread.sleep(3000);
		
		//Scroll top to bottom Vertically
		js.executeScript("window.scrollTo(0,document.body.scrollHight)");
		Thread.sleep(3000);
		
		// scroll Bottom to top vertically
		js.executeScript("window.scrollTo(document.body.scrollHight,0)");
		Thread.sleep(3000);
		
		// Scroll vertically to certain pixel
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		driver.quit();
		
		

	}

}
