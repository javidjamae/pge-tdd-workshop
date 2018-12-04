package features;

import org.junit.Assume;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class CucumberHooks {
    @Before("@skip")
    public void skip_scenario(Scenario scenario){
        System.out.println("SKIP SCENARIO: " + scenario.getName());
        Assume.assumeTrue(false);
    }
}