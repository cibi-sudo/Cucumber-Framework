package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.helper;

public class loginPage {
    WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        helper.setDriver(driver);
    }

    By brandElement = By.xpath("//div[@class='orangehrm-login-logo']");
    By usernameField = By.xpath("//input[@name='username']");
    By passwordField = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[@type='submit']");
    By warningMessage = By.xpath("//p[text()='Invalid credentials']");
    By requiredMessage = By.xpath("//span[text()='Required']");

    public boolean visibilityBrandElement(){
        return helper.elementToBeDisplayed(brandElement);
    }
    public void enterUsername(String username){
        helper.sendText(usernameField,username);
    }
    public void enterPassword(String password){
        helper.sendText(passwordField,password);
    }

    public void loginClick(){
        helper.elementClick(loginButton);
    }

    public boolean getWarningMessage(){
        return helper.elementToBeDisplayed(warningMessage);
    }

    public boolean getRequiredMessage(){
        return helper.elementToBeDisplayed(requiredMessage);
    }
}
