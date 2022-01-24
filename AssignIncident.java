package servicenow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AssignIncident extends servicenowTestNg{
	@Test
		public void assignIncidentmain() throws InterruptedException
		{
		driver.findElement(By.xpath("(//div[text()='Open'])")).click();	
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("INC0010047",Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		//driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Software",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		driver.switchTo().window(window.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Assigned group with software");
		Thread.sleep(2000);
		driver.findElement(By.id("sysverb_update")).click();
		Thread.sleep(3000);
		String assignedGroup = driver.findElement(By.xpath("//tbody[@class='list2_body']//td[10]")).getText();
		if(assignedGroup.equals("Software")) {
			System.out.println("Assigned group updated successfully -"+assignedGroup);
		}else {
			System.out.println("Assigned group is not updated -"+assignedGroup);
		}
		
		
		
		}

	
	

}
