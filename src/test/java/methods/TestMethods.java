package methods;

import objects.LoginPage;
import objects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class TestMethods {
	private WebDriver driver;
	private LoginPage login;
	private HomePage home;

	public TestMethods(WebDriver driver) {

		login = PageFactory.initElements(driver, LoginPage.class);
	    home = PageFactory.initElements(driver, HomePage.class);
		this.driver = driver;


	}

	public void setCredentials(String userId,String password) {
		login.inputCredentials(userId,password);

	}

	public String verifySuccessfulLogin() {
		return home.getLoginText();

	}

	public String verifyLoginPage() {
		return login.getLoginPageText();

	}

	public void logout() {
		home.clickLogout();
	}

	public String verifyFailedLogin() {
		return login.getFailureText();
	}


	public void endTest()
	{
		driver.close();
		driver.quit();
	}
}

