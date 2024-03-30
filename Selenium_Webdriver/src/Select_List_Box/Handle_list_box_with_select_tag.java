package Select_List_Box;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Handle_list_box_with_select_tag {

	public static void main(String[] args) {
	
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.opencart.com/index.php?route=account/register");
	
	Select countryelement = new Select(driver.findElement(By.id("input-country")));
	
	/*countryelement.selectByIndex(2);
	countryelement.selectByValue("5");
	countryelement.selectByVisibleText("Denmark")*/
	
	List<WebElement>countrylist = countryelement.getOptions();
	System.out.println(countrylist.size());

	for (WebElement countryname : countrylist) {

		if(countryname.getText().equalsIgnoreCase("INDIA"))
		{
			countryname.click();
			break;

		}

}
	
	
	

	}

}
