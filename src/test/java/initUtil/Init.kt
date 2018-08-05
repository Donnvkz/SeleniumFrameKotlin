package initUtil

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import java.util.concurrent.TimeUnit

abstract class Init {
    lateinit var driver: WebDriver
        private set

    @BeforeTest
    fun setUp() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe")
        driver = ChromeDriver()

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage().window().maximize()
        driver.get(UtilResources.getParam("pageURL"))
    }

    @AfterTest
    fun driverClose() {
        driver.close();
    }
}