package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Checkout.feature",
        glue = {"steps", "utils"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RegisterWhileCheckoutRunner extends AbstractTestNGCucumberTests {
}