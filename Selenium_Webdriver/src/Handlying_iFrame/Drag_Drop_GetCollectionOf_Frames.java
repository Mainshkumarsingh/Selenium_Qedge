package Handlying_iFrame;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_Drop_GetCollectionOf_Frames {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(5000);
		Actions ac = new Actions(driver);
	
		// Get Collection of frames in web page
		List<WebElement> all_frames = driver.findElements(By.tagName("iframe"));
		System.out.println("No of all frames"+"    "+all_frames.size());

		// switch to frame
		driver.switchTo().frame(0);
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target  = driver.findElement(By.xpath("//div[@id='droppable']"));
		ac.clickAndHold(source).moveToElement(target).release().perform();
		
		// Switch to main html page
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		// Move mouse to button link and click over there
		ac.moveToElement(driver.findElement(By.linkText("Button"))).click().perform();
		System.out.println(driver.getTitle());
		driver.quit();
		

		
		
	}

}
