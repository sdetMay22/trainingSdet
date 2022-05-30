package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameTest {
	WebDriver driver = null;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
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
	public void iframeTest() {
		int iframeCounts = driver.findElements(By.xpath("//iframe")).size();
		System.out.println("Total iframes on the page are " + iframeCounts);
		
		WebElement iframeEle = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(iframeEle); // Switch to by WebElement
		
		driver.switchTo().frame(0); // Switch to by Index
		
		driver.findElement(By.linkText("Sign in")).click();
	}

}
