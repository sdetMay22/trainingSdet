package tables;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableScrapping {

	WebDriver driver = null;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.timeanddate.com/worldclock/");
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
	public void printCityAndTime() {
		
		// Total number of Rows in table
		int totalNoRows = driver.findElements(By.xpath("//table//tbody/tr")).size();
		
		// print city name and time for all the rows
		for (int i = 0; i < totalNoRows; i++) {
			String customXPathForCity = String.format("//table//tbody/tr[%s]//a", String.valueOf(i));
			String customXPathForTime = String.format("//table//tbody/tr[%s]//td[@class='rbi']", String.valueOf(i));
			fetchTableData(customXPathForCity, customXPathForTime);
		}
		
		
				
	}
	
	
	public void fetchTableData(String xpathforCityName, String xPathForCityTime) {
		
		String expectedTableName = "Current Local Times Around the World";
		
		WebElement tableNameElement = driver.findElement(By.xpath("//table//h3"));
		String actualTableName = tableNameElement.getText();
		
		Assert.assertTrue("Expected " + expectedTableName + " and " + "Actual " + actualTableName + " table names are not matching.", expectedTableName.equalsIgnoreCase(actualTableName));
		
		List<WebElement> citiesRowOne = driver.findElements(By.xpath(xpathforCityName));
		List<WebElement> timeRowOne = driver.findElements(By.xpath(xPathForCityTime));

		for (int i = 0; i < citiesRowOne.size(); i++) {
			System.out.print(citiesRowOne.get(i).getText() + " | ");;
			System.out.println(timeRowOne.get(i).getText());
		}
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
