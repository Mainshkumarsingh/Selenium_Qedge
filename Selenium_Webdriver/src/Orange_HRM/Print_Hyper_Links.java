package Orange_HRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Print_Hyper_Links {

	public static void main(String[] args) throws Throwable {
		// write a script to print collection of hyper links in a web page(punjab national bank) and print 
		// name of each and every hyperlinks which is visible by using  .get(text) 
		// method and also print each and every hyperlinks url by using  .get(Attribute) method 
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://www.pnbindia.in/");
	Thread.sleep(5000);
	List<WebElement>all_links = driver.findElements(By.tagName("a"));
	System.out.println("No.Of allLinks are   "+all_links.size());
	for (WebElement each : all_links) {
		System.out.println(each.getText());
		System.out.println(each.getAttribute("href"));
	}
	Thread.sleep(5000);
	driver.quit();
	}
	}
