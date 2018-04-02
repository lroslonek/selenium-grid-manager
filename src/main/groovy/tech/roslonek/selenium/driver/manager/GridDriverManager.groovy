package tech.roslonek.selenium.driver.manager

import org.openqa.selenium.Platform
import org.openqa.selenium.WebDriverException
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

class GridDriverManager extends DriverManager {

    private static final GRID_HOST = "http://localhost:4444/"

    Browsers browser

    enum Browsers {
        CHROME,
        FIREFOX
    }

    @Override
    void stopService() {
    }

    @Override
    void createDriver() {
        if (browser == Browsers.FIREFOX) {
            driver = createFFRemoteDriver()
        } else if (browser == Browsers.CHROME) {
            driver = createChromeRemoteDriver()
        } else {
            new WebDriverException("unable to instantiate driver")
        }
    }

    static RemoteWebDriver createChromeRemoteDriver() {
        ChromeOptions options = new ChromeOptions()
                .addArguments("disable-infobars")

        DesiredCapabilities cap = new DesiredCapabilities()
//        cap.setPlatform(Platform.VISTA)
        cap.setCapability(ChromeOptions.CAPABILITY, options)

        return new RemoteWebDriver(
                new URL(GRID_HOST + "wd/hub"),
                cap
        )
    }

    static RemoteWebDriver createFFRemoteDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions()

        return new RemoteWebDriver(
                new URL(GRID_HOST + "wd/hub"), firefoxOptions
        )
    }
}
