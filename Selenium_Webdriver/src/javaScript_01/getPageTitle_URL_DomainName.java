package javaScript_01;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getPageTitle_URL_DomainName {

	public static void main(String[] args) throws Throwable {
		// Write Java Script to print Title,URl and DomainName along with name
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.manage().deleteAllCookies();

		// Create object for Java Script executor
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//Launch URl
		js.executeScript("window.location='https://www.tatacliq.com/'");
		Thread.sleep(3000);

		// print Title and length of title
		String pagetitle = js.executeScript("return document.title").toString();
		System.out.println("Page Title is"+"   "+pagetitle);
		System.out.println("Page Title Length is"+"   "+pagetitle.length());
		
		// print url and length of url
		String pageurl = js.executeScript("return document.URL").toString();
		System.out.println("Current URL is      "+"   "+pageurl);
		System.out.println("Current URL Length is "+"    "+pageurl.length());
		
		//print Domain and length of Domain
		String DomainName = js.executeScript("return document.domain").toString();
		System.out.println("Domain name is"+"    "+DomainName);
		System.out.println("Domain name Length is"+"    "+DomainName.length());
		driver.quit();
		
		
		
		

	}

}
