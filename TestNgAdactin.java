package projectTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPages;
import testNG_BaseClass.TestNG_BaseClass;

public class TestNgAdactin extends TestNG_BaseClass {
	
	//public static WebDriver driver=TestNG_BaseClass.driver;
	LoginPages log;

	@BeforeSuite
	public void setup() {
// System.out.println("chrome launched");
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\PC\\Selenium\\SeleniumPractice\\Drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		 browserLaun("chrome");
	}

	@BeforeClass
	public void navigateURl() {
		
	//driver.get("https://adactinhotelapp.com/");
		urlNavigate("https://adactinhotelapp.com/");
		//navigateTo("https://adactinhotelapp.com/");

	}
	
@Parameters({"username"})
	@Test(priority =1 )
	public void userName(@Optional("rio")  String name) throws InterruptedException {
		 log=new LoginPages(driver);
	  //WebElement username = driver.findElement(By.id("username"));
		sendTextOnInputBox(log.getUserName(),name);
		//Thread.sleep(3000);
		
	} 

	
	@Parameters({"userpassword"})
	@Test(priority = 2)
	public void passWord(@Optional("12367")  String pass) throws InterruptedException {
		 log=new LoginPages(driver);
		//sendTextOnInputBox(driver.findElement(By.id("password")), "1234567");
		sendTextOnInputBox(log.getPassWord(), pass);
		//Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void login() {
	//driver.findElement(By.id("login")).click();
		 log=new LoginPages(driver);
		clickOnElements(log.getLoginBtn());
		String actualUrl = driver.getCurrentUrl();
		assertion("https://adactinhotelapp.com/SearchHotel.php", actualUrl);
		
		//System.out.println(actualUrl);
		//Assert.assertEquals(actualUrl, "https://adactinhotelapp.com/SearchHotel.php");
	}

	@AfterSuite
	public void tearDown() {
		// System.out.println("browser closed");
		driver.close();

	}
	
}
