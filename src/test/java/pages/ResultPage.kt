package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy


class ResultPage(driver: WebDriver) : StartPage(driver) {

    @FindBy(xpath = "//div[@class='serp-header__logo']")
    private var FULL_LOGO: WebElement? = null

    @FindBy(xpath = "//li[@class='serp-item']")
    private val RESULTS: List<WebElement>? = null

    override fun isPageOpened(): Boolean{
        return FULL_LOGO!!.isDisplayed()
    }

    fun countResult(): Int? {
        return RESULTS?.size
    }


}
