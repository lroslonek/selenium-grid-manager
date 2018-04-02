package tech.roslonek.selenium.e2e

import groovy.util.logging.Slf4j
import org.junit.Rule
import org.junit.rules.TestName
import org.openqa.selenium.WebDriver
import spock.lang.Shared
import spock.lang.Specification
import tech.roslonek.selenium.DriverManagerFactory
import tech.roslonek.selenium.DriverType
import tech.roslonek.selenium.driver.manager.DriverManager

@Slf4j
class BaseSpec extends Specification {

    @Shared
    DriverManager driverManager

    @Shared
    WebDriver driver

    @Rule
    TestName name = new TestName()

    def setupSpec() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME_HEADLESS)
    }

    def setup() {
        log.info "#TEST: " + name.methodName
        driver = driverManager.getDriver()
    }

    def cleanup() {
        driverManager.quitDriver()
    }

    def cleanupSpec() {
        driverManager = null
    }
}
