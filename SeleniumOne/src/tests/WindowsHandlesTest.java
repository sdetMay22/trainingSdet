package tests;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandlesTest {
	
WebDriver driver = null;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void windowHandleTest() {
		driver.get(
				"https://www.amazon.in/s?bbn=976420031&rh=n%3A976419031%2Cn%3A1375458031&dc&qid=1653646074&rnid=976420031&ref=lp_976420031_nr_n_10");
		driver.findElement(By.xpath("(//img)[31]")).click();
		
		
		
		Set<String> amazonHandles = driver.getWindowHandles();
		for (String handles : amazonHandles) {
			System.out.println(handles.toString());
		}
//		String handle = driver.getWindowHandle();
//		System.out.println(handle);
		driver.quit();
	}

}
