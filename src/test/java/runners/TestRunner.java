package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "utilities.formatter.PrettyReports:target/cucumber-pretty-reports"
        },
        features = "src/test/resources",
        glue = "stepdefinitions",
        tags = "@amazon",
        dryRun = false
)
public class TestRunner {
        // for running cucumber tests and generating reports
}
