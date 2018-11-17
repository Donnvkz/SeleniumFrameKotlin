
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java8.En
import initUtil.UtilResources
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

class StepDefs: En {
    lateinit var driver: WebDriver
        private set

    @Before
    fun setUp() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe")
        driver = ChromeDriver()

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage().window().maximize()
        driver.get(UtilResources.getParam("pageURL"))
    }

    @After
    fun driverClose() {
        driver.close();
    }

    init {
        Given("open homePage") {
            var page = StartP
        }

        When("^I wait (\\d+) hour$") { arg1: Int ->
            print(arg1)
//            // Write code here that turns the phrase above into concrete actions
//            throw PendingException()
        }

        Then("^my belly should growl$") {
            //            // Write code here that turns the phrase above into concrete actions
//            throw PendingException()
        }
    }
}