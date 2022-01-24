package servicenow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends servicenowTestNg{
	@Test
	
	
	public void UpdateIncidentMain() throws InterruptedException
	{
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();				
		Thread.sleep(2000);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("INC0010047",Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		//driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.id("incident.urgency"));
		WebElement element = driver.findElement(By.id("incident.urgency"));
		Select urgency = new Select(element);
		urgency.selectByValue("1");
		
		WebElement urgText = urgency.getFirstSelectedOption();
	    String selectedOption = urgText.getText();
		
		WebElement element1=driver.findElement(By.id("incident.state"));
		Select state=new Select(element1);
		state.selectByValue("2");
		

		WebElement stateText = state.getFirstSelectedOption();
	    String selectedOption1 = stateText.getText();
		
	    if(selectedOption.contains("High"))
	    {
	    	System.out.println("Urgency updated to High");
	    }
		else
		{
			System.out.println("Urgency not updated to High");
		}
	
	    if(selectedOption1.contains("In Progress"))
	    {
	    	System.out.println("State changed to in progress");
	    }
	    else
	    {
	    	System.out.println("State not changed to in progress");
	    }
	driver.findElement(By.id("sysverb_update")).click();
}
}