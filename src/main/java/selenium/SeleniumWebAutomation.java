package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumWebAutomation {

    public void initializeDriver(String websiteURL, String safariWebDriver, String safariWebDriverPath,
                                 SafariDriver safariDriver) {
        System.setProperty(safariWebDriver, safariWebDriverPath);
        safariDriver.navigate().to(websiteURL);
        safariDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void clickButton(String findElementById, SafariDriver safariDriver){
        WebElement m=safariDriver.
                findElement(By.id(findElementById));
        m.click();
    }

    public String gettingTextFromWebsite(String findElementById, SafariDriver safariDriver){
        String text = safariDriver.findElement(By.id(findElementById)).getText();
        return text;
    }

    public void writeInForm(String findElementById, String inputText,SafariDriver safariDriver){
        safariDriver.findElement(By.id(findElementById)).sendKeys(inputText);
    }

    public void usingThreadSleep(int millisSecond){
        try{
            Thread.sleep(millisSecond);
        } catch (InterruptedException e){
            System.out.println("something went wrong");
        }
    }

    public void closeDriver(SafariDriver safariDriver){
        if (safariDriver != null)
        {
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                System.out.println("something went wrong");
            }
            safariDriver.quit();
        }
    }

    public void makeItFullScreen(SafariDriver safariDriver){
        safariDriver.manage().window().maximize();
    }


}


