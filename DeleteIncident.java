package servicenow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class DeleteIncident extends servicenowTestNg{
	@Test
	public void deleteIncidentMain() throws InterruptedException
	{
		driver.findElement(By.xpath("(//div[text()='Open'])")).click();	
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("INC0010047",Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='sysverb_delete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ok_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys("INC0010047");
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(Keys.ENTER);	
		
		String text = driver.findElement(By.xpath("//tbody[@class='list2_body']//td")).getText();
		if(text.contains("No records to display")) {
			System.out.println("Incident deleted Successfully");
		}
		else {
			System.out.println("Incident cant be deleted");
		}
		
		
	}

}
