package Handlying_iFrame;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_Drop_By_XY_Coordinates {

	public static void main(String[] args) throws Throwable {
		// Drag_Drop_By_XY_Using_Coordinates as a locator

	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://jqueryui.com/droppable/");
	Thread.sleep(3000);

	List<WebElement> all_frames = driver.findElements(By.tagName("div"));
	System.out.println(all_frames.size());
	
	//Switch Frame
	driver.switchTo().frame(0);
	
// create Action class intanse Object
	Actions ac = new Actions(driver);

WebElement source = driver.findElement(By.id("draggable"));
WebElement target = driver.findElement(By.id("droppable"));
int x = target.getLocation().getX();
int y = target.getLocation().getY();

System.out.println(x+"   "+y);
ac.dragAndDropBy(source, x, y).perform();




	
	
	
	}

}
