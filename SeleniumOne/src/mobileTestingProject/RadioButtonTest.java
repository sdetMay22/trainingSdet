package mobileTestingProject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonTest {
	
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
	public void radioBtnTest() {
		WebElement radioBtnFor10krange = driver.findElement(By.xpath("//input[@id='latestandexpectprice1000001500001']"));
		WebElement radioBtnFor15krange = driver.findElement(By.xpath("//input[@id='latestandexpectprice1500002000001']"));
		
		sleepNow();
		radioBtnFor10krange.click();
		String radioCheckedValue = radioBtnFor10krange.getAttribute("checked");
		System.out.println("The radio button checked attr is " + radioCheckedValue);
//		Assert.assertTrue("The radio button is not checked", radioCheckedValue.equalsIgnoreCase("true"));
		sleepNow();
		System.out.println("Is radio button selected for 10k range? " + radioBtnFor10krange.isSelected());
		System.out.println("Is radio button selected for 15k range? " + radioBtnFor15krange.isSelected());
	}

}
