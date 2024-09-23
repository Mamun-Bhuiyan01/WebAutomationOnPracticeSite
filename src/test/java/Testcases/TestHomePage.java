package Testcases;

import Pages.HomePage;
import Utilities.DriverSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomePage extends DriverSetup {

    HomePage homePage = new HomePage();

    @Test(description = "Loading home page")
    @Description("Home page")
    @Severity(SeverityLevel.BLOCKER)
    public void testHomePageTitle(){
        homePage.loadawebpage(homePage.homepageurl);
        homePage.addScreenshot("Home Page");
        Assert.assertEquals(getDriver().getTitle(), "Automation Exercise");

    }
}
