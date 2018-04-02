package tech.roslonek.selenium.driver.manager

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions

class FirefoxDriverManager extends DriverManager {

    @Override
    void stopService() {
    }

    @Override
    void createDriver() {
        System.setProperty("webdriver.gecko.driver", EXECUTABLES_PATH + "geckodriver")
        FirefoxOptions options = new FirefoxOptions()
        driver = new FirefoxDriver(options)
    }

}
