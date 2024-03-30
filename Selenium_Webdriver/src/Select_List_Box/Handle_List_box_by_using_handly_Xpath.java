package Select_List_Box;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_List_box_by_using_handly_Xpath {

	public static void main(String[] args) throws Throwable {
		// Handle_List_box_by_using_handly_Xpath in spotify
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://open.spotify.com/");
		String page_title = driver.getTitle();
		System.out.println("Page Title is "+"   "+page_title);
		Thread.sleep(5000);
		
		
		

	}

}
