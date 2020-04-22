import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class TestLogin {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//Load the Chrome webdriver using Java properties, make sure to add your local chromedriver file location 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dima.nabhani\\Downloads\\chromedriver_win32\\chromedriver.exe");
			}


	@Test
	public void testInvalidLogin() {
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://start.ca";
        // launch Chrome and direct it to the Base URL
        driver.get(baseUrl);
        driver.manage().window().maximize();
		driver.findElement(By.linkText("Log in / Register")).click();
        driver.findElement(By.name("USER")).sendKeys("test1@domain.com");
        driver.findElement(By.name("PASSWORD")).sendKeys("testpassword1");
        driver.findElement(By.name("LOGIN")).click();
        String error = driver.findElement(By.className("error")).getText();
		assertEquals(error,"Sorry, your user name or password are not correct.");
		driver.close();
	}
	
	@Test
	public void testNullEmail() {
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://start.ca";
        // launch Chrome and direct it to the Base URL
        driver.get(baseUrl);
        driver.manage().window().maximize();
		driver.findElement(By.linkText("Log in / Register")).click();
		//here we will not type in an email address
		driver.findElement(By.name("PASSWORD")).sendKeys("testpassword2");
        driver.findElement(By.name("LOGIN")).click();
        String error = driver.findElement(By.className("error")).getText();
		assertEquals(error,"Sorry, your user name and password are required.");
		driver.close();
	}
	
	@Test
	public void testNullPassword() {
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://start.ca";
        // launch Chrome and direct it to the Base URL
        driver.get(baseUrl);
        driver.manage().window().maximize();
		driver.findElement(By.linkText("Log in / Register")).click();
        driver.findElement(By.name("USER")).sendKeys("test3@domain.com");
        //here we will not send a password
        driver.findElement(By.name("LOGIN")).click();
        String error = driver.findElement(By.className("error")).getText();
		assertEquals(error,"Sorry, your user name and password are required.");
		driver.close();
	}
	
	
	
	@After
	public void tearDown() throws Exception {
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
}
