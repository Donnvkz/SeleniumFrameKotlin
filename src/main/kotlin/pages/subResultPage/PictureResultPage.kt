package pages.subResultPage

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import pages.ResultPage


class PictureResultPage(driver: WebDriver) : ResultPage(driver) {

    @FindBy(xpath = "//div[contains(@class,'serp-list serp-list_type_search serp-list_unique')]/div[@role='listitem']")
    private val RESULTS: List<WebElement>? = null


    override fun isPageOpened(): Boolean {
        return CURENT_SEARCH_CATEGORY!!.text.equals("Картинки")
    }

    override fun countResult(): Int? {
        return RESULTS?.size
    }


}
