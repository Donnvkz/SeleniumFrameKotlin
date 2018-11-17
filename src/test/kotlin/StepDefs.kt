import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java8.En
import org.junit.Assert
import pages.AbstractPage
import pages.ResultPage
import pages.StartPage

class StepDefs : En {
    var INIT: Init? = null
    lateinit var CURRENT_PAGE: AbstractPage

    @Before
    fun set222Up() {
        INIT = Init()
        INIT!!.setUp()
    }

    @After
    fun driverClose() {
        INIT!!.driverClose();
    }

    init {
        Given("open startPage") {
            CURRENT_PAGE = StartPage(INIT!!.getWebDriver());
            Assert.assertTrue("fwsfwe", CURRENT_PAGE.isPageOpened())
        }

        When("writes in the search bar \"([^\"]*)\"") { arg1: String ->
            var page: StartPage = CURRENT_PAGE as StartPage
            page.setSearchRequest(arg1)
        }

        Then("^my belly should growl$") {
            //            // Write code here that turns the phrase above into concrete actions
//            throw PendingException()
        }
    }
}