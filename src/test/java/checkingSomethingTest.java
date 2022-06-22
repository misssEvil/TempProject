import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class checkingSomethingTest extends BaseTest {
@Ignore    
@Test
    public void lastMenuElement() {
        getDriver().get("http://www.99-bottles-of-beer.net/");
        WebElement submitLang2 = getDriver().findElement(By.linkText("Submit new Language"));
        WebElement submitLang = getDriver().findElement(By.cssSelector("#menu > li:nth-child(6) > a"));
        Assert.assertEquals(submitLang.getText().toLowerCase(), "submit new language");
        Assert.assertEquals(submitLang2.getText(), "Submit new Language");
    }
}
