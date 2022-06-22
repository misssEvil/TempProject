import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import runner.JenkinsUtils;

import java.util.concurrent.TimeUnit;

public class CreateNewFPTest extends BaseTest {

    private final String NEW_JOB_FREESTYLE_CLASS = "hudson_model_FreeStyleProject";

    protected void findItemOnJobsTableAndClick(String itemName) {
        itemName = itemName.replaceAll(" ", "%20");
        System.out.println(itemName);
        getDriver().findElement(By.xpath("//a[@href=\"job/".concat(itemName).concat("/\"]"))).click();
    }

    protected void deleteFreestyleProject(String itemName){
        getDriver().findElement(By.linkText("Delete Project")).click();
        getDriver().switchTo().alert().accept();
    }

    protected void choseNewItemType(String itemType) {
        getDriver().findElement(By.className(itemType)).click();
    }

    @Test
    public void createFreestyleProjectWithValidName() {
        String projectBName = "newFreestyleProject";
        getDriver().findElement(By.linkText("New Item")).click();
        getDriver().findElement(By.id("name")).sendKeys(projectBName);
        choseNewItemType(NEW_JOB_FREESTYLE_CLASS);
        getDriver().findElement(By.id("ok-button")).click();
        goHome();
        findItemOnJobsTableAndClick(projectBName);
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://localhost:8080/job/newFreestyleProject/");
        deleteFreestyleProject(projectBName);
    }

    @Test
    public void createFreestyleProjectWithInvalidName() {
        String projectBName = "[]//*";
        getDriver().findElement(By.linkText("New Item")).click();
        getDriver().findElement(By.id("name")).sendKeys(projectBName);
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(getDriver().findElement(By.id("itemname-invalid")).isEnabled());
    }

    @Test
    public void createFreestyleProjectWithSpacesInName() {
        String projectBName = "new Freestyle Project";
        getDriver().findElement(By.linkText("New Item")).click();
        getDriver().findElement(By.id("name")).sendKeys(projectBName);
        choseNewItemType(NEW_JOB_FREESTYLE_CLASS);
        getDriver().findElement(By.id("ok-button")).click();
        goHome();
        findItemOnJobsTableAndClick(projectBName);
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://localhost:8080/job/new%20Freestyle%20Project/");
        deleteFreestyleProject(projectBName);
    }
    @Test
    public void createFreestyleProjectNullName()  {
        String projectBName = "lalala";
        getDriver().findElement(By.linkText("New Item")).click();
        getDriver().findElement(By.id("name")).sendKeys(projectBName);
        getDriver().findElement(By.id("name")).clear();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(getDriver().findElement(By.id("itemname-required")).isEnabled());
    }
}
