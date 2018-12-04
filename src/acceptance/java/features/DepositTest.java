package features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty" }, 
		features = "classpath:features/deposit.feature", 
		glue = { "features.account" } )
public class DepositTest {
}