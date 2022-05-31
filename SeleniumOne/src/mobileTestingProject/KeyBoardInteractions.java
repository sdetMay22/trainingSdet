package mobileTestingProject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardInteractions {

	WebDriver driver = null;
	Actions actions = null;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://91mobiles.com");
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
	public void searchPhoneCompany() {
		WebElement searchBox = driver
				.findElement(By.cssSelector(".selection-container>input[placeholder='Search for products or brands']"));
		searchBox.sendKeys("Apple");
		pressEnter(searchBox);
		
	}
	
	
	@Test
	public void facebookHighLightAll() {
		driver.get("https://facebook.com");
		WebElement username = driver.findElement(By.id("email"));
		actions.keyDown(Keys.SHIFT).pause(2000).sendKeys("testing").pause(2000).keyUp(Keys.SHIFT).build().perform();
		WebElement facebookHeading = driver.findElement(By.cssSelector("img[alt='Facebook']"));
		facebookHeading.click();
		actions.keyDown(Keys.LEFT_CONTROL).pause(2000).sendKeys("t").pause(2000).keyUp(Keys.LEFT_CONTROL).build().perform();
		
	}
	
	@Test
	public void facebookRightClick() {
		driver.get("https://facebook.com");
		WebElement facebookHeading = driver.findElement(By.cssSelector("img[alt='Facebook']"));
		facebookHeading.click();
		actions.keyDown(Keys.LEFT_CONTROL).pause(2000).sendKeys("a").pause(2000).keyUp(Keys.LEFT_CONTROL).build().perform();
		actions.contextClick(facebookHeading).build().perform();
		actions.sendKeys(Keys.ARROW_DOWN).pause(2000).keyDown(Keys.ENTER).build().perform();
	}
	
	public void pressEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);
		System.out.println("Pressed enter key on element: " + element.toString());
	}

	public void pressCtrlA(WebElement element) {
		element.sendKeys(Keys.CONTROL, "a");
		System.out.println("Ctrl+A pressed");
	}

}
