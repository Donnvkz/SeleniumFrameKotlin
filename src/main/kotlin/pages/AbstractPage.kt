package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

abstract class AbstractPage( driver: WebDriver) {
    init {
        PageFactory.initElements(driver, this)
    }
    abstract fun isPageOpened(): Boolean

    abstract fun countResult(): Int?
}