package tests;

import org.testng.annotations.Test;
import runner.BaseTest;

public class ExampleTest extends BaseTest {

    @Test
    public void random(){
        getDriver().get("http://localhost:8080");
    }


}
