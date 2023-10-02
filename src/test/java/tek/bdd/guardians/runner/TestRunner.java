package tek.bdd.guardians.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

//We use the @RunWith from JUnit and then use the CucumberOptions to setup the TestRunner class
//Make sure to type your code outside the class

@RunWith(Cucumber.class)
@CucumberOptions(
		
		tags = "@sidebarOption",
		features = ("classpath:features"),
		glue = "tek.bdd.guardians",
		dryRun = false,
		plugin = {
				"pretty",
				"html:target/htmlReports/cucumber-pretty.html",
				"json:target/jsonReports/cucumber.json"
		},
		snippets = CAMELCASE,
		monochrome = true
		
		)


public class TestRunner {

}
