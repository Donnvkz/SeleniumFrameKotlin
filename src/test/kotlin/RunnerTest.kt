
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith


@RunWith(Cucumber::class)
@CucumberOptions(
        features = ["src/test/resources"],
        format = ["pretty", "html:target/htmlreports" ],
        tags = ["@dev"]
//        ,glue=["test.kotlin.StepDefs"]
 )

class RunnerTest