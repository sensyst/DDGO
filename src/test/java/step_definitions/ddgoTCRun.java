package step_definitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",tags = {"@AC5"},
format = { "pretty", "html:target/cucumber-html-report", "pretty:target/cucumber-report.json" })


public class ddgoTCRun {

}
