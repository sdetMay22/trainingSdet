package mobileTestingProject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickTest {
	
	WebDriver driver = null;
	Actions actions = null;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
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
		 * Do not use sleep in your tests. It is bad practice. We are only using it for
		 * demonstration purpose. So that we can see execution happening.
		 * 
		 */

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void rightClickTest() {
		driver.get("https://facebook.com");
		WebElement facebookHeading = driver.findElement(By.cssSelector("img[alt='Facebook']"));
		facebookHeading.click();
		actions.contextClick(facebookHeading).build().perform();
	}


}
