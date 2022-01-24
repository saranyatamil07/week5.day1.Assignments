package attributes;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGAttributes {
	@Test(priority=0)
	public void createlead()
	{
		System.out.println("A new Lead has been created");
	}
	@Test(priority=2)
	public void deleteLead()
	{
		System.out.println("Lead has been deleted");
	}
	@Test(priority=1)
	public void editLead()
	{
		System.out.println("Lead has been edited");
	}
	@Test(priority=3,dependsOnMethods="deleteLead",alwaysRun=true)
	public void mergeLead()
	{
		System.out.println("2 Lead has been merged");
	}
	@Test(priority=4,invocationCount=2,threadPoolSize=2)
	public void strat()
	{
		 WebDriverManager.edgedriver().setup();
		 EdgeDriver driver=new EdgeDriver();
		driver.get("https://dev82417.service-now.com/");
		driver.manage().window().maximize();
		driver.close();
	}

}
