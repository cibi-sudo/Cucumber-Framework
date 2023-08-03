package hooks;

import browserFactory.browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utility.helper;

public class hook {
    WebDriver driver;

    @Before
    public void setup() {
        driver = browser.initializeBrowser("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @After
    public void tearDown(Scenario scenario) {
        String scenarioName = scenario.getName().replaceAll(" ","_");
        if(scenario.isFailed()) {
            byte[] screenshot = helper.captureScreenshotinByte(driver);
            scenario.attach(screenshot,"image/png",scenarioName);
        }
        driver.quit();
    }
}
