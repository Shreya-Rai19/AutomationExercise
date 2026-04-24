package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/registerCheckout.feature",  
    glue = {"steps","utils"},                 
    plugin = {
        "pretty",
        "html:target/cucumber-report.html"
    }
)

public class RegisterCheckoutRunner extends AbstractTestNGCucumberTests {
}