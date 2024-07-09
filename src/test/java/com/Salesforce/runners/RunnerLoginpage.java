package com.Salesforce.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
			features = {"src/test/resources/features/Loginfeaturepage.feature"},
			glue = {"com.Salesforce.stepdefs"},
			dryRun = false,
			
					plugin = {"pretty",
							  "json:target/cucumber-reports/cucumber.json",
							  "html:target/cucumber-reports/cucumberreport.html" }

			)
	public class RunnerLoginpage extends AbstractTestNGCucumberTests{
		
}
