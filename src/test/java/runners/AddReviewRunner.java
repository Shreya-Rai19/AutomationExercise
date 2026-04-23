package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/AddReview.feature",   // path to your .feature files
    glue = {"steps", "utils"},                  // packages containing step defs & hooks
    plugin = {"pretty", "html:target/cucumber-report.html"}                      // optional: run scenarios with specific tags
)

public class AddReviewRunner extends AbstractTestNGCucumberTests {

}
