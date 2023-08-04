package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class helper {
    static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        helper.driver = driver;
    }

    public static int pageloadouttime = 15;
    public static int implicittime = 10;
    public static int explicittime = 20;

    public static byte[] captureScreenshotinByte(WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] screenshot;
        screenshot = ts.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

    public static String captureScreenshotinbase64(WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String base64;
        base64 = ts.getScreenshotAs(OutputType.BASE64);
        return base64;
    }

    public static void captureScreenshot(WebDriver driver) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File trg = new File("./Images/" + getcurrenttime() + ".png");
            FileUtils.copyFile(src, trg);
        } catch (IOException exception) {
            System.out.println("Something went wrong" + exception.getMessage());
        }
    }

    public static void captureElement(WebDriver driver, WebElement element) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = element.getScreenshotAs(OutputType.FILE);
            File trg = new File("./Images/" + getcurrenttime() + ".png");
            FileUtils.copyFile(src, trg);
        } catch (IOException exception) {
            System.out.println("Something went wrong" + exception.getMessage());
        }
    }

    public static String getcurrenttime() {
        return new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
    }

    public static boolean elementToBeDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

    public static void elementClick(By locator){
        driver.findElement(locator).click();
    }

    public static void sendText(By locator,String string){
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(string);
    }

}
