package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod() {
        driver = BaseUtils.createDriver();
        JenkinsUtils.getBaseUrl(driver);
        JenkinsUtils.login(driver);
    }

    @AfterMethod
    protected void afterMethod() {
        JenkinsUtils.logout(driver);
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void goHome(){
        JenkinsUtils.getBaseUrl(getDriver());
    }
}
