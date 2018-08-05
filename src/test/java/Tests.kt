import initUtil.Init
import org.testng.Assert
import org.testng.annotations.Test
import pages.ResultPage
import pages.StartPage

class Tests() : Init() {

    @Test
    fun open() {
        val homePage = StartPage(driver)
        Assert.assertTrue(homePage.isPageOpened())
    }

    @Test
    fun request() {
        val homePage = StartPage(driver)
        homePage.setSearchRequest("Hello world Kotlin")

        val resultPage = ResultPage(driver)
        Assert.assertTrue(resultPage.isPageOpened())
    }

    @Test
    fun testSearchResult(){
        val resultPage = ResultPage(driver)
        Assert.assertTrue(resultPage.countResult()!! >0)

        resultPage.clearSearchInput()
        resultPage.searchButtonclick()
        Thread.sleep(500)
        Assert.assertTrue(resultPage.countResult()==0)
    }
}