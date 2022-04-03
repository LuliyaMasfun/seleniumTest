package selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumWebAutomationTestOnMySite {
    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariPathToWebDriver = "/usr/bin/safaridriver";
    private static SafariDriver safariDriver;
    private SeleniumWebAutomation seleniumWebAutomation;


    @BeforeEach
    public void setUp(){

        seleniumWebAutomation = new SeleniumWebAutomation();

        safariDriver = new SafariDriver();

        String baseUrl = "http://127.0.0.1:5500/src/main/resources/static/index.html";
        String tagName = "";
        tagName = safariDriver.findElement(By.id("submit-button")).getTagName();
        System.out.println(tagName);

        seleniumWebAutomation.initializeDriver
                ("http://127.0.0.1:5500/src/main/resources/static/index.html",safariWebDriver, safariPathToWebDriver,
                        safariDriver);
        seleniumWebAutomation.makeItFullScreen(safariDriver);

    }

}
