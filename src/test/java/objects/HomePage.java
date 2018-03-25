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
public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//h4[@class='subheader']")
	public WebElement successMessage;

	@FindBy(xpath = "//i[@class='icon-2x icon-signout']")
	public WebElement logout;

	public String getLoginText() {

		return successMessage.getText();

	}

	public void clickLogout() {
		logout.click();

	}

}