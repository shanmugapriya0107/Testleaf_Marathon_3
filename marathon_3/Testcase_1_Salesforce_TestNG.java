package marathon_3;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class Testcase_1_Salesforce_TestNG extends Baseclass_Salesforce {

	@Test(dataProvider="fetchData")
	public void salesforceTestNG_1(String question, String details) throws InterruptedException, IOException {
		
		WebElement findElement = driver.findElement(By.xpath("//span[text()='Chatter']"));
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();", findElement);
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("(//span[@class='title'])[3]")).click();
		
		driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(question);
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow']")).sendKeys(details);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand cuf-publisherShareButton qe-questionPostDesktop MEDIUM']")).click();
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/Salesforce_question.png");
		FileUtils.copyFile(source, target);

		
	}
	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException
	{
		
		return ReadExcelData_Salesforce_Question.readData();
	}

	

}

