package core;
import org.openqa.selenium.By;
import utils.Browser;

public class BasePage {

    protected static void type(By locator, String whatToType) {
        Browser.driver.findElement(locator).sendKeys(whatToType);
    }

    protected static void click(By locator) {
        Browser.driver.findElement(locator).click();
    }

    protected static String getText(By locator) {
        return Browser.driver.findElement(locator).getText();
    }
}
