package marathon_3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testcase_2_Salesforce_TestNG extends Baseclass_Salesforce {

	@Test(dataProvider = "fetchOpportunity")
	public void salesforceTestNG_2(String name, String amount) throws IOException, InterruptedException {
		
		WebElement findElement = driver.findElement(By.xpath("(//span[@class='viewAllLabel'])[4]"));
		Actions builder1 = new Actions(driver);
		builder1.scrollToElement(findElement).perform();
		driver.findElement(By.xpath("//a[@class='filterIcon slds-button slds-button--icon-more ']")).click();
		driver.findElement(By.xpath("//a[text()='Recent Opportunities']")).click();
		
		driver.findElement(By.xpath("(//span[@class='viewAllLabel'])[4]")).click();
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys(name);
		driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='New Customer']")).click();
		WebElement findElement2 = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]"));
		driver.executeScript("arguments[0].click();", findElement2);
		
		driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys(amount);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("2/20/2023");
		driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]")).click();
		driver.findElement(By.xpath("(//span[@title='Needs Analysis'])")).click();
		WebElement findElement3 = driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input'])[2]"));
		driver.executeScript("arguments[0].click();", findElement3);
		driver.findElement(By.xpath("(//span[@title='test'])")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		Thread.sleep(3000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/Salesforce_opportunity.png");
		FileUtils.copyFile(source, target);

	}
	@DataProvider(name="fetchOpportunity")
	public String[][] name_amount() throws IOException
	{
		String[][] opportunityData = ReadExcelData_Salesforce_Opportunity.opportunityData();
		return opportunityData;

}
}

