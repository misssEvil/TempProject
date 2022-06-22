package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    protected void setUp() {
        driver = BaseUtils.createDriver();
        getJenkins();
        login();
    }

    @AfterMethod
    protected void closeUp() {
        logout();
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void goHome(){
        JenkinsUtils.getBaseUrl(getDriver());
    }

    protected void getJenkins(){
        JenkinsUtils.getBaseUrl(driver);
    }

    protected void login(){
        JenkinsUtils.login(driver);
    }

    protected void logout(){
        JenkinsUtils.logout(driver);
    }
}
