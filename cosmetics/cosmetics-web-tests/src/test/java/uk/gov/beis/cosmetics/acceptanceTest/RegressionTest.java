package uk.gov.beis.cosmetics.acceptanceTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "html:target/cucumber-reports/html",
		"json:target/cucumber-reports/cucumber.json" }, features = {
				"src/test/resources/Features" }, glue="uk.gov.beis.cosmetics.stepdefs",
	 tags = {"@wip","~@ignore,@Pending"})

public class RegressionTest {

}