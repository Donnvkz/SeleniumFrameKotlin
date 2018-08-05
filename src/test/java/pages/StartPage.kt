package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

open class StartPage(driver: WebDriver) : AbstractPage(driver) {

    @FindBy(xpath = "//a[@title='Яндекс']")
    private val LOGO: WebElement? = null

    @FindBy(xpath = "//span[@class='input__box']/input")
    private val SEARCH_INPUT : WebElement? = null

    @FindBy(xpath = "//div[@class='search2__button']/button")
    private val SEARCH_BUTTON : WebElement? = null

    override fun isPageOpened(): Boolean{
        return LOGO!!.isDisplayed()
    }

    fun clearSearchInput(){
        SEARCH_INPUT!!.clear()
    }

    fun searchButtonclick(){
        SEARCH_BUTTON!!.click()
    }

    fun setSearchRequest(request:String){
        clearSearchInput()
        SEARCH_INPUT!!.sendKeys(request)
        searchButtonclick()
    }
}