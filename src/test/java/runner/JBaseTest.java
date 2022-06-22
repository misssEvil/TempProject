package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class JBaseTest {

    private WebDriver driver;

    @BeforeMethod
    protected void BeforeMethod() {
        startDriver();
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

    protected void startDriver(){
        driver = JBaseUtils.createDriver();
    }

    protected void goHome(){
        JenkinsUtils.getBaseUrl(getDriver());
    }



    protected void login(){
        JenkinsUtils.login(driver);
    }

    protected void logout(){
        JenkinsUtils.logout(driver);
    }
}
