package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpsTest {
	WebDriver driver = null;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.indiapost.gov.in");
	}

	@After
	public void tearDown() {

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}

//		driver.quit();
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
	
//	@Test
//	public void switchToHtmlPop() {
//		String popHeading = "PLI/RPLI Update";
//		String actualHeading = null;
//		
//		actualHeading = driver.findElement(By.xpath("//h3[text()=' PLI/RPLI Update ']")).getText();
//		Assert.assertTrue("Expected heading is - -" + popHeading + "- and " + " actual heading is - -" + actualHeading, popHeading.equalsIgnoreCase(actualHeading));
//		driver.findElement(By.xpath("//button[text()='Close']")).click();
//	}
	
	@Test
	public void switchToJSPop() {
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		driver.findElement(By.xpath("//a/img[@alt='Buy Stamps']")).click();
		driver.findElement(By.linkText("Buy Now")).click();
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		Assert.assertTrue("Incorrect pop up", alertText.contains("redirected to an external website"));
//		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
	}
}
