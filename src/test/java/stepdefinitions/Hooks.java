package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.GWD;

public class Hooks {

    @Before
    public void setUp() {
        GWD.getDriver().get(ConfigReader.getProperty("urlAmazon"));
    }

    @After
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        GWD.quitDriver();
    }


}
