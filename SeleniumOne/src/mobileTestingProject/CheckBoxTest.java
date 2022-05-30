package mobileTestingProject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxTest {
	

	
WebDriver driver = null;

	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://91mobiles.com/phonefinder.php");
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
	
	@Test
	public void testCheckBox() {
		WebElement sixGBRam = driver.findElement(By.cssSelector("input[data-text='6 GB & above RAM']"));
		WebElement mAH = driver.findElement(By.cssSelector("input[data-text='4000 mAh & above']"));
		sixGBRam.click();
		System.out.println("Is Checkbox selected for 6GB RAM? " + sixGBRam.isSelected());
		System.out.println("Is Checkbox selected for mAH? " + mAH.isSelected());
		Assert.assertTrue("Check box is not clicked ", sixGBRam.isSelected());
	}
	
	

}
