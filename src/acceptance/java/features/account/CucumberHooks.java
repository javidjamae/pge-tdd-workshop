package features.account;

import org.junit.Assume;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class CucumberHooks {
    @Before("@skip")
    public void skip_scenario(Scenario scenario){
        System.out.println("SKIPPING SCENARIO: " + scenario.getName());
        Assume.assumeTrue("Skipping test marked with @skip", false);
    }
}