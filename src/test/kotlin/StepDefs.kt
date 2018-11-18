import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java8.En
import org.junit.AfterClass
import org.junit.Assert
import pages.AbstractPage
import pages.ResultPage
import pages.StartPage
import pages.subResultPage.PictureResultPage
import pages.subResultPage.VideoResultPage

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


    private fun getAnotherNewHandle(setHandles:Set<String>): String? {
        return INIT!!.getWebDriver().windowHandles.singleOrNull { e->!setHandles.contains(e) }
    }

    init {
        Given("^open startPage$") {
            CURRENT_PAGE = StartPage(INIT!!.getWebDriver());
            Assert.assertTrue("fwsfwe", CURRENT_PAGE.isPageOpened())
        }

        When("^writes in the search bar \"([^\"]*)\" and click Searh Button$") { arg1: String ->
            val page: StartPage = CURRENT_PAGE as StartPage
            page.setSearchRequest(arg1)
        }

        Then("^is opened main page$") {
            CURRENT_PAGE =ResultPage (INIT!!.getWebDriver())
            Assert.assertTrue( CURRENT_PAGE.isPageOpened())
        }

        When("^number of search result exactly (\\d+)$") { arg1: Int ->
            val page: ResultPage = CURRENT_PAGE as ResultPage
            Assert.assertEquals(page.countResult(),arg1)
        }

        When("^number of search result over (\\d+)$") { arg1: Int ->
            Assert.assertTrue(CURRENT_PAGE.countResult()!! >arg1)
        }

        Then("^is opened picture page$") {
            CURRENT_PAGE =PictureResultPage (INIT!!.getWebDriver())
            Assert.assertTrue( CURRENT_PAGE.isPageOpened())
        }

        Then("^is opened video page$") {
            CURRENT_PAGE = VideoResultPage (INIT!!.getWebDriver())
            Assert.assertTrue( CURRENT_PAGE.isPageOpened())
        }

        When("^click navigation item by name \"([^\"]*)\"$") { arg1: String ->
            var currPageHandle:Set<String> = INIT!!.getWebDriver().windowHandles
            val page: ResultPage = CURRENT_PAGE as ResultPage
            page.clickNaviItem(arg1)
            INIT!!.getWebDriver().switchTo().window(getAnotherNewHandle(currPageHandle))
//div[contains(@class, 'serp-list serp-list_type_search serp-list_unique')]/div[@role='listitem']
        }
    }
}