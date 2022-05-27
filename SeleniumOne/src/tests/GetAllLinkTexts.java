package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetAllLinkTexts {
	
	WebDriver driver = null;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		// Thread sleep      ------ Wait type 2
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		
		// Thread sleep      ------ Wait type 3
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void getTextForAllLinks() {
		driver.get("https://facebook.com");
		
		// Thread sleep      ------ Wait type 1
//		try {
//			Thread.sleep(10000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		
		
		// Thread sleep      ------ Wait type 4
		new WebDriverWait(driver, 100).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("a"), 100));
		
		List<WebElement> allAnchorTags = driver.findElements(By.tagName("a"));
		int listSize = allAnchorTags.size();
		
		Assert.assertTrue("There are no anchor tags and list size is " + listSize, listSize<0);
		
		System.out.println("List size is " + listSize);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	

}
