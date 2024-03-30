package Select_List_Box;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelection_List_Box_deSelect_List_box {

	public static void main(String[] args) throws Throwable{
		// MultiSelection_List_Box_deSelect_List_box
		
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.navigate().to("file:///E:/Class%20Notes/MultiListboxHtmlpage_lyst3659.html");
	Thread.sleep(5000);
	Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='multiSelection']")));
	//Verify list box is single or multiple selection
	boolean value = dropdown.isMultiple();
	System.out.println(value);

	List<WebElement>alllist=dropdown.getOptions();
	for (WebElement eachlist : alllist) {
		System.out.println(eachlist.getText());
		if (eachlist.getText().equalsIgnoreCase("black")) {
			eachlist.click();
			break;
		}		
	}

	}
}
