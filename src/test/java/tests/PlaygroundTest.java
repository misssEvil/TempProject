package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.JBaseTest;

public class PlaygroundTest extends JBaseTest {

    @Test
    public void randomTest() {

        WebElement searchBox = getDriver().findElement(By.id("search-box"));
        searchBox.sendKeys("0000");
        searchBox.sendKeys(Keys.ENTER);
        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), "Search for '0000'");

    }
}
