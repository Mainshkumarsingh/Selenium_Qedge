package Select_List_Box;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Get_Collection_of_items_in_list_box_using_Amazon {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("http:/amazon.in");
		Thread.sleep(1000);
		
	Select alldropdown= new Select(driver.findElement(By.id("searchDropdownBox")));
	List<WebElement>alllist = alldropdown.getOptions();
	System.out.println(alllist.size());
	
	for (WebElement listname : alllist) {
		System.out.println(listname.getText());
		if(listname.getText().equalsIgnoreCase("Baby"))
		{
			listname.click();
		break;
			
		}
		 }
	      }
	       }
		
	
	

	


		
	


