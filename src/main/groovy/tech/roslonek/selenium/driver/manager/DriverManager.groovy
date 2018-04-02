package tech.roslonek.selenium.driver.manager

import org.openqa.selenium.WebDriver

abstract class DriverManager {

    protected static final EXECUTABLES_PATH= "src/main/groovy/tech/roslonek/selenium/driver/executables/"
                                              //MacOS dedicated binaries
    protected WebDriver driver
    protected abstract void stopService()
    protected abstract void createDriver()


    void quitDriver() {
        if (null != driver) {
            driver.quit()
            driver = null
            stopService()
        }
    }

    WebDriver getDriver() {
        if (null == driver) {
            createDriver()
        }
        return driver
    }
}
