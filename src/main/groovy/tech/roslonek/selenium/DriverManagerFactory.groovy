package tech.roslonek.selenium

import tech.roslonek.selenium.driver.manager.ChromeDriverManager
import tech.roslonek.selenium.driver.manager.DriverManager
import tech.roslonek.selenium.driver.manager.FirefoxDriverManager
import tech.roslonek.selenium.driver.manager.GridDriverManager

class DriverManagerFactory {

    static DriverManager driverManager

    static DriverManager getManager(DriverType type) {

        switch (type) {
            case DriverType.CHROME:
                driverManager = new ChromeDriverManager()
                break
            case DriverType.CHROME_HEADLESS:
                driverManager = new ChromeDriverManager()
                driverManager.headless = true
                break
            case DriverType.FIREFOX:
                driverManager = new FirefoxDriverManager()
                break
            case DriverType.GRID_CHROME:
                driverManager = new GridDriverManager()
                driverManager.browser = GridDriverManager.Browsers.CHROME
                break
            case DriverType.GRID_FIREFOX:
                driverManager = new GridDriverManager()
                driverManager.browser = GridDriverManager.Browsers.FIREFOX
                break
            default:
                driverManager = new ChromeDriverManager()
                driverManager.headless = true
                break
        }
        return driverManager
    }
}
