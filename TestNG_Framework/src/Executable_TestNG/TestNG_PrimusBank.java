package Executable_TestNG;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Executable_Configuration.Apputil_PrimusBank;
 class TestNG_PrimusBank extends Apputil_PrimusBank{
	@Test(description ="Validating Branches" ,invocationCount = 5)
	public void branches()
	{
		driver.findElement(By.xpath("(//img)[5]")).click();
		Reporter.log("Executing Branches test",true);
	}}
 class TestNG_PrimusBank1 extends Apputil_PrimusBank{
	@Test(description ="Validating Roles" ,invocationCount = 5)
	public void roles()
	{
		driver.findElement(By.xpath("(//img)[6]")).click();
		Reporter.log("Executing roles test",true);
	}}
class TestNG_PrimusBank2 extends Apputil_PrimusBank{
	@Test(description ="Validating Userss" ,invocationCount = 5)
	public void users()
	{
		driver.findElement(By.xpath("(//img)[7]")).click();
		Reporter.log("Executing users test",true);
	}}
class TestNG_PrimusBank3 extends Apputil_PrimusBank{
	@Test(description ="Validating Employees" ,invocationCount = 5)
	public void employee()
	{
		driver.findElement(By.xpath("(//img)[8]")).click();
		Reporter.log("Executing employees test",true);
	}}


