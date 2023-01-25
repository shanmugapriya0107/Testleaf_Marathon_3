package marathon_3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Baseclass_Salesforce {
	public ChromeDriver driver;

	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url, String uName, String pWord) {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Login
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pWord);
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("(//div[@class='tooltipTrigger tooltip-trigger uiTooltip'])[6]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("(//input[@class='slds-input'])")).sendKeys("Content");
		driver.findElement(By.xpath("//mark[text()='Content']")).click();

	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	
	

}
