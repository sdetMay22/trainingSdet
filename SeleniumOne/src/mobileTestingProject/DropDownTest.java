package mobileTestingProject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownTest {
	WebDriver driver = null;

	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://91mobiles.com/phonefinder.php");
	}
	
	@Test
	public void dropdownTest() {
		WebElement searchDropDown = driver.findElement(By.id("auto_suggest_category"));
		searchDropDown.click();
		Select select = new Select(searchDropDown);
		System.out.println("The default selected option is " + select.getFirstSelectedOption());
		sleepNow();
		select.selectByVisibleText("Deals");
		sleepNow();
		select.selectByIndex(1);
		sleepNow();
		select.selectByValue("l");
	}
	
	@Test
	public void dropdownTestTwo() {
		WebElement moreDropDown = driver.findElement(By.cssSelector(".more_arrow"));
		moreDropDown.click();
		
		sleepNow();
		
		WebElement recentDDvalue = driver.findElement(By.xpath("//li[text()='Recent']"));
		recentDDvalue.click();
		
		sleepNow();
		
		WebElement cameraScoreDDvalue = driver.findElement(By.xpath("//li[text()='Rear camera Score']"));
		moreDropDown.click();
		cameraScoreDDvalue.click();
	}

	@After
	public void tearDown() {
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		driver.quit();
	}
	

	public void sleepNow() {
		/*
		 * 
		 * Do not use sleep in your tests. It is bad practice.
		 * We are only using it for demonstration purpose. So that we can see execution happening.
		 * 
		 */
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
