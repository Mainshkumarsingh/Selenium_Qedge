package Handlying_Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Verify_LoginFunctionality_with_Multiple_Data {

	public static void main(String[] args) throws Throwable{
		//Read Path of file
		FileReader fr = new FileReader("E:\\Class Notes/Orange HRM Login Validate Data.txt");
		BufferedReader br = new BufferedReader(fr);
		String str = " ";
		
		while ((str=br.readLine())!=null) {
		
			// Split notepad data in array
			String login[]=str.split(";");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
			WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//Thread.sleep(1000);
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("txtUsername")));
			driver.findElement(By.name("txtUsername")).sendKeys(login[0]);
			driver.findElement(By.name("txtPassword")).sendKeys(login[1]);
			driver.findElement(By.name("Submit")).click();

			String expected = "dashboard";
			String actual = driver.getCurrentUrl();
			if (actual.contains(expected)) {
				System.out.println("Login sucessfull"+"   "+expected+actual);
			}
		else {

			String error_massage = driver.findElement(By.id("spanMessage")).getText();
			System.out.println(error_massage+expected+actual);
		}
			br.close();
			driver.quit();			
	}
		
}

}
