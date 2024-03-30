package Extra_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart_searchbar_suggestions {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		
	WebDriver driver = new ChromeDriver();
	driver.manage().window().minimize();
	driver.get("https://www.flipkart.com/");
	Thread.sleep(3000);
	
	String Expected_title = "flipkart";
	String Actual_Title = driver.getTitle();
	System.out.println(Actual_Title);
if (Expected_title.equalsIgnoreCase(Actual_Title)) {
	System.out.println("Title is Matching"+"     "+Expected_title);
}
else
	System.out.println("Title is not Matching"+"     "+Expected_title);
	

driver.quit();

    
		
		
		
		
		
		
		
	}

}
