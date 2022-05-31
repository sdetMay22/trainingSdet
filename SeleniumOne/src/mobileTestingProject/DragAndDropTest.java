package mobileTestingProject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {

	WebDriver driver = null;
	Actions actions = null;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		actions = new Actions(driver);
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

	// 91mobiles slider

	@Test
	public void moveSliderClickAndHold() {
		WebElement sliderLeft = driver.findElement(By.cssSelector(".noUi-handle.noUi-handle-lower"));
		System.out.println(sliderLeft.isDisplayed());
		
		sliderLeft.click();
		
		WebElement sliderRight = driver.findElement(By.cssSelector(".noUi-handle.noUi-handle-upper"));
		System.out.println(sliderRight.isDisplayed());
		
		Actions actions = new Actions(driver);
		actions
			.clickAndHold(sliderLeft)
			.pause(2000)
			.moveToElement(sliderRight)
			.pause(2000)
			.build()
			.perform();
		
	}

	@Test
	public void moveSliderDragNDrop() {
		WebElement sliderLeft = driver.findElement(By.cssSelector(".noUi-handle.noUi-handle-lower"));
		System.out.println(sliderLeft.isDisplayed());
		
		sliderLeft.click();
		
		WebElement sliderRight = driver.findElement(By.cssSelector(".noUi-handle.noUi-handle-upper"));
		System.out.println(sliderRight.isDisplayed());
		
		Actions actions = new Actions(driver);
		actions
			.dragAndDrop(sliderLeft, sliderRight)
			.build()
			.perform();
		
	}

	@Test
	public void moveSliderByOffset() {
		WebElement sliderLeft = driver.findElement(By.cssSelector(".noUi-handle.noUi-handle-lower"));
		System.out.println(sliderLeft.isDisplayed());
		
		sliderLeft.click();
		
		
		Actions actions = new Actions(driver);
		actions
			.clickAndHold(sliderLeft)
			.pause(5000)
			.moveByOffset(50, 0)
			.pause(5000)
			.build()
			.perform();
		
	}

	@Test
	public void moveSliderByRange() {
		String startingRange = "7,000";
		WebElement sliderLeft = driver.findElement(By.cssSelector(".noUi-handle.noUi-handle-lower"));
		System.out.println(sliderLeft.isDisplayed());

		sliderLeft.click();

		for (int i = 0; i < 100; i++) {
			actions
			 .clickAndHold(sliderLeft)
			 .pause(2000)
			 .moveByOffset(5, 0)
			 .pause(2000)
			 .release()
			 .build()
			 .perform();
		String priceRange = driver.findElement(By.cssSelector("#filter_list li:nth-child(2)>span")).getText();
		System.out.println("Price range is " + priceRange);
			if(priceRange.contains(startingRange)) {
				System.out.println("Quitting the loop as we found the list of phones in desired price range: " +priceRange);
				break;
			}
		}
		

	}

}
