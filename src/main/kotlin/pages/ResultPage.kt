package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy


open class ResultPage(driver: WebDriver) : StartPage(driver) {

    @FindBy(xpath = "//div[@class='serp-header__logo']")
    var FULL_LOGO: WebElement? = null

    @FindBy(xpath = "//li[@class='serp-item']")
    private val RESULTS: List<WebElement>? = null

    @FindBy(xpath = "//div[@class='misspell__message' or @class='misspell']")
    val MISSPEL_MESSAGE: List<WebElement>? = null

    @FindBy(xpath = "//div[contains(@class,'navigation__item navigation__item_service_yes navigation__item_name')]")
    val NAVIGATION_ITEMS: List<WebElement>? = null

    @FindBy(xpath = "//div[@class='tabs-navigation__content']/a[not(@rel)]")
    val CURENT_SEARCH_CATEGORY: WebElement? = null

    override fun isPageOpened(): Boolean {
        return FULL_LOGO!!.isDisplayed()
    }

    override fun countResult(): Int? {
        return RESULTS?.size
    }

    open fun clickNaviItem(itemName: String) {
        return NAVIGATION_ITEMS!!.findLast { e -> e.findElement(By.xpath(".//span")).text.equals(itemName) }!!.click()
    }


}
