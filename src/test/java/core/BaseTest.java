package core;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utils.Browser;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        Browser.setup();
    }

    @AfterTest
    public void tearDown() {
        Browser.quit();
    }
}
