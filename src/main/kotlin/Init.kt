
import initUtil.UtilResources
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import java.util.concurrent.TimeUnit

class Init {
    lateinit var driver: WebDriver
        private set

    fun setUp() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe")
        driver = ChromeDriver()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage().window().maximize()
        driver.get(UtilResources.getParam("pageURL"))
    }

    fun driverClose() {
        driver.quit()
    }

    fun getWebDriver(): WebDriver {
        return driver
    }
}