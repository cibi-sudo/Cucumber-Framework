package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Helper;

public class LoginPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='orangehrm-login-logo']")
    public static WebElement brandElement;
    @FindBy(xpath = "//input[@name='username']")
    public static WebElement usernameField;
    @FindBy(xpath = "//input[@name='password']")
    public static WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    public static WebElement loginButton;
    @FindBy(xpath = "//p[text()='Invalid credentials']")
    public static WebElement warningMessage;
    @FindBy(xpath = "//span[text()='Required']")
    public static WebElement requiredMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        Helper.setDriver(driver);
    }

    public boolean visibilityBrandElement() {
        return Helper.elementToBeDisplayed(brandElement);
    }

    public void enterUsername(String username) {
        Helper.sendText(usernameField, username);
    }

    public void enterPassword(String password) {
        Helper.sendText(passwordField, password);
    }

    public void loginClick() {
        Helper.elementClick(loginButton);
    }

    public boolean getWarningMessage() {
        Helper.waitForElement(warningMessage);
        return Helper.elementToBeDisplayed(warningMessage);
    }

    public boolean getRequiredMessage() {
        Helper.waitForElement(requiredMessage);
        return Helper.elementToBeDisplayed(requiredMessage);
    }
}
