package tests;

import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HtmlMethods {

	WebDriver driver = null;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
	}

	@Test
	public void getCurrentURLTest() {
		driver.findElement(By.className("_6ltj")).click(); // Click forgot password
		String getCurrentURL = driver.getCurrentUrl();
		System.out.println(getCurrentURL);
		Assert.assertTrue("I am not on forgot password page", getCurrentURL.contains("recover"));
	}

	@Test
	public void getPageSource() {
		driver.findElement(By.className("_6ltj")).click(); // Click forgot password
		String getPageSource = driver.getPageSource();
		System.out.println(getPageSource);
	}

	@Test
	public void getTitleTest() {
		driver.findElement(By.className("_6ltj")).click(); // Click forgot password
		String getTitle = driver.getTitle();
		System.out.println(getTitle);
		Assert.assertTrue("I am not on forgot password page", getTitle.contains("Forgot"));
	}

	@Test
	public void getWindowHandleTest() {
		driver.findElement(By.className("_6ltj")).click(); // Click forgot password
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
	}

	@Test
	public void navigateToTest() {
		driver.findElement(By.className("_6ltj")).click(); // Click forgot password
		driver.navigate().to("https://91mobiles.com/phonefinder.php");
	}

	@Test
	public void windowsHandlesTest() {
		driver.get(
				"https://www.amazon.in/s?bbn=976420031&rh=n%3A976419031%2Cn%3A1375458031&dc&qid=1653646074&rnid=976420031&ref=lp_976420031_nr_n_10");
		driver.findElement(By.xpath("(//img)[31]")).click();
		Set<String> amazonHandles = driver.getWindowHandles();
		
		System.out.println("Tabs count was " + amazonHandles.size());
		Assert.assertTrue("The new tabs are not found", amazonHandles.size()>0);
		
//		for (String handles : amazonHandles) {
//			String windowTitle = driver.switchTo().window(handles).getTitle();
//			System.out.println(windowTitle);
//		}
		
//		String newTabTitle = "TCL Tab 10 (10.1 inches WUXGA Display, 3GB+64GB, 5500mAh, Wi-Fi + 4G Calling Tablet (Black) (9060G (Black) : Amazon.in: Health & Personal Care";
//		
//		driver.switchTo().window(newTabTitle);
		for (int j = 0; j < amazonHandles.toArray().length; j++) {
			driver.switchTo().window((String) amazonHandles.toArray()[j]);
			Assert.assertTrue("This is TCL tab product page", driver.getTitle().contains("TCL Tab"));
			break;
		}
		
		
		
		driver.findElement(By.id("add-to-cart-button")).click();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
