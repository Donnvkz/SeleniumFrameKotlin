package pages.subResultPage

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import pages.ResultPage


class VideoResultPage(driver: WebDriver) : ResultPage(driver) {

    @FindBy(xpath = "//div[contains(@class,'serp-list serp-list_type_search serp-controller__list counter__reqid')]/div[@role='listitem']")
    private val RESULTS: List<WebElement>? = null


    override fun isPageOpened(): Boolean {
        return CURENT_SEARCH_CATEGORY!!.text.equals("Видео")
    }

    override fun countResult(): Int? {
        if(MISSPEL_MESSAGE!!.text.equals("По вашему запросу ничего не нашлось.")) return 0
        return RESULTS?.size
    }


}
