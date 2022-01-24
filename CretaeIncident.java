package servicenow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CretaeIncident extends servicenowTestNg{
	@Test
	public void CretaeIncidentMain() throws InterruptedException
	{
		
		driver.findElement(By.xpath("((//div[text()='All'])[2])/ancestor::a")).click();
		Thread.sleep(3000);
		
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> windows=new ArrayList<String>(windowHandles);	
		
		driver.switchTo().window(windows.get(1));
		
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		driver.switchTo().window(windows.get(0));
		driver.switchTo().frame("gsft_main");
		
	
		driver.findElement(By.id("lookup.incident.short_description")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> window2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(window2.get(1));
		
		driver.findElement(By.linkText("Issue with a web page")).click();
		//driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/td[3]/a")).click();
		driver.switchTo().window(window2.get(0));
		driver.switchTo().frame("gsft_main");
		
		//incident storing in variable
		String incnum=driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incnum);
		
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incnum);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		String incnum1=driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/td[3]/a")).getText();
		System.out.println(incnum1);

		if (incnum1.equals(incnum)) {

			System.out.println("Incident created successfully");

		} else {

			System.out.println("No incident found");

		}

	}}
