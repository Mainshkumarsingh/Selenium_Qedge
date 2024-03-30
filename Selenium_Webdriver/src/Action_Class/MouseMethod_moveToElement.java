package Action_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMethod_moveToElement {

	public static void main(String[] args) throws Throwable {
		// moveToElement();,click();
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		
		// press escape button
		Actions ac = new Actions(driver);
		ac.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(3000);
		// Move mouse to electronics items
		ac.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Electronics']"))).perform();
		Thread.sleep(3000);
		//move to baby&Kids
		ac.moveToElement(driver.findElement(By.xpath("(//*[@class='_3490ry'])[1]"))).click().perform();
		Thread.sleep(3000);
		// Move to Baby and Kinds
		ac.moveToElement(driver.findElement(By.xpath("(//*[@class='_2I9KP_'])[8]"))).perform();
		Thread.sleep(3000);
		// Move to mouse puzzle
		ac.moveToElement(driver.findElement(By.xpath("//*[@title='Puzzles']"))).click().perform();
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
	}

}
