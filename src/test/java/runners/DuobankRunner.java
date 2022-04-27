package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        tags = "@temp",

        features = "src/test/resources",

        glue = "stepDefinitions",

        stepNotifications = true

        //,dryRun = true
)

public class DuobankRunner {
}
