package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static runner.BaseUtils.PREFIX;
import static runner.BaseUtils.getProperties;

public final class JenkinsUtils {

   private static final String PORT = PREFIX + "port";
   private static final String USER = PREFIX + "admin.username";
   private static final String PASSWORD = PREFIX + "admin.password";



    static void getBaseUrl(WebDriver driver){
        driver.get("http://localhost:".concat(getProperties().getProperty(PORT)));

    }

    static void login(WebDriver driver) {
        getBaseUrl(driver);

        driver.findElement(By.id("j_username")).sendKeys(getProperties().getProperty(USER));
        driver.findElement(By.name("j_password")).sendKeys("af70de925be74d309d3f86e4350df842");
        driver.findElement(By.name("Submit")).click();

    }

    static void logout(WebDriver driver){
        getBaseUrl(driver);

        driver.findElement(By.xpath("//a[@href='/logout']")).click();
        getBaseUrl(driver);


    }



}
