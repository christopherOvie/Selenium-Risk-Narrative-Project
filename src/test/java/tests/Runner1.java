package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//add @smoketest tag to required scenarios or scenario outlines in feature files manually, 
//which are passed previously but related to failed scenarios. So need to run again.
//Regression testing
@CucumberOptions(
		features={"src\\test\\resources\\features"},
		glue={"gluecode"},
		tags="@smoketest",
		dryRun=false,
		monochrome=true,
		plugin={"pretty","html:target/smoketestres",
				                            "rerun:target/failedsmoketestres.txt"}
		)
public class Runner1 extends AbstractTestNGCucumberTests
{
}











