package servicenow;


import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class servicenowTestNg {
	
	public EdgeDriver driver;
 
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
		driver.get("https://dev82417.service-now.com/");
		driver.manage().window().maximize();
		 
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Tamil@1993");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("Incident",Keys.ENTER);
		
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
	  driver.close();
  }

}
