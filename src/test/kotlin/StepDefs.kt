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
        Given("^open startPage$") {
            CURRENT_PAGE = StartPage(INIT!!.getWebDriver());
            Assert.assertTrue("fwsfwe", CURRENT_PAGE.isPageOpened())
        }

        When("^writes in the search bar \"([^\"]*)\" and click Searh Button$") { arg1: String ->
            val page: StartPage = CURRENT_PAGE as StartPage
            page.setSearchRequest(arg1)
            CURRENT_PAGE =ResultPage (INIT!!.getWebDriver())
        }

        Then("^is opened main page$") {
            val page: ResultPage = CURRENT_PAGE as ResultPage
            Assert.assertTrue( page.isPageOpened())
        }

        When("^number of search result exactly (\\d+)$") { arg1: Int ->
            val page: ResultPage = CURRENT_PAGE as ResultPage
            Assert.assertEquals(page.countResult(),arg1)
        }

        When("^number of search result over (\\d+)$") { arg1: Int ->
            val page: ResultPage = CURRENT_PAGE as ResultPage
            Assert.assertTrue(page.countResult()!! >arg1)
        }
    }
}