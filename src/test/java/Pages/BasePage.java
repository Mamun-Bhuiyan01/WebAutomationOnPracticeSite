package Pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import static Utilities.DriverSetup.getDriver;

public class BasePage {

    public WebElement getelement(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickonelement(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void loadawebpage(String url){
        getDriver().get(url);
    }

    public void writeonelement(By locator, String text){
        getelement(locator).clear();
        getelement(locator).sendKeys(text);
    }

    public boolean getdisplaystatus(By locator){
        try {
            return getDriver().findElement(locator).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    public String getattributetext (By locator, String atrributename){
        return getelement(locator).getAttribute(atrributename);
    }

    public String getelementtext (By locator){
        return getelement(locator).getText();
    }

    public void addScreenshot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
