package gameSeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTest {
	
	public WebDriver driver;
	
	@BeforeClass
	public void beforeClass(){
		 //System.setProperty("webdriver.chrome.driver", "C:\\Users\\I333868\\Desktop\\InProcess\\SeleniumTests\\Selenium_Task\\SeleniumLibs\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
	}
	
	@Test
	public void gameLoginLogoutTest() throws InterruptedException{
		
		driver.get("https://www.game.co.za");
		driver.findElement(By.linkText("Sign in / Register")).click();
		driver.findElement(By.id("j_username")).sendKeys("abc@xyz.com");
		driver.findElement(By.id("j_password")).sendKeys("abc@xyz.com");
		driver.findElement(By.id("loginForm")).findElement(By.tagName("button")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign Out")).click();
		WebElement web = driver.findElement(By.linkText("Sign in / Register"));
		if(web!=null)
			System.out.println("Login-LogOut Test Pass");
		else
			System.out.println("Login-LogOut Fail");
		String Title = driver.getTitle();
		System.out.println(Title);
		
	}
	
	@AfterClass
	public void afterClass() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}

}