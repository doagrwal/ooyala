package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import config.Config;
import methods.TestMethods;

public class LoginTest {

	private WebDriver driver;
	Config config = new Config();
	TestMethods testMethod;


	@BeforeClass
	public void beforeClass() {

		String baseUrl = config.fetchConfig("BaseUrl");
		String driverPath = config.fetchConfig("chromeDriverPath");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/login");
		driver.manage().window().maximize();
		testMethod = new TestMethods(driver);
	}


	@Test(description = "Testing For Successful Login Functionality", dataProvider = "ValidDataSet")
	void Test1(String userId, String password){
		testMethod.setCredentials(userId,password);
		Assert.assertEquals(testMethod.verifySuccessfulLogin(),"Welcome to the Secure Area. When you are done click logout below.","Login successful");
		testMethod.logout();
		Assert.assertEquals(testMethod.verifySuccessfulLogin(),"This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.","Logout successful");
	}


	@Test(description = "Testing when wrong username is passed", dataProvider = "InvalidUserSet")
	void Test2(String userId, String password){
		testMethod.setCredentials(userId,password);
		Assert.assertEquals(testMethod.verifyFailedLogin(),"Your username is invalid!","Login failed");

	}

	@Test(description = "Testing when wrong password is passed", dataProvider = "InvalidPasswordSet")
	void Test3(String userId, String password){
		testMethod.setCredentials(userId,password);
		Assert.assertEquals(testMethod.verifyFailedLogin(),"Your password is invalid!","Login failed");

	}

	@DataProvider(name = "ValidDataSet")
	public Object[][] getValidData() {
		return new Object[][]{{"tomsmith", "SuperSecretPassword!"}
		};
	}

	@DataProvider(name = "InvalidUserSet")
	public Object[][] getInvalidUserData() {
		return new Object[][]{{"smith", "SuperSecretPassword"}
		};
	}

	@DataProvider(name = "InvalidPasswordSet")
	public Object[][] getInvalidPasswordData() {
		return new Object[][]{{"tomsmith", "SuperSecretPassword"}
		};
	}



	@AfterClass
	public void afterClass() {
		testMethod.endTest();
	}
}


