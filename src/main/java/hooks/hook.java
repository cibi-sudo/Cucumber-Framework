package hooks;

import browserFactory.browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utility.configReader;
import utility.helper;

import java.util.Properties;

public class hook {
    WebDriver driver;

    @Before
    public void setup() {
        Properties prop = new configReader().intializeProperties();
        driver = browser.initializeBrowser(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        String scenarioName = scenario.getName().replaceAll(" ", "_");
        if (scenario.isFailed()) {
            byte[] screenshot = helper.captureScreenshotinByte(driver);
            scenario.attach(screenshot, "image/png", scenarioName);
        }
        driver.quit();
    }
}
