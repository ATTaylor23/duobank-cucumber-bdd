package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.Driver;

import java.time.Duration;

public class Hooks {

    @Before("@module1")
    public void setup() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();


        }

    @After
    public void teardown(){
        Driver.quitDriver();
    }

}
