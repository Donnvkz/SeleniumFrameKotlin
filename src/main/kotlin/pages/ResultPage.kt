package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.WebDriverWait


class ResultPage(driver: WebDriver) : StartPage(driver) {

    @FindBy(xpath = "//div[@class='serp-header__logo']")
    private var FULL_LOGO: WebElement? = null

    @FindBy(xpath = "//li[@class='serp-item']")
    private val RESULTS: List<WebElement>? = null

    @FindBy(xpath = "//div[@class='misspell__message']")
    private val MISSPEL_MESSAGE:WebElement? = null

    override fun isPageOpened(): Boolean {
        return FULL_LOGO!!.isDisplayed()
    }

    fun countResult(): Int? {
        if(MISSPEL_MESSAGE!!.text.equals("Задан пустой поисковый запрос")) return 0
        return RESULTS?.size
    }


}
