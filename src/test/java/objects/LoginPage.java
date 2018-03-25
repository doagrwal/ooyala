package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

@SuppressWarnings("unused")
public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "username")
	public WebElement userName;

	@FindBy(id = "password")
	public WebElement userPassword;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement login;


	@FindBy(xpath = "//div[@class='flash error']")
	public WebElement failureMessage;


	public String getFailureText() {
		String message[]=failureMessage.getText().split("×") ;
		return message[0].trim();

	}

	public String getLoginPageText() {

		return login.getText();

	}

	public void inputCredentials(String userId,String password) {

		userName.sendKeys(userId);
		userPassword.sendKeys(password);
		login.click();

	}



}


