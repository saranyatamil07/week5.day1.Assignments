package testcase1;


	import org.openqa.selenium.By;
	import org.testng.annotations.Test;

	public class CreatLead1 extends NewBaseClass{
		@Test
		public void createLeadMain()
		{
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Saranya");
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Tamil");
			driver.findElement(By.name("submitButton")).click();
	}


}
