package Handle_Multi_Window;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_Specific_Tab_Window {

	public static void main(String[] args) throws Throwable {
		// Handle Specified tab window with get tab title
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://gmail.com");
		String page_title = driver.getTitle();
		System.out.println(page_title);
		Thread.sleep(5000);
		//Click on links like help,privacy and terms link to open in new tabs
		driver.findElement(By.linkText("Help")).click();
		driver.findElement(By.linkText("Privacy")).click();
		driver.findElement(By.linkText("Terms")).click();
		//store all windows into arraylist
		ArrayList<String> brw = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(brw);
		//switch to google account help window and click link
		driver.switchTo().window(brw.get(3));
		String page_title1 = driver.getTitle();
		System.out.println(page_title1);
		Thread.sleep(5000);
		//click link
				driver.findElement(By.linkText("Community"));
				String page_title2 = driver.getTitle();
				System.out.println(page_title2);
				Thread.sleep(5000);
				driver.close();
				////switch to privacy window and click link
				driver.switchTo().window(brw.get(2));
				String page_title3 = driver.getTitle();
				System.out.println(page_title3);
				driver.findElement(By.linkText("Technologies")).click();
				Thread.sleep(5000);
				driver.close();
				// Switch to Terms window and click link over
				driver.switchTo().window(brw.get(1));
				String page_title4 = driver.getTitle();
				System.out.println(page_title4);
				driver.findElement(By.linkText("FAQ"));
				Thread.sleep(3000);
				driver.close();
				//  Switch to parent window
				driver.switchTo().window(brw.get(0));
				String page_title5 = driver.getTitle();
				System.out.println(page_title5);
				driver.findElement(By.xpath("//span[normalize-space()='Create account']")).click();
				Thread.sleep(3000);
				driver.close();
				
				
				
	}

}
