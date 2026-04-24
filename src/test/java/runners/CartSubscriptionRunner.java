package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features/CartSubscription.feature",   
	    glue = {"utils","steps"},                 
	    plugin = {
	        "pretty",                               
	        "html:target/cucumber-reports.html",    
	        "json:target/cucumber.json"             
	    }              
	)
public class CartSubscriptionRunner extends AbstractTestNGCucumberTests{

}
