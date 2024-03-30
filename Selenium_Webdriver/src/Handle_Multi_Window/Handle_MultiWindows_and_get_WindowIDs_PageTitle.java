package Handle_Multi_Window;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_MultiWindows_and_get_WindowIDs_PageTitle {

	public static void main(String[] args) throws Throwable {
		// Handle_MultiWindows_and_get_WindowIDs_PageTitle
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://gmail.com");
		String page_title = driver.getTitle();
		System.out.println("Page Title Name is "+page_title);
		Thread.sleep(5000);
		//print parent window id
		String parent =driver.getWindowHandle();
		System.out.println(parent);
		//click on links like help,privacy and terms link to open in new tabs
		driver.findElement(By.linkText("Help")).click();
		driver.findElement(By.linkText("Privacy")).click();
		driver.findElement(By.linkText("Terms")).click();
		//get collection of all window IDs
		Set<String> allwins = driver.getWindowHandles();
		System.out.println(allwins);
		//iterate all windows
		for (String each : allwins) {
			//parent id should not be equal to child id
			if(!parent.equals(each))   
			{
				//switch to each child window get title and close
				Thread.sleep(5000);
				String pagetitle = driver.switchTo().window(each).getTitle();
				System.out.println(pagetitle);
				Thread.sleep(5000);
				driver.close();
				
				
			}
		}
		//switch back to parent
		Thread.sleep(5000);
		driver.switchTo().window(parent);
		driver.findElement(By.id("identifierId")).sendKeys("pranga2010@gmail.com");
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
	}

}
