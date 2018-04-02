package tech.roslonek.selenium.driver.manager

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions

class ChromeDriverManager extends DriverManager {

    private ChromeDriverService chService
    boolean headless

    void startService() {
        if (null == chService) {
            try {
                chService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(EXECUTABLES_PATH + "chromedriver"))
                        .usingAnyFreePort()
                        .build()
                chService.start()
            } catch (Exception e) {
                e.printStackTrace()
            }
        }
    }

    @Override
    void stopService() {
        if (null != chService && chService.isRunning())
            chService.stop()
    }

    @Override
    void createDriver() {
        startService()
        ChromeOptions options = new ChromeOptions()
        options.addArguments("disable-infobars")
        if (headless) {
            options.addArguments("headless")
        }
        driver = new ChromeDriver(chService, options)
    }

}
