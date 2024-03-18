package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features={"src\\test\\resources\\features\\SearchingForJobs.feature"},
		glue={"gluecode"},
		monochrome=true,
		plugin={"pretty",
				"html:target/mycucumber.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class Runner2 extends AbstractTestNGCucumberTests
{
	  
}











