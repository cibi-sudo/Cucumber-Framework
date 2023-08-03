package stepDefinitions;


import browserFactory.browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.loginPage;


public class login {
    loginPage login = PageFactory.initElements(browser.getDriver(), loginPage.class);

    @Given("User able to see the the brand element")
    public void user_able_to_see_the_the_brand_element() {
       Assert.assertTrue(login.visibilityBrandElement());
    }

    @When("User enters valid username {string} into email field")
    public void user_enters_valid_username_into_email_field(String username) {
        login.enterUsername(username);
    }

    @When("User enters valid password {string} into password field")
    public void user_enters_valid_password_into_password_field(String password) {
        login.enterPassword(password);
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        login.loginClick();
    }

    @Then("User should get a proper warning message about credentials mismatch")
    public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
    Assert.assertTrue(login.getWarningMessage());
    }

    @When("User don't enter username into username field")
    public void user_don_t_enter_username_into_username_field() {
        login.enterUsername("");
    }

    @When("User don't enter password into password field")
    public void user_don_t_enter_password_into_password_field() {
        login.enterPassword("");
    }

    @Then("User should get a proper warning message about credentials required")
    public void user_should_get_a_proper_warning_message_about_credentials_required() {
       Assert.assertTrue(login.getRequiredMessage());
    }
}
