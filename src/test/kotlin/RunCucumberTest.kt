
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith


@RunWith(Cucumber::class)
@CucumberOptions(
        features = ["src/test/features"],
        tags = ["@dev"]
//        ,glue=["test.kotlin.StepDefs"]
 )

class RunCucumberTest