package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.time.Duration;

public class Hooks {

    @Before("@module1")
    public void setup() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();


        }

    @After
    public void teardown(Scenario scenario){

        if (scenario.isFailed()){

            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshotAs, "image/png", "failed");

        }

        Driver.quitDriver();
    }

}
