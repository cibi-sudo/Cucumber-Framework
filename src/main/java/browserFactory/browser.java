package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utility.helper;

import java.time.Duration;

public class browser {
    static WebDriver driver = null;

    public static WebDriver initializeBrowser(String browserName) {

        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(helper.pageloadouttime));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(helper.implicittime));
        return driver;
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
