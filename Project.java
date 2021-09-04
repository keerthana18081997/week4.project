package week4day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Project {
	public static void main(String[] args) throws InterruptedException, IOException {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.myntra.com");
		 String title=driver.getTitle();
		 System.out.println(title);
		 driver.manage().window().maximize();
		 WebElement men=driver.findElement(By.xpath("//a[text()='Men']"));
		    Actions action=new Actions(driver);
		    action.moveToElement(men).perform();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		   String text= driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		   String replace= text.replaceAll("[^0-9]", "");
		    int count= Integer.parseInt(replace);
		    System.out.println(count);
		   
		   String text1= driver.findElement(By.xpath("(//span[@class='categories-num'])")).getText();
		   String replace1= text1.replaceAll("[^0-9]", "");
		    int count1= Integer.parseInt(replace1);
		    System.out.println(count1);
		    
		   String text2= driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		   String replace2= text2.replaceAll("[^0-9]", "");
		    int count2= Integer.parseInt(replace2);
		    System.out.println(count2);
		    
		    if(count==(count1+count2)) {
		    	System.out.println("jackets count matches");
		    }
		    else {
		    	System.out.println("jackets count not matches");
		    }
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("(//div[@class='brand-more'])")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("(//input[@class='FilterDirectory-searchInput'])")).sendKeys("Duke");
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[11]")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("(//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove'])")).click();
		    Thread.sleep(3000);
		    
		    List<WebElement> dukecount=driver.findElements(By.tagName("h3"));
		    for (int i = 0; i < dukecount.size(); i++) {
				String a=dukecount.get(i).getText();
				//System.out.println(a);
				if(a.equals("Duke")) {
					System.out.println("the current page has only duke brand clothes");
				}
				else {
					System.out.println("it have all brands clothes");
				}
			}
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("(//div[@class='sort-sortBy'])")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("(//label[@class='sort-label '])")).click();
		    Thread.sleep(3000);
		   String text3= driver.findElement(By.xpath("(//div[@class='product-price'])//span")).getText();
		    String replace3= text3.replaceAll("[^0-9]", "");
		    int count3= Integer.parseInt(replace3);
		    System.out.println("lowest price==" +count3);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("(//div[@class='product-thumbShim'])[1]")).click();
		    
		    Set<String> windowhandleset1= driver.getWindowHandles();
			 List<String> windowhandlesList1=new ArrayList<String>(windowhandleset1);
			 driver.switchTo().window(windowhandlesList1.get(1));
		    File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
			File file = new File("./snaps/incident.png");
			FileUtils.copyFile(screenshotAs, file);	
			 driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconWishlist sprites-headerWishlist']")).click();
			 driver.switchTo().window(windowhandlesList1.get(0));
			 driver.close();  
}
}
