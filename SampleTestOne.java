package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class SampleTestOne {

    WebDriver driver = null;
    WebElement userNameInputBox = null;

    @Before
    public void setup() {
    	System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://facebook.com");
        userNameInputBox = driver.findElement(By.id("email"));
    }



    @Test
    public void sampleOne() {
        userNameInputBox.clear();
        userNameInputBox.sendKeys("Hello By Name");
    }

    @Test
    public void sampleTwo() {
        userNameInputBox.clear();
        userNameInputBox.sendKeys("Hello By ID");
    }

    @Test()
    public void sampleThree() {

        userNameInputBox.clear();
        userNameInputBox.sendKeys("Hello By Css selector");

        List<WebElement> allEr = driver.findElements(By.partialLinkText("er"));
        System.out.println("Total link text containing er " + allEr.size());

 
        driver.findElement(By.className("_6ltj")).click(); // Click forgot password
        WebElement forgotPageHeading = driver.findElement(By.cssSelector(".uiHeaderTitle"));
        String originlHeading = forgotPageHeading.getText();
        String expectedHeading = "Find Your Account";
        Assert.assertTrue("Assertion is failing because Orignal heading " + originlHeading + " is not matching with Expected Heading " + expectedHeading , originlHeading.equalsIgnoreCase(expectedHeading));
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(2000); // bad practice
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close(); // It will close the browser window
        driver.quit(); // It will quit driver session

    }
}
