import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// runner for features. we use this runner for maven because maven will recognize and run test file by Test keyword in file name.


@RunWith(Cucumber.class)
@CucumberOptions(
        // to generate report in html format at target/html folder
        plugin={"pretty","html:target/html"},
        // to locate and run feature file
        features="src/test/resources/search.feature"
)
public class RunnerTest {

}
