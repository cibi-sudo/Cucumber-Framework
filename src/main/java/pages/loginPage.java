package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.helper;

public class loginPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='orangehrm-login-logo']")
    private WebElement brandElement;
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//p[text()='Invalid credentials']")
    private WebElement warningMessage;
    @FindBy(xpath = "//span[text()='Required']")
    private WebElement requiredMessage;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        helper.setDriver(driver);
    }

    public boolean visibilityBrandElement() {
        return helper.elementToBeDisplayed(brandElement);
    }

    public void enterUsername(String username) {
        helper.sendText(usernameField, username);
    }

    public void enterPassword(String password) {
        helper.sendText(passwordField, password);
    }

    public void loginClick() {
        helper.elementClick(loginButton);
    }

    public boolean getWarningMessage() {
        helper.waitForElement(warningMessage);
        return helper.elementToBeDisplayed(warningMessage);
    }

    public boolean getRequiredMessage() {
        helper.waitForElement(requiredMessage);
        return helper.elementToBeDisplayed(requiredMessage);
    }
}
