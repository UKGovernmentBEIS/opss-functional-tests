package uk.gov.beis.digital.AcceptanceTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "html:target/cucumber-reports/html",
		"json:target/cucumber-reports/cucumber.json" }, features = {
				"src/test/resources/Features" }, glue="uk.gov.beis.digital.stepdefs",
	 tags = {"@regression","~@ignore,@Pending"})

public class RegressionTest {

}