package tech.roslonek.selenium.e2e

import groovy.util.logging.Slf4j

@Slf4j
class PocTestSpec extends BaseSpec {

    def "should get Google webpage"() {

        when: "driver requests google webpage"
            driver.get("http://google.com/")

        then: "page is displayed"
            log.info driver.getCurrentUrl()
            driver.getPageSource().contains('<title>Google')
    }

}
