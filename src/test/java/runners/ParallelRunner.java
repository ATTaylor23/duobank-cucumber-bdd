package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        tags = "@temp",

        features = "src/test/resources/",

        glue = "stepDefinitions",

        stepNotifications = true,

        snippets = CucumberOptions.SnippetType.CAMELCASE,

        plugin = {"pretty",
                "html:target/duobank-report/built-in-report.html",
                "json:target/Cucumber.json",
                "rerun:target/failed.txt"
        }

        //,dryRun = true
)


public class ParallelRunner {
}
