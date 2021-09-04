package week4day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.amazon.in/");
		 String title=driver.getTitle();
		 System.out.println(title);
		 driver.manage().window().maximize();
		 
		 WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		 search.sendKeys("oneplus 9 pro" +Keys.ENTER);
		 Thread.sleep(3000);
		String lowestPrice= driver.findElement(By.xpath("//span[@class='a-price-whole'][1]")).getText();
		 System.out.println(lowestPrice);
		 
		 driver.findElement(By.xpath("//i[@class='a-icon a-icon-popover']")).click();
		 Thread.sleep(3000);
		 String rating= driver.findElement(By.xpath("(//span[@data-hook='acr-average-stars-rating-text'])")).getText();
		 System.out.println("overall rating==" +rating);
	
		 String FivestarPercentage= driver.findElement(By.xpath("//*[@id=\"histogramTable\"]/tbody/tr[1]/td[3]/span[2]/a")).getText();
		 System.out.println("5 star percentage==" +FivestarPercentage);
		 
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']")).click();
		 Set<String> windowhandleset1= driver.getWindowHandles();
		 List<String> windowhandlesList1=new ArrayList<String>(windowhandleset1);
		 
		 driver.switchTo().window(windowhandlesList1.get(1));
		 Thread.sleep(3000); 
	     driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	     Thread.sleep(3000); 
		 File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
			File file = new File("./snaps/incident.png");
			FileUtils.copyFile(screenshotAs, file);	
		 driver.switchTo().window(windowhandlesList1.get(0));
		 
		 
		driver.close();
		 
}
}