package PageAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddEmployeePage {

	WebDriver driver;
	public AddEmployeePage(WebDriver driver)
	{
		this.driver=driver;
	}
	//define repository
	@FindBy(xpath = "//b[normalize-space()='PIM']")
	WebElement clickPim;
	@FindBy(name ="btnAdd")
	WebElement clickAdd;
	@FindBy(name ="firstName")
	WebElement EnterFname;
	@FindBy(name ="middleName")
	WebElement EnterMname;
	@FindBy(name ="lastName")
	WebElement EnterLname;
	@FindBy(name="employeeId")
	WebElement BeforeEID;
	@FindBy(id="btnSave")
	WebElement clicksave;
	@FindBy(name ="personal[txtEmployeeId]")
	WebElement AfterEID;
	//method for employee
	public boolean addEmployee(String FirstName,String MiddleName,String LastName)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(this.clickPim).click().perform();
		ac.moveToElement(this.clickAdd).click().perform();
		this.EnterFname.sendKeys(FirstName);
		this.EnterMname.sendKeys(MiddleName);
		this.EnterLname.sendKeys(LastName);
		//capture eid
		String Exp_EID =this.BeforeEID.getAttribute("value");
		ac.moveToElement(this.clicksave).click().perform();
		//cvapture eid
		String Act_EID = this.AfterEID.getAttribute("value");
		if(Exp_EID.equals(Act_EID))
		{
			Reporter.log("Add Employee Success::"+Exp_EID+"     "+Act_EID,true);
			return true;
		}
		else
		{
			Reporter.log("Add Employee Fail::"+Exp_EID+"     "+Act_EID,true);
			return false;
		}
		
		
	}

}
