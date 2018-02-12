// Setup Cucumber environment run file
package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/scenarioOut"},
        glue = {"tests"},
        tags = {"@All", "~@Skip"}
)

public class runCukeTests {

}
