package selenium;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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

        seleniumWebAutomation.initializeDriver
                ("https://www.wikipedia.org",safariWebDriver, safariPathToWebDriver,
                        safariDriver);
        seleniumWebAutomation.makeItFullScreen(safariDriver);
    }

    @Test
    public void testWriteASearchOnWikipedia(){
        seleniumWebAutomation.writeInForm("searchInput", "Beyonce",safariDriver);
    }
    @Test
    public void testButtonOnWikipedia(){
        seleniumWebAutomation.clickButton("js-link-box-en", safariDriver);
    }

    @Test
    public void gettingTextFromWikipedia(){
        String expectedTextFromWikipedia ="\n" +
                "\n"+
                "Read Wikipedia in your language " +
                "\n"
                +"\n";

      String textFromWikipedia = seleniumWebAutomation.gettingTextFromWebsite("js-lang-list-button", safariDriver);

        Assert.assertEquals(expectedTextFromWikipedia, textFromWikipedia);

    }
    @AfterEach
    public void closeDriver (){
        seleniumWebAutomation.closeDriver(safariDriver);
    }
}
